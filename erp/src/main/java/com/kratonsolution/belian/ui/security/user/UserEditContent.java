
package com.kratonsolution.belian.ui.security.user;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.A;
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
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class UserEditContent extends AbstractForm
{	
	private UserService service = Springs.get(UserService.class);

	private PersonService personService = Springs.get(PersonService.class);
	
	private RoleService roleService = Springs.get(RoleService.class);

	private Textbox email = Components.mandatoryTextBox(false);

	private A link = new A(lang.get("generic.grid.column.changepassword"));

	private Checkbox enabled = new Checkbox(lang.get("generic.grid.column.active"));

	private Row row;

	private final Grid roles = new Grid();

	public UserEditContent(Row row)
	{
		super();
		this.row = row;
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
				if(Strings.isNullOrEmpty(email.getText()))
					throw new WrongValueException(email,lang.get("message.field.empty"));

				User user = service.getOne(RowUtils.id(row));
				if(user != null)
				{
					user.setUserName(email.getText());
					user.setEnabled(enabled.isChecked());

					for(Object object:roles.getRows().getChildren())
					{
						Row target = (Row)object;

						Iterator<UserRole> iterator = user.getRoles().iterator();
						while (iterator.hasNext())
						{
							UserRole userRole = (UserRole) iterator.next();
							if(userRole.getId().equals(RowUtils.string(target, 2)))
								userRole.setEnabled(RowUtils.isChecked(target, 1));
						}
					}

					service.edit(user);
				}

				Flow.next(getParent(), new UserGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		User user = service.getOne(RowUtils.id(row));
		if(user != null)
		{
			link.addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					Flow.next(getParent(), new ChangePassword(row,false));
				}
			});

			email.setConstraint("no empty");
			email.setText(user.getUserName());
			email.setWidth("250px");
			enabled.setChecked(user.isEnabled());

			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"150px"));
			grid.getColumns().appendChild(new Column());
			grid.setSpan("2");

			Row row2 = new Row();
			row2.appendChild(new Label(lang.get("generic.grid.column.username")));
			row2.appendChild(email);

			Row row4 = new Row();
			row4.appendChild(new Label(""));
			row4.appendChild(link);

			Row row5 = new Row();
			row5.appendChild(new Label(lang.get("generic.grid.column.status")));
			row5.appendChild(enabled);

			rows.appendChild(row2);
			rows.appendChild(row4);
			rows.appendChild(row5);
		}
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

				Rows rows = roles.getRows();
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

		roles.appendChild(head);
		roles.appendChild(columns);

		User user = service.getOne(RowUtils.id(row));
		if(user != null)
		{
			Map<String,Boolean> already = new HashMap<>();
			
			Rows _rows = new Rows();
			for(UserRole role:user.getRoles())
			{
				Row row = new Row();
				row.appendChild(new Label(role.getRole().getName()));

				Checkbox checkbox = new Checkbox();
				checkbox.setChecked(role.isEnabled());

				row.appendChild(checkbox);
				row.appendChild(new Label(role.getId()));

				_rows.appendChild(row);
				
				already.put(role.getRole().getId(), true);
			}

			for(Role role:roleService.findAll())
			{
				if(!already.containsKey(role.getId()))
				{
					Row row = new Row();
					row.appendChild(new Label(role.getName()));
					row.appendChild(Components.checkbox(false));
					row.appendChild(new Label(role.getId()));

					_rows.appendChild(row);
				}
			}
			
			roles.appendChild(_rows);
		}

		appendChild(roles);
	}
}
