
package com.kratonsolution.belian.ui.security.user;

import org.zkoss.zk.ui.WrongValueException;
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
import com.kratonsolution.belian.partys.svc.PersonService;
import com.kratonsolution.belian.security.impl.dm.Role;
import com.kratonsolution.belian.security.impl.dm.User;
import com.kratonsolution.belian.security.impl.dm.UserRole;
import com.kratonsolution.belian.security.impl.svc.RoleService;
import com.kratonsolution.belian.security.impl.svc.UserService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.hr.employment.EmployeeList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @since 1.0.0
 */
public class UserFormContent extends AbstractForm
{	
	private UserService service = Springs.get(UserService.class);
	
	private RoleService roleService = Springs.get(RoleService.class);
	
	private PersonService personService = Springs.get(PersonService.class);
	
	private Textbox email = Components.mandatoryTextBox(false);
	
	private Textbox password = Components.mandatoryTextBox(false);
	
	private Textbox repassword = Components.mandatoryTextBox(false);
	
	private Checkbox enabled = new Checkbox(lang.get("generic.grid.column.active"));
	
	private EmployeeList employees = new EmployeeList(false);
	
	private Grid roles = new Grid();
	
	public UserFormContent()
	{
		super();
		initToolbar();
		initForm();
		initRoles();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new UserGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(employees.getChildren().size() <= 0)
					throw new WrongValueException(employees,lang.get("message.field.empty"));
				
				if(Strings.isNullOrEmpty(email.getText()))
					throw new WrongValueException(email,lang.get("message.field.empty"));
			
				if(Strings.isNullOrEmpty(password.getText()))
					throw new WrongValueException(password,lang.get("message.field.empty"));
				
				if(Strings.isNullOrEmpty(repassword.getText()))
					throw new WrongValueException(repassword,lang.get("message.field.empty"));
				
				if(!password.getText().equals(repassword.getText()))
					throw new WrongValueException(repassword,lang.get("message.field.empty"));
					
				User user = new User();
				user.setUserName(email.getText());
				user.setPassword(password.getText());
				user.setEnabled(enabled.isChecked());
//				user.setEmployee(employees.getDomain());
				
				service.add(user);
				
				Rows _rows = roles.getRows();
				for(Object object:_rows.getChildren())
				{
					Row row = (Row)object;
					
					Role role = roleService.getOne(RowUtils.string(row, 2));
					if(role != null)
					{
						UserRole userRole = new UserRole();
						userRole.setRole(role);
						userRole.setUser(user);
						userRole.setEnabled(RowUtils.isChecked(row, 1));
						
						user.getRoles().add(userRole);
					}
				}
				
				service.edit(user);
				
				Flow.next(getParent(), new UserGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{		
		password.setType("password");
		repassword.setType("password");
		enabled.setChecked(true);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"150px"));
		grid.getColumns().appendChild(new Column());
		grid.setSpan("1");
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("generic.grid.column.username")));
		row1.appendChild(email);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generic.grid.column.employee")));
		row2.appendChild(employees);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("generic.grid.column.password")));
		row3.appendChild(password);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("generic.grid.column.repassword")));
		row4.appendChild(repassword);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("generic.grid.column.status")));
		row5.appendChild(enabled);

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);

	}
	
	protected void initRoles()
	{
		Auxhead head = new Auxhead();
		Auxheader header = new Auxheader(lang.get("generic.grid.column.userrole"));
		header.setColspan(3);
		header.setRowspan(1);
		
		head.appendChild(header);
		
		Column col1 = new Column(lang.get("generic.grid.column.role"));
		col1.setWidth("175px");
		
		Checkbox all = new Checkbox(lang.get("generic.grid.column.enableall"));
		all.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Checkbox source = (Checkbox)event.getTarget();
				
				Rows rows = grid.getRows();
				for(Object object:rows.getChildren())
				{
					Row row = (Row)object;
					if(source.isChecked())
						RowUtils.checked(row,1);
					else
						RowUtils.unchecked(row, 1);
				}
			}
		});
		
		Column col2 = new Column();
		col2.appendChild(all);
		
		Column col3 = new Column();
		col3.setVisible(false);
		
		Columns columns = new Columns();
		columns.appendChild(col1);
		columns.appendChild(col2);
		columns.appendChild(col3);

		Rows _rows = new Rows();
		for(Role role:roleService.findAll())
		{
			Row row = new Row();
			row.appendChild(new Label(role.getName()));
			row.appendChild(new Checkbox());
			row.appendChild(new Label(role.getId()));
			
			_rows.appendChild(row);
		}
		
		roles.appendChild(head);
		roles.appendChild(columns);
		roles.appendChild(_rows);
		
		appendChild(roles);
	}
}
