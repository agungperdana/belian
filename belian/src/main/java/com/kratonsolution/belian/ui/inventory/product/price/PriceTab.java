/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.product.price;

import java.util.Iterator;

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

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductPrice;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.TabedDisplay;
import com.kratonsolution.belian.ui.inventory.product.ProductEditContent;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.Objects;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PriceTab implements TabedDisplay
{
	private Product product;

	private ProductEditContent parent;
	
	private ProductService service = Springs.get(ProductService.class);

	public PriceTab(Product product,ProductEditContent parent)
	{
		this.product = product;
		this.parent = parent;
	}

	public Tab getHeader()
	{
		return new Tab("Price");
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
		Toolbarbutton create = new Toolbarbutton("New Price","/icons/new.png");
		create.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				parent.appendChild(new PriceWindow(product));
			}
		});

		toolbar.appendChild(create);
		layout.appendChild(toolbar);
	
		Grid grid = new Grid();
		grid.appendChild(new Rows());
		grid.appendChild(new Columns());

		grid.getColumns().appendChild(new Column(null,null,"35px"));
		grid.getColumns().appendChild(new Column("From",null,"85px"));
		grid.getColumns().appendChild(new Column("To",null,"85px"));
		grid.getColumns().appendChild(new Column("Price",null,"125px"));
		grid.getColumns().appendChild(new Column("Type",null,"50px"));
		grid.getColumns().appendChild(new Column("Geographic",null,"100px"));
		grid.getColumns().appendChild(new Column("Party",null,"135px"));
		grid.getColumns().appendChild(new Column(null,null,"1px"));
		grid.getColumns().getChildren().get(7).setVisible(false);
		grid.setSpan("6");

		final Iterator<ProductPrice> iterator = this.product.getPrices().iterator();
		while (iterator.hasNext())
		{
			final ProductPrice price = (ProductPrice) iterator.next();

			Image remove = new Image("/icons/deletesmall.png");
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
								iterator.remove();
								service.edit(product);
								parent.refresh();
								parent.setSelectedTab(4);
							}
						}
					});
				}
			});

			Row row = new Row();
			row.appendChild(remove);
			row.appendChild(new Label(DateTimes.format(price.getFrom())));
			row.appendChild(new Label(DateTimes.format(price.getTo())));
			row.appendChild(new Label(Numbers.format(price.getPrice())));
			row.appendChild(new Label(price.getType().toString()));
			row.appendChild(new Label(Objects.notNull(price.getGeographic())?price.getGeographic().getName():""));
			row.appendChild(new Label(Objects.notNull(price.getParty())?price.getParty().getName():""));
			row.appendChild(new Label(price.getId()));

			grid.getRows().appendChild(row);

			row.addEventListener(Events.ON_DOUBLE_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					parent.appendChild(new PriceEditWindow(product, price.getId()));
				}
			});
		}

		layout.appendChild(grid);
		
		return panel;
	}
}
