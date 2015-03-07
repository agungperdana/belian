/**
 * 
 */
package com.kratonsolution.belian.ui.partyrelationshiptype;

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
import com.kratonsolution.belian.general.dm.PartyRelationshipType;
import com.kratonsolution.belian.general.svc.PartyRelationshipTypeService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class PartyRelationshipTypeFormContent extends FormContent
{	
	private final PartyRelationshipTypeService service = Springs.get(PartyRelationshipTypeService.class);
		
	private Textbox name = new Textbox();
	
	public PartyRelationshipTypeFormContent()
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
				PartyRelationshipTypeWindow window = (PartyRelationshipTypeWindow)getParent();
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
			
				PartyRelationshipType type = new PartyRelationshipType();
				type.setName(name.getText());
				
				service.add(type);
				
				PartyRelationshipTypeWindow window = (PartyRelationshipTypeWindow)getParent();
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
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row2 = new Row();
		row2.appendChild(new Label("Name"));
		row2.appendChild(name);
		
		rows.appendChild(row2);
	}
}
