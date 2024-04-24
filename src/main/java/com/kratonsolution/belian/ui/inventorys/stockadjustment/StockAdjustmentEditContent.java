
package com.kratonsolution.belian.ui.inventorys.stockadjustment;

import java.math.BigDecimal;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Timebox;

import com.kratonsolution.belian.inventory.dm.StockAdjustment;
import com.kratonsolution.belian.inventory.svc.StockAdjustmentService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.general.companystructure.CompanyStructureList;
import com.kratonsolution.belian.ui.inventory.facility.ContainerList;
import com.kratonsolution.belian.ui.inventory.facility.FacilityList;
import com.kratonsolution.belian.ui.products.product.ProductBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StockAdjustmentEditContent extends AbstractForm
{	
	private StockAdjustmentService service = Springs.get(StockAdjustmentService.class);

	private Datebox date = Components.currentDatebox();

	private Timebox time = Components.timebox();

	private CompanyStructureList organizations = new CompanyStructureList(false);

	private FacilityList facilitys = new FacilityList(false);

	private Textbox note = Components.stdTextBox(null, false);

	private Grid items = new Grid();

	private Row row;

	public StockAdjustmentEditContent(Row row)
	{
		super();
		this.row = row;

		initToolbar();
		initForm();
		initItems();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new StockAdjustmentGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				StockAdjustment adjustment = service.findById(RowUtils.id(row));
				adjustment.setNote(note.getText());

				service.edit(adjustment);

				Flow.next(getParent(), new StockAdjustmentGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		StockAdjustment adjustment = service.findById(RowUtils.id(row));
		if(adjustment != null)
		{
			organizations.setDomainAsRef(adjustment.getOrganization());
			date.setValue(adjustment.getDate());
			time.setValue(adjustment.getTime());
			facilitys.setDomainAsRef(adjustment.getFacility());
			note.setText(adjustment.getNote());
		}

		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());

		Row row0 = new Row();
		row0.appendChild(new Label(lang.get("stockadjustment.grid.column.organization")));
		row0.appendChild(organizations);

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("stockadjustment.grid.column.date")));
		row1.appendChild(date);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("stockadjustment.grid.column.time")));
		row2.appendChild(time);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("stockadjustment.grid.column.facility")));
		row3.appendChild(facilitys);

		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("stockadjustment.grid.column.note")));
		row4.appendChild(note);

		rows.appendChild(row0);
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
	}

	private void initItems()
	{
		NRCToolbar nrc = new NRCToolbar(items);

		items.setEmptyMessage(lang.get("message.grid.empty"));
		items.setWidth("100%");
		items.appendChild(new Rows());
		items.appendChild(new Columns());
		items.getColumns().appendChild(new Column(null,null, "25px"));
		items.getColumns().appendChild(new Column(lang.get("stockadjustment.grid.column.product"),null, "250px"));
		items.getColumns().appendChild(new Column(lang.get("stockadjustment.grid.column.quantity"),null, "90px"));
		items.getColumns().appendChild(new Column(lang.get("stockadjustment.grid.column.container"),null, "150px"));
		items.getColumns().appendChild(new Column(lang.get("stockadjustment.grid.column.expired"),null, "125px"));
		items.getColumns().appendChild(new Column(lang.get("stockadjustment.grid.column.note"),null, "150px"));
		items.setSpan("1");

		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();

				row.appendChild(Components.checkbox(false));
				row.appendChild(new ProductBox(true));
				row.appendChild(Components.fullspanDecimalbox(BigDecimal.ONE));
				row.appendChild(new ContainerList(true));
				row.appendChild(Components.fullSpanDatebox(null));
				row.appendChild(Components.textBox(null));

				items.getRows().appendChild(row);
			}
		});

		appendChild(nrc);
		appendChild(items);
	}
}
