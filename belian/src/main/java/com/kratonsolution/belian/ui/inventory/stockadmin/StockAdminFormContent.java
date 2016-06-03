/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.stockadmin;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;

import com.kratonsolution.belian.inventory.dm.StockAdmin;
import com.kratonsolution.belian.payment.svc.StockAdminService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.EmployeeBox;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StockAdminFormContent extends FormContent
{	
	private StockAdminService service = Springs.get(StockAdminService.class);
	
	private EmployeeBox employee = new EmployeeBox(false);
	
	private OrganizationList companys = new OrganizationList();
	
	public StockAdminFormContent()
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
				Flow.next(getParent(), new StockAdminGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
			
				StockAdmin admin = new StockAdmin();
				admin.setEmployee(employee.getEmployee());
				admin.setOrganization(companys.getAsRole());
				
				service.add(admin);
				
				Flow.next(getParent(), new StockAdminGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Companys"));
		row1.appendChild(companys);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Employee"));
		row2.appendChild(employee);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
	}
}
