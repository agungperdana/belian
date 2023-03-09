
package com.kratonsolution.belian.ui.setting;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.general.dm.GeographicType;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.global.dm.PrinterType;
import com.kratonsolution.belian.global.dm.UserSetting;
import com.kratonsolution.belian.global.svc.UserSettingService;
import com.kratonsolution.belian.security.dm.User;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.accounting.currency.CurrencyList;
import com.kratonsolution.belian.ui.accounting.tax.TaxList;
import com.kratonsolution.belian.ui.general.companystructure.CompanyStructureList;
import com.kratonsolution.belian.ui.general.geographic.GeographicList;
import com.kratonsolution.belian.ui.inventory.facility.FacilityList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SettingForm extends AbstractForm
{
	private UserSettingService userService = Springs.get(UserSettingService.class);

	private GeographicService geographicService = Springs.get(GeographicService.class);

	private Vlayout layout = new Vlayout(); 

	private Tabbox tabbox = new Tabbox();

	private CompanyStructureList organizations = new CompanyStructureList(false);

	private GeographicList locations = new GeographicList(false, GeographicType.CITY);

	private LanguageList languanges = new LanguageList();

	private CurrencyList currencys = new CurrencyList(false);

	private TaxList taxes = new TaxList(false);

	private Listbox printers = Components.newSelect();

	private FacilityList facilitys = new FacilityList(false);

	private Doublebox rowPerPage = new Doublebox(25);

	public SettingForm()
	{
		super();
		initToolbar();
		initForm();
	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.FormContent#initToolbar()
	 */
	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				getParent().setVisible(false);
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				User user = utils.getUser();
				if(user != null)
				{
					UserSetting setting = null;
					if(user.getSetting() != null)
						setting = userService.getOne(user.getSetting().getId());

					if(setting == null)
					{
						setting = new UserSetting();
						userService.add(setting);

						user.setSetting(setting);
						userService.edit(user);
					}

					setting.setLanguage(Components.string(languanges));
					setting.setRowPerPage(rowPerPage.intValue());
					setting.setOrganization(organizations.getDomainAsRef());
					setting.setCurrency(currencys.getDomainAsRef());
					setting.setLocation(locations.getDomainAsRef());
					setting.setTax(taxes.getDomainAsRef());
					setting.setPrinter(PrinterType.valueOf(Components.string(printers)));
					setting.setFacility(facilitys.getDomainAsRef());

					userService.edit(setting);
					
					Executions.sendRedirect("/home");
				}

				getParent().setVisible(false);
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.FormContent#initForm()
	 */
	@Override
	public void initForm()
	{
		organizations.addObserver(facilitys);

		for(PrinterType type:PrinterType.values())
		{
			Listitem listitem = printers.appendItem(type.name(),type.name());
			if(utils.getPrinterType().equals(type))
				printers.setSelectedItem(listitem);
		}

		rowPerPage.setValue(utils.getRowPerPage());

		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"150px"));
		grid.getColumns().appendChild(new Column());
		grid.setSpan("1");

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("generic.grid.column.company")));
		row1.appendChild(organizations);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generic.grid.column.location")));
		row2.appendChild(locations);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("generic.grid.column.facility")));
		row3.appendChild(facilitys);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("generic.grid.column.language")));
		row4.appendChild(languanges);

		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("generic.grid.column.currency")));
		row5.appendChild(currencys);

		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("generic.grid.column.tax")));
		row6.appendChild(taxes);

		Row row7 = new Row();
		row7.appendChild(new Label(lang.get("generic.grid.column.rowperpage")));
		row7.appendChild(rowPerPage);

		Row row8 = new Row();
		row8.appendChild(new Label(lang.get("generic.grid.column.printer")));
		row8.appendChild(printers);

		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
		grid.getRows().appendChild(row4);
		grid.getRows().appendChild(row5);
		grid.getRows().appendChild(row6);
		grid.getRows().appendChild(row7);
		grid.getRows().appendChild(row8);
	}
}
