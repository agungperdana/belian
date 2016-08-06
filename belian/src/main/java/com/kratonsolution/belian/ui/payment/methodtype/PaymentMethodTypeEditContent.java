/**
 * 
 */
package com.kratonsolution.belian.ui.payment.methodtype;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.payment.dm.PaymentMethodType;
import com.kratonsolution.belian.payment.svc.PaymentMethodTypeService;
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
public class PaymentMethodTypeEditContent extends FormContent
{	
	private PaymentMethodTypeService service = Springs.get(PaymentMethodTypeService.class);

	private Textbox note = Components.stdTextBox(null,false);

	private Textbox name = Components.mandatoryTextBox(false);

	private Row row;

	public PaymentMethodTypeEditContent(Row row)
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
				Flow.next(getParent(), new PaymentMethodTypeGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PaymentMethodType type = service.findOne(RowUtils.id(row));
				if(type != null)
				{
					type.setName(name.getText());
					type.setNote(note.getText());

					service.edit(type);
				}

				Flow.next(getParent(), new PaymentMethodTypeGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		PaymentMethodType type = service.findOne(RowUtils.id(row));
		if(type != null)
		{
			name.setText(type.getName());
			note.setText(type.getNote());
			
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"75px"));
			grid.getColumns().appendChild(new Column());
			
			Row row1 = new Row();
			row1.appendChild(new Label(lang.get("generic.grid.column.name")));
			row1.appendChild(name);
			
			Row row2 = new Row();
			row2.appendChild(new Label(lang.get("generic.grid.column.note")));
			row2.appendChild(note);
			
			rows.appendChild(row1);
			rows.appendChild(row2);
		}
	}
}
