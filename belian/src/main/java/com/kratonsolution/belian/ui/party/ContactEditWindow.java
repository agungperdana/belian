/**
 * 
 */
package com.kratonsolution.belian.ui.party;

import java.util.Iterator;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
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
import org.zkoss.zul.Window;

import com.kratonsolution.belian.general.dm.Contact;
import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.svc.PartyService;
import com.kratonsolution.belian.ui.FormToolbar;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class ContactEditWindow extends Window
{
	private FormToolbar toolbar = new FormToolbar();
	
	private Grid layout = new Grid();
	
	private Textbox number = new Textbox();
	
	private Listbox type = new Listbox();
	
	private Checkbox status = new Checkbox("Active");
	
	private PartyService service = Springs.get(PartyService.class);
	
	private Contact edited;
	
	public ContactEditWindow(Contact edited)
	{
		this.edited = edited;
		
		setMode(Mode.POPUP);
		setWidth("450px");
		setHeight("400px");
		setPosition("center");
		
		Caption caption = new Caption("Contact");
		caption.setImage("/icons/contact.png");
	
		type.setMold("select");
		
		appendChild(caption);
		appendChild(toolbar);
		appendChild(layout);
		setClosable(true);
		
		initToolbar();
		initContent();
	}
	
	protected void initToolbar()
	{
		toolbar.setHeight("35px");
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				detach();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Party party = service.findOne(edited.getParty().getId());
				if(party != null)
				{
					Iterator<Contact> iterator = party.getContacts().iterator();
					while (iterator.hasNext())
					{
						Contact contact = (Contact) iterator.next();
						if(contact.getId().equals(edited.getId()))
						{
							contact.setContact(number.getText());
							contact.setActive(status.isChecked());
							contact.setType(Contact.Type.valueOf(type.getSelectedItem().getValue().toString()));
							break;
						}
					}
					
					service.edit(party);
					((Refreshable)getParent()).refresh();
				}
				
				detach();
			}
		});
	}
	
	protected void initContent()
	{
		number.setWidth("300px");
		number.setConstraint("no empty");
		number.setText(edited.getContact());
		
		status.setChecked(edited.isActive());
		
		layout.appendChild(new Rows());
		layout.appendChild(new Columns());
		layout.getColumns().appendChild(new Column(null,null,"75px"));
		layout.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Number"));
		row1.appendChild(number);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Status"));
		row3.appendChild(status);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Type"));
		row4.appendChild(type);
		
		for(Contact.Type _type:Contact.Type.values())
		{
			Listitem listitem = new Listitem(_type.name(),_type.name());
			type.appendChild(listitem);
			if(_type.equals(edited.getType()))
				type.setSelectedItem(listitem);
		}
				
		layout.getRows().appendChild(row1);
		layout.getRows().appendChild(row3);
		layout.getRows().appendChild(row4);
	}
	
	@Override
	public void onClose()
	{
		setVisible(false);
		setParent(null);
	}
}
