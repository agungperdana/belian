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

	private OGLAccountList taxsales = new OGLAccountList();

	private OGLAccountList tuslahpayable = new OGLAccountList();
	
	private OGLAccountList receivable = new OGLAccountList();
	
	private OGLAccountList branchCash = new OGLAccountList(companys.getOrganization());
	
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
					setting.getSales().setTaxSales(taxsales.getAccount());
					setting.getSales().setTuslah(tuslahpayable.getAccount());
					setting.getSales().setReceivable(receivable.getAccount());
					setting.getSales().setBranchCash(branchCash.getAccount());

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
				goodsSales.repopulate(companys.getOrganization());
				taxsales.repopulate(companys.getOrganization());
				receivable.repopulate(companys.getOrganization());
				branchCash.repopulate(companys.getOrganization());
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

			taxsales.repopulate(setting.getOrganization());
			taxsales.setAccount(setting.getSales().getTaxSales());
			
			tuslahpayable.repopulate(setting.getOrganization());
			tuslahpayable.setAccount(setting.getSales().getTuslah());
			
			receivable.repopulate(setting.getOrganization());
			receivable.setAccount(setting.getSales().getReceivable());
			
			branchCash.repopulate(setting.getOrganization());
			branchCash.setAccount(setting.getSales().getBranchCash());
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
		row5.appendChild(new Label(lang.get("journalsetting.grid.column.taxsales")));
		row5.appendChild(taxsales);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("journalsetting.grid.column.receivable")));
		row6.appendChild(receivable);
		
		Row row7 = new Row();
		row7.appendChild(new Label(lang.get("journalsetting.grid.column.tuslah")));
		row7.appendChild(tuslahpayable);
		
		Row row8 = new Row();
		row8.appendChild(new Label(lang.get("journalsetting.grid.column.branchcash")));
		row8.appendChild(branchCash);
		
		layout.getRows().appendChild(row2);
		layout.getRows().appendChild(row3);
		layout.getRows().appendChild(row4);
		layout.getRows().appendChild(row5);
		layout.getRows().appendChild(row6);
		layout.getRows().appendChild(row7);
		layout.getRows().appendChild(row8);
		
		tabbox.getTabpanels().getFirstChild().appendChild(layout);
	}
}
