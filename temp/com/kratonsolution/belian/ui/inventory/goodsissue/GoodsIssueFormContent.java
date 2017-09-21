/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.goodsissue;

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

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.inventory.svc.GoodsIssueService;
import com.kratonsolution.belian.inventory.svc.TransferOrderRequestService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GoodsIssueFormContent extends FormContent
{	
	private GoodsIssueService service = Springs.get(GoodsIssueService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private TransferOrderRequestService requestService = Springs.get(TransferOrderRequestService.class);
	
	private FacilityService facilityService = Springs.get(FacilityService.class);
	
	private Datebox date = Components.currentDatebox();
	
	private Listbox companys = Components.newSelect(utils.getOrganization());
	
	private Listbox requests = Components.newSelect(requestService.findAllIncomplete(),true);
	
	private Listbox facilitys = Components.newSelect(facilityService.findAllActive(),true);
	
	private Listbox users = Components.newSelect(utils.getUser().getPerson());
	
	private Grid items = new Grid();
	
	public GoodsIssueFormContent()
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
				GoodsIssueWindow window = (GoodsIssueWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				
				GoodsIssueWindow window = (GoodsIssueWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		requests.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
			}
		});
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Date"));
		row1.appendChild(date);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Company"));
		row2.appendChild(companys);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Request Number"));
		row3.appendChild(requests);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Facility"));
		row4.appendChild(facilitys);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Issued By"));
		row5.appendChild(users);
		
		rows.appendChild(row1);
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
		items.getColumns().appendChild(new Column("Quantity",null, "150px"));
		items.getColumns().appendChild(new Column("Note",null, "150px"));
		items.getColumns().appendChild(new Column(null,null, "1px"));
		items.getColumns().getChildren().get(3).setVisible(false);
		items.setSpan("0");
		
		appendChild(items);
	}
}
