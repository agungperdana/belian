/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctorincomereport;

import java.sql.Date;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.ui.ReportContent;
import com.kratonsolution.belian.ui.util.Flow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorIncomeReportResultContent extends ReportContent
{		
	private String company;
	
	private String docter;
	
	private Date start;
	
	private Date end;
	
	public DoctorIncomeReportResultContent(String company,String doctor,Date start,Date end)
	{
		super();
		
		this.company = company;
		this.docter = doctor;
		this.start = start;
		this.end = end;

		initToolbar();
		initContent();
	}

	@Override
	public void initToolbar()
	{	
		toolbar.getGenerate().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new DoctorIncomeReportFormContent());
			}
		});
	}
	
	@Override
	protected void initContent()
	{
		if(!Strings.isNullOrEmpty(this.docter) && this.start != null && this.end != null)
			frame.setSrc("/doctorincomereport.htm?start="+DateTimes.format(this.start)+"&end="+DateTimes.format(this.end)+"&doctor="+this.docter+"&company="+this.company);
	}
}
