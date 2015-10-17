/**
 * 
 */
package com.kratonsolution.belian.ui.positiontyperate;

import java.math.BigDecimal;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.dm.PeriodType;
import com.kratonsolution.belian.accounting.svc.CurrencyService;
import com.kratonsolution.belian.hr.dm.PositionType;
import com.kratonsolution.belian.hr.dm.PositionTypeRate;
import com.kratonsolution.belian.hr.dm.RateType;
import com.kratonsolution.belian.hr.svc.PositionTypeRateService;
import com.kratonsolution.belian.hr.svc.PositionTypeService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PositionTypeRateFormContent extends FormContent
{	
	private PositionTypeRateService service = Springs.get(PositionTypeRateService.class);
	
	private CurrencyService currencyService = Springs.get(CurrencyService.class);
	
	private PositionTypeService positionTypeService = Springs.get(PositionTypeService.class);
	
	private Datebox start = Components.mandatoryDatebox();
	
	private Datebox end = Components.mandatoryDatebox();
	
	private Listbox positions = Components.newSelect();
	
	private Listbox rateTypes = Components.newSelect();
	
	private Listbox periodTypes = Components.newSelect();
	
	private Listbox currencys = Components.newSelect();
	
	private Doublebox amount = Components.doubleBox(0);
	
	private Textbox comment = new Textbox();
	
	public PositionTypeRateFormContent()
	{
		super();
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
				PositionTypeRateWindow window = (PositionTypeRateWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PositionTypeRate rate = new PositionTypeRate();
				rate.setStart(start.getValue());
				rate.setEnd(end.getValue());
				rate.setAmount(BigDecimal.valueOf(amount.doubleValue()));
				rate.setComment(comment.getText());
				rate.setCurrency(currencyService.findOne(Components.string(currencys)));
				rate.setPeriodType(PeriodType.valueOf(Components.string(periodTypes)));
				rate.setPositionType(positionTypeService.findOne(Components.string(positions)));
				rate.setRateType(RateType.valueOf(Components.string(rateTypes)));

				service.add(rate);
				
				PositionTypeRateWindow window = (PositionTypeRateWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		for(RateType type:RateType.values())
			rateTypes.appendChild(new Listitem(type.display(), type.name()));
		
		for(PeriodType type:PeriodType.values())
			periodTypes.appendChild(new Listitem(type.display(),type.name()));
		
		for(PositionType type:positionTypeService.findAll())
			positions.appendChild(new Listitem(type.getLabel(), type.getValue()));
		
		for(Currency currency:currencyService.findAll())
			currencys.appendChild(new Listitem(currency.getLabel(), currency.getValue()));
		
		Components.setDefault(rateTypes);
		Components.setDefault(periodTypes);
		Components.setDefault(positions);
		Components.setDefault(currencys);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Start Date"));
		row1.appendChild(start);
		
		Row row2 = new Row();
		row2.appendChild(new Label("End Date"));
		row2.appendChild(end);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Position Type"));
		row3.appendChild(positions);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Rate Type"));
		row4.appendChild(rateTypes);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Period Type"));
		row5.appendChild(periodTypes);
		
		Row row6 = new Row();
		row6.appendChild(new Label("Currency"));
		row6.appendChild(currencys);
		
		Row row7 = new Row();
		row7.appendChild(new Label("Amount"));
		row7.appendChild(amount);
		
		Row row8 = new Row();
		row8.appendChild(new Label("Comment"));
		row8.appendChild(comment);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row7);
		rows.appendChild(row8);
	}
}
