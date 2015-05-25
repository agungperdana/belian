/**
 * 
 */
package com.kratonsolution.belian.ui.role;

import java.util.UUID;

import org.zkoss.zk.ui.Component;
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
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.security.dm.AccessRole;
import com.kratonsolution.belian.security.dm.AccessibleOrganization;
import com.kratonsolution.belian.security.dm.Module;
import com.kratonsolution.belian.security.dm.Role;
import com.kratonsolution.belian.security.svc.ModuleService;
import com.kratonsolution.belian.security.svc.RoleService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class RoleFormContent extends FormContent
{	
	private final RoleService service = Springs.get(RoleService.class);
	
	private final ModuleService moduleService = Springs.get(ModuleService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private Textbox code = new Textbox();
	
	private Textbox name = new Textbox();
	
	private Textbox note = new Textbox();
	
	private Grid accessModules = new Grid();
	
	private Tabbox tabbox = new Tabbox();
	
	private Grid accessibleCompanys = new Grid();
	
	public RoleFormContent()
	{
		super();
		
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab("Accessible Module"));
		tabbox.getTabs().appendChild(new Tab("Accessible Company"));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		appendChild(tabbox);
		
		initToolbar();
		initForm();
		initModules();
		initCompanys();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				RoleWindow window = (RoleWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(code.getText()))
					throw new WrongValueException(code,"Code cannot be empty");
			
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Name cannot be empty");
			
				Role role = new Role();
				role.setId(UUID.randomUUID().toString());
				role.setCode(code.getText());
				role.setName(name.getText());
				role.setNote(note.getText());
				
				Rows moduleRows = accessModules.getRows();
				for(Object object:moduleRows.getChildren())
				{
					Row _row = (Row)object;
					
					Module module = moduleService.findOne(RowUtils.string(_row, 6));
					if(module != null)
					{
						AccessRole accessRole = new AccessRole();
						accessRole.setId(UUID.randomUUID().toString());
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
				
				for(Component component:accessibleCompanys.getRows().getChildren())
				{
					Row row = (Row)component;
					
					AccessibleOrganization organization = new AccessibleOrganization();
					organization.setId(UUID.randomUUID().toString());
					organization.setOrganization(organizationService.findOne(RowUtils.string(row, 2)));
					organization.setRole(role);
					organization.setSelected(RowUtils.isChecked(row, 1));
					
					role.getOrganizations().add(organization);
				}
				
				service.add(role);
				
				RoleWindow window = (RoleWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		code.setConstraint("no empty");
		code.setWidth("250px");

		name.setConstraint("no empty");
		name.setWidth("250px");
		
		note.setWidth("300px");
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Code"));
		row1.appendChild(code);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Name"));
		row2.appendChild(name);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Note"));
		row3.appendChild(note);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
	}
	
	protected void initModules()
	{
		Auxhead head = new Auxhead();
		Auxheader header = new Auxheader("Module Access");
		header.setColspan(7);
		header.setRowspan(1);
		
		head.appendChild(header);
		
		Columns columns = new Columns();
		
		Column moduleName = new Column("Module");
		moduleName.setWidth("175px");
		
		Column canCreate = new Column();
		Column canRead = new Column();
		Column canUpdate = new Column();
		Column canDelete = new Column();
		Column canPrint = new Column();
		Column moduleId = new Column();
		moduleId.setVisible(false);
		
		Checkbox check1 = new Checkbox("Create");
		check1.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
		{
			@Override
			public void onEvent(CheckEvent event) throws Exception
			{
				Rows rows = accessModules.getRows();
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
				Rows rows = accessModules.getRows();
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
				Rows rows = accessModules.getRows();
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
				Rows rows = accessModules.getRows();
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
				Rows rows = accessModules.getRows();
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
		
		columns.appendChild(moduleName);
		columns.appendChild(canCreate);
		columns.appendChild(canRead);
		columns.appendChild(canUpdate);
		columns.appendChild(canDelete);
		columns.appendChild(canPrint);
		columns.appendChild(moduleId);
	
		Rows moduleRows = new Rows();
		
		for(Module module:moduleService.findAll())
		{
			Row row = new Row();
			row.appendChild(new Label(module.getName()));
			row.appendChild(new Checkbox());
			row.appendChild(new Checkbox());
			row.appendChild(new Checkbox());
			row.appendChild(new Checkbox());
			row.appendChild(new Checkbox());
			row.appendChild(new Label(module.getId()));
			
			moduleRows.appendChild(row);
		}
		
		accessModules.appendChild(head);
		accessModules.appendChild(columns);
		accessModules.appendChild(moduleRows);
		
		tabbox.getTabpanels().getChildren().get(0).appendChild(accessModules);
	}
	
	private void initCompanys()
	{
		accessibleCompanys.appendChild(new Columns());
		accessibleCompanys.appendChild(new Rows());
		accessibleCompanys.getColumns().appendChild(new Column("Company",null, null));
		accessibleCompanys.getColumns().appendChild(new Column("Status",null, "65px"));
		accessibleCompanys.getColumns().appendChild(new Column("",null,null));
		accessibleCompanys.getColumns().getChildren().get(2).setVisible(false);
		
		for(Organization organization:organizationService.findAllByRolesTypeName("Company Structure"))
		{
			Row row = new Row();
			row.appendChild(new Label(organization.getName()));
			row.appendChild(new Checkbox());
			row.appendChild(new Label(organization.getId()));
			
			accessibleCompanys.getRows().appendChild(row);
		}
		
		tabbox.getTabpanels().getChildren().get(1).appendChild(accessibleCompanys);
	}
}
