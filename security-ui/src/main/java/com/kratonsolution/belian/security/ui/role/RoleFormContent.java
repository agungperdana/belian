package com.kratonsolution.belian.security.ui.role;

import java.util.ArrayList;
import java.util.Collection;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Auxhead;
import org.zkoss.zul.Auxheader;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.ui.AbstractForm;
import com.kratonsolution.belian.common.ui.event.WindowContentChangeEvent;
import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.common.ui.util.FlowHelper;
import com.kratonsolution.belian.common.ui.util.RowUtils;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.security.api.ModuleData;
import com.kratonsolution.belian.security.api.ModuleGroup;
import com.kratonsolution.belian.security.api.application.ModuleService;
import com.kratonsolution.belian.security.api.application.RoleService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class RoleFormContent extends AbstractForm
{	
	private static final long serialVersionUID = 1858194593980526506L;

	private RoleService service = Springs.get(RoleService.class);
	
	private ModuleService moduleService = Springs.get(ModuleService.class);
	
	private Textbox code = Components.mandatoryTextBox(false);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private Textbox note = Components.stdTextBox(null,false);
	
	private Checkbox status = new Checkbox(Labels.getLabel("label.active"));
	
	private Tabbox tabbox = new Tabbox();
	
	private Collection<Grid> modules = new ArrayList<>();
	
	public RoleFormContent()
	{
		super();
		
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		appendChild(tabbox);
		
		initToolbar();
		initForm();
		initModules();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				FlowHelper.next(getParent(), WindowContentChangeEvent.GRID);
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(code.getText()))
					throw new WrongValueException(code, Labels.getLabel("message.field.empty"));
			
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,Labels.getLabel("message.field.empty"));
			
//				Role role = new Role();
//				role.setCode(code.getText());
//				role.setName(name.getText());
//				role.setNote(note.getText());
//				
//				for(Grid grid:modules)
//				{
//					Rows moduleRows = grid.getRows();
//					for(Object object:moduleRows.getChildren())
//					{
//						Row _row = (Row)object;
//						
//						Module module = moduleService.findOne(RowUtils.string(_row, 6));
//						if(module != null)
//						{
//							AccessRole accessRole = new AccessRole();
//							accessRole.setModule(module);
//							accessRole.setRole(role);
//							accessRole.setCanCreate(RowUtils.isChecked(_row, 1));
//							accessRole.setCanRead(RowUtils.isChecked(_row, 2));
//							accessRole.setCanUpdate(RowUtils.isChecked(_row, 3));
//							accessRole.setCanDelete(RowUtils.isChecked(_row, 4));
//							accessRole.setCanPrint(RowUtils.isChecked(_row, 5));
//							
//							role.getAccesses().add(accessRole);
//						}
//					}
//				}
//				
//				service.add(role);
				
				FlowHelper.next(getParent(), WindowContentChangeEvent.GRID);
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(Labels.getLabel("label.code")));
		row1.appendChild(code);
		
		Row row2 = new Row();
		row2.appendChild(new Label(Labels.getLabel("label.name")));
		row2.appendChild(name);
		
		Row row3 = new Row();
		row3.appendChild(new Label(Labels.getLabel("label.note")));
		row3.appendChild(note);
		
		Row row4 = new Row();
		row4.appendChild(new Label(Labels.getLabel("label.status")));
		row4.appendChild(status);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
	}
	
	protected void initModules()
	{
		for(ModuleGroup group:ModuleGroup.values())
		{
			Grid grid = new Grid();
			grid.appendChild(new Rows());
			grid.appendChild(new Columns());
			grid.setHflex("1");
			grid.setSpan("0");
			
			Auxhead head = new Auxhead();
			Auxheader header = new Auxheader(Labels.getLabel("role.module.title"));
			header.setColspan(7);
			header.setRowspan(1);
			
			head.appendChild(header);
			
			Column canCreate = new Column(null,null,"85px");
			Column canRead = new Column(null,null,"85px");
			Column canUpdate = new Column(null,null,"85px");
			Column canDelete = new Column(null,null,"85px");
			Column canPrint = new Column(null,null,"85px");
			
			Checkbox createChk = new Checkbox(Labels.getLabel("label.create"));
			createChk.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
			{
				@Override
				public void onEvent(CheckEvent event) throws Exception
				{
					Rows rows = grid.getRows();
					for(Object object:rows.getChildren())
					{
						Row _row = (Row)object;
						if(event.isChecked())
							RowUtils.checked(_row, 1);
						else
							RowUtils.unchecked(_row, 1);
					}
				}
			});
			
			Checkbox readChck = new Checkbox(Labels.getLabel("label.read"));
			readChck.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
			{
				@Override
				public void onEvent(CheckEvent event) throws Exception
				{
					Rows rows = grid.getRows();
					for(Object object:rows.getChildren())
					{
						Row _row = (Row)object;
						if(event.isChecked())
							RowUtils.checked(_row, 2);
						else
							RowUtils.unchecked(_row, 2);
					}
				}
			});
			
			Checkbox updateChk = new Checkbox(Labels.getLabel("label.update"));
			updateChk.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
			{
				@Override
				public void onEvent(CheckEvent event) throws Exception
				{
					Rows rows = grid.getRows();
					for(Object object:rows.getChildren())
					{
						Row _row = (Row)object;
						if(event.isChecked())
							RowUtils.checked(_row, 3);
						else
							RowUtils.unchecked(_row, 3);
					}
				}
			});
			
			Checkbox deleteChk = new Checkbox(Labels.getLabel("label.delete"));
			deleteChk.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
			{
				@Override
				public void onEvent(CheckEvent event) throws Exception
				{
					Rows rows = grid.getRows();
					for(Object object:rows.getChildren())
					{
						Row _row = (Row)object;
						if(event.isChecked())
							RowUtils.checked(_row, 4);
						else
							RowUtils.unchecked(_row, 4);
					}
				}
			});
			
			Checkbox printChk = new Checkbox(Labels.getLabel("label.print"));
			printChk.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
			{
				@Override
				public void onEvent(CheckEvent event) throws Exception
				{
					Rows rows = grid.getRows();
					for(Object object:rows.getChildren())
					{
						Row _row = (Row)object;
						if(event.isChecked())
							RowUtils.checked(_row, 5);
						else
							RowUtils.unchecked(_row, 5);
					}
				}
			});
			
			canCreate.appendChild(createChk);
			canRead.appendChild(readChck);
			canUpdate.appendChild(updateChk);
			canDelete.appendChild(deleteChk);
			canPrint.appendChild(printChk);
			
			grid.getColumns().appendChild(new Column(Labels.getLabel("module.Caption"), null, "175px"));
			grid.getColumns().appendChild(canCreate);
			grid.getColumns().appendChild(canRead);
			grid.getColumns().appendChild(canUpdate);
			grid.getColumns().appendChild(canDelete);
			grid.getColumns().appendChild(canPrint);
			
			for(ModuleData module:moduleService.getAllModules())
			{
				if(module.getGroup().equals(group))
				{
					Row row = new Row();
					row.appendChild(new Label(module.getCode()));
					row.appendChild(new Label(module.getName()));
					row.appendChild(Components.checkbox(module.getGroup().equals(ModuleGroup.SYSTEM)));
					row.appendChild(Components.checkbox(module.getGroup().equals(ModuleGroup.SYSTEM)));
					row.appendChild(Components.checkbox(module.getGroup().equals(ModuleGroup.SYSTEM)));
					row.appendChild(Components.checkbox(module.getGroup().equals(ModuleGroup.SYSTEM)));
					row.appendChild(Components.checkbox(module.getGroup().equals(ModuleGroup.SYSTEM)));
					
					grid.getRows().appendChild(row);
				}
			}
			
			grid.appendChild(head);
			grid.setSpan("0");
			
			Tabpanel panel = new Tabpanel();
			panel.appendChild(grid);
			
			tabbox.getTabs().appendChild(new Tab(group.name()));
			tabbox.getTabpanels().appendChild(panel);
			
			modules.add(grid);
		}
	}
}
