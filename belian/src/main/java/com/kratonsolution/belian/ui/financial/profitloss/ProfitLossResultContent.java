/**
 * 
 */
package com.kratonsolution.belian.ui.financial.profitloss;

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
public class ProfitLossResultContent extends ReportContent
{		
	private String organization;
	
	private Date start;
	
	private Date end;
	
	public ProfitLossResultContent(String organization,Date start,Date end)
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
				Flow.next(getParent(), new ProfitLossFormContent());
			}
		});
	}
	
	@Override
	protected void initContent()
	{
		if(!Strings.isNullOrEmpty(this.organization) && this.start != null && this.end != null)
			frame.setSrc("/profitlossreport.htm?start="+DateTimes.format(this.start)+"&end="+DateTimes.format(this.end)+"&company="+this.organization);
	}
}
