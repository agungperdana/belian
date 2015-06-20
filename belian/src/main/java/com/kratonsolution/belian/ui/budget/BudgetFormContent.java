/**
 * 
 */
package com.kratonsolution.belian.ui.budget;

import java.util.Date;

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
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.accounting.dm.Budget;
import com.kratonsolution.belian.accounting.dm.BudgetType;
import com.kratonsolution.belian.accounting.svc.BudgetService;
import com.kratonsolution.belian.accounting.svc.BudgetTypeService;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class BudgetFormContent extends FormContent
{	
	private BudgetService service = Springs.get(BudgetService.class);
	
	private BudgetTypeService typeService = Springs.get(BudgetTypeService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private SessionUtils sessionUtils = Springs.get(SessionUtils.class);
	
	private Datebox start = new Datebox(new Date());
	
	private Datebox end = new Datebox();
	
	private Listbox types = Components.newSelect();
	
	private Textbox description = new Textbox();
	
	private Listbox owners = Components.newSelect();
	
	public BudgetFormContent()
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
				BudgetWindow window = (BudgetWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Budget budget = new Budget();
				budget.setStart(start.getValue());
				budget.setEnd(end.getValue());
				budget.setType(typeService.findOne(Components.string(types)));
				budget.setDescription(description.getText());
				budget.setOwner(organizationService.findOne(Components.string(owners)));
				
				service.add(budget);
				
				BudgetWindow window = (BudgetWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		start.setWidth("150px");
		start.setConstraint("no empty");
		end.setWidth("150px");
		types.setWidth("250px");
		description.setWidth("300px");
		
		for(BudgetType type:typeService.findAll())
			types.appendChild(new Listitem(type.getName(), type.getId()));
		
		Components.setDefault(types);
		
		for(Organization organization:sessionUtils.getOrganizations())
			owners.appendChild(new Listitem(organization.getName(),organization.getId()));
		
		Components.setDefault(owners);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("From"));
		row1.appendChild(start);
		
		Row row2 = new Row();
		row2.appendChild(new Label("To"));
		row2.appendChild(end);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Type"));
		row3.appendChild(types);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Owner"));
		row4.appendChild(owners);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Description"));
		row5.appendChild(description);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}
}
