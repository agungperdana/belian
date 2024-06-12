
package com.kratonsolution.belian.ui.products.product;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Comboitem;

import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.common.orm.Observer;
import com.kratonsolution.belian.product.impl.orm.Product;
import com.kratonsolution.belian.product.impl.application.ProductService;
import com.kratonsolution.belian.ui.component.AbstractCombobox;
import com.kratonsolution.belian.ui.component.ListSelectionListener;
import com.kratonsolution.belian.ui.products.feature.ProductFeatureList;
import com.kratonsolution.belian.ui.util.Springs;

import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Setter
public class ProductBox extends AbstractCombobox<Product>
{
	private ProductService service = Springs.get(ProductService.class);

	private ProductFeatureList featureList;

	public ProductBox(boolean showCreateLink)
	{
		this(showCreateLink,false,null);
	}

	public ProductBox(boolean showCreateLink,boolean fullspan)
	{
		this(showCreateLink,fullspan,null);
	}

	public ProductBox(boolean showCreateLink,boolean fullspan,Product product)
	{
		super(showCreateLink,fullspan);

		if(product != null)
			setDomain(product);

		input.addEventListener(Events.ON_CHANGING, new OnEventListener());
		input.addEventListener(Events.ON_SELECT, new OnEventListener());
		input.addEventListener(Events.ON_BLUR, new OnEventListener());

		link.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
			}
		});
	}

	private class OnEventListener implements EventListener<Event>
	{
		@Override
		public void onEvent(Event event) throws Exception
		{
			if(event instanceof InputEvent)
			{
				InputEvent ev = (InputEvent)event;

				input.getItems().clear();

				for(Product product:service.findAll(ev.getValue()))
				{
					Comboitem comboitem = input.appendItem(product.getName());
					comboitem.setAttribute("product_id",product.getId());

					if(!maps.containsKey(product.getId()))
						maps.put(product.getId(), product);
				}
			}
			else
			{
				Comboitem selected = input.getSelectedItem();

				if(selected != null)
				{
					if(selected.getAttributes().containsKey("product_id") && selected.getAttribute("product_id") != null)
					{
						Product product = maps.get(selected.getAttribute("product_id").toString());

						for(ListSelectionListener<Product> listener:listeners)
							listener.fireItemSelected(product);

						if(featureList != null)
							featureList.fireItemSelected(product);
						
						for(Observer observer:observers)
							observer.valueChange(getDomainAsRef());
					}
				}
			}
		}
	}

	@Override
	public Product getDomain()
	{
		if(input.getSelectedItem() != null && maps.containsKey(input.getSelectedItem().getAttribute("product_id")))
			return maps.get(input.getSelectedItem().getAttribute("product_id").toString());

		return null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		if(input.getSelectedItem() != null && maps.containsKey(input.getSelectedItem().getAttribute("product_id")))
		{
			Product product = maps.get(input.getSelectedItem().getAttribute("product_id").toString());
			if(product != null)
			{
				IDValueRef ref = new IDValueRef();
				ref.setId(product.getId());
				ref.setValue(product.getName());
				ref.setType(Product.class.getSimpleName());

				return ref;
			}
		}

		return null;
	}

	@Override
	public void setDomain(Product ref)
	{
		if(ref != null)
		{
			input.getItems().clear();
			Comboitem comboitem = input.appendItem(ref.getValue());
			comboitem.setAttribute("product_id",ref.getId());

			input.setSelectedItem(comboitem);

			if(!maps.containsKey(ref.getId()))
				maps.put(ref.getId(), ref);
		}
		else
			input.setSelectedItem(null);
	}

	@Override
	public void setDomainAsRef(IDValueRef ref)
	{
		if(ref != null)
		{
			input.getItems().clear();
			Comboitem comboitem = input.appendItem(ref.getValue());
			comboitem.setAttribute("product_id",ref.getId());

			input.setSelectedItem(comboitem);

			if(!maps.containsKey(ref.getId()))
				maps.put(ref.getId(), new Product(ref));

			for(Observer observer:observers)
				observer.valueChange(ref);
		}
		else
			input.setSelectedItem(null);
	}
}
