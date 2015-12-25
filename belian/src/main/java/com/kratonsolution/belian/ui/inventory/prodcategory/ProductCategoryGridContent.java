/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.prodcategory;

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
import org.zkoss.zul.event.PagingEvent;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.svc.ProductCategoryService;
import com.kratonsolution.belian.ui.GridContent;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductCategoryGridContent extends GridContent
{
	private ProductCategoryService service = Springs.get(ProductCategoryService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	public ProductCategoryGridContent()
	{
		super();
		initToolbar();
		initGrid();
	}
	
	protected void initToolbar()
	{
		gridToolbar.setParent(this);
		gridToolbar.getRefresh().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				grid.getPagingChild().setActivePage(0);
				refresh(new ProductCategoryModel(utils.getRowPerPage()));
			}
		});
		
		gridToolbar.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				ProductCategoryWindow window = (ProductCategoryWindow)getParent();
				window.removeGrid();
				window.insertCreateForm();
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
				Messagebox.show("Are you sure want to remove the data(s) ?","Warning",Messagebox.CANCEL|Messagebox.OK, Messagebox.QUESTION,new EventListener<Event>()
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
							
							refresh(new ProductCategoryModel(utils.getRowPerPage()));
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

	}
	
	protected void initGrid()
	{
		final ProductCategoryModel model = new ProductCategoryModel(utils.getRowPerPage());
		
		grid.setParent(this);
		grid.setHeight("80%");
		grid.setEmptyMessage("No Product Category data exist.");
		grid.setModel(model);
		grid.setRowRenderer(new ProductCategoryRowRenderer());
		grid.setPagingPosition("both");
		grid.setMold("paging");
		grid.setPageSize(utils.getRowPerPage());
		grid.appendChild(new Columns());
		
		grid.getColumns().appendChild(new Column(null,null,"25px"));
		grid.getColumns().appendChild(new Column("Code",null,"100px"));
		grid.getColumns().appendChild(new Column("Name",null,"150px"));
		grid.getColumns().appendChild(new Column("Note"));
		grid.getColumns().appendChild(new Column(null,null,"1px"));
		grid.getColumns().getChildren().get(4).setVisible(false);

		grid.addEventListener("onPaging",new EventListener<PagingEvent>()
		{
			@Override
			public void onEvent(PagingEvent event) throws Exception
			{
				model.next(event.getActivePage(), utils.getRowPerPage());
				grid.setModel(model);
				refresh(model);
			}
		});
		
		refresh(new ProductCategoryModel(utils.getRowPerPage()));
	}
}