package com.kratonsolution.belian.ui.general.companystructure;

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

import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.core.companystructure.impl.orm.CompanyStructure;
import com.kratonsolution.belian.core.companystructure.impl.orm.CompanyStructureType;
import com.kratonsolution.belian.general.svc.CompanyStructureService;
import com.kratonsolution.belian.core.party.impl.application.OrganizationService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public class CompanyStructureFormContent extends AbstractForm
{	
	private CompanyStructureService service = Springs.get(CompanyStructureService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private Datebox from = Components.currentDatebox();
	
	private Datebox to = Components.datebox();
	
	private Listbox organizations = Components.newSelect(organizationService.findAllNotIn(service.findAllOrganizationId()), false);
	
	private Listbox types = Components.newSelect();
	
	private CompanyStructure parent;
	
	public CompanyStructureFormContent(CompanyStructure parent)
	{
		super();
		this.parent = parent;
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
				Flow.next(getParent(),null);
			}
		});
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				CompanyStructure structure = new CompanyStructure();
				structure.setFrom(DateTimes.sql(from.getValue()));
				structure.setTo(DateTimes.sql(to.getValue()));
				structure.setOrganization(organizationService.findById(Components.string(organizations)));
				structure.setType(CompanyStructureType.valueOf(Components.string(types)));
				
				if(parent != null)
					structure.setParent(parent);
				
				service.add(structure);
				
				Flow.next(getParent().getParent().getParent(),new CompanyStructureContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		for(CompanyStructureType type:CompanyStructureType.values())
			types.appendChild(new Listitem(type.name(),type.name()));
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("companystructure.grid.column.start")));
		row1.appendChild(from);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("companystructure.grid.column.end")));
		row2.appendChild(to);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("companystructure.grid.column.company")));
		row3.appendChild(organizations);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("companystructure.grid.column.type")));
		row4.appendChild(types);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
	}
}
