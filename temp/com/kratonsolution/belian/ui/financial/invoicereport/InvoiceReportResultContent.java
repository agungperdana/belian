/**
 * 
 */
package com.kratonsolution.belian.ui.financial.invoicereport;

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
public class InvoiceReportResultContent extends ReportContent
{		
	private String customer;
	
	private String organization;
	
	public InvoiceReportResultContent(String customer,String organization)
	{
		super();
		
		this.customer = customer;
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
				Flow.next(getParent(), new InvoiceReportFormContent());
			}
		});
	}
	
	@Override
	protected void initContent()
	{
		if(!Strings.isNullOrEmpty(this.organization))
			frame.setSrc("/invoicereport.htm?customer="+(Strings.isNullOrEmpty(customer)?"":this.customer)+"&company="+this.organization);
	}
}
