/**
 * 
 */
package com.kratonsolution.belian.ui.payment.deductiontype;

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
import com.kratonsolution.belian.payment.dm.DeductionType;
import com.kratonsolution.belian.payment.svc.DeductionTypeService;
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
public class DeductionTypeEditContent extends FormContent
{	
	private DeductionTypeService service = Springs.get(DeductionTypeService.class);

	private Textbox name = Components.mandatoryTextBox();

	private Textbox note = Components.stdTextBox(null, false);

	private Row row;

	public DeductionTypeEditContent(Row row)
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
				Flow.next(getParent(), new DeductionTypeGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,lang.get("message.field.empty"));

				DeductionType type = service.findOne(RowUtils.id(row));
				if(type != null)
				{
					type.setName(name.getText());
					type.setNote(note.getText());

					service.edit(type);
				}

				Flow.next(getParent(), new DeductionTypeGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		DeductionType type = service.findOne(RowUtils.id(row));
		if(type != null)
		{
			name.setText(type.getName());
			note.setText(type.getNote());
		}

		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generic.grid.column.name")));
		row2.appendChild(name);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("generic.grid.column.note")));
		row3.appendChild(note);

		rows.appendChild(row2);
		rows.appendChild(row3);
	}
}
