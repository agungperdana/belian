/**
 * 
 */
package com.kratonsolution.belian.ui.financial.invoicereport;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;

import com.kratonsolution.belian.ui.ReportForm;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.component.PersonBox;
import com.kratonsolution.belian.ui.util.Flow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class InvoiceReportFormContent extends ReportForm
{	
	private PersonBox persons = new PersonBox(false);
	
	private OrganizationList companys = new OrganizationList();
		
	public InvoiceReportFormContent()
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
					
				Flow.next(getParent(), new InvoiceReportResultContent(persons.getNullablePersonId(), companys.getOrganization().getId()));
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("invoice.label.company")));
		row2.appendChild(companys);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("invoice.label.customer")));
		row3.appendChild(persons);
		
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
	}
}
