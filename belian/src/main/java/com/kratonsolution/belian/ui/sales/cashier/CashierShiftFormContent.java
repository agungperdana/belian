/**
 * 
 */
package com.kratonsolution.belian.ui.sales.cashier;

import java.math.BigDecimal;
import java.util.List;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.asset.svc.AssetService;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.sales.dm.CashierShift;
import com.kratonsolution.belian.sales.srv.CashierShiftService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.CurrencyList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashierShiftFormContent extends FormContent
{	
	private AssetService assetService = Springs.get(AssetService.class);

	private CashierShiftService service = Springs.get(CashierShiftService.class);

	private Datebox date = Components.currentDatebox(true);

	private Listbox assets = Components.newSelect(assetService.findAllUnused(),true);

	private Listbox employee = Components.newSelect(utils.getEmployee());
	
	private CurrencyList currencys = new CurrencyList();

	private Doublebox capital = Components.stdDoubleBox(0);

	public CashierShiftFormContent()
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
				Clients.showNotification(lang.get("cashier.message.shiftwarning"));
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(assets.getSelectedCount() != 1)
					throw new WrongValueException(assets,lang.get("cashier.message.machiendused"));

				CashierShift shift = new CashierShift();
				shift.setCapital(BigDecimal.valueOf(capital.doubleValue()));
				shift.setClosed(false);
				shift.setDate(DateTimes.currentDate());
				shift.setMachine(assetService.findOne(Components.string(assets)));
				shift.setEmployee(utils.getEmployee());
				shift.setStart(DateTimes.currentTime());
				shift.setCurrency(currencys.getCurrency());

				service.open(shift);

				Flow.next(getParent(), new CashierGridContent());
			}
		});

		if(utils.getEmployee() != null)
		{
			List<CashierShift> shifts = service.findAllPendingBefore(null, utils.getEmployee().getId());
			if(!shifts.isEmpty())
			{
				Toolbarbutton close = new Toolbarbutton(lang.get("generic.grid.column.cashierclose"),"/icons/cashier-shift.png");
				close.addEventListener(Events.ON_CLICK,new EventListener<Event>()
				{
					@Override
					public void onEvent(Event event) throws Exception
					{
						CashierShiftService service = Springs.get(CashierShiftService.class);
						if(service != null)
						{
							for(CashierShift shift:shifts)
								service.close(shift);
						}

						Flow.next(getParent(),new CashierShiftFormContent());
					}
				});
				
				toolbar.appendChild(close);
			}
		}
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());

		Row row0 = new Row();
		row0.appendChild(new Label(lang.get("cashier.grid.column.employee")));
		row0.appendChild(employee);

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("cashier.grid.column.date")));
		row1.appendChild(date);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("cashier.grid.column.machine")));
		row2.appendChild(assets);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("cashier.grid.column.capital")));
		row3.appendChild(capital);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("cashier.grid.column.currency")));
		row4.appendChild(currencys);

		rows.appendChild(row0);
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
	}
}