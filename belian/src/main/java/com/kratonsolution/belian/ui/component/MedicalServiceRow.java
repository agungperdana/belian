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
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.PriceComponent;
import com.kratonsolution.belian.products.dm.PriceComponentType;
import com.kratonsolution.belian.products.dm.ProductRepository;
import com.kratonsolution.belian.sales.dm.BillableItem;
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

	private Map<PriceComponentType,BigDecimal> prices = new HashMap<>();

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
		products.addEventListener(Events.ON_CHANGING,new PriceEvent());
		products.addEventListener(Events.ON_BLUR,new PriceEvent());
		products.addEventListener(Events.ON_SELECT,new PriceEvent());
	}
	
	public void setItem(BillableItem item)
	{
		products.appendItem(item.getProduct().getName());
		products.setSelectedIndex(0);
		if(!maps.containsKey(item.getProduct().getName()))
			maps.put(item.getProduct().getName(), item.getProduct());
		
		quantity.setValue(item.getQuantity().doubleValue());
		uoms.setText(item.getMeasure());
		note.setText(item.getNote());
	}

	public Product getProduct()
	{
		if(Strings.isNullOrEmpty(products.getValue()))
			throw new RuntimeException("Please choose product first.");

		return maps.get(products.getValue());
	}

	public BigDecimal getPrice(boolean isBPJS,boolean isClinic,boolean isRef)
	{
		if(Strings.isNullOrEmpty(products.getValue()) || !maps.containsKey(products.getValue()))
			throw new RuntimeException("Please select product first");
		
		for(PriceComponent pro:maps.get(products.getValue()).getPrices())
		{
			switch (pro.getType())
			{
				case BPJS:
					if(isBPJS && isClinic)
						return pro.getPrice();
				case CLINIC:
					if(!isBPJS && isClinic)
						return pro.getPrice();
				case REFERENCE:
					if(!isBPJS && !isClinic && isRef)
						return pro.getPrice();
				case BASE_PRICE:
					if(!isBPJS && !isClinic && !isRef)
						return pro.getPrice();
				default:
					break;
			}
		}
		
		return BigDecimal.ZERO;
	}
	
	public BigDecimal getCharge()
	{
		if(prices.containsKey(PriceComponentType.CHARGE))
			return prices.get(PriceComponentType.CHARGE);
		
		return BigDecimal.ZERO;
	}
	
	public BigDecimal getDiscount()
	{
		if(prices.containsKey(PriceComponentType.DISCOUNT))
			return prices.get(PriceComponentType.DISCOUNT);
		
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
		return (getQuantity().multiply(getPrice(false,false,false))).subtract(getDiscount()).add(getCharge());
	}
	
	private class PriceEvent implements EventListener<Event>
	{

		@Override
		public void onEvent(Event event) throws Exception
		{
			if(event instanceof InputEvent)
			{
				InputEvent input = (InputEvent)event;
				
				if(!Strings.isNullOrEmpty(input.getValue()))
				{
					products.getItems().clear();
					
					ProductRepository repository = Springs.get(ProductRepository.class);
					for(Product product:repository.findAllMedicalService(input.getValue(),DateTimes.currentDate()))
					{
						products.appendItem(product.getName());
						if(!maps.containsKey(product.getName()))
							maps.put(product.getName(), product);
					}
				}
			}
			else
			{
				uoms.setText(maps.get(products.getValue()).getUom().getCode());
			}
		}
		
	}
}
