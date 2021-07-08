package com.kratonsolution.belian.security.ui.role;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;

import com.kratonsolution.belian.access.api.application.RoleDeleteCommand;
import com.kratonsolution.belian.access.api.application.RoleService;
import com.kratonsolution.belian.common.ui.GridContent;
import com.kratonsolution.belian.common.ui.util.FlowHelper;
import com.kratonsolution.belian.common.ui.util.RowUtils;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.common.ui.util.UIHelper;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class RoleGridContent extends GridContent
{
	private static final long serialVersionUID = -6833976191675557237L;
	
	private RoleService service = Springs.get(RoleService.class);
	
	public RoleGridContent()
	{
		super();
		initToolbar();
		initGrid();
	}
	
	protected void initToolbar()
	{
		appendChild(toolbar);
		toolbar.getRefresh().addEventListener(Events.ON_CLICK, e->FlowHelper.next(RoleUIEvent.toGrid()));
		toolbar.getNewData().addEventListener(Events.ON_CLICK,e->FlowHelper.next(RoleUIEvent.newForm()));
		
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
				Messagebox.show(Labels.getLabel("warning.remove"),"Warning",
						Messagebox.CANCEL|Messagebox.OK, Messagebox.QUESTION,new EventListener<Event>()
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
												RoleDeleteCommand command = new RoleDeleteCommand();
												command.setCode(RowUtils.string(row, 1));
												
												service.delete(command);
											}
										}
									}
									
									FlowHelper.next(RoleUIEvent.toGrid());
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
		grid.setParent(this);
		grid.setHeight("80%");
		grid.setEmptyMessage(Labels.getLabel("warning.grid.empty"));
		grid.setModel(new RoleModel());
		grid.setRowRenderer(new RoleRowRenderer());
		grid.setPagingPosition("both");
		grid.setMold("paging");
		grid.setPageSize(UIHelper.getSetting().getMaxRow());
		grid.appendChild(new Columns());
		
		grid.getColumns().appendChild(new Column(null,null,"25px"));
		grid.getColumns().appendChild(new Column(Labels.getLabel("label.code"),null,"100px"));
		grid.getColumns().appendChild(new Column(Labels.getLabel("label.name"),null,"150px"));
		grid.getColumns().appendChild(new Column(Labels.getLabel("label.note")));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().getLastChild().setVisible(false);
		grid.setSpan("3");
		grid.appendChild(getFoot(grid.getColumns().getChildren().size()));
	}
}