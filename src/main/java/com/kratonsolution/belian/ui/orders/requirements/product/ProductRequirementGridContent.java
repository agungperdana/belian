
package com.kratonsolution.belian.ui.orders.requirements.product;

import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.event.PagingEvent;
import org.zkoss.zul.event.ZulEvents;

import com.kratonsolution.belian.requirement.svc.ProductRequirementService;
import com.kratonsolution.belian.ui.GridContent;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductRequirementGridContent extends GridContent
{
	private ProductRequirementService service = Springs.get(ProductRequirementService.class);
	
	public ProductRequirementGridContent()
	{
		super();
		initToolbar();
		initGrid();
	}
	
	protected void initToolbar()
	{
		toolbar.setParent(this);
		toolbar.getRefresh().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new ProductRequirementGridContent());
			}
		});
		
		toolbar.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new ProductRequirementFormContent());
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
							Vector<String> ids = new Vector<>();
							
							for(Object object:grid.getRows().getChildren())
							{
								Row row = (Row)object;
								if(RowUtils.isChecked(row))
									ids.add(RowUtils.id(row));
							}
							
							if(!ids.isEmpty())
								service.delete(ids);
							
							Flow.next(getParent(), new ProductRequirementGridContent());
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
		final ProductRequirementModel model = new ProductRequirementModel(utils.getRowPerPage());
		
		appendChild(grid);
		
		grid.setHeight("80%");
		grid.setEmptyMessage(lang.get("message.grid.empty"));
		grid.setModel(model);
		grid.setRowRenderer(new ProductRequirementRowRenderer());
		grid.setPagingPosition("both");
		grid.setMold("paging");
		grid.setPageSize(utils.getRowPerPage());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"25px"));
		grid.getColumns().appendChild(new Column(lang.get("workrequirement.grid.column.number"),null,"125px"));
		grid.getColumns().appendChild(new Column(lang.get("workrequirement.grid.column.creation"),null,"95px"));
		grid.getColumns().appendChild(new Column(lang.get("workrequirement.grid.column.required"),null,"95px"));
		grid.getColumns().appendChild(new Column(lang.get("workrequirement.grid.column.description"),null,"200px"));
		grid.getColumns().appendChild(new Column(lang.get("workrequirement.grid.column.reason"),null,"200px"));
		grid.getColumns().appendChild(new Column(lang.get("workrequirement.grid.column.type"),null,"150px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().getLastChild().setVisible(false);
		grid.setSpan("4");
		grid.addEventListener(ZulEvents.ON_AFTER_RENDER, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Grid target = (Grid)event.getTarget();
				for(Component com:target.getRows().getChildren())
				{
					com.addEventListener(Events.ON_CLICK,new EventListener<Event>()
					{
						@Override
						public void onEvent(Event ev) throws Exception
						{
							Row row = (Row)ev.getTarget();
							Flow.next(getParent(), new ProductRequirementEditContent(row));
						}
					});
				}
			}
		});
		grid.addEventListener("onPaging",new EventListener<PagingEvent>()
		{
			@Override
			public void onEvent(PagingEvent event) throws Exception
			{
				model.next(event.getActivePage(), utils.getRowPerPage());
				grid.setModel(model);
			}
		});
	}
}