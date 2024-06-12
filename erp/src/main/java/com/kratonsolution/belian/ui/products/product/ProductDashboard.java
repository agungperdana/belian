package com.kratonsolution.belian.ui.products.product;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.product.impl.orm.Product;
import com.kratonsolution.belian.ui.Dashboard;
import com.kratonsolution.belian.ui.util.Flow;

public class ProductDashboard extends Dashboard
{
	private ProductNav nav = new ProductNav();
	
	public ProductDashboard(Product product)
	{
		super();
		
		appendChild(nav);
		appendChild(canvas);
		
		canvas.appendChild(new ProductForm(product,nav));
		
		initNav(product);
	}
	
	private void initNav(Product product)
	{
		nav.setAddMode(product.getId().equals("0"));
		
		nav.getTable().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Flow.next(task.getFocused(), new ProductGridContent());
			}
		});
		
		nav.getForm().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				canvas.clear();
				canvas.appendChild(new ProductForm(product,nav));
			}
		});
		
		nav.getCode().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				canvas.clear();
				canvas.appendChild(new ProductCodeGrid(product));
			}
		});
		
		nav.getCategory().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				canvas.clear();
				canvas.appendChild(new ProductCategoryGrid(product));
			}
		});
		
		nav.getComponent().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				canvas.clear();
				canvas.appendChild(new ProductComponentGrid(product));
			}
		});
		
		nav.getFeature().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				canvas.clear();
				canvas.appendChild(new ProductFeatureGrid(product));
			}
		});
		
		nav.getSupplier().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				canvas.clear();
				canvas.appendChild(new ProductSupplierGrid(product));
			}
		});
		
		nav.getPrice().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				canvas.clear();
				canvas.appendChild(new ProductPriceGrid(product));
			}
		});
		
		nav.getCost().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				canvas.clear();
				canvas.appendChild(new ProductCostGrid(product));
			}
		});
	}
}
