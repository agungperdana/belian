/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.journalsetting;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.accounting.dm.AutoJournalSetting;
import com.kratonsolution.belian.accounting.svc.JournalSettingService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.accounting.organizationaccount.OGLAccountList;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class JournalSettingEditContent extends FormContent
{	
	private JournalSettingService service = Springs.get(JournalSettingService.class);

	private OrganizationList companys = new OrganizationList();

	private OGLAccountList cashes = new OGLAccountList();

	private OGLAccountList serviceSales = new OGLAccountList();

	private OGLAccountList goodsSales = new OGLAccountList();

	private OGLAccountList taxpayable = new OGLAccountList();

	private OGLAccountList payable = new OGLAccountList();

	private Textbox note = Components.stdTextBox(null, false);
	
	private Tabbox tabbox = new Tabbox();
	
	private Row row;

	public JournalSettingEditContent(Row row)
	{
		super();
		this.row = row;

		initToolbar();
		initForm();
		initTabbox();
		initSales();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new JournalSettingGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				AutoJournalSetting setting = service.findOne(RowUtils.id(row));
				if(setting != null)
				{
					setting.getSales().setCash(cashes.getAccount());
					setting.getSales().setServiceSales(serviceSales.getAccount());
					setting.getSales().setGoodsSales(goodsSales.getAccount());
					setting.getSales().setTaxPayable(taxpayable.getAccount());
					setting.getSales().setPayable(payable.getAccount());

					service.edit(setting);
				}

				Flow.next(getParent(), new JournalSettingGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		AutoJournalSetting setting = service.findOne(RowUtils.id(row));
		if(setting != null)
			companys.setOrganization(setting.getOrganization());

		companys.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				cashes.repopulate(companys.getOrganization());
				serviceSales.repopulate(companys.getOrganization());
				taxpayable.repopulate(companys.getOrganization());
				payable.repopulate(companys.getOrganization());
			}
		});
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"165px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("generic.grid.column.company")));
		row1.appendChild(companys);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generic.grid.column.note")));
		row2.appendChild(note);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		
		appendChild(grid);
	}
	
	private void initTabbox()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab("SALES"));
		tabbox.getTabs().appendChild(new Tab("PAYROLL"));
		tabbox.getTabs().appendChild(new Tab("PAYMENT"));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		
		appendChild(tabbox);
	}
	
	private void initSales()
	{
		AutoJournalSetting setting = service.findOne(RowUtils.id(row));
		if(setting != null && setting.getSales() != null)
		{
			cashes.repopulate(setting.getOrganization());
			cashes.setAccount(setting.getSales().getCash());
			
			serviceSales.repopulate(setting.getOrganization());
			serviceSales.setAccount(setting.getSales().getServiceSales());

			goodsSales.repopulate(setting.getOrganization());
			goodsSales.setAccount(setting.getSales().getGoodsSales());

			taxpayable.repopulate(setting.getOrganization());
			taxpayable.setAccount(setting.getSales().getTaxPayable());

			payable.repopulate(setting.getOrganization());
			payable.setAccount(setting.getSales().getPayable());
		}
		
		Grid layout = new Grid();
		layout.appendChild(new Columns());
		layout.appendChild(new Rows());
		layout.getColumns().appendChild(new Column(null,null,"165px"));
		layout.getColumns().appendChild(new Column());
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("journalsetting.grid.column.cash")));
		row2.appendChild(cashes);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("journalsetting.grid.column.servicesales")));
		row3.appendChild(serviceSales);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("journalsetting.grid.column.goodssales")));
		row4.appendChild(goodsSales);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("journalsetting.grid.column.taxpayable")));
		row5.appendChild(taxpayable);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("journalsetting.grid.column.payable")));
		row6.appendChild(payable);
		
		layout.getRows().appendChild(row2);
		layout.getRows().appendChild(row3);
		layout.getRows().appendChild(row4);
		layout.getRows().appendChild(row5);
		layout.getRows().appendChild(row6);
		
		tabbox.getTabpanels().getFirstChild().appendChild(layout);
	}
}
