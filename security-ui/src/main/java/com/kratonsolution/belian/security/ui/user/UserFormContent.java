package com.kratonsolution.belian.security.ui.user;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.ui.AbstractForm;
import com.kratonsolution.belian.common.ui.event.WindowContentChangeEvent;
import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.common.ui.util.FlowHelper;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.security.api.application.CreateUserCommand;
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
	
	private UserService service = Springs.get(UserService.class);
	
	public UserFormContent()
	{
		super();
		initToolbar();
		initForm();
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
				FlowHelper.next(getParent(), WindowContentChangeEvent.GRID);
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
}
