/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductPrice;
import com.kratonsolution.belian.inventory.dm.ProductPriceType;
import com.kratonsolution.belian.inventory.dm.ProductRepository;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class MedicalServiceRow extends Row implements HasAmount
{
	private Checkbox checkbox = Components.checkbox(false);

	private Combobox products = new Combobox();

	private Doublebox quantity = Components.doubleBox(1d);

	private Textbox uoms = Components.readOnlyTextBox();

	private Textbox note = Components.textBox(null);

	private Map<String,Product> maps = new HashMap<>();

	private Map<ProductPriceType,BigDecimal> prices = new HashMap<>();

	public MedicalServiceRow()
	{
		products.setWidth("100%");
		products.setAutocomplete(true);
		products.setAutodrop(true);

		appendChild(checkbox);
		appendChild(products);
		appendChild(quantity);
		appendChild(uoms);
		appendChild(note);

		init();
	}

	private void init()
	{
		products.addEventListener(Events.ON_CHANGING,new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent input) throws Exception
			{
				if(!Strings.isNullOrEmpty(input.getValue()))
				{
					products.getItems().clear();
					ProductRepository repository = Springs.get(ProductRepository.class);
					for(Product product:repository.findAllMedicalTreatment(input.getValue(),DateTimes.currentDate()))
					{
						products.appendItem(product.getName());
						if(!maps.containsKey(product.getName()))
							maps.put(product.getName(), product);
					}
				}
			}
		});

		products.addEventListener(Events.ON_BLUR,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(!Strings.isNullOrEmpty(products.getValue()) && maps.containsKey(products.getValue()))
				{
					uoms.setText(maps.get(products.getValue()).getUom().getCode());
					prices.clear();

					for(ProductPrice price:maps.get(products.getValue()).getPrices())
						prices.put(price.getType(), price.getPrice());
				}
			}
		});

		products.addEventListener(Events.ON_SELECT,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(!Strings.isNullOrEmpty(products.getValue()) && maps.containsKey(products.getValue()))
				{
					uoms.setText(maps.get(products.getValue()).getUom().getCode());

					prices.clear();

					for(ProductPrice price:maps.get(products.getValue()).getPrices())
						prices.put(price.getType(), price.getPrice());
				}
			}
		});
	}

	public Product getProduct()
	{
		if(Strings.isNullOrEmpty(products.getValue()))
			throw new RuntimeException("Please choose product first.");

		return maps.get(products.getValue());
	}

	public BigDecimal getPrice(boolean isBPJS,boolean isClinic)
	{
		if(isBPJS && isClinic)
			return prices.get(ProductPriceType.BPJS);
		else if(!isBPJS && isClinic)
			return prices.get(ProductPriceType.CLINIC);
		else if(!isBPJS && !isClinic)
			return prices.get(ProductPriceType.BASE);
		else
			return BigDecimal.ZERO;
	}
	
	public BigDecimal getCharge()
	{
		if(prices.containsKey(ProductPriceType.CHARGE))
			return prices.get(ProductPriceType.CHARGE);
		
		return BigDecimal.ZERO;
	}
	
	public BigDecimal getDiscount()
	{
		if(prices.containsKey(ProductPriceType.DISCOUNT))
			return prices.get(ProductPriceType.DISCOUNT);
		
		return BigDecimal.ZERO;
	}
	
	public String getNote()
	{
		return note.getText();
	}
	
	public BigDecimal getQuantity()
	{
		return BigDecimal.valueOf(quantity.doubleValue());
	}

	@Override
	public BigDecimal getAmount()
	{
		return (getQuantity().multiply(getPrice(false,false))).subtract(getDiscount()).add(getCharge());
	}
}
