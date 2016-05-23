/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.util.Date;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Listbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.general.dm.IndustrySegmentation;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductType;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductBox extends Combobox implements EventListener<InputEvent>
{
	private ProductService service = Springs.get(ProductService.class);
	
	private String category;
	
	private IndustrySegmentation segmentation;
	
	private ProductType type;
	
	private Date date;
	
	private Listbox uoms = Components.fullSpanSelect();
	
	public ProductBox()
	{
		this(null,null,null);
	}
	
	public ProductBox(String category,IndustrySegmentation segmentation,ProductType type)
	{
		this(new Date(),category,segmentation,type);
	}
	
	public ProductBox(Date date,String category,IndustrySegmentation segmentation,ProductType type)
	{
		this.date = date;
		this.category = category;
		this.segmentation = segmentation;
		this.type = type;
	
		setAutocomplete(true);
		setAutodrop(true);
		setConstraint("no empty");
		setWidth("100%");
		addEventListener(Events.ON_CHANGING,this);
		addEventListener(Events.ON_BLUR,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				initUom(getValue());
			}
		});
	}
	
	@Override
	public void onEvent(InputEvent event) throws Exception
	{
		getChildren().clear();
		
		if(date == null)
			date = new Date();
		
		if(Strings.isNullOrEmpty(category) || segmentation == null || type == null)
		{
			for(Product product:service.findAll(date,event.getValue()))
				appendChild(new ProductComboItem(product));
		}
		else
		{
			for(Product product:service.findAll(date,category,segmentation,type,event.getValue()))
				appendChild(new ProductComboItem(product));
		}
		
		initUom(event.getValue());
	}
	
	public Product getProduct()
	{
		if(getSelectedItem() != null)
			return ((ProductComboItem)getSelectedItem()).getProduct();
	
		return service.findOneByName(getValue());
	}
	
	public void setProduct(Product product)
	{
		ProductComboItem item = new ProductComboItem(product);
		appendChild(item);
		setSelectedItem(item);
		initUom(item.getLabel());
	}
	
	public Listbox getUoms()
	{
		return uoms;
	}
	
	private void initUom(String value)
	{
		try
		{
			if(!Strings.isNullOrEmpty(value))
			{
				for(Comboitem item:getItems())
				{
					if(item.getLabel().equals(value))
					{
						Product product = service.findOne(item.getId());
						if(product != null)
						{
							uoms.getChildren().clear();
							uoms.appendItem(product.getUom().getLabel(), product.getUom().getValue());
							uoms.setSelectedIndex(0);
						}
					}
				}
			}
		}
		catch (Exception e){e.printStackTrace();}
	}
}
