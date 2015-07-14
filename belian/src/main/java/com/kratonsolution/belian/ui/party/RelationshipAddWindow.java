/**
 * 
 */
package com.kratonsolution.belian.ui.party;

import java.util.UUID;

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
public class RelationshipAddWindow extends Window
{
	private FormToolbar toolbar = new FormToolbar();
	
	private Grid layout = new Grid();
	
	private Datebox from = new Datebox();
	
	private Datebox to = new Datebox();

	private Listbox fromRole = new Listbox();
	
	private Listbox toParty = new Listbox();
	
	private Listbox types = new Listbox();
	
	private EconomicAgentService service = Springs.get(EconomicAgentService.class);
	
	private PartyRelationshipTypeService relationshipTypeController = Springs.get(PartyRelationshipTypeService.class);
	
	private PartyRoleTypeService roleTypeController = Springs.get(PartyRoleTypeService.class);
	
	private String partyId;
	
	public RelationshipAddWindow(String partyId)
	{
		this.partyId = partyId;
		
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
				EconomicAgent party = service.findOne(partyId);
				if(party != null)
				{
					PartyRelationship relationship = new PartyRelationship();
					relationship.setId(UUID.randomUUID().toString());
					relationship.setFrom(from.getValue());
					relationship.setTo(to.getValue());
					relationship.setRelationshipType(relationshipTypeController.findOne(types.getSelectedItem().getValue().toString()));
					relationship.setResponsibleTo(service.findOne(toParty.getSelectedItem().getValue().toString()));
					relationship.setResponsibleAs(roleTypeController.findOne(fromRole.getSelectedItem().getValue().toString()));
					relationship.setParty(party);
					
					party.getRelationships().add(relationship);
					
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
		fromRole.setMold("select");
		toParty.setMold("select");
		types.setMold("select");
		
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
			types.appendChild(new Listitem(type.getName(),type.getId()));
		
		for(PartyRole role:service.findOne(partyId).getRoles())
			fromRole.appendChild(new Listitem(role.getType().getName(),role.getType().getId()));

		for(EconomicAgent party:service.findAllExcept(partyId))
			toParty.appendChild(new Listitem(party.getName(),party.getId()));
		
		if(!types.getChildren().isEmpty())
			types.setSelectedIndex(0);
		
		if(!fromRole.getChildren().isEmpty())
			fromRole.setSelectedIndex(0);
		
		if(!toParty.getChildren().isEmpty())
			toParty.setSelectedIndex(0);
		
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
