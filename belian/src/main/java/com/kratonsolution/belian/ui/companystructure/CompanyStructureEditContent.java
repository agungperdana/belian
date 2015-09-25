/**
 * 
 */
package com.kratonsolution.belian.ui.companystructure;

import java.util.ArrayList;
import java.util.List;

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
import com.kratonsolution.belian.general.dm.OrganizationUnit;
import com.kratonsolution.belian.general.dm.PartyRelationship;
import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.general.dm.PartyRole.Type;
import com.kratonsolution.belian.general.svc.CompanyStructureService;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.general.svc.OrganizationUnitService;
import com.kratonsolution.belian.general.svc.PartyRoleService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
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

	private Listbox parents = Components.newSelect(organizationService.findAll(), false);

	private Listbox childs = Components.newSelect(organizationService.findAll(), false);

	private Listbox types = Components.newSelect(PartyRelationship.Type.COMPANYSTRUCTURE.toString(),PartyRelationship.Type.COMPANYSTRUCTURE.toString());

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
				OrganizationUnit fromRole = unitService.findOneByPartyIdAndType(Components.string(parents), Type.valueOf(Components.string(fromroles)));
				if(fromRole == null)
				{
					fromRole = OrganizationUnit.newInstance(Type.valueOf(Components.string(fromroles)));
					fromRole.setFrom(from.getValue());
					fromRole.setTo(to.getValue());
					fromRole.setParty(organizationService.findOne(Components.string(parents)));
				}
				
				OrganizationUnit toRole = unitService.findOneByPartyIdAndType(Components.string(childs), Type.valueOf(Components.string(toroles)));
				if(toRole == null)
				{
					toRole = OrganizationUnit.newInstance(Type.valueOf(Components.string(toroles)));
					toRole.setFrom(from.getValue());
					toRole.setTo(to.getValue());
					toRole.setParty(organizationService.findOne(Components.string(childs)));
				}
				
				CompanyStructure structure = new CompanyStructure();
				structure.setFrom(from.getValue());
				structure.setTo(to.getValue());
				structure.setType(PartyRelationship.Type.COMPANYSTRUCTURE);
				structure.setParent(fromRole);
				structure.setChild(toRole);
				
				service.add(structure);
				
				CompanyStructureWindow window = (CompanyStructureWindow)getParent();
				window.removeCreateForm();
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
			List<PartyRole.Type> types = new ArrayList<PartyRole.Type>();
			types.add(PartyRole.Type.DEPARTMENT);
			types.add(PartyRole.Type.DIVISION);
			types.add(PartyRole.Type.HOLDING);
			types.add(PartyRole.Type.SUBSIDIARY);
			
			for(PartyRole.Type type:types)
			{
				fromroles.appendChild(new Listitem(type.name(), type.name()));
				toroles.appendChild(new Listitem(type.name(), type.name()));
			}
			
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
