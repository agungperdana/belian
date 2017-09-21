/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.goodreceive;

import java.sql.Date;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.global.dm.ProductReceiveable;
import com.kratonsolution.belian.global.dm.ProductReceiveableItem;
import com.kratonsolution.belian.global.dm.ProductReceiveableRepository;
import com.kratonsolution.belian.inventory.dm.GoodsReceive;
import com.kratonsolution.belian.inventory.dm.GoodsReceiveItem;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.inventory.svc.GoodsReceiveService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GoodsReceiveFormContent extends FormContent
{	
	private GoodsReceiveService service = Springs.get(GoodsReceiveService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private ProductReceiveableRepository requestService = Springs.get(ProductReceiveableRepository.class);
	
	private FacilityService facilityService = Springs.get(FacilityService.class);
	
	private Datebox date = Components.currentDatebox();
	
	private Textbox number = Components.stdTextBox(GoodsReceive.NCODE+System.currentTimeMillis(),true);
	
	private Listbox companys = Components.newSelect(utils.getOrganization());
	
	private Listbox receiveables = Components.newSelect(requestService.findAllNew(utils.getOrganization().getId()),true);
	
	private Listbox facilitys = Components.newSelect(facilityService.findAllActive(),true);
	
	private Listbox users = Components.newSelect(utils.getUser().getPerson());
	
	private Grid items = new Grid();
	
	public GoodsReceiveFormContent()
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
				GoodsReceiveWindow window = (GoodsReceiveWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(receiveables.getSelectedCount() < 1)
					throw new WrongValueException(receiveables,"Receivable reference cannot be empty.");
				
				GoodsReceive gr = new GoodsReceive();
				gr.setDate(new Date(date.getValue().getTime()));
				gr.setDestination(facilityService.findOne(Components.string(facilitys)));
				gr.setNumber(number.getText());
				gr.setOrganization(utils.getOrganization());
				gr.setReceiver(utils.getUser().getPerson());
				gr.setReference(requestService.findOne(Components.string(receiveables)));
				
				for(ProductReceiveableItem item:gr.getReference().getItems())
				{
					GoodsReceiveItem gri = new GoodsReceiveItem();
					gri.setGoodsReceive(gr);
					gri.setNote(item.getNote());
					gri.setProduct(item.getProduct());
					gri.setQuantity(item.getQuantity());
					
					gr.getItems().add(gri);
				}
				
				service.add(gr);
				
				GoodsReceiveWindow window = (GoodsReceiveWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		receiveables.addEventListener(Events.ON_SELECT,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				initData();
			}
		});
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Date"));
		row1.appendChild(date);
		
		Row row0 = new Row();
		row0.appendChild(new Label("Number"));
		row0.appendChild(number);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Company"));
		row2.appendChild(companys);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Reference"));
		row3.appendChild(receiveables);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Facility"));
		row4.appendChild(facilitys);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Receive By"));
		row5.appendChild(users);
		
		rows.appendChild(row1);
		rows.appendChild(row0);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}
	
	private void initItems()
	{
		items.setWidth("100%");
		items.appendChild(new Rows());
		items.appendChild(new Columns());
		items.getColumns().appendChild(new Column("Product",null, "150px"));
		items.getColumns().appendChild(new Column("Quantity",null, "90px"));
		items.getColumns().appendChild(new Column("UoM",null, "100px"));
		items.getColumns().appendChild(new Column("Note",null, "150px"));
		items.setSpan("0");
		
		appendChild(items);
	
		initData();
	}
	
	private void initData()
	{
		items.getRows().getChildren().clear();
		
		ProductReceiveable receiveable = requestService.findOne(Components.string(receiveables));
		if(receiveable != null)
		{
			for(ProductReceiveableItem item:receiveable.getItems())
			{
				Row row = new Row();
				row.appendChild(new Label(item.getProduct().getName()));
				row.appendChild(Components.label(item.getQuantity()));
				row.appendChild(new Label(item.getProduct().getUom().getName()));
				row.appendChild(new Label(item.getNote()));
				
				items.getRows().appendChild(row);
			}
		}
	}
}
