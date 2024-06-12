
package com.kratonsolution.belian.ui.inventorys.stockadjustment;

import java.math.BigDecimal;

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
import org.zkoss.zul.Timebox;

import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.stockadjustment.impl.orm.StockAdjustment;
import com.kratonsolution.belian.stockadjustment.impl.orm.StockAdjustmentItem;
import com.kratonsolution.belian.stockadjustment.impl.application.StockAdjustmentService;
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
public class StockAdjustmentFormContent extends AbstractForm
{	
	private StockAdjustmentService service = Springs.get(StockAdjustmentService.class);
	
	private Datebox date = Components.currentDatebox();
	
	private Timebox time = Components.timebox();
	
	private CompanyStructureList organizations = new CompanyStructureList(false);
	
	private FacilityList facilitys = new FacilityList(false);
	
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
				if(organizations.getDomain() == null)
					throw new WrongValueException(organizations,lang.get("message.field.empty"));
				
				if(date.getValue() == null)
					throw new WrongValueException(date,lang.get("message.field.empty"));
				
				if(facilitys.getDomain() == null)
					throw new WrongValueException(facilitys,lang.get("message.field.empty"));
				
				StockAdjustment stock = new StockAdjustment();
				stock.setDate(DateTimes.sql(date.getValue()));
				stock.setTime(DateTimes.time(null,false));
				stock.setOrganization(organizations.getDomainAsRef());
				stock.setFacility(facilitys.getDomainAsRef());
				stock.setNote(note.getText());
				
				for(Component com:items.getRows().getChildren())
				{
					Row row = (Row)com;
					
					ProductBox box = (ProductBox)row.getChildren().get(1);
					StockAdjustmentTypeList types = (StockAdjustmentTypeList)row.getChildren().get(3);
					ContainerList con = (ContainerList)row.getChildren().get(4);
					
					
					if(box.getDomain() == null)
						throw new WrongValueException(row.getChildren().get(1),lang.get("message.field.empty"));
					
					if(types.getStockAdjustmentType() == null)
						throw new WrongValueException(row.getChildren().get(3),lang.get("message.field.empty"));
					
					if(con.getDomain() == null)
						throw new WrongValueException(row.getChildren().get(4),lang.get("message.field.empty"));
					
					BigDecimal adjusted = RowUtils.decimal(row, 2);
					if(adjusted != null && adjusted.compareTo(BigDecimal.ZERO) > 0)
					{
						StockAdjustmentItem item = new StockAdjustmentItem();
						item.setParent(stock);
						item.setType(types.getStockAdjustmentType());
						item.setAdjustment(RowUtils.decimal(row, 2));
						item.setContainer(con.getDomainAsRef());
						item.setExpired(RowUtils.sql(row, 4));
						item.setNote(RowUtils.string(row, 5));
						item.setProduct(box.getDomainAsRef());
						
						stock.getItems().add(item);
					}
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
		items.getColumns().appendChild(new Column(lang.get("stockadjustment.grid.column.type"),null, "100px"));
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
				row.appendChild(new StockAdjustmentTypeList(true));
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
