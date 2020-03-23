package com.kratonsolution.belian.security.ui.module;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.event.PagingEvent;
import org.zkoss.zul.event.ZulEvents;

import com.kratonsolution.belian.common.ui.GridContent;
import com.kratonsolution.belian.common.ui.event.WindowContentChangeEvent;
import com.kratonsolution.belian.common.ui.util.FlowHelper;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.common.ui.util.UIHelper;
import com.kratonsolution.belian.security.api.application.ModuleService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class ModuleGridContent extends GridContent
{
	private static final long serialVersionUID = -7191047588399258066L;
	
	private ModuleService service = Springs.get(ModuleService.class);
	
	public ModuleGridContent()
	{
		super();
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
				FlowHelper.next(getParent(), WindowContentChangeEvent.GRID);
			}
		});
		
		toolbar.getNewData().addEventListener(Events.ON_CLICK,new EventListener<Event>(){
			@Override
			public void onEvent(Event event) throws Exception
			{
//				Flow.next(getParent(), new ModuleFormContent());
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
//				Messagebox.show(lang.get("message.removedata"),"Warning",Messagebox.CANCEL|Messagebox.OK, Messagebox.QUESTION,new EventListener<Event>()
//				{
//					@Override
//					public void onEvent(Event event) throws Exception
//					{
//						if(event.getName().equals("onOK"))
//						{
//							for(Object object:grid.getRows().getChildren())
//							{
//								Row row = (Row)object;
//
//								if(RowUtils.isChecked(row,0))
//									service.delete(RowUtils.string(row, 4));
//							}
//							
//							Flow.next(getParent(), new ModuleGridContent());
//						}
//					}
//				});
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
		final ModuleModel model = new ModuleModel();
		
//		filter.setPlaceholder(lang.get("message.filter.placeholder"));
//		filter.addEventListener(Events.ON_CHANGING,new EventListener<InputEvent>()
//		{
//			@Override
//			public void onEvent(InputEvent input) throws Exception
//			{
//				grid.setModel(new ModuleModel(utils.getRowPerPage(),input.getValue()));
//			}
//		});
		
		appendChild(filter);
		appendChild(grid);
		
		grid.setHeight("80%");
		grid.setEmptyMessage(Labels.getLabel("warning.grid.empty"));
		grid.setModel(model);
		grid.setRowRenderer(new ModuleRowRenderer());
		grid.setPagingPosition("both");
		grid.setMold("paging");
		grid.setPageSize(UIHelper.getSetting().getMaxRow());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"25px"));
		grid.getColumns().appendChild(new Column(Labels.getLabel("module.grid.code"),null,"200px"));
		grid.getColumns().appendChild(new Column(Labels.getLabel("user.grid.name"),null,"150px"));
		grid.getColumns().appendChild(new Column(Labels.getLabel("module.grid.group")));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().getLastChild().setVisible(false);
		grid.appendChild(getFoot(grid.getColumns().getChildren().size()));
		grid.setSpan("2");
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
//							Flow.next(getParent(), new ModuleEditContent(row));
						}
					});
				}
			}
		});
		
		grid.addEventListener(ZulEvents.ON_PAGING,new EventListener<PagingEvent>()
		{
			@Override
			public void onEvent(PagingEvent event) throws Exception
			{
				model.next(event.getActivePage());
				grid.setModel(model);
			}
		});
	}
}