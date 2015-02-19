/**
 * 
 */
package com.kratonsolution.belian.ui.product;

import java.util.Iterator;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductComponent;
import com.kratonsolution.belian.ui.TabedDisplay;

/**
 * @author agungdodiperdana
 *
 */
public class ComponentTab implements TabedDisplay
{
	private Product product;
	
	private Component parent;
	
	public ComponentTab(Product product,Component parent)
	{
		this.product = product;
		this.parent = parent;
	}
	
	public Tab getHeader()
	{
		return new Tab("Component");
	}
	
	public Tabpanel getBody()
	{
		Tabpanel panel = new Tabpanel();
		Toolbar toolbar = new Toolbar();
		Grid grid = new Grid();
		Vlayout layout = new Vlayout();
	
		layout.setStyle("overflow:auto");
		layout.setWidth("100%");
		
		panel.setWidth("100%");
		panel.appendChild(layout);
		
		Toolbarbutton create = new Toolbarbutton("New Component","/icons/new.png");
		create.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
//				parent.appendChild(new FeatureWindow(product));
			}
		});
		
		toolbar.appendChild(create);
		toolbar.setHflex("true");
		
		layout.appendChild(toolbar);
		
		grid.appendChild(new Rows());
		grid.appendChild(new Columns());
		
		grid.getColumns().appendChild(new Column(null,null,"35px"));
		grid.getColumns().appendChild(new Column("Name",null,"150px"));
		grid.getColumns().appendChild(new Column("Quantity",null,"100px"));
		grid.getColumns().appendChild(new Column("Note"));
		grid.setSpan("3");
		
		final Iterator<ProductComponent> iterator = this.product.getComponents().iterator();
		while (iterator.hasNext())
		{
			ProductComponent feature = (ProductComponent) iterator.next();
		
			Image remove = new Image("/icons");
			remove.addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					iterator.remove();
				}
			});
			
			Row row = new Row();
			row.appendChild(remove);
			row.appendChild(new Label(feature.getProduct().getName()));
			row.appendChild(new Label(feature.getQuantity().toPlainString()));
			row.appendChild(new Label(feature.getNote()));
			
			grid.getRows().appendChild(row);
			
			row.addEventListener(Events.ON_DOUBLE_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
				}
			});
		}
		
		layout.appendChild(grid);
		
		return panel;
	}
}
