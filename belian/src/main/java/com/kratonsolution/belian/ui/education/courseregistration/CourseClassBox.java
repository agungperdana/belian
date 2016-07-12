/**
 * 
 */
package com.kratonsolution.belian.ui.education.courseregistration;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.A;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Hbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.component.Listenable;
import com.kratonsolution.belian.ui.component.ModelListener;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CourseClassBox extends Hbox implements Listenable<ModelListener<Product>>
{
	private Language lang = Springs.get(Language.class);
	
	private ProductService service = Springs.get(ProductService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Combobox products = new Combobox();

	private A link = new A(lang.get("navbar.menu.education.newstudent"));
	
	private Map<String,Product> maps = new HashMap<String, Product>(); 
	
	private Vector<ModelListener<Product>> listeners = new Vector<>();

	public CourseClassBox(boolean showCreateLink)
	{
		Handler handler = new Handler();
		
		products.setAutocomplete(true);
		products.setAutodrop(true);
		products.setConstraint("no empty");
		products.setWidth("290px");
		products.setPlaceholder(lang.get("message.field.iden"));
		products.addEventListener(Events.ON_CHANGING,handler);
		products.addEventListener(Events.ON_SELECT, handler);
		products.addEventListener(Events.ON_BLUR, handler);
		
		setWidth("400px");

		appendChild(products);

		if(showCreateLink)
			appendChild(link);
		
		link.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
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
				
				products.getChildren().clear();
				
				for(Product prod:service.findAll(DateTimes.currentDate(),iv.getValue()))
				{
					String key = prod.getCode()+" "+prod.getName();
					products.appendItem(key);
					if(!maps.containsKey(key))
						maps.put(key, prod);
				}
			}
			else
			{
				if(!Strings.isNullOrEmpty(products.getValue()) && maps.containsKey(products.getValue()))
				{
					for(ModelListener<Product> listener:listeners)
						listener.fireEvent(maps.get(products.getValue()));
				}
			}
		}
	}
	
	public Product getProduct()
	{
		if(!Strings.isNullOrEmpty(products.getValue()) && maps.containsKey(products.getValue()))
			return maps.get(products.getValue());
		
		throw new RuntimeException(lang.get("message.field.empty"));
	}
	
	public void setProduct(Product product)
	{
		if(product != null)
		{
			String key = product.getCode()+" "+product.getName();
			if(!maps.containsKey(key))
				maps.put(key, product);
		
			products.getItems().clear();
			products.appendItem(key);
			products.setSelectedIndex(0);
		}
	}

	@Override
	public void addListener(ModelListener<Product> listener)
	{
		if(listener != null)
			listeners.add(listener);
	}
}
