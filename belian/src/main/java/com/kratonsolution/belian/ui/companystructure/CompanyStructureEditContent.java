/**
 * 
 */
package com.kratonsolution.belian.ui.companystructure;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.CompanyStructure;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.PartyRelationship;
import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.general.svc.CompanyStructureService;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.general.svc.OrganizationUnitService;
import com.kratonsolution.belian.general.svc.PartyRoleService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CompanyStructureEditContent extends FormContent
{	
	private CompanyStructureService service = Springs.get(CompanyStructureService.class);

	private OrganizationUnitService unitService = Springs.get(OrganizationUnitService.class);

	private OrganizationService organizationService = Springs.get(OrganizationService.class);

	private PartyRoleService partyRoleService = Springs.get(PartyRoleService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);

	private Datebox from = Components.currentDatebox();

	private Datebox to = Components.datebox();

	private Listbox fromroles = Components.newSelect();

	private Listbox toroles = Components.newSelect();

	private Listbox parents = Components.newSelect();

	private Listbox childs = Components.newSelect();

	private Listbox types = Components.newSelect(PartyRelationship.Type.COMPANYSTRUCTURE.name(),PartyRelationship.Type.COMPANYSTRUCTURE.name());

	private Row row;

	public CompanyStructureEditContent(Row row)
	{
		super();
		this.row = row;
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
				CompanyStructureWindow window = (CompanyStructureWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				CompanyStructure structure = service.findOne(RowUtils.string(row, 7));
				structure.setFrom(from.getValue());
				structure.setTo(to.getValue());
				structure.setType(PartyRelationship.Type.COMPANYSTRUCTURE);
				structure.getParent().setFrom(from.getValue());
				structure.getParent().setTo(to.getValue());
				structure.getChild().setFrom(from.getValue());
				structure.getChild().setTo(to.getValue());
				
				service.edit(structure);
				
				CompanyStructureWindow window = (CompanyStructureWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		CompanyStructure companyStructure = service.findOne(RowUtils.string(row, 7));
		if(companyStructure != null)
		{
			for(Organization organization:utils.getOrganizations())
			{
				Listitem item = new Listitem(organization.getLabel(),organization.getValue());
				
				parents.appendChild(item);
				childs.appendChild(item);
				
				if(companyStructure.getParent() != null && organization.getId().equals(companyStructure.getParent().getParty().getId()))
					parents.setSelectedItem(item);
				
				if(companyStructure.getChild() != null && organization.getId().equals(companyStructure.getChild().getParty().getId()))
					childs.setSelectedItem(item);
			}

			for(PartyRole.Type type:PartyRole.Type.values())
			{
				Listitem item = new Listitem(type.name(),type.name());

				fromroles.appendChild(item);
				toroles.appendChild(item);
			
				if(companyStructure.getParent() != null && type.equals(companyStructure.getParent().getType()))
					fromroles.setSelectedItem(item);
				
				if(companyStructure.getChild() != null && type.equals(companyStructure.getChild().getType()))
					toroles.setSelectedItem(item);
			}
			
			Components.setDefault(parents);
			Components.setDefault(childs);
			Components.setDefault(fromroles);
			Components.setDefault(toroles);
			
			from.setValue(companyStructure.getFrom());
			to.setValue(companyStructure.getTo());
			
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"75px"));
			grid.getColumns().appendChild(new Column());
			
			Row row1 = new Row();
			row1.appendChild(new Label("Start Date"));
			row1.appendChild(from);
			
			Row row2 = new Row();
			row2.appendChild(new Label("End Date"));
			row2.appendChild(to);
			
			Row row3 = new Row();
			row3.appendChild(new Label("Parent"));
			row3.appendChild(parents);
			
			Row row4 = new Row();
			row4.appendChild(new Label("Role As"));
			row4.appendChild(fromroles);
			
			Row row5 = new Row();
			row5.appendChild(new Label("Child"));
			row5.appendChild(childs);
			
			Row row6 = new Row();
			row6.appendChild(new Label("Role As"));
			row6.appendChild(toroles);
			
			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			rows.appendChild(row4);
			rows.appendChild(row5);
			rows.appendChild(row6);
		}
	}
}
