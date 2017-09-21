/**
 * 
 */
package com.kratonsolution.belian.ui.financial.generalledger;

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
import com.kratonsolution.belian.ui.accounting.organizationaccount.OGLAccountList;
import com.kratonsolution.belian.ui.component.ChartOfAccountList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GeneralLedgerReportFormContent extends ReportForm
{	
	private ChartOfAccountList companys = new ChartOfAccountList();
	
	private OGLAccountList accounts = new OGLAccountList(companys.getOrganization().getOrganization(),true);
	
	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.currentDatebox();
		
	public GeneralLedgerReportFormContent()
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
					
				Flow.next(getParent(), new GeneralLedgerReportResultContent(companys.getOrganization().getId(),accounts.getAccount()!=null?accounts.getAccount().getId():null,DateTimes.sql(start.getValue()),DateTimes.sql(start.getValue())));
			}
		});
	}

	@Override
	public void initForm()
	{
		companys.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				accounts.repopulate(companys.getOrganization().getOrganization(),true);
			}
		});
		
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("generalledger.label.company")));
		row1.appendChild(companys);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generalledger.label.start")));
		row2.appendChild(start);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("generalledger.label.end")));
		row3.appendChild(end);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("generalledger.label.account")));
		row4.appendChild(accounts);
		
		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
		grid.getRows().appendChild(row4);
	}
}
