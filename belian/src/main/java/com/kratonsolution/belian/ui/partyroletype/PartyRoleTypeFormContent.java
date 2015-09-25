/**
 * 
 */
package com.kratonsolution.belian.ui.partyroletype;

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
import com.kratonsolution.belian.general.dm.PartyRoleType;
import com.kratonsolution.belian.general.svc.PartyRoleService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class PartyRoleTypeFormContent extends FormContent
{	
	private PartyRoleService service = Springs.get(PartyRoleService.class);
		
	private Textbox name = Components.mandatoryTextBox();
	
	private Textbox description = Components.mandatoryTextBox();
	
	public PartyRoleTypeFormContent()
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
				PartyRoleTypeWindow window = (PartyRoleTypeWindow)getParent();
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
					throw new WrongValueException(name,"Name cannot be empty");
			
				PartyRoleType type = new PartyRoleType();
				type.setName(name.getText());
				type.setDescription(description.getText());
				type.setDeleteable(true);
				
//				service.add(type);
				
				PartyRoleTypeWindow window = (PartyRoleTypeWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		name.setConstraint("no empty");
		name.setWidth("300px");
		
		description.setConstraint("no empty");
		description.setWidth("300px");
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Name"));
		row1.appendChild(name);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Description"));
		row2.appendChild(description);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
	}
}
