/**
 * 
 */
package com.kratonsolution.belian.ui.role;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.security.dm.Role;
import com.kratonsolution.belian.security.view.RoleController;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class RoleFormContent extends FormContent
{	
	private final RoleController controller = Springs.get(RoleController.class);
	
	private Textbox code = new Textbox();
	
	private Textbox name = new Textbox();
	
	public RoleFormContent()
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
				RoleWindow window = (RoleWindow)getParent();
				window.removeForm();
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
				role.setCode(code.getText());
				role.setName(name.getText());
				
				controller.add(role);
				
				RoleWindow window = (RoleWindow)getParent();
				window.removeForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		code.setConstraint("no empty");
		name.setConstraint("no empty");
		
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

	@Override
	public Component getInstance()
	{
		return this;
	}
}
