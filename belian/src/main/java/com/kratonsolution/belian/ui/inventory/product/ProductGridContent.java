/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.product;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.event.PagingEvent;

import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.GridContent;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductGridContent extends GridContent
{
	private ProductService service = Springs.get(ProductService.class);
	
	public ProductGridContent()
	{
		super();
		initToolbar();
		initGrid();
	}
	
	protected void initToolbar()
	{
		appendChild(gridToolbar);
		
		gridToolbar.getRefresh().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new ProductGridContent());
			}
		});
		
		gridToolbar.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new ProductFormContent());
			}
		});
		
		gridToolbar.getSelect().addEventListener(Events.ON_CLICK,new EventListener<Event>()
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
					
					gridToolbar.removeChild(gridToolbar.getSelect());
					gridToolbar.insertBefore(gridToolbar.getDeselect(),gridToolbar.getDelete());
				}
			}
		});
		
		gridToolbar.getDeselect().addEventListener(Events.ON_CLICK,new EventListener<Event>()
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
				
					gridToolbar.removeChild(gridToolbar.getDeselect());
					gridToolbar.insertBefore(gridToolbar.getSelect(),gridToolbar.getDelete());
				}
			}
		});
		
		gridToolbar.getDelete().addEventListener(Events.ON_CLICK,new EventListener<Event>()
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
										Label label = (Label)row.getLastChild();
										service.delete(label.getValue());
									}
								}
							}
							
							refresh(new ProductModel(utils.getRowPerPage()));
						}
					}
				});
			}
		});
		
		gridToolbar.getSearch().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
			}
		});
		
		Toolbarbutton subCost = new Toolbarbutton("Substract Cost 10%","/icons/close24.png");
		subCost.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				service.subsCost();
			}
		});
		
		Toolbarbutton subPrice = new Toolbarbutton("Substract Price 10%","/icons/close24.png");
		subPrice.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				service.subsPrices();
			}
		});
		
		
		gridToolbar.appendChild(subCost);
		gridToolbar.appendChild(subPrice);

	}
	
	protected void initGrid()
	{
		filter.setPlaceholder("Type product code/name to filter");
		
		appendChild(filter);
		appendChild(grid);
		
		filter.addEventListener(Events.ON_CHANGING, new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent input) throws Exception
			{
				refresh(new ProductModel(utils.getRowPerPage(),input.getValue()));
			}
		});
		
		final ProductModel model = new ProductModel(utils.getRowPerPage(),filter.getText());
		
		grid.setHeight("80%");
		grid.setEmptyMessage(lang.get("message.grid.empty"));
		grid.setModel(model);
		grid.setRowRenderer(new ProductRowRenderer());
		grid.setPagingPosition("both");
		grid.setMold("paging");
		grid.setPageSize(utils.getRowPerPage());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"25px"));
		grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.start"),null,"85px"));
		grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.end"),null,"85px"));
		grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.code"),null,"85px"));
		grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.name")));
		grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.category"),null,"100px"));
		grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.type"),null,"125px"));
		grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.uom"),null,"75px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().getLastChild().setVisible(false);
		grid.setSpan("4");

		grid.addEventListener("onPaging",new EventListener<PagingEvent>()
		{
			@Override
			public void onEvent(PagingEvent event) throws Exception
			{
				model.next(event.getActivePage(), utils.getRowPerPage(),filter.getText());
				grid.setModel(model);
				refresh(model);
			}
		});
		
		refresh(new ProductModel(utils.getRowPerPage(),filter.getText()));
	}
}