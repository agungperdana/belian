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

import com.kratonsolution.belian.general.dm.CompanyStructure;
import com.kratonsolution.belian.general.dm.PartyRelationship;
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
	private final CompanyStructureService service = Springs.get(CompanyStructureService.class);

	private final OrganizationUnitService unitService = Springs.get(OrganizationUnitService.class);

	private final OrganizationService organizationService = Springs.get(OrganizationService.class);

	private final PartyRoleService partyRoleService = Springs.get(PartyRoleService.class);

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
			parents.appendChild(new Listitem(companyStructure.getParent().getParty().getLabel(),companyStructure.getParent().getParty().getValue()));
			childs.appendChild(new Listitem(companyStructure.getChild().getParty().getLabel(),companyStructure.getChild().getParty().getValue()));
			fromroles.appendChild(new Listitem(companyStructure.getParent().getType().name(),companyStructure.getParent().getType().name()));
			toroles.appendChild(new Listitem(companyStructure.getChild().getType().name(),companyStructure.getChild().getType().name()));
			
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
