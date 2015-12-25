/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.budget;

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
import com.kratonsolution.belian.accounting.dm.Budget.Type;
import com.kratonsolution.belian.accounting.dm.BudgetStatus;
import com.kratonsolution.belian.accounting.svc.BudgetService;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.general.svc.OrganizationUnitService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BudgetFormContent extends FormContent
{	
	private BudgetService service = Springs.get(BudgetService.class);
	
	private OrganizationUnitService unitService = Springs.get(OrganizationUnitService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private SessionUtils sessionUtils = Springs.get(SessionUtils.class);
	
	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();
	
	private Listbox types = Components.newSelect();
	
	private Textbox comment = new Textbox();
	
	private Listbox targets = Components.newSelect();
	
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
				budget.setType(Type.valueOf(Components.string(types)));
				budget.setPartyRequested(organizationService.findOne(Components.string(targets)));
				budget.setStart(start.getValue());
				budget.setEnd(end.getValue());
				budget.setComment(comment.getText());
				
				BudgetStatus status = new BudgetStatus();
				status.setBudget(budget);
				status.setDate(start.getValue());
				status.setDescription("Submitted for review.");
				status.setType(BudgetStatus.StatusType.SUBMITTED);
				
				budget.getStatuses().add(status);
				
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
		comment.setWidth("300px");
		
		for(Type type:Type.values())
			types.appendChild(new Listitem(type.name(), type.name()));
		
		Components.setDefault(types);
		
		for(Organization unit:sessionUtils.getOrganizations())
			targets.appendChild(new Listitem(unit.getName(),unit.getId()));
		
		Components.setDefault(targets);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Type"));
		row1.appendChild(types);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Party"));
		row2.appendChild(targets);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Start"));
		row3.appendChild(start);
		
		Row row4 = new Row();
		row4.appendChild(new Label("End"));
		row4.appendChild(end);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Comment"));
		row5.appendChild(comment);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}
}
