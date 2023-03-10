
package com.kratonsolution.belian.ui.security.role;

import java.util.ArrayList;
import java.util.Collection;

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
import com.kratonsolution.belian.general.dm.CompanyStructure;
import com.kratonsolution.belian.general.svc.CompanyStructureService;
import com.kratonsolution.belian.partys.svc.OrganizationService;
import com.kratonsolution.belian.security.impl.dm.AccessRole;
import com.kratonsolution.belian.security.impl.dm.Module;
import com.kratonsolution.belian.security.impl.dm.ModuleGroup;
import com.kratonsolution.belian.security.impl.dm.Role;
import com.kratonsolution.belian.security.impl.svc.ModuleService;
import com.kratonsolution.belian.security.impl.svc.RoleService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class RoleFormContent extends AbstractForm
{	
	private RoleService service = Springs.get(RoleService.class);
	
	private ModuleService moduleService = Springs.get(ModuleService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private CompanyStructureService structure = Springs.get(CompanyStructureService.class);
	
	private Textbox code = Components.mandatoryTextBox(false);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private Textbox note = Components.stdTextBox(null,false);
	
	private Tabbox tabbox = new Tabbox();
	
	private Grid accessibleCompanys = new Grid();
	
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
				Flow.next(getParent(), new RoleGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(code.getText()))
					throw new WrongValueException(code,lang.get("message.field.empty"));
			
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,lang.get("message.field.empty"));
			
				Role role = new Role();
				role.setCode(code.getText());
				role.setName(name.getText());
				role.setNote(note.getText());
				
				for(Grid grid:modules)
				{
					Rows moduleRows = grid.getRows();
					for(Object object:moduleRows.getChildren())
					{
						Row _row = (Row)object;
						
						Module module = moduleService.getOne(RowUtils.string(_row, 6));
						if(module != null)
						{
							AccessRole accessRole = new AccessRole();
							accessRole.setModule(module);
							accessRole.setRole(role);
							accessRole.setCanCreate(RowUtils.isChecked(_row, 1));
							accessRole.setCanRead(RowUtils.isChecked(_row, 2));
							accessRole.setCanUpdate(RowUtils.isChecked(_row, 3));
							accessRole.setCanDelete(RowUtils.isChecked(_row, 4));
							accessRole.setCanPrint(RowUtils.isChecked(_row, 5));
							
							role.getAccesses().add(accessRole);
						}
					}
				}
				
				service.add(role);
				
				Flow.next(getParent(), new RoleGridContent());
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
		row1.appendChild(new Label(lang.get("generic.grid.column.code")));
		row1.appendChild(code);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generic.grid.column.name")));
		row2.appendChild(name);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("generic.grid.column.note")));
		row3.appendChild(note);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
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
			Auxheader header = new Auxheader("Module Access");
			header.setColspan(7);
			header.setRowspan(1);
			
			head.appendChild(header);
			
			Column canCreate = new Column(null,null,"85px");
			Column canRead = new Column(null,null,"85px");
			Column canUpdate = new Column(null,null,"85px");
			Column canDelete = new Column(null,null,"85px");
			Column canPrint = new Column(null,null,"85px");
			Column moduleId = new Column();
			moduleId.setVisible(false);
			
			Checkbox check1 = new Checkbox("Create");
			check1.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
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
			
			Checkbox check2 = new Checkbox("Read");
			check2.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
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
			
			Checkbox check3 = new Checkbox("Update");
			check3.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
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
			
			Checkbox check4 = new Checkbox("Delete");
			check4.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
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
			
			Checkbox check5 = new Checkbox("Print");
			check5.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
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
			
			canCreate.appendChild(check1);
			canRead.appendChild(check2);
			canUpdate.appendChild(check3);
			canDelete.appendChild(check4);
			canPrint.appendChild(check5);
			
			grid.getColumns().appendChild(new Column("Module",null,"175px"));
			grid.getColumns().appendChild(canCreate);
			grid.getColumns().appendChild(canRead);
			grid.getColumns().appendChild(canUpdate);
			grid.getColumns().appendChild(canDelete);
			grid.getColumns().appendChild(canPrint);
			grid.getColumns().appendChild(moduleId);
			
			for(Module module:moduleService.findAll())
			{
				if(module.getGroup().equals(group))
				{
					Row row = new Row();
					row.appendChild(new Label(module.getName()));
					row.appendChild(Components.checkbox(module.getGroup().equals(ModuleGroup.SYSTEM)));
					row.appendChild(Components.checkbox(module.getGroup().equals(ModuleGroup.SYSTEM)));
					row.appendChild(Components.checkbox(module.getGroup().equals(ModuleGroup.SYSTEM)));
					row.appendChild(Components.checkbox(module.getGroup().equals(ModuleGroup.SYSTEM)));
					row.appendChild(Components.checkbox(module.getGroup().equals(ModuleGroup.SYSTEM)));
					row.appendChild(new Label(module.getId()));
					
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
	
	private void initCompanys()
	{
		accessibleCompanys.appendChild(new Columns());
		accessibleCompanys.appendChild(new Rows());
		accessibleCompanys.getColumns().appendChild(new Column("Company",null, null));
		accessibleCompanys.getColumns().appendChild(new Column("Status",null, "65px"));
		accessibleCompanys.getColumns().appendChild(new Column("",null,null));
		accessibleCompanys.getColumns().getChildren().get(2).setVisible(false);
		
		for(CompanyStructure unit:structure.findAll())
		{
			Row row = new Row();
			row.appendChild(new Label(unit.getOrganization().getName()));
			row.appendChild(new Checkbox());
			row.appendChild(new Label(unit.getOrganization().getId()));
			
			accessibleCompanys.getRows().appendChild(row);
		}
		
		Tabpanel tabpanel = new Tabpanel();
		tabpanel.appendChild(accessibleCompanys);
		
		tabbox.getTabs().appendChild(new Tab("Accessible Company"));
		tabbox.getTabpanels().appendChild(tabpanel);
	}
}
