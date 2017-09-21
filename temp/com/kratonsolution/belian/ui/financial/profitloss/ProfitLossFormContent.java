/**
 * 
 */
package com.kratonsolution.belian.ui.financial.profitloss;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.svc.AccountingPeriodService;
import com.kratonsolution.belian.ui.ReportForm;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProfitLossFormContent extends ReportForm
{	
	private AccountingPeriodService service = Springs.get(AccountingPeriodService.class);
	
	private Listbox periods = Components.newSelect(service.findAll(),true);
	
	private OrganizationList companys = new OrganizationList();
		
	public ProfitLossFormContent()
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
				if(Strings.isNullOrEmpty(Components.string(periods)))
					throw new WrongValueException(periods,lang.get("message.field.empty"));
				
				if(companys.getOrganization() == null)
					throw new WrongValueException(companys,lang.get("message.field.empty"));
					
				Flow.next(getParent(), new ProfitLossResultContent(Components.string(periods), companys.getOrganization().getId()));
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generic.grid.column.company")));
		row2.appendChild(companys);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("generic.grid.column.accoutingperiod")));
		row3.appendChild(periods);
		
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
	}
}
