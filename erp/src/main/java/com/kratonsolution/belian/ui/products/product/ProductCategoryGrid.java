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
import com.kratonsolution.belian.product.impl.orm.Product;
import com.kratonsolution.belian.product.impl.orm.ProductCategoryClassification;
import com.kratonsolution.belian.product.impl.application.ProductService;
import com.kratonsolution.belian.ui.GridContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public class ProductCategoryGrid extends GridContent
{
	private ProductService service = Springs.get(ProductService.class);

	private Product product;

	public ProductCategoryGrid(Product product)
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
				Flow.next(getParent(), new ProductCategoryGrid(product));
			}
		});

		toolbar.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				ProductCategoryClassification category = new ProductCategoryClassification();
				category.setProduct(product);
				
				Flow.next(getParent(), new ProductCategoryForm(product.getId()));
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
											Iterator<ProductCategoryClassification> iterator = fresh.getClassifications().iterator();
											while (iterator.hasNext())
											{
												ProductCategoryClassification code = (ProductCategoryClassification) iterator.next();
												if(code.getId().equals(RowUtils.id(row)))
													iterator.remove();
											}

											service.edit(fresh);
										}
									}
								}
							}

							Flow.next(getParent(), new ProductCategoryGrid(product));
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
		grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.start"),null,"125px"));
		grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.end"),null,"125px"));
		grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.category"),null,"200px"));
		grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.primary"),null,"65px"));
		grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.note"),null,"250px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().getLastChild().setVisible(false);
		grid.setSpan("3");

		Product fresh = service.findById(product.getId());
		if(fresh != null)
		{
			for(ProductCategoryClassification classification:fresh.getClassifications())
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(new Label(DateTimes.format(classification.getStart())));
				row.appendChild(new Label(DateTimes.format(classification.getEnd())));
				row.appendChild(new Label(classification.getCategory().getValue()));
				row.appendChild(new Label(classification.isPrimary()?"Yes":"No"));
				row.appendChild(new Label(classification.getComment()));
				row.appendChild(new Label(classification.getId()));
				
				grid.getRows().appendChild(row);
				
				row.addEventListener(Events.ON_CLICK, new EventListener<Event>()
				{
					@Override
					public void onEvent(Event arg0) throws Exception
					{
						Flow.next(ProductCategoryGrid.this.getParent(), new ProductCategoryEditForm(classification));
					}
				});
			}
		}
		
		appendChild(grid);
	}
}