/**
 * 
 */
package com.kratonsolution.belian.ui.role;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.security.dm.AccessRole;
import com.kratonsolution.belian.security.dm.Module;
import com.kratonsolution.belian.security.dm.Role;
import com.kratonsolution.belian.security.view.ModuleController;
import com.kratonsolution.belian.security.view.RoleController;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class RoleEditContent extends FormContent
{	
	private final RoleController controller = Springs.get(RoleController.class);
	
	private final ModuleController moduleController = Springs.get(ModuleController.class);
	
	private Textbox code = new Textbox();
	
	private Textbox name = new Textbox();
	
	private Row row;
	
	private Grid accessModules = new Grid();
	
	public RoleEditContent(Row row)
	{
		super();
		this.row = row;
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
				
				Role role = new Role();
				role.setId(RowUtils.rowValue(row, 3));
				role.setCode(code.getText());
				role.setName(name.getText());
				
				Rows moduleRows = accessModules.getRows();
				for(Object object:moduleRows.getChildren())
				{
					Row _row = (Row)object;
					
					Module module = new Module();
					module.setId(RowUtils.rowValue(_row, 6));
					
					AccessRole accessRole = new AccessRole();
					accessRole.setId(UUID.randomUUID().toString());
					accessRole.setModule(module);
					accessRole.setCanCreate(RowUtils.isChecked(_row, 1));
					accessRole.setCanRead(RowUtils.isChecked(_row, 2));
					accessRole.setCanUpdate(RowUtils.isChecked(_row, 3));
					accessRole.setCanDelete(RowUtils.isChecked(_row, 4));
					accessRole.setCanPrint(RowUtils.isChecked(_row, 5));
					
					role.getAccesses().add(accessRole);
				}
				
				controller.add(role);
				
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
		code.setText(RowUtils.rowValue(this.row,1));
		
		name.setConstraint("no empty");
		name.setText(RowUtils.rowValue(row, 2));
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Code"));
		row1.appendChild(code);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Name"));
		row2.appendChild(name);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
	}

	protected void initModules()
	{
		Auxhead head = new Auxhead();
		Auxheader header = new Auxheader("Module Access");
		header.setColspan(7);
		header.setRowspan(1);
		
		head.appendChild(header);
		
		Columns columns = new Columns();
		
		Column column1 = new Column("Module");
		column1.setWidth("175px");
		
		Column column2 = new Column();
		Column column3 = new Column();
		Column column4 = new Column();
		Column column5 = new Column();
		Column column6 = new Column();
		Column column7 = new Column();
		column7.setVisible(false);
		
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
		
		column2.appendChild(check1);
		column3.appendChild(check2);
		column4.appendChild(check3);
		column5.appendChild(check4);
		column6.appendChild(check5);
			
		columns.appendChild(column1);
		columns.appendChild(column2);
		columns.appendChild(column3);
		columns.appendChild(column4);
		columns.appendChild(column5);
		columns.appendChild(column6);
		columns.appendChild(column7);
	
		Rows moduleRows = new Rows();
		
		List<Module> newModules = new ArrayList<Module>();
		
		Role role = controller.findOne(RowUtils.rowValue(this.row, 3));
		for(AccessRole accessRole:role.getAccesses())
		{
			if(accessRole.getModule() != null)
			{
				Module module = moduleController.findOne(accessRole.getModule().getId());
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
					
					moduleRows.appendChild(row);
				}
			}
		}
		
		for(Module module:moduleController.findAll())
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
		
		appendChild(accessModules);
	}
}
