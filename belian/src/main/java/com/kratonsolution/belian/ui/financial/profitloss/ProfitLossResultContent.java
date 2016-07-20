/**
 * 
 */
package com.kratonsolution.belian.ui.financial.profitloss;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;

import com.google.common.base.Strings;
import com.kratonsolution.belian.ui.ReportContent;
import com.kratonsolution.belian.ui.util.Flow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProfitLossResultContent extends ReportContent
{		
	private String period;
	
	private String organization;
	
	public ProfitLossResultContent(String period,String organization)
	{
		super();
		
		this.period = period;
		this.organization = organization;

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
		if(!Strings.isNullOrEmpty(this.period) && !Strings.isNullOrEmpty(this.organization))
			frame.setSrc("/profitlossreport.htm?period="+this.period+"&company="+this.organization);
	}
}
