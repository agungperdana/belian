/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.clinicsalesinvoice;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.ui.ReportForm;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ClinicSalesInvoiceReportFormContent extends ReportForm
{	
	private OrganizationList companys = new OrganizationList();
	
	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.currentDatebox();
		
	public ClinicSalesInvoiceReportFormContent()
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
					throw new WrongValueException(companys,lang.get("message.field.empty"));
				
				if(start.getValue() == null)
					throw new WrongValueException(start,lang.get("message.field.empty"));
				
				if(end.getValue() == null)
					throw new WrongValueException(end,lang.get("message.field.empty"));
					
				Flow.next(getParent(), new ClinicSalesInvoiceReportResultContent(companys.getOrganization().getId(),DateTimes.sql(start.getValue()),DateTimes.sql(start.getValue())));
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("generic.grid.column.company")));
		row1.appendChild(companys);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generic.grid.column.start")));
		row2.appendChild(start);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("generic.grid.column.end")));
		row3.appendChild(end);
		
		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
	}
}
