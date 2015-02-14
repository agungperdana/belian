/**
 * 
 */
package com.kratonsolution.belian.ui.user;

import java.util.UUID;

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
import com.kratonsolution.belian.security.dm.Role;
import com.kratonsolution.belian.security.dm.User;
import com.kratonsolution.belian.security.dm.UserRole;
import com.kratonsolution.belian.security.svc.RoleService;
import com.kratonsolution.belian.security.svc.UserService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class UserFormContent extends FormContent
{	
	private final UserService controller = Springs.get(UserService.class);
	
	private final RoleService roleController = Springs.get(RoleService.class);
	
	private Textbox name = new Textbox();
	
	private Textbox email = new Textbox();
	
	private Textbox password = new Textbox();
	
	private Textbox repassword = new Textbox();
	
	private Checkbox enabled = new Checkbox("Active");
	
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
				UserWindow window = (UserWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Code cannot be empty");
			
				if(Strings.isNullOrEmpty(email.getText()))
					throw new WrongValueException(email,"Name cannot be empty");
			
				if(Strings.isNullOrEmpty(password.getText()))
					throw new WrongValueException(password,"Password cannot be empty");
				
				if(Strings.isNullOrEmpty(repassword.getText()))
					throw new WrongValueException(repassword,"Re Password cannot be empty");
				
				if(!password.getText().equals(repassword.getText()))
					throw new WrongValueException(repassword,"Re Password not equal");
					
				User user = new User();
				user.setName(name.getText());
				user.setEmail(email.getText());
				user.setPassword(password.getText());
				user.setRePassword(repassword.getText());
				user.setEnabled(enabled.isChecked());
				
				Rows _rows = roles.getRows();
				for(Object object:_rows.getChildren())
				{
					Row row = (Row)object;
					
					Role role = roleController.findOne(RowUtils.rowValue(row, 2));
					if(role != null)
					{
						UserRole userRole = new UserRole();
						userRole.setId(UUID.randomUUID().toString());
						userRole.setRole(role);
						userRole.setEnabled(RowUtils.isChecked(row, 1));
						
						user.getRoles().add(userRole);
					}
				}
				
				controller.add(user);
				
				UserWindow window = (UserWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		name.setConstraint("no empty");
		name.setWidth("250px");
		
		email.setConstraint("no empty");
		email.setWidth("250px");
		
		password.setConstraint("no empty");
		password.setType("password");
		password.setWidth("250px");
		
		repassword.setConstraint("no empty");
		repassword.setType("password");
		repassword.setWidth("250px");
		
		enabled.setChecked(true);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"150px"));
		grid.getColumns().appendChild(new Column());
		grid.setSpan("1");
		
		Row row1 = new Row();
		row1.appendChild(new Label("Name"));
		row1.appendChild(name);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Email"));
		row2.appendChild(email);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Password"));
		row3.appendChild(password);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Re - Password"));
		row4.appendChild(repassword);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Status"));
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
		Auxheader header = new Auxheader("User Role");
		header.setColspan(3);
		header.setRowspan(1);
		
		head.appendChild(header);
		
		Column col1 = new Column("Role");
		col1.setWidth("175px");
		
		Checkbox all = new Checkbox("Enable All");
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
		for(Role role:roleController.findAll())
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