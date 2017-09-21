/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.currency;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.svc.CurrencyService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CurrencyEditContent extends FormContent
{	
	private CurrencyService service = Springs.get(CurrencyService.class);

	private Textbox code = Components.mandatoryTextBox(false);

	private Textbox name = Components.mandatoryTextBox(false);

	private Row row;

	public CurrencyEditContent(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new CurrencyGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(code.getText()))
					throw new WrongValueException(code,lang.get("message.field.empty"));

				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,lang.get("message.field.empty"));

				Currency currency = service.findOne(RowUtils.id(row));
				if(currency != null)
				{
					currency.setCode(code.getText());
					currency.setName(name.getText());

					service.edit(currency);
				}

				Flow.next(getParent(), new CurrencyGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		Currency currency = service.findOne(RowUtils.id(row));
		if(currency != null)
		{
			code.setText(currency.getCode());
			name.setText(currency.getName());
		}

		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("generic.grid.column.code")));
		row1.appendChild(code);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generic.grid.column.name")));
		row2.appendChild(name);

		rows.appendChild(row1);
		rows.appendChild(row2);
	}
}
