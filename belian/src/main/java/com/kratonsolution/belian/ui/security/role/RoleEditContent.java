/**
 * 
 */
package com.kratonsolution.belian.ui.security.role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
import com.kratonsolution.belian.general.svc.CompanyStructureService;
import com.kratonsolution.belian.global.dm.EconomicAgent;
import com.kratonsolution.belian.security.dm.AccessRole;
import com.kratonsolution.belian.security.dm.AccessibleOrganization;
import com.kratonsolution.belian.security.dm.Module;
import com.kratonsolution.belian.security.dm.Role;
import com.kratonsolution.belian.security.svc.ModuleService;
import com.kratonsolution.belian.security.svc.RoleService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class RoleEditContent extends FormContent
{	
	private RoleService service = Springs.get(RoleService.class);

	private ModuleService moduleService = Springs.get(ModuleService.class);
	
	private CompanyStructureService structureService = Springs.get(CompanyStructureService.class);

	private Textbox code = new Textbox();

	private Textbox name = new Textbox();

	private Textbox note = new Textbox();

	private Row row;

	private Grid accessModules = new Grid();

	private Tabbox tabbox = new Tabbox();

	private Grid accessibleCompanys = new Grid();

	public RoleEditContent(Row row)
	{
		super();
		this.row = row;
		
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
				window.removeEditForm();
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

				Role role = service.findOne(RowUtils.string(row, 4));
				role.setCode(code.getText());
				role.setName(name.getText());
				role.setNote(note.getText());

				Rows moduleRows = accessModules.getRows();
				for(Object object:moduleRows.getChildren())
				{
					Row _row = (Row)object;

					Iterator<AccessRole> iterator = role.getAccesses().iterator();
					while (iterator.hasNext())
					{
						AccessRole accessRole = (AccessRole) iterator.next();
						if(accessRole.getId().equals(RowUtils.string(_row, 7)))
						{
							accessRole.setCanCreate(RowUtils.isChecked(_row, 1));
							accessRole.setCanRead(RowUtils.isChecked(_row, 2));
							accessRole.setCanUpdate(RowUtils.isChecked(_row, 3));
							accessRole.setCanDelete(RowUtils.isChecked(_row, 4));
							accessRole.setCanPrint(RowUtils.isChecked(_row, 5));
						}
					}
				}
				
				for(Component component:accessibleCompanys.getRows().getChildren())
				{
					Row _row = (Row)component;
					
					Iterator<AccessibleOrganization> iterator = role.getOrganizations().iterator();
					while (iterator.hasNext())
					{
						AccessibleOrganization org = (AccessibleOrganization) iterator.next();
						if(org.getId().equals(RowUtils.string(_row, 2)))
							org.setSelected(RowUtils.isChecked(_row, 1));
					}
				}

				service.edit(role);

				RoleWindow window = (RoleWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		code.setConstraint("no empty");
		code.setWidth("250px");
		code.setText(RowUtils.string(this.row,1));

		name.setConstraint("no empty");
		name.setWidth("250px");
		name.setText(RowUtils.string(row, 2));

		note.setText(RowUtils.string(row, 3));
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
		header.setColspan(8);
		header.setRowspan(1);

		head.appendChild(header);

		Columns columns = new Columns();
		columns.appendChild(new Column("Module",null,"175px"));
		columns.appendChild(new Column());
		columns.appendChild(new Column());
		columns.appendChild(new Column());
		columns.appendChild(new Column());
		columns.appendChild(new Column());
		columns.appendChild(new Column(null,null,"1px"));
		columns.appendChild(new Column(null,null,"1px"));
		columns.getChildren().get(6).setVisible(false);
		columns.getChildren().get(7).setVisible(false);

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

		columns.getChildren().get(1).appendChild(check1);
		columns.getChildren().get(2).appendChild(check2);
		columns.getChildren().get(3).appendChild(check3);
		columns.getChildren().get(4).appendChild(check4);
		columns.getChildren().get(5).appendChild(check5);

		Rows moduleRows = new Rows();

		List<Module> newModules = new ArrayList<Module>();

		Role role = service.findOne(RowUtils.string(this.row, 4));
		for(AccessRole accessRole:role.getAccesses())
		{
			if(accessRole.getModule() != null)
			{
				Module module = moduleService.findOne(accessRole.getModule().getId());
				if(module != null)
				{
					Checkbox create = new Checkbox();
					create.setChecked(accessRole.isCanCreate());

					Checkbox read = new Checkbox();
					read.setChecked(accessRole.isCanRead());

					Checkbox update = new Checkbox();
					update.setChecked(accessRole.isCanUpdate());

					Checkbox delete = new Checkbox();
					delete.setChecked(accessRole.isCanDelete());

					Checkbox print = new Checkbox();
					print.setChecked(accessRole.isCanPrint());

					Row row = new Row();
					row.appendChild(new Label(module.getName()));
					row.appendChild(create);
					row.appendChild(read);
					row.appendChild(update);
					row.appendChild(delete);
					row.appendChild(print);
					row.appendChild(new Label(module.getId()));
					row.appendChild(new Label(accessRole.getId()));

					moduleRows.appendChild(row);
				}
			}
		}

		for(Module module:moduleService.findAll())
		{
			boolean exist = false;
			for(AccessRole accessRole:role.getAccesses())
			{
				if(accessRole.getModule() != null && accessRole.getModule().getId().equals(module.getId()))
					exist = true;
			}

			if(!exist)
				newModules.add(module);
		}

		if(!newModules.isEmpty())
		{
			for(Module module:newModules)
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
		}

		accessModules.appendChild(head);
		accessModules.appendChild(columns);
		accessModules.appendChild(moduleRows);

		tabbox.getTabpanels().getChildren().get(0).appendChild(accessModules);
	}
	
	private void initCompanys()
	{
		Role role = service.findOne(RowUtils.string(row, 4));
		
		accessibleCompanys.appendChild(new Columns());
		accessibleCompanys.appendChild(new Rows());
		accessibleCompanys.getColumns().appendChild(new Column("Company",null, null));
		accessibleCompanys.getColumns().appendChild(new Column("Status",null, "65px"));
		accessibleCompanys.getColumns().appendChild(new Column("",null,null));
		accessibleCompanys.getColumns().getChildren().get(2).setVisible(false);
		
		if(role != null)
		{
			if(!role.getOrganizations().isEmpty())
				populateCompanys(role.getOrganizations());
			else
			{
				List<AccessibleOrganization> orgs = new ArrayList<AccessibleOrganization>();
				for(EconomicAgent organization:structureService.findAllCompanyMembers())
				{
					AccessibleOrganization accessibleOrganization = new AccessibleOrganization();
					accessibleOrganization.setId(UUID.randomUUID().toString());
					accessibleOrganization.setRole(role);
					accessibleOrganization.setOrganization((Organization)organization);
					
					role.getOrganizations().add(accessibleOrganization);
				
					orgs.add(accessibleOrganization);
				}
				
				service.edit(role);
				
				populateCompanys(orgs);
			}
		}
		
		tabbox.getTabpanels().getChildren().get(1).appendChild(accessibleCompanys);
	}

	private void populateCompanys(Collection<AccessibleOrganization> companys)
	{
		for(AccessibleOrganization access:companys)
		{
			Row row = new Row();
			row.appendChild(new Label(access.getOrganization().getName()));
			row.appendChild(Components.checkbox(access.isSelected()));
			row.appendChild(new Label(access.getId()));
			
			accessibleCompanys.getRows().appendChild(row);
		}
	}
}
