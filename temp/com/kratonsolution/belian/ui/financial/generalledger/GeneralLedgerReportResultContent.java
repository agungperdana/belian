/**
 * 
 */
package com.kratonsolution.belian.ui.financial.generalledger;

import java.sql.Date;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.Strings;
import com.kratonsolution.belian.ui.ReportContent;
import com.kratonsolution.belian.ui.util.Flow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GeneralLedgerReportResultContent extends ReportContent
{		
	private Date start;
	
	private Date end;
	
	private String organization;
	
	private String account;
	
	public GeneralLedgerReportResultContent(String organization,String account,Date start,Date end)
	{
		super();
		
		this.organization = organization;
		this.start = start;
		this.end = end;
		this.account = account;

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
				Flow.next(getParent(), new GeneralLedgerReportFormContent());
			}
		});
	}
	
	@Override
	protected void initContent()
	{
		frame.setSrc("/generalledgerreport.htm?company="+this.organization+"&account="+Strings.safe(this.account)+"&start="+DateTimes.format(start)+"&end="+DateTimes.format(end));
	}
}
