/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.ProductFeature;
import com.kratonsolution.belian.products.dm.ProductFeatureRepository;
import com.kratonsolution.belian.products.dm.PriceComponent;
import com.kratonsolution.belian.products.dm.PriceComponentType;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductServiceRow extends Row
{
	private Language lang = Springs.get(Language.class);
	
	private ProductService service = Springs.get(ProductService.class);
	
	private ProductFeatureRepository featureRepository = Springs.get(ProductFeatureRepository.class);
	
	private Combobox products = new Combobox();
	
	private Listbox features = Components.fullSpanSelect();
	
	private Doublebox quantity = Components.readOnlyDoubleBox(1);
	
	private Listbox prices = Components.fullSpanSelect();
	
	private Map<String,Product> maps = new HashMap<>();
	
	private Vector<DisplayListener> listeners = new Vector<>();
	
	public ProductServiceRow()
	{
		this(null,null,null);
	}
	
	public ProductServiceRow(Product product,ProductFeature feature,BigDecimal price)
	{
		products.setWidth("100%");
		products.setAutodrop(true);
		
		appendChild(new Checkbox());
		appendChild(products);
		appendChild(features);
		appendChild(quantity);
		appendChild(prices);
		appendChild(new Label(UUID.randomUUID().toString()));
		
		Handler handler = new Handler();
		
		products.addEventListener(Events.ON_CHANGING,handler);
		products.addEventListener(Events.ON_SELECT,handler);
		products.addEventListener(Events.ON_BLUR,handler);
		
		setProduct(product);
		setFeature(feature);
		setPrice(price);
		
		features.addEventListener(Events.ON_SELECT,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				prices.getItems().clear();
				
				if(features.getSelectedItem().getValue().toString().equals("000"))
				{
					for(PriceComponent price:maps.get(products.getValue()).getPrices())
					{
						if(price.getType().equals(PriceComponentType.BASE_PRICE) && price.getFeature() == null)
							prices.appendItem(Numbers.format(price.getPrice()), price.getPrice().toString());
					}
				}
				else
				{
					for(PriceComponent price:maps.get(products.getValue()).getPrices())
					{
						if(price.getType().equals(PriceComponentType.BASE_PRICE) && price.getFeature() != null && price.getFeature().getId().equals(features.getSelectedItem().getValue().toString()))
							prices.appendItem(Numbers.format(price.getPrice()), price.getPrice().toString());
					}
				}

				if(prices.getItemCount() > 0)
					prices.setSelectedIndex(0);
				
				for(DisplayListener listener:listeners)
					listener.display();
			}
		});
	}

	private class Handler implements EventListener<Event>
	{
		@Override
		public void onEvent(Event ev) throws Exception
		{
			if(ev instanceof InputEvent)
			{
				InputEvent iv = (InputEvent)ev;
				
				products.getItems().clear();
				
				for(Product product:service.findAll(DateTimes.currentDate(),iv.getValue()))
				{
					if(!maps.containsKey(product.getName()))
						maps.put(product.getName(), product);
					
					products.appendItem(product.getName());
				}
			}
			else
			{
				if(!Strings.isNullOrEmpty(products.getValue()) && maps.containsKey(products.getValue()))
				{
					features.getItems().clear();
					prices.getItems().clear();
					
					features.appendItem("", "000");
					features.setSelectedIndex(0);
					
//					for(ProductFeature feature:maps.get(products.getValue()).getFeatures())
//						features.appendItem(feature.getValue(), feature.getId());
				
					for(PriceComponent price:maps.get(products.getValue()).getPrices())
					{
						if(price.getType().equals(PriceComponentType.BASE_PRICE) && price.getFeature() == null)
							prices.appendItem(Numbers.format(price.getPrice()), price.getPrice().toString());
					}
				}
			}
		}
	}
	
	public BigDecimal getQuantity()
	{
		if(quantity.getValue() == 0)
			throw new WrongValueException(quantity,lang.get("message.field.zero"));
		
		return BigDecimal.valueOf(quantity.doubleValue());
	}
	
	public BigDecimal getPrice()
	{
		if(prices.getSelectedCount() == 0)
			throw new WrongValueException(prices,lang.get("message.field.empty"));
		
		return Components.decimal(prices);
	}
	
	public void setProduct(Product product)
	{
		if(product != null)
		{
			products.getItems().clear();
			
			if(!maps.containsKey(product.getName()))
				maps.put(product.getName(), product);
			
			products.appendItem(product.getName());
			products.setSelectedIndex(0);
		}
	}
	
	public Product getProduct()
	{
		if(Strings.isNullOrEmpty(products.getValue()) || !maps.containsKey(products.getValue()))
			throw new WrongValueException(lang.get("message.field.empty"));
		
		return maps.get(products.getValue());
	}
	
	public void setFeature(ProductFeature feature)
	{
		if(feature != null)
		{
			features.getItems().clear();
			features.appendItem(feature.getValue(), feature.getId());
			features.setSelectedIndex(0);
		}
	}
	
	public void setPrice(BigDecimal price)
	{
		if(price != null)
		{
			prices.getItems().clear();
			prices.appendItem(Numbers.format(price),price.toString());
			prices.setSelectedIndex(0);
		}
	}
	
	public ProductFeature getFeature()
	{
		if(features.getSelectedCount() > 0)
			return featureRepository.findOne(Components.string(features));
		
		return null;
	}
	
	public void addDisplayListener(DisplayListener listener)
	{
		if(listener != null)
			listeners.add(listener);
	}
}
