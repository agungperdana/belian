
package com.kratonsolution.belian.ui.hr.employment;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;

import com.kratonsolution.belian.common.util.DateTimes;
import com.kratonsolution.belian.hr.svc.EmploymentService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.general.companystructure.CompanyStructureList;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class EmploymentFormContent extends AbstractForm
{	
	private EmploymentService service = Springs.get(EmploymentService.class);
	
	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();
	
	private CompanyStructureList employer = new CompanyStructureList(false);
	
	private PartyBox employee = new PartyBox(true,true);
	
	public EmploymentFormContent()
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
				Flow.next(getParent(), new EmploymentGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(start.getValue() == null)
					throw new WrongValueException(start, lang.get("message.field.empty"));
				
				if(employer.getDomain() == null)
					throw new WrongValueException(employer, lang.get("message.field.empty"));
				
				if(employee.getDomain() == null)
					throw new WrongValueException(employee, lang.get("message.field.empty"));
				
				service.add(DateTimes.sql(start.getValue()),DateTimes.sql(end.getValue()),employee.getDomainAsRef(),employer.getDomainAsRef());
				
				Flow.next(getParent(), new EmploymentGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{		
		employer.setDomain(utils.getOrganization());
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
			
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("employment.grid.column.start")));
		row1.appendChild(start);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("employment.grid.column.end")));
		row2.appendChild(end);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("employment.grid.column.employer")));
		row3.appendChild(employer);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("employment.grid.column.employee")));
		row4.appendChild(employee);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
	}
}