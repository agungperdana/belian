package com.kratonsolution.belian.security.ui.user;

import org.zkoss.util.resource.Labels;
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
import com.kratonsolution.belian.common.ui.AbstractForm;
import com.kratonsolution.belian.common.ui.event.UIEvent;
import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.common.ui.util.FlowHelper;
import com.kratonsolution.belian.common.ui.util.RowUtils;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.security.api.RoleData;
import com.kratonsolution.belian.security.api.application.CreateUserCommand;
import com.kratonsolution.belian.security.api.application.RoleService;
import com.kratonsolution.belian.security.api.application.UserService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class UserFormContent extends AbstractForm
{	
	private static final long serialVersionUID = -7413880943776472L;

	private Textbox name = Components.mandatoryTextBox(false);
	
	private Textbox email = Components.mandatoryTextBox(false);
	
	private Textbox password = Components.mandatoryTextBox(false);
	
	private Textbox repassword = Components.mandatoryTextBox(false);
	
	private Checkbox enabled = new Checkbox("Active");
	
	private Grid roles = new Grid();
	
	private UserService service = Springs.get(UserService.class);
	
	private RoleService roleService = Springs.get(RoleService.class);
	
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
				FlowHelper.next(getParent(), UIEvent.GRID);
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(email, Labels.getLabel("form.name"));
				
				if(Strings.isNullOrEmpty(email.getText()))
					throw new WrongValueException(email, Labels.getLabel("form.email"));
			
				if(Strings.isNullOrEmpty(password.getText()))
					throw new WrongValueException(password, Labels.getLabel("form.password"));
				
				if(Strings.isNullOrEmpty(repassword.getText()))
					throw new WrongValueException(repassword, Labels.getLabel("form.repassword"));
				
				if(!password.getText().equals(repassword.getText()))
					throw new WrongValueException(repassword, Labels.getLabel("form.password.notmatch"));
				
				CreateUserCommand command = new CreateUserCommand();
				command.setEmail(email.getText());
				command.setName(name.getText());
				command.setPassword(password.getText());
				command.setEnabled(enabled.isChecked());
				
				service.create(command);
				FlowHelper.next(getParent(), UIEvent.GRID);
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
		
		Row row0 = new Row();
		row0.appendChild(new Label(Labels.getLabel("form.name")));
		row0.appendChild(name);
		
		Row row1 = new Row();
		row1.appendChild(new Label(Labels.getLabel("form.email")));
		row1.appendChild(email);
		
		Row row2 = new Row();
		row2.appendChild(new Label(Labels.getLabel("form.password")));
		row2.appendChild(password);
		
		Row row3 = new Row();
		row3.appendChild(new Label(Labels.getLabel("form.repassword")));
		row3.appendChild(repassword);
		
		Row row4 = new Row();
		row4.appendChild(new Label(Labels.getLabel("form.status")));
		row4.appendChild(enabled);

		rows.appendChild(row0);
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);

	}
	
	protected void initRoles()
	{
		Auxhead head = new Auxhead();
		Auxheader header = new Auxheader(Labels.getLabel("form.userrole"));
		header.setColspan(2);
		header.setRowspan(1);
		
		head.appendChild(header);
		
		Column col1 = new Column(Labels.getLabel("form.role"));
		col1.setWidth("175px");
		
		Checkbox all = new Checkbox(Labels.getLabel("form.selectall"));
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

		Rows _rows = new Rows();
		for(RoleData role:roleService.getAllRoles())
		{
			Row row = new Row();
			row.appendChild(new Label(role.getName()));
			row.appendChild(new Checkbox());
			
			_rows.appendChild(row);
		}
		
		roles.appendChild(head);
		roles.appendChild(columns);
		roles.appendChild(_rows);
		
		appendChild(roles);
	}
}
