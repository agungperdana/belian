/**
 * 
 */
package com.kratonsolution.belian.ui.user;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.security.svc.UserService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class ChangePassword extends FormContent
{
	private final UserService controller = Springs.get(UserService.class);
	
	private Row row;
	
	private Textbox oldPassword = new Textbox();
	
	private Textbox newPassword = new Textbox();
	
	private Textbox renewPassword = new Textbox();
	
	public ChangePassword(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
	}
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.FormContent#initToolbar()
	 */
	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				UserWindow window = (UserWindow)getParent();
				window.removeChild(get());
				window.insertEditForm(row);
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(!newPassword.getText().equals(renewPassword.getText()))
					Messagebox.show("New Password not equal");
				else
				{
					controller.changePassword(RowUtils.string(row,4), newPassword.getText(), renewPassword.getText());
					
					UserWindow window = (UserWindow)getParent();
					window.removeChild(get());
					window.insertEditForm(row);
				}
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
		oldPassword.setReadonly(true);
		oldPassword.setWidth("250px");
		oldPassword.setText("user password");
		
		newPassword.setType("password");
		newPassword.setWidth("250px");
		
		renewPassword.setType("password");
		renewPassword.setWidth("250px");
		
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
	
	protected Component get()
	{
		return this;
	}

}
