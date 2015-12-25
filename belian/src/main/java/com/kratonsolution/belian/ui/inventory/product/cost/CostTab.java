/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.product.cost;

import java.math.RoundingMode;
import java.util.Iterator;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
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
import com.kratonsolution.belian.inventory.dm.ProductCost;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.TabedDisplay;
import com.kratonsolution.belian.ui.inventory.product.ProductEditContent;
import com.kratonsolution.belian.ui.util.Dates;
import com.kratonsolution.belian.ui.util.Objects;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class CostTab implements TabedDisplay
{
	private Product product;

	private ProductEditContent parent;
	
	private ProductService service = Springs.get(ProductService.class);

	public CostTab(Product product,ProductEditContent parent)
	{
		this.product = product;
		this.parent = parent;
	}

	public Tab getHeader()
	{
		return new Tab("Cost");
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
		Toolbarbutton create = new Toolbarbutton("New Cost","/icons/new.png");
		create.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				parent.appendChild(new CostWindow(product));
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
		grid.getColumns().appendChild(new Column("Cost",null,"125px"));
		grid.getColumns().appendChild(new Column("Type",null,"85px"));
		grid.getColumns().appendChild(new Column("Geographic"));
		grid.getColumns().appendChild(new Column(null,null,"1px"));
		grid.getColumns().getChildren().get(6).setVisible(false);
		grid.setSpan("5");

		final Iterator<ProductCost> iterator = this.product.getCosts().iterator();
		while (iterator.hasNext())
		{
			final ProductCost cost = (ProductCost) iterator.next();

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
								parent.setSelectedTab(5);
							}
						}
					});
				}
			});

			Row row = new Row();
			row.appendChild(remove);
			row.appendChild(new Label(Dates.format(cost.getFrom())));
			row.appendChild(new Label(Dates.format(cost.getTo())));
			row.appendChild(new Label(Money.of(CurrencyUnit.of(cost.getCurrency().getCode()),cost.getEstimated(),RoundingMode.HALF_DOWN).toString()));
			row.appendChild(new Label(cost.getType().toString()));
			row.appendChild(new Label(Objects.notNull(cost.getGeographic())?cost.getGeographic().getName():""));
			row.appendChild(new Label(cost.getId()));

			grid.getRows().appendChild(row);

			row.addEventListener(Events.ON_DOUBLE_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					parent.appendChild(new CostEditWindow(product, cost.getId()));
				}
			});
		}

		layout.appendChild(grid);
		
		return panel;
	}
}
