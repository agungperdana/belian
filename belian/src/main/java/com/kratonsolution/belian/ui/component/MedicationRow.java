/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.IndustrySegmentation;
import com.kratonsolution.belian.healtcare.dm.LaboratoryItem;
import com.kratonsolution.belian.healtcare.dm.MedicationItem;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductPrice;
import com.kratonsolution.belian.inventory.dm.ProductPriceRepository;
import com.kratonsolution.belian.inventory.dm.ProductRepository;
import com.kratonsolution.belian.inventory.dm.ProductType;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class MedicationRow extends Row implements HasAmount
{
	private SessionUtils utils = Springs.get(SessionUtils.class);

	private ProductRepository repository = Springs.get(ProductRepository.class);

	private ProductRepository productRepository = Springs.get(ProductRepository.class);

	private ProductPriceRepository priceRepository = Springs.get(ProductPriceRepository.class);

	private Combobox products = new Combobox();

	private Listbox prices = Components.fullSpanSelect();

	private Listbox discounts = Components.fullSpanSelect();

	private Listbox uoms = Components.fullSpanSelect();

	private Listbox charges = Components.fullSpanSelect();

	private Doublebox quantity = Components.doubleOne();

	private Textbox note = new Textbox();

	private Checkbox deleteable = new Checkbox();

	private Map<String,Product> maps = new HashMap<>();

	private Collection<ProductPriceSelectionListener> listeners = new ArrayList<ProductPriceSelectionListener>();

	public MedicationRow(boolean isBPJS,boolean isClinic)
	{
		appendChild(deleteable);
		appendChild(products);
		appendChild(quantity);
		appendChild(uoms);
		
		if(!isClinic)
		{
			appendChild(prices);
			appendChild(discounts);
			appendChild(charges);
		}
		
		appendChild(note);

		init(isBPJS, isClinic);
	}

	private void init(boolean isBPJS,boolean isClinic)
	{
		products.setWidth("100%");
		products.setAutocomplete(true);
		products.setAutodrop(true);
		products.addEventListener(Events.ON_CHANGING,new Listener(isBPJS, isClinic));
		products.addEventListener(Events.ON_BLUR,new Listener(isBPJS, isClinic));
		products.addEventListener(Events.ON_SELECT,new Listener(isBPJS, isClinic));

		quantity.addEventListener(Events.ON_CHANGE, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				for(ProductPriceSelectionListener listener:listeners)
					listener.fireSelectedPrice(null,null,null,null);
			}
		});

		discounts.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				for(ProductPriceSelectionListener listener:listeners)
					listener.fireSelectedPrice(null,null,null,null);
			}
		});

		charges.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				for(ProductPriceSelectionListener listener:listeners)
					listener.fireSelectedPrice(null,null,null,null);
			}
		});
	}

	public Product getProduct()
	{
		if(maps.containsKey(products.getValue()))
			return maps.get(products.getValue());

		return null;
	}

	public void addProductPriceListener(ProductPriceSelectionListener listener)
	{
		if(listener != null)
			listeners.add(listener);
	}

	public MedicationItem getItem()
	{
		MedicationItem item = new MedicationItem();
		item.setCharge(Components.decimal(charges));
		item.setDiscount(Components.decimal(discounts));
		item.setPrice(Components.decimal(prices));
		item.setMedicine(getProduct());
		item.setNote(note.getText());
		item.setQuantity(BigDecimal.valueOf(quantity.doubleValue()));

		return item;
	}
	
	public void setItem(MedicationItem item)
	{
		products.appendItem(item.getProduct().getName());
		prices.appendItem(Numbers.format(item.getPrice()),item.getPrice().toString());
		discounts.appendItem(Numbers.format(item.getDiscount()),item.getDiscount().toString());
		charges.appendItem(Numbers.format(item.getCharge()),item.getCharge().toString());
		quantity.setValue(item.getQuantity().doubleValue());
		uoms.appendItem(item.getMeasure(), item.getMeasure());
		
		products.setSelectedIndex(0);
		Components.setDefault(prices);
		Components.setDefault(discounts);
		Components.setDefault(charges);
		Components.setDefault(uoms);
	}
	
	public void setItem(LaboratoryItem item)
	{
		products.appendItem(item.getProduct().getName());
		prices.appendItem(Numbers.format(item.getPrice()),item.getPrice().toString());
		discounts.appendItem(Numbers.format(item.getDiscount()),item.getDiscount().toString());
		charges.appendItem(Numbers.format(item.getCharge()),item.getCharge().toString());
		quantity.setValue(item.getQuantity().doubleValue());
		uoms.appendItem(item.getMeasure(), item.getMeasure());
		
		products.setSelectedIndex(0);
		Components.setDefault(prices);
		Components.setDefault(discounts);
		Components.setDefault(charges);
		Components.setDefault(uoms);
	}

	public BigDecimal getAmount()
	{
		return Components.decimal(prices).multiply(BigDecimal.valueOf(quantity.doubleValue())).subtract(Components.decimal(discounts)).add(Components.decimal(charges));
	}

	private class Listener implements EventListener<Event>
	{
		private boolean isBPJS;

		private boolean isClinic;

		public Listener(boolean isBPJS,boolean isClinic)
		{
			this.isBPJS = isBPJS;
			this.isClinic = isClinic;
		}

		@Override
		public void onEvent(Event event) throws Exception
		{
			if(event instanceof InputEvent)
			{
				products.getItems().clear();

				InputEvent input = (InputEvent)event;
				for(Product product:productRepository.findAllMedical(DateTimes.currentDate(),input.getValue(),IndustrySegmentation.MEDICAL,ProductType.FINISHGOOD))
				{
					products.appendItem(product.getName());
					if(!maps.containsKey(product.getName()))
						maps.put(product.getName(),product);
				}
			}
			else
			{
				prices.getItems().clear();
				discounts.getItems().clear();
				charges.getItems().clear();

				if(!Strings.isNullOrEmpty(products.getValue()) && maps.containsKey(products.getValue()))
				{
					for(ProductPrice price:maps.get(products.getValue()).getPrices())
					{
						if(DateTimes.inActiveState(price.getFrom(), price.getTo()))
						{
							switch (price.getType())
							{
								case CHARGE:
									charges.appendItem(Numbers.format(price.getPrice()), price.getPrice().toString());
									break;
								case DISCOUNT:
									discounts.appendItem(Numbers.format(price.getPrice()), price.getPrice().toString());
									break;
								case BPJS:
									if(isBPJS && isClinic)
										prices.appendItem(Numbers.format(price.getPrice()), price.getPrice().toString());
									break;
								case CLINIC:
									if(isClinic)
										prices.appendItem(Numbers.format(price.getPrice()), price.getPrice().toString());
									break;
								default:
									prices.appendItem(Numbers.format(price.getPrice())+"("+price.getType().display(utils.getLanguage())+")", price.getPrice().toString());
									break;
								
							}
						}
					}

					uoms.getItems().clear();
					uoms.appendItem(maps.get(products.getValue()).getUom().getCode(), maps.get(products.getValue()).getUom().getCode());
					uoms.setSelectedIndex(0);
				}

				if(prices.getItems().isEmpty())
					prices.appendItem("0","0");

				if(discounts.getItems().isEmpty())
					discounts.appendItem("0","0");

				if(charges.getItems().isEmpty())
					charges.appendItem("0","0");

				Components.setDefault(prices);
				Components.setDefault(discounts);
				Components.setDefault(charges);
			}

			for(ProductPriceSelectionListener listener:listeners)
				listener.fireSelectedPrice(null, null,null,null);
		}
	}
}
