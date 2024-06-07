
package com.kratonsolution.belian.ui.healthcares.clinic.pos;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.common.app.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class ClinicPOSPrescription extends Window
{
	private Language lang = Springs.get(Language.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Textbox customer = Components.textBox(null);
	
	private Textbox doctor = Components.textBox(null);

	private Button ok = new Button(lang.get("label.component.button.save"));
	
	public ClinicPOSPrescription(Label custbox,Label doctbox)
	{
		setHeight("150px");
		setWidth("300px");
		setPosition("center");
		setMaximizable(false);
		setMinimizable(false);
		setClosable(false);

		ok.setIconSclass("z-icon-plus-circle");
		
		Button cancel = new Button(lang.get("label.component.button.cancel"));
		cancel.setIconSclass("z-icon-remove");
		cancel.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				detach();
			}
		});
		
		Hbox hbox = new Hbox();
		hbox.setHflex("1");
		hbox.setPack("end");
		hbox.appendChild(cancel);
		hbox.appendChild(ok);
		
		Grid grid = new Grid();
		grid.setHflex("1");
		grid.setVflex("1");
		grid.appendChild(new Columns());
		grid.appendChild(new Rows());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		grid.setSpan("1");
		grid.getRows().appendChild(RowUtils.row(lang.get("order.pos.grid.column.customer"), customer));
		grid.getRows().appendChild(RowUtils.row(lang.get("order.pos.grid.column.doctor"), doctor));

		Row row = new Row();
		row.appendChild(new Label());
		row.appendChild(hbox);
		
		grid.getRows().appendChild(row);
		
		appendChild(grid);
	}
}
