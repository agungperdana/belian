/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.sql.Date;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Listbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.dm.IndustrySegmentation;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductCost;
import com.kratonsolution.belian.inventory.dm.ProductType;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.StateListener;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductBox extends Combobox
{
	private ProductService service = Springs.get(ProductService.class);
	
	private String category;
	
	private IndustrySegmentation segmentation;
	
	private ProductType type;
	
	private Date date;
	
	private Listbox uoms = Components.fullSpanSelect();
	
	private Doublebox quantity = Components.doubleBox(1);
	
	private Doublebox price = Components.readOnlyDoubleBox(0);
	
	private Doublebox total = Components.readOnlyDoubleBox(0);
	
	private Map<String,Product> maps = new HashMap<>();
	
	private Collection<StateListener> listeners = new Vector<>();
	
	public ProductBox()
	{
		this(null,null,null);
	}
	
	public ProductBox(String category,IndustrySegmentation segmentation,ProductType type)
	{
		this(DateTimes.currentDate(),category,segmentation,type);
	}
	
	public ProductBox(Date date,String category,IndustrySegmentation segmentation,ProductType type)
	{
		this.date = date;
		if(date == null)
			this.date = DateTimes.currentDate();
		
		this.category = category;
		this.segmentation = segmentation;
		this.type = type;
	
		setAutocomplete(true);
		setAutodrop(true);
		setConstraint("no empty");
		setWidth("100%");
		
		Handler handler = new Handler();
		
		addEventListener(Events.ON_CHANGING,handler);
		addEventListener(Events.ON_SELECT,handler);
		addEventListener(Events.ON_BLUR,handler);
		
		quantity.addEventListener(Events.ON_CHANGE, handler);
		quantity.addEventListener(Events.ON_BLUR, handler);
	}

	public Product getProduct()
	{
		if(!Strings.isNullOrEmpty(getValue()) && maps.containsKey(getValue()))
			return maps.get(getValue());
	
		return null;
	}
	
	public void setProduct(Product product)
	{
		if(product != null)
		{
			getChildren().clear();
			setSelectedItem(appendItem(product.getName()));
			
			if(!maps.containsKey(product.getName()))
				maps.put(product.getName(), product);
			
			uoms.getChildren().clear();
			price.setValue(0);
			total.setValue(0);
			
			uoms.setSelectedItem(uoms.appendItem(product.getUom().getName(), product.getUom().getId()));
			
			for(ProductCost cost:product.getCosts())
			{
				if(DateTimes.inRange(date, cost.getFrom(), cost.getTo()))
				{
					price.setValue(cost.getEstimated().doubleValue());
					break;
				}
			}
			
			total.setValue(quantity.doubleValue()*price.doubleValue());
		}
	}
	
	public Listbox getUoms()
	{
		return uoms;
	}
	
	private void initUom(String value)
	{
	}

	public Doublebox getPrice()
	{
		return price;
	}

	public Doublebox getTotal()
	{
		return total;
	}
	
	public Doublebox getQuantity()
	{
		return quantity;
	}
	
	public void addListener(StateListener listener)
	{
		if(listener != null)
			listeners.add(listener);
	}

	private class Handler implements EventListener<Event>
	{
		@Override
		public void onEvent(Event event) throws Exception
		{
			if(event instanceof InputEvent)
			{
				getChildren().clear();
				
				InputEvent input = (InputEvent)event;
				
				for(Product product:service.findAll(date, input.getValue()))
				{
					appendItem(product.getName());
					
					if(!maps.containsKey(product.getName()))
						maps.put(product.getName(),product);
				}
				
				total.setValue(quantity.doubleValue()*price.doubleValue());
			}
			else
			{
				uoms.getChildren().clear();
				price.setValue(0);
				total.setValue(0);
				
				if(!Strings.isNullOrEmpty(getValue()) && maps.containsKey(getValue()))
				{
					Product product = maps.get(getValue());
					uoms.setSelectedItem(uoms.appendItem(product.getUom().getName(), product.getUom().getId()));
					
					for(ProductCost cost:product.getCosts())
					{
						if(DateTimes.inRange(date, cost.getFrom(), cost.getTo()))
						{
							price.setValue(cost.getEstimated().doubleValue());
							break;
						}
					}
				}
				
				total.setValue(quantity.doubleValue()*price.doubleValue());
			}
			
			for(StateListener listener:listeners)
				listener.stateChanged();
		}
	}
}
