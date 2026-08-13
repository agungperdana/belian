
package com.kratonsolution.belian.ui.healthcares.clinic.pos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.A;
import org.zkoss.zul.Button;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.orders.dm.OrderAdjustmentType;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ClinicPOSAdjustment extends Window
{
	private Language lang = Springs.get(Language.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Decimalbox percent = Components.fullspanDecimalbox(BigDecimal.ZERO);
	
	private Decimalbox nominal = Components.fullspanDecimalbox(BigDecimal.ZERO);
	
	public ClinicPOSAdjustment(OrderAdjustmentType type,ClinicPOSContent content)
	{
		setHeight("200px");
		setWidth("300px");
		setPosition("center");
		setMaximizable(false);
		setMinimizable(false);
		setClosable(false);
		
		Button ok = new Button(lang.get("label.component.button.save"));
		ok.setIconSclass("z-icon-plus-circle");
		ok.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				if((percent.getValue() == null && nominal.getValue() == null) || (nominal.getValue().compareTo(BigDecimal.ZERO) <= 0 && percent.getValue().compareTo(BigDecimal.ZERO) <= 0))
					throw new WrongValueException(nominal,lang.get("message.field.empty"));
				
				Decimalbox quan = Components.fullspanReadonlyDecimalbox(BigDecimal.ONE);
				Decimalbox up = Components.fullspanReadonlyDecimalbox(BigDecimal.ZERO);
				Decimalbox tot = Components.fullspanReadonlyDecimalbox(BigDecimal.ZERO);

				if(nominal.getValue() != null && nominal.getValue().compareTo(BigDecimal.ZERO) > 0)
				{
					up.setValue(nominal.getValue());
					tot.setValue(quan.getValue().multiply(up.getValue()));
				}
				else
				{
					up.setValue(percent.getValue());
					tot.setValue(quan.getValue().multiply(content.getSubtotal().multiply(up.getValue()).divide(BigDecimal.valueOf(100),RoundingMode.HALF_UP)));
				}
				
				A min = new A();
				min.setIconSclass("z-icon-minus-circle z-icon-2x");
				min.addEventListener(Events.ON_CLICK, new EventListener<Event>()
				{
					@Override
					public void onEvent(Event arg0) throws Exception
					{
						if(quan.getValue().compareTo(BigDecimal.ZERO) > 0)
							quan.setValue(quan.getValue().subtract(BigDecimal.ONE));

						tot.setValue(up.getValue().multiply(quan.getValue()));
						content.calculateResult();
					}
				});

				A plus = new A();
				plus.setIconSclass("z-icon-plus-circle z-icon-2x");
				plus.addEventListener(Events.ON_CLICK, new EventListener<Event>()
				{
					@Override
					public void onEvent(Event arg0) throws Exception
					{
						quan.setValue(quan.getValue().add(BigDecimal.ONE));
						tot.setValue(up.getValue().multiply(quan.getValue()));
						content.calculateResult();
					}
				});

				Row row = new Row();

				A close = new A();
				close.setIconSclass("z-icon-remove z-icon-2x");
				close.addEventListener(Events.ON_CLICK, new EventListener<Event>()
				{
					@Override
					public void onEvent(Event arg0) throws Exception
					{
						content.getItems().getRows().removeChild(row);
						content.calculateResult();
					}
				});

				row.appendChild(new Label(type.display(utils.getLanguage())));
				row.appendChild(min);
				row.appendChild(quan);
				row.appendChild(plus);
				row.appendChild(up);
				row.appendChild(tot);
				row.appendChild(close);
				row.appendChild(new Label(type.toString()));

				content.getItems().getRows().appendChild(row);

				content.calculateResult();
				
				detach();
			}
		});
		
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
		grid.getRows().appendChild(RowUtils.row(lang.get("order.adjustments.grid.column.type"), type.display(utils.getLanguage())));
		grid.getRows().appendChild(RowUtils.row(lang.get("order.adjustments.grid.column.percent"), percent));
		grid.getRows().appendChild(RowUtils.row(lang.get("order.adjustments.grid.column.amount"), nominal));

		Row row = new Row();
		row.appendChild(new Label());
		row.appendChild(hbox);
		
		grid.getRows().appendChild(row);
		
		appendChild(grid);
	}
}
