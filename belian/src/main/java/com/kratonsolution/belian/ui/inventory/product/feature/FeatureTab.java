/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.product.feature;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductFeature;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.TabedDisplay;
import com.kratonsolution.belian.ui.inventory.product.ProductEditContent;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FeatureTab implements TabedDisplay
{
	private Product product;

	private ProductEditContent parent;
	
	private ProductService service = Springs.get(ProductService.class);

	public FeatureTab(Product product,ProductEditContent parent)
	{
		this.product = product;
		this.parent = parent;
	}

	public Tab getHeader()
	{
		return new Tab("Feature");
	}

	public Tabpanel getBody()
	{
		final Tabpanel panel = new Tabpanel();

		Vlayout layout = new Vlayout();
		layout.setStyle("overflow:auto");
		layout.setWidth("100%");

		panel.setWidth("100%");
		panel.appendChild(layout);

		Toolbar toolbar = new Toolbar();
		Toolbarbutton create = new Toolbarbutton("New Feature","/icons/new.png");
		create.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				parent.appendChild(new FeatureWindow(product));
			}
		});

		toolbar.appendChild(create);
		layout.appendChild(toolbar);
	
		Grid grid = new Grid();
		grid.appendChild(new Rows());
		grid.appendChild(new Columns());

		grid.getColumns().appendChild(new Column(null,null,"35px"));
		grid.getColumns().appendChild(new Column("Value",null,"150px"));
		grid.getColumns().appendChild(new Column("Type",null,"100px"));
		grid.getColumns().appendChild(new Column("Note"));
		grid.getColumns().appendChild(new Column(null,null,"1px"));
		grid.getColumns().getLastChild().setVisible(false);
		grid.setSpan("3");

		for(ProductFeature feature:this.product.getFeatures())
		{
			Image remove = new Image("/icons/deletesmall.png");
			remove.setAttribute("featureId",feature.getId());
			remove.addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					Messagebox.show("Are you sure want to remove the data(s) ?","Warning",Messagebox.CANCEL|Messagebox.OK, Messagebox.QUESTION,new EventListener<Event>()
					{
						@Override
						public void onEvent(Event event) throws Exception
						{
							if(event.getName().equals("onOK"))
							{
								service.removeFeature(product,remove.getAttribute("featureId").toString());
								parent.refresh();
								parent.setSelectedTab(1);
							}
						}
					});
				}
			});

			Row row = new Row();
			row.appendChild(remove);
			row.appendChild(new Label(feature.getValue()));
			row.appendChild(new Label(feature.getType().toString()));
			row.appendChild(new Label(feature.getNote()));
			row.appendChild(new Label(feature.getId()));

			grid.getRows().appendChild(row);

			row.addEventListener(Events.ON_DOUBLE_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					parent.appendChild(new FeatureEditWindow(product, feature.getId()));
				}
			});
		}

		layout.appendChild(grid);
		
		return panel;
	}
}
