
package com.kratonsolution.belian.ui.products.product;

import java.util.Iterator;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;

import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.ProductCost;
import com.kratonsolution.belian.products.svc.ProductService;
import com.kratonsolution.belian.ui.GridContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductCostGrid extends GridContent
{
	private ProductService service = Springs.get(ProductService.class);

	private Product product;

	public ProductCostGrid(Product product)
	{
		super();
		this.product = product;

		initToolbar();
		initGrid();
	}

	protected void initToolbar()
	{
		appendChild(toolbar);

		toolbar.getRefresh().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new ProductCostGrid(product));
			}
		});

		toolbar.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new ProductCostForm(product.getId()));
			}
		});

		toolbar.getSelect().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Rows rows = grid.getRows();
				for(Object object:rows.getChildren())
				{
					Row row = (Row)object;

					if(row.getFirstChild() instanceof Checkbox)
					{
						Checkbox checkbox = (Checkbox)row.getFirstChild();
						checkbox.setChecked(true);
					}

					toolbar.removeChild(toolbar.getSelect());
					toolbar.insertBefore(toolbar.getDeselect(),toolbar.getDelete());
				}
			}
		});

		toolbar.getDeselect().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Rows rows = grid.getRows();
				for(Object object:rows.getChildren())
				{
					Row row = (Row)object;
					if(row.getFirstChild() instanceof Checkbox)
					{
						Checkbox checkbox = (Checkbox)row.getFirstChild();
						checkbox.setChecked(false);						
					}

					toolbar.removeChild(toolbar.getDeselect());
					toolbar.insertBefore(toolbar.getSelect(),toolbar.getDelete());
				}
			}
		});

		toolbar.getDelete().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Messagebox.show(lang.get("message.removedata"),"Warning",Messagebox.CANCEL|Messagebox.OK, Messagebox.QUESTION,new EventListener<Event>()
				{
					@Override
					public void onEvent(Event event) throws Exception
					{
						if(event.getName().equals("onOK"))
						{
							for(Object object:grid.getRows().getChildren())
							{
								Row row = (Row)object;

								if(row.getFirstChild() instanceof Checkbox)
								{
									Checkbox check = (Checkbox)row.getFirstChild();
									if(check.isChecked())
									{
										Product fresh = service.findById(product.getId());
										if(fresh != null)
										{
											Iterator<ProductCost> iterator = fresh.getCosts().iterator();
											while (iterator.hasNext())
											{
												ProductCost code = (ProductCost) iterator.next();
												if(code.getId().equals(RowUtils.id(row)))
													iterator.remove();
											}

											service.edit(fresh);
										}
									}
								}
							}

							Flow.next(getParent(), new ProductCostGrid(product));
						}
					}
				});
			}
		});

		toolbar.getSearch().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
			}
		});

	}

	protected void initGrid()
	{
		grid.setHflex("1");
		grid.setEmptyMessage(lang.get("message.grid.empty"));
		grid.appendChild(new Rows());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"25px"));
		grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.start"),null,"100px"));
		grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.end"),null,"100px"));
		grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.price"),null,"100px"));
		grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.currency"),null,"85px"));
		grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.type"),null,"200px"));
		grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.geographic"),null,"100px"));
		grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.feature"),null,"100px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().getLastChild().setVisible(false);
		grid.setSpan("3");

		Product fresh = service.findById(product.getId());
		if(fresh != null)
		{
			for(ProductCost cost:fresh.getCosts())
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(new Label(DateTimes.format(cost.getStart())));
				row.appendChild(new Label(DateTimes.format(cost.getEnd())));
				row.appendChild(new Label(Numbers.format(cost.getEstimated())));
				row.appendChild(new Label(cost.getCurrency()!=null?cost.getCurrency().getValue():""));
				row.appendChild(new Label(cost.getType().display()));
				row.appendChild(new Label(cost.getArea()!=null?cost.getArea().getValue():""));
				row.appendChild(new Label(cost.getFeature()!=null?cost.getFeature().getValue():""));
				row.appendChild(new Label(cost.getId()));

				grid.getRows().appendChild(row);
				
				row.addEventListener(Events.ON_CLICK, new EventListener<Event>()
				{
					@Override
					public void onEvent(Event arg0) throws Exception
					{
						Flow.next(getParent(), new ProductCostEditForm(cost));
					}
				});
			}
		}
		
		appendChild(grid);
	}
}