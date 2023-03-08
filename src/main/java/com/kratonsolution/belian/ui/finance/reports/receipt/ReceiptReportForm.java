/**
 * 
 */
package com.kratonsolution.belian.ui.finance.reports.receipt;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.PrintWindow;
import com.kratonsolution.belian.ui.util.Components;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ReceiptReportForm extends AbstractForm
{
	private Datebox from = Components.currentDatebox();
	
	private Datebox to = Components.currentDatebox();
	
	public ReceiptReportForm()
	{
		super();
		initToolbar();
		initForm();
	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.AbstractForm#initToolbar()
	 */
	@Override
	public void initToolbar()
	{
		toolbar.getCancel().setLabel(lang.get("label.component.button.clear"));
		toolbar.getCancel().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
			}
		});
		
		toolbar.getSave().setLabel(lang.get("label.component.button.generate"));
		toolbar.getSave().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				if(organizations.getDomain() == null)
					throw new WrongValueException(organizations,lang.get("message.field.empty"));
				
				if(from.getValue() == null)
					throw new WrongValueException(from,lang.get("message.field.empty"));
				
				if(to.getValue() == null)
					throw new WrongValueException(to,lang.get("message.field.empty"));
				
				StringBuilder builder = new StringBuilder();
				builder.append("/receiptreportview?organization="+organizations.getDomain());
				builder.append("&from="+DateTimes.format(from.getValue()));
				builder.append("&to="+DateTimes.format(to.getValue()));
				
				PrintWindow window = new PrintWindow(builder.toString());
				window.setPage(getPage());
				window.doModal();
				window.getPrint().setFocus(true);
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.AbstractForm#initForm()
	 */
	@Override
	public void initForm()
	{
		grid.setVflex("1");
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.setSpan("1");
		
		initRow();
		
	}
	
	private void initRow()
	{
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("generic.grid.column.organization")));
		row1.appendChild(organizations);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generic.grid.column.fromdate")));
		row2.appendChild(from);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("generic.grid.column.todate")));
		row3.appendChild(to);
		
		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
	}
}
