/**
 * 
 */
package com.kratonsolution.belian.ui.financial.generaljournal;

import java.sql.Date;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.ui.ReportContent;
import com.kratonsolution.belian.ui.util.Flow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GeneralJournalReportResultContent extends ReportContent
{		
	private Date start;
	
	private Date end;
	
	private String organization;
	
	public GeneralJournalReportResultContent(String organization,Date start,Date end)
	{
		super();
		
		this.organization = organization;
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
				Flow.next(getParent(), new GeneralJournalReportFormContent());
			}
		});
	}
	
	@Override
	protected void initContent()
	{
		frame.setSrc("/generaljournalreport.htm?company="+this.organization+"&start="+DateTimes.format(start)+"&end="+DateTimes.format(end));
	}
}
