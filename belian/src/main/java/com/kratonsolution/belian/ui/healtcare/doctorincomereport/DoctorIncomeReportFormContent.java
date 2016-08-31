/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctorincomereport;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;

import com.kratonsolution.belian.accounting.svc.AccountingPeriodService;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.ui.ReportForm;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.healtcare.doctor.DoctorBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorIncomeReportFormContent extends ReportForm
{	
	private AccountingPeriodService service = Springs.get(AccountingPeriodService.class);
		
	private OrganizationList companys = new OrganizationList();
	
	private DoctorBox doctors = new DoctorBox(false);
	
	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.currentDatebox();
	
	public DoctorIncomeReportFormContent()
	{
		super();
		initToolbar();
		initForm();
	}

	public void initToolbar()
	{
		toolbar.removeChild(toolbar.getPrint());
		toolbar.getGenerate().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(companys.getOrganization() == null)
					throw new WrongValueException(doctors,lang.get("message.field.empty"));
				
				if(doctors.getDoctor() == null)
					throw new WrongValueException(doctors,lang.get("message.field.empty"));
				
				if(start.getValue() == null)
					throw new WrongValueException(start,lang.get("message.field.empty"));
				
				if(end.getValue() == null)
					throw new WrongValueException(end,lang.get("message.field.empty"));
					
				Flow.next(getParent(), new DoctorIncomeReportResultContent(companys.getOrganization().getId(),doctors.getDoctor().getPerson().getId(),DateTimes.sql(start.getValue()),DateTimes.sql(end.getValue())));
			}
		});
	}

	@Override
	public void initForm()
	{
		if(companys.getOrganization() != null)
			doctors.setOrganization(companys.getOrganization());
		
		companys.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				if(companys.getOrganization() != null)
					doctors.setOrganization(companys.getOrganization());
			}
		});
		
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row0 = new Row();
		row0.appendChild(new Label(lang.get("generic.grid.column.company")));
		row0.appendChild(companys);
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("navbar.menu.healtcare.doctor")));
		row1.appendChild(doctors);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generic.grid.column.start")));
		row2.appendChild(start);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("generic.grid.column.end")));
		row3.appendChild(end);
		
		grid.getRows().appendChild(row0);
		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
	}
}
