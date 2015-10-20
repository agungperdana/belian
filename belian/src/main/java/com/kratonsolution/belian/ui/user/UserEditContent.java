/**
 * 
 */
package com.kratonsolution.belian.ui.user;

import java.util.Iterator;

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
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.security.dm.User;
import com.kratonsolution.belian.security.dm.UserRole;
import com.kratonsolution.belian.security.svc.UserService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class UserEditContent extends FormContent
{	
	private UserService service = Springs.get(UserService.class);

	private PersonService personService = Springs.get(PersonService.class);

	private Textbox name = new Textbox();

	private Textbox email = new Textbox();

	private Listbox employee = Components.newSelect();

	private A link = new A("Change Password");

	private Checkbox enabled = new Checkbox("Active");

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
				UserWindow window = (UserWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(employee.getChildren().size() <= 0)
					throw new WrongValueException(employee,"Employee cannot be empty");
				
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Code cannot be empty");

				if(Strings.isNullOrEmpty(email.getText()))
					throw new WrongValueException(email,"Name cannot be empty");

				User user = service.findOne(RowUtils.string(row, 4));
				if(user != null)
				{
					user.setName(name.getText());
					user.setEmail(email.getText());
					user.setEnabled(enabled.isChecked());
					user.setPerson(personService.findOne(Components.string(employee)));

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
					personService.edit(user.getPerson());
				}

				UserWindow window = (UserWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		User user = service.findOne(RowUtils.string(row, 4));
		if(user != null)
		{
			for(Person person:personService.findAll())
			{
				Listitem listitem = new Listitem(person.getLabel(), person.getValue());
				employee.appendChild(listitem);
				
				if(user.getPerson() != null)
				{
					if(person.getId().equals(user.getPerson().getId()))
						employee.setSelectedItem(listitem);
				}
				else
					Components.setDefault(employee);
			}
			
			link.addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					UserWindow window = (UserWindow)getParent();
					window.removeEditForm();
					window.appendChild(new ChangePassword(row));
				}
			});

			name.setConstraint("no empty");
			name.setText(user.getName());
			name.setWidth("250px");

			email.setConstraint("no empty");
			email.setText(user.getEmail());
			email.setWidth("250px");
			
			if(RowUtils.string(row, 3).equals("Active"))
				enabled.setChecked(true);
			else
				enabled.setChecked(false);

			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"150px"));
			grid.getColumns().appendChild(new Column());
			grid.setSpan("2");

			Row row1 = new Row();
			row1.appendChild(new Label("Name"));
			row1.appendChild(name);

			Row row2 = new Row();
			row2.appendChild(new Label("Email"));
			row2.appendChild(email);
			
			Row row3 = new Row();
			row3.appendChild(new Label("Employee"));
			row3.appendChild(employee);

			Row row4 = new Row();
			row4.appendChild(new Label(""));
			row4.appendChild(link);

			Row row5 = new Row();
			row5.appendChild(new Label("Status"));
			row5.appendChild(enabled);

			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			rows.appendChild(row4);
			rows.appendChild(row5);
		}
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

		User user = service.findOne(RowUtils.string(row, 4));
		if(user != null)
		{
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
			}

			roles.appendChild(_rows);
		}

		appendChild(roles);
	}
}
