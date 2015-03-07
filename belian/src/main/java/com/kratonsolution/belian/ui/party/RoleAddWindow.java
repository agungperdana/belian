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

import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.general.dm.PartyRoleType;
import com.kratonsolution.belian.general.svc.PartyRoleTypeService;
import com.kratonsolution.belian.general.svc.PartyService;
import com.kratonsolution.belian.ui.FormToolbar;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class RoleAddWindow extends Window
{
	private FormToolbar toolbar = new FormToolbar();
	
	private Grid layout = new Grid();
	
	private Datebox from = new Datebox();
	
	private Datebox to = new Datebox();

	private Listbox roles = new Listbox();
	
	private PartyService service = Springs.get(PartyService.class);
	
	private PartyRoleTypeService partyRoleTypeController = Springs.get(PartyRoleTypeService.class);
	
	private String partyId;
	
	public RoleAddWindow(String partyId)
	{
		this.partyId = partyId;
		
		setMode(Mode.POPUP);
		setWidth("450px");
		setHeight("400px");
		setPosition("center");
		
		Caption caption = new Caption("Party Role");
		caption.setImage("/icons/roletypesmall.png");
		
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
				Party party = service.findOne(partyId);
				if(party != null)
				{
					PartyRole role = new PartyRole();
					role.setId(UUID.randomUUID().toString());
					role.setFrom(from.getValue());
					role.setTo(to.getValue());
					role.setParty(service.findOne(partyId));
					role.setType(partyRoleTypeController.findOne(roles.getSelectedItem().getValue().toString()));
				
					party.getRoles().add(role);
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
		roles.setMold("select");
		
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
		row4.appendChild(roles);

		for(PartyRoleType type:partyRoleTypeController.findAll())
			roles.appendChild(new Listitem(type.getName(),type.getId()));

		roles.setSelectedIndex(0);
		
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
