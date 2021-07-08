package com.kratonsolution.belian.security.ui.user;

import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.access.api.application.ChangePasswordCommand;
import com.kratonsolution.belian.access.api.application.UserService;
import com.kratonsolution.belian.common.ui.AbstractForm;
import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.common.ui.util.FlowHelper;
import com.kratonsolution.belian.common.ui.util.Springs;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class ChangePassword extends AbstractForm
{
	private static final long serialVersionUID = 8705274328741214663L;

	private UserService service = Springs.get(UserService.class);
	
	private Textbox oldPassword = Components.mandatoryTextBox(false);
	
	private Textbox newPassword = Components.mandatoryTextBox(false);
	
	private Textbox renewPassword = Components.mandatoryTextBox(false);

	private String userName;
	
	public ChangePassword(@NonNull String userName)
	{
		super();
		this.userName = userName;
		initToolbar();
		initForm();
	}
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.FormContent#initToolbar()
	 */
	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK, e->FlowHelper.next(UserUIEvent.editForm(this.userName)));
		toolbar.getSave().addEventListener(Events.ON_CLICK, e->{
			
			if(!newPassword.getText().equals(renewPassword.getText()))
				Messagebox.show("New Password not equal");
			else
			{
				ChangePasswordCommand command = new ChangePasswordCommand();
				command.setName(userName);
				command.setOldPassword(oldPassword.getText());
				command.setNewPassword(newPassword.getText());
				
				service.changePassword(command);
				
				FlowHelper.next(UserUIEvent.editForm(this.userName));
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.FormContent#initForm()
	 */
	@Override
	public void initForm()
	{
		oldPassword.setType("password");
		oldPassword.setConstraint("no empty");
		
		newPassword.setType("password");
		newPassword.setConstraint("no empty");
		
		renewPassword.setType("password");
		renewPassword.setConstraint("no empty");
		
		Row row1 = new Row();
		row1.appendChild(new Label("Current Password"));
		row1.appendChild(oldPassword);
		
		Row row2 = new Row();
		row2.appendChild(new Label("New Password"));
		row2.appendChild(newPassword);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Re - New Password"));
		row3.appendChild(renewPassword);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"150px"));
		grid.getColumns().appendChild(new Column());
		grid.setSpan("1");
	}
}