/**
 * 
 */
package com.kratonsolution.belian.ui.party;

import java.util.Iterator;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.general.dm.PartyRelationship;
import com.kratonsolution.belian.general.dm.PartyRelationshipType;
import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.general.svc.PartyRelationshipTypeService;
import com.kratonsolution.belian.general.svc.PartyRoleTypeService;
import com.kratonsolution.belian.global.dm.EconomicAgent;
import com.kratonsolution.belian.global.svc.EconomicAgentService;
import com.kratonsolution.belian.ui.FormToolbar;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class RelationshipEditWindow extends Window
{
	private FormToolbar toolbar = new FormToolbar();
	
	private Grid layout = new Grid();
	
	private Datebox from = new Datebox();
	
	private Datebox to = new Datebox();
	
	private Listbox types = new Listbox();
	
	private Listbox fromRole = new Listbox();
	
	private Listbox toParty = new Listbox();
	
	private EconomicAgentService service = Springs.get(EconomicAgentService.class);

	private PartyRelationshipTypeService relationshipTypeController = Springs.get(PartyRelationshipTypeService.class);
	
	private PartyRoleTypeService roleTypeController = Springs.get(PartyRoleTypeService.class);
	
	private PartyRelationship edited;
	
	public RelationshipEditWindow(PartyRelationship edited)
	{
		this.edited = edited;
		
		setMode(Mode.POPUP);
		setWidth("450px");
		setHeight("400px");
		setPosition("center");
		
		Caption caption = new Caption("Party Relationship");
		caption.setImage("/icons/relationshiptype.png");
		
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
				EconomicAgent party = service.findOne(edited.getParty().getId());
				if(party != null)
				{
					Iterator<PartyRelationship> iterator = party.getRelationships().iterator();
					while (iterator.hasNext())
					{
						PartyRelationship rel = (PartyRelationship) iterator.next();
						if(rel.getId().equals(edited.getId()))
						{
							rel.setFrom(from.getValue());
							rel.setTo(to.getValue());
							rel.setRelationshipType(relationshipTypeController.findOne(types.getSelectedItem().getValue().toString()));
							rel.setResponsibleTo(service.findOne(toParty.getSelectedItem().getValue().toString()));
							rel.setResponsibleAs(roleTypeController.findOne(fromRole.getSelectedItem().getValue().toString()));
							
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
		from.setConstraint("no empty");
		from.setValue(edited.getFrom());
		
		to.setValue(edited.getTo());
		to.setValue(edited.getTo());
		
		types.setMold("select");
		fromRole.setMold("select");
		toParty.setMold("select");
		
		layout.appendChild(new Rows());
		layout.appendChild(new Columns());
		layout.getColumns().appendChild(new Column(null,null,"75px"));
		layout.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("From"));
		row1.appendChild(from);
		
		Row row3 = new Row();
		row3.appendChild(new Label("To"));
		row3.appendChild(to);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Type"));
		row4.appendChild(types);
		
		Row row5 = new Row();
		row5.appendChild(new Label("From Role"));
		row5.appendChild(fromRole);
		
		Row row6 = new Row();
		row6.appendChild(new Label("To Party"));
		row6.appendChild(toParty);
		
		for(PartyRelationshipType type:relationshipTypeController.findAll())
		{
			Listitem listitem = new Listitem(type.getName(),type.getId());
			types.appendChild(listitem);
			
			if(type.getId().equals(edited.getRelationshipType().getId()))
				types.setSelectedItem(listitem);
		}
		
		for(EconomicAgent pty:service.findAll())
		{
			Listitem listitem = new Listitem(pty.getName(),pty.getId());
			toParty.appendChild(listitem);
			
			if(pty.getId().equals(edited.getResponsibleTo().getId()))
				toParty.setSelectedItem(listitem);
		}
		
		for(PartyRole role:service.findOne(edited.getParty().getId()).getRoles())
		{
			Listitem listitem = new Listitem(role.getType().getName(),role.getType().getId());
			fromRole.appendChild(listitem);
			
			if(role.getType().getId().equals(edited.getResponsibleAs().getId()))
				fromRole.setSelectedItem(listitem);
		}
		
		layout.getRows().appendChild(row1);
		layout.getRows().appendChild(row3);
		layout.getRows().appendChild(row4);
		layout.getRows().appendChild(row5);
		layout.getRows().appendChild(row6);
	}
	
	@Override
	public void onClose()
	{
		setVisible(false);
		setParent(null);
	}
}
