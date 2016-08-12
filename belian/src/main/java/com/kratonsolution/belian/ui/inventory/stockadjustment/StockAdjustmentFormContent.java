/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.stockadjustment;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
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

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.inventory.dm.StockAdjustment;
import com.kratonsolution.belian.inventory.dm.StockAdjustmentItem;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.inventory.svc.StockAdjustmentService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.FacilityList;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.component.ProductBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StockAdjustmentFormContent extends FormContent
{	
	private StockAdjustmentService service = Springs.get(StockAdjustmentService.class);
	
	private FacilityService facilityService = Springs.get(FacilityService.class);
	
	private Datebox date = Components.currentDatebox();
	
	private OrganizationList companys = new OrganizationList();
	
	private FacilityList facilitys = new FacilityList();
	
	private Textbox note = Components.stdTextBox(null, false);
	
	private Grid items = new Grid();
	
	public StockAdjustmentFormContent()
	{
		super();
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
				if(date.getValue() == null)
					throw new WrongValueException(date,lang.get("message.field.empty"));
				
				if(companys.getOrganization() == null)
					throw new WrongValueException(companys,lang.get("message.field.empty"));
				
				if(facilitys.getFacility() == null)
					throw new WrongValueException(facilitys,lang.get("message.field.empty"));
				
				StockAdjustment stock = new StockAdjustment();
				stock.setDate(DateTimes.sql(date.getValue()));
				stock.setOrganization(companys.getOrganization());
				stock.setFacility(facilitys.getFacility());
				stock.setNote(note.getText());
				
				for(Component com:items.getRows().getChildren())
				{
					Row row = (Row)com;
					
					StockAdjustmentItem item = new StockAdjustmentItem();
					item.setParent(stock);
					item.setProduct(Components.product(row, 1));
					item.setQuantity(RowUtils.decimal(row, 2));
					item.setExpired(RowUtils.sql(row, 4));
					item.setNote(RowUtils.string(row, 5));
					
					stock.getItems().add(item);
				}
				
				service.add(stock);
				
				Flow.next(getParent(), new StockAdjustmentGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("generic.grid.column.date")));
		row1.appendChild(date);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generic.grid.column.company")));
		row2.appendChild(companys);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("generic.grid.column.facility")));
		row3.appendChild(facilitys);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("generic.grid.column.note")));
		row4.appendChild(note);
		
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
		items.getColumns().appendChild(new Column(lang.get("stockadjustment.grid.column.uom"),null, "85px"));
		items.getColumns().appendChild(new Column(lang.get("stockadjustment.grid.column.expired"),null, "125px"));
		items.getColumns().appendChild(new Column(lang.get("stockadjustment.grid.column.note"),null, "150px"));
		items.setSpan("0");
		
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				
				ProductBox box = new ProductBox();
			
				row.appendChild(Components.checkbox(false));
				row.appendChild(box);
				row.appendChild(Components.doubleBox(1d));
				row.appendChild(box.getUoms());
				row.appendChild(Components.fullSpanDatebox(null));
				row.appendChild(Components.textBox(null));
				
				items.getRows().appendChild(row);
			}
		});
		
		appendChild(nrc);
		appendChild(items);
	}
}
