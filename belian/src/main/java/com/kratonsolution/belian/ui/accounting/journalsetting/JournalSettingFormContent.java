/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.journalsetting;

import org.zkoss.zk.ui.WrongValueException;
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

import com.kratonsolution.belian.accounting.dm.AutoJournalSales;
import com.kratonsolution.belian.accounting.dm.AutoJournalSetting;
import com.kratonsolution.belian.accounting.svc.JournalSettingService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.accounting.organizationaccount.OGLAccountList;
import com.kratonsolution.belian.ui.component.CompanyList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class JournalSettingFormContent extends FormContent
{	
	private JournalSettingService service = Springs.get(JournalSettingService.class);
	
	private CompanyList companys = new CompanyList();
	
	private OGLAccountList cashes = new OGLAccountList(companys.getOrganization());
	
	private OGLAccountList serviceSales = new OGLAccountList(companys.getOrganization());
	
	private OGLAccountList goodsSales = new OGLAccountList(companys.getOrganization());
	
	private OGLAccountList taxsales = new OGLAccountList(companys.getOrganization());
	
	private OGLAccountList tuslahpayable = new OGLAccountList(companys.getOrganization());
	
	private OGLAccountList receivable = new OGLAccountList(companys.getOrganization());
	
	private Textbox note = Components.stdTextBox(null,false);
	
	private Tabbox tabbox = new Tabbox();
	
	public JournalSettingFormContent()
	{
		super();
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
				if(service.findOneByOrganizationId(companys.getOrganization().getId()) != null)
					throw new WrongValueException(companys,lang.get("message.field.exist"));
				
				AutoJournalSetting setting = new AutoJournalSetting();
				setting.setOrganization(companys.getOrganization());
				setting.setSales(new AutoJournalSales());
				setting.getSales().setCash(cashes.getAccount());
				setting.getSales().setServiceSales(serviceSales.getAccount());
				setting.getSales().setGoodsSales(goodsSales.getAccount());
				setting.getSales().setTaxSales(taxsales.getAccount());
				setting.getSales().setTuslah(tuslahpayable.getAccount());
				setting.getSales().setReceivable(receivable.getAccount());
				
				service.add(setting);
				
				Flow.next(getParent(), new JournalSettingGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		companys.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				cashes.repopulate(companys.getOrganization());
				serviceSales.repopulate(companys.getOrganization());
				taxsales.repopulate(companys.getOrganization());
				tuslahpayable.repopulate(companys.getOrganization());
				receivable.repopulate(companys.getOrganization());
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
		
		layout.getRows().appendChild(row2);
		layout.getRows().appendChild(row3);
		layout.getRows().appendChild(row4);
		layout.getRows().appendChild(row5);
		layout.getRows().appendChild(row6);
		layout.getRows().appendChild(row7);
		
		tabbox.getTabpanels().getFirstChild().appendChild(layout);
	}
}
