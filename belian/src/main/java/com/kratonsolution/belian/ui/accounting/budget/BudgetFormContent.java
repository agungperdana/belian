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
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.accounting.dm.Budget;
import com.kratonsolution.belian.accounting.dm.BudgetRole;
import com.kratonsolution.belian.accounting.dm.BudgetRoleType;
import com.kratonsolution.belian.accounting.dm.BudgetStatus;
import com.kratonsolution.belian.accounting.dm.BudgetStatusType;
import com.kratonsolution.belian.accounting.dm.BudgetType;
import com.kratonsolution.belian.accounting.svc.BudgetService;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BudgetFormContent extends FormContent
{	
	private BudgetService service = Springs.get(BudgetService.class);
	
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
				Flow.next(getParent(), new BudgetGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Budget budget = new Budget();
				budget.setType(BudgetType.valueOf(Components.string(types)));
				budget.setOrganization(sessionUtils.getOrganization());
				budget.setStart(start.getValue());
				budget.setEnd(end.getValue());
				budget.setComment(comment.getText());
				
				BudgetStatus status = new BudgetStatus();
				status.setBudget(budget);
				status.setDate(start.getValue());
				status.setDescription("Just Created");
				status.setType(BudgetStatusType.Created);
				
				budget.getStatuses().add(status);
				budget.setLastStatus(status);
				
				BudgetRole initiator = new BudgetRole();
				initiator.setBudget(budget);
				initiator.setParty(sessionUtils.getUser().getPerson());
				initiator.setType(BudgetRoleType.Initiator);
				
				BudgetRole requested = new BudgetRole();
				requested.setBudget(budget);
				requested.setParty(sessionUtils.getOrganization());
				requested.setType(BudgetRoleType.RequestedFor);
				
				budget.getRoles().add(initiator);
				budget.getRoles().add(requested);
				
				service.add(budget);
				
				Flow.next(getParent(), new BudgetEditContent(budget));
			}
		});
	}

	@Override
	public void initForm()
	{
		comment.setWidth("300px");
		targets.appendItem(sessionUtils.getOrganization().getName(),sessionUtils.getOrganization().getId());
		
		for(BudgetType type:BudgetType.values())
			types.appendItem(type.name(), type.name());

		Components.setDefault(types);
		Components.setDefault(targets);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
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
