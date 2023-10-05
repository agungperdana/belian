
package com.kratonsolution.belian.ui.hr.employment;

import java.util.UUID;

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
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;

import com.kratonsolution.belian.common.util.DateTimes;
import com.kratonsolution.belian.hr.dm.Employment;
import com.kratonsolution.belian.hr.svc.EmploymentService;
import com.kratonsolution.belian.partys.dm.Organization;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.general.companystructure.CompanyStructureList;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class EmploymentEditContent extends AbstractForm
{	
	private EmploymentService service = Springs.get(EmploymentService.class);
	
	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();
	
	private CompanyStructureList employer = new CompanyStructureList(false);
	
	private PartyBox employee = new PartyBox(false);

	private Grid salarys = new Grid();
	
	private Grid benefits = new Grid();
	
	private Grid payrolls = new Grid();
	
	private Tabbox tabbox = new Tabbox();
	
	private Row row;
	
	public EmploymentEditContent(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
		initTabs();
		initSalarys();
		initBenefits();
		initPayrolls();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new EmploymentGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Employment employment = service.getOne(RowUtils.id(row));
				if(employment != null)
				{
					employment.setStart(DateTimes.sql(start.getValue()));
					employment.setEnd(DateTimes.sql(end.getValue()));
					
					service.edit(employment);
				}
				
				Flow.next(getParent(), new EmploymentGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{		
		Employment employment = service.getOne(RowUtils.id(row));
		if(employment != null)
		{
			start.setValue(employment.getStart());
			end.setValue(employment.getEnd());
			employer.setDomain((Organization)employment.getFromParty());
			employee.setDomain(employment.getToParty());
		}
		
		employer.setDisabled(true);
		employee.setDisabled();
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
			
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("employment.grid.column.start")));
		row1.appendChild(start);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("employment.grid.column.end")));
		row2.appendChild(end);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("employment.grid.column.employer")));
		row3.appendChild(employer);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("employment.grid.column.employee")));
		row4.appendChild(employee);

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
	}
	
	private void initTabs()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab(lang.get("employment.grid.column.salarys")));
		tabbox.getTabs().appendChild(new Tab(lang.get("employment.grid.column.benefits")));
		tabbox.getTabs().appendChild(new Tab(lang.get("employment.grid.column.payrolls")));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		
		appendChild(tabbox);
	}
	
	
	private void initSalarys()
	{
		NRCToolbar nrc = new NRCToolbar(salarys);
		
		salarys.setWidth("100%");
		salarys.appendChild(new Columns());
		salarys.appendChild(new Rows());
		salarys.setEmptyMessage(lang.get("message.grid.empty"));
		salarys.getColumns().appendChild(new Column(null,null,"25px"));
		salarys.getColumns().appendChild(new Column(lang.get("employment.grid.column.start"),null,"120px"));
		salarys.getColumns().appendChild(new Column(lang.get("employment.grid.column.end"),null,"120px"));
		salarys.getColumns().appendChild(new Column(lang.get("employment.grid.column.amount"),null,"120px"));
		salarys.getColumns().appendChild(new Column(lang.get("employment.grid.column.period"),null,"110px"));
		salarys.getColumns().appendChild(new Column());
		salarys.getColumns().getLastChild().setVisible(false);
		salarys.setSpan("4");
		
		Employment employment = service.getOne(RowUtils.id(row));
		if(employment != null)
		{
//			for(PayHistory history:employment.getSalarys())
//			{
//				Listbox measures = Components.fullSpanSelect();
//				
//				for(UnitOfMeasure measure:measureService.findAll())
//				{
//					Listitem listitem = measures.appendItem(measure.getLabel(), measure.getValue());
//					if(measure.getId().equals(history.getUom().getId()))
//						measures.setSelectedItem(listitem);
//				}
//				
//				Row row = new Row();
//				row.appendChild(Components.checkbox(false));
//				row.appendChild(Components.mandatoryDatebox(history.getStart()));
//				row.appendChild(Components.fullSpanDatebox(history.getEnd()));
//				row.appendChild(Components.doubleBox(history.getAmount().doubleValue()));
//				row.appendChild(measures);
//				row.appendChild(Components.label(history.getId()));
//				
//				salarys.getRows().appendChild(row);
//			}
		}
		
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox());
				row.appendChild(Components.fullSpanDatebox(null));
				row.appendChild(Components.doubleBox(0));
//				row.appendChild(Components.fullSpanSelect(measureService.findAll(),true));
				row.appendChild(Components.label(UUID.randomUUID().toString()));
				
				salarys.getRows().appendChild(row);
			}
		});
		
		tabbox.getTabpanels().getFirstChild().appendChild(nrc);
		tabbox.getTabpanels().getFirstChild().appendChild(salarys);
	}
	
	private void initBenefits()
	{
		NRCToolbar nrc = new NRCToolbar(benefits);
		
		benefits.setWidth("100%");
		benefits.appendChild(new Columns());
		benefits.appendChild(new Rows());
		benefits.setEmptyMessage(lang.get("message.grid.empty"));
		benefits.getColumns().appendChild(new Column(null,null,"25px"));
		benefits.getColumns().appendChild(new Column(lang.get("employment.grid.column.start"),null,"105px"));
		benefits.getColumns().appendChild(new Column(lang.get("employment.grid.column.end"),null,"105px"));
		benefits.getColumns().appendChild(new Column(lang.get("employment.grid.column.benefittype"),null,"110px"));
		benefits.getColumns().appendChild(new Column(lang.get("employment.grid.column.cost"),null,"90px"));
		benefits.getColumns().appendChild(new Column(lang.get("employment.grid.column.employerpaid"),null,"80px"));
		benefits.getColumns().appendChild(new Column(lang.get("employment.grid.column.available"),null,"50px"));
		benefits.getColumns().appendChild(new Column(lang.get("employment.grid.column.period"),null,"90px"));
		benefits.getColumns().appendChild(new Column());
		benefits.getColumns().getLastChild().setVisible(false);
		benefits.setSpan("3");
		
		Employment employment = service.getOne(RowUtils.id(row));
		if(employment != null)
		{
//			for(Benefit benefit:employment.getBenefits())
//			{
//				Listbox periods = Components.fullSpanSelect();
//				for(PeriodType type:PeriodType.values())
//				{
//					Listitem item = periods.appendItem(type.display(), type.name());
//					if(benefit.getPeriodType().equals(type))
//						periods.setSelectedItem(item);
//				}
//				
//				Row row = new Row();
//				row.appendChild(Components.checkbox(false));
//				row.appendChild(Components.mandatoryDatebox(benefit.getStart()));
//				row.appendChild(Components.fullSpanDatebox(benefit.getEnd()));
//				row.appendChild(Components.fullSpanSelect(benefitTypeService.findAll(),benefit.getType()));
//				row.appendChild(Components.doubleBox(benefit.getCost().doubleValue()));
//				row.appendChild(Components.doubleBox(benefit.getEmployerPaid().doubleValue()));
//				row.appendChild(Components.doubleBox(benefit.getAvailableTime()));
//				row.appendChild(periods);
//				row.appendChild(Components.label(benefit.getId()));
//				
//				benefits.getRows().appendChild(row);
//			}
		}
		
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
//				Listbox periods = Components.fullSpanSelect();
//				for(PeriodType type:PeriodType.values())
//					periods.setSelectedItem(periods.appendItem(type.display(), type.name()));
//				
//				Row row = new Row();
//				row.appendChild(Components.checkbox(false));
//				row.appendChild(Components.mandatoryDatebox());
//				row.appendChild(Components.fullSpanDatebox(null));
//				row.appendChild(Components.fullSpanSelect(benefitTypeService.findAll(),true));
//				row.appendChild(Components.doubleBox(0));
//				row.appendChild(Components.doubleBox(0));
//				row.appendChild(Components.doubleBox(0));
//				row.appendChild(periods);
//				row.appendChild(Components.label(UUID.randomUUID().toString()));
//				
//				benefits.getRows().appendChild(row);
			}
		});
		
		tabbox.getTabpanels().getChildren().get(1).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(1).appendChild(benefits);
	}
	
	private void initPayrolls()
	{
		NRCToolbar nrc = new NRCToolbar(payrolls);
		
		payrolls.setWidth("100%");
		payrolls.appendChild(new Columns());
		payrolls.appendChild(new Rows());
		payrolls.setEmptyMessage(lang.get("message.grid.empty"));
		payrolls.getColumns().appendChild(new Column(null,null,"25px"));
		payrolls.getColumns().appendChild(new Column(lang.get("employment.grid.column.start"),null,"105px"));
		payrolls.getColumns().appendChild(new Column(lang.get("employment.grid.column.end"),null,"105px"));
		payrolls.getColumns().appendChild(new Column(lang.get("employment.grid.column.paymenttype"),null,"110px"));
		payrolls.getColumns().appendChild(new Column(lang.get("employment.grid.column.percent"),null,"90px"));
		payrolls.getColumns().appendChild(new Column(lang.get("employment.grid.column.amount"),null,"90px"));
		payrolls.getColumns().appendChild(new Column(lang.get("employment.grid.column.banknumber"),null,"120px"));
		payrolls.getColumns().appendChild(new Column(lang.get("employment.grid.column.bankname"),null,"120px"));
		payrolls.getColumns().appendChild(new Column(lang.get("employment.grid.column.period"),null,"90px"));
		payrolls.getColumns().appendChild(new Column());
		payrolls.getColumns().getLastChild().setVisible(false);
		
		Employment employment = service.getOne(RowUtils.id(row));
		if(employment != null)
		{
//			for(PayrollPreference preference:employment.getPreferences())
//			{
//				Listbox periods = Components.fullSpanSelect();
//				for(PeriodType type:PeriodType.values())
//					periods.setSelectedItem(periods.appendItem(type.display(), type.name()));
//				
//				Row prow = new Row();
//				prow.appendChild(Components.checkbox(false));
//				prow.appendChild(Components.mandatoryDatebox(preference.getStart()));
//				prow.appendChild(Components.fullSpanDatebox(preference.getEnd()));
//				prow.appendChild(Components.fullSpanSelect(methodTypeService.findAll(), preference.getPaymentType()));
//				prow.appendChild(Components.doubleBox(preference.getPercent()));
//				prow.appendChild(Components.doubleBox(preference.getAmount()));
//				prow.appendChild(Components.textBox(preference.getBankNumber()));
//				prow.appendChild(Components.textBox(preference.getBankName()));
//				prow.appendChild(periods);
//				prow.appendChild(Components.label(preference.getId()));
//				
//				payrolls.getRows().appendChild(prow);
//			}
		}
		
		nrc.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
//				Listbox periods = Components.fullSpanSelect();
//				for(PeriodType type:PeriodType.values())
//					periods.setSelectedItem(periods.appendItem(type.display(), type.name()));
//				
//				Row row = new Row();
//				row.appendChild(Components.checkbox(false));
//				row.appendChild(Components.mandatoryDatebox(DateTimes.currentDate()));
//				row.appendChild(Components.fullSpanDatebox(null));
//				row.appendChild(Components.fullSpanSelect(methodTypeService.findAll(), true));
//				row.appendChild(Components.doubleBox(null));
//				row.appendChild(Components.doubleBox(null));
//				row.appendChild(Components.textBox(null));
//				row.appendChild(Components.textBox(null));
//				row.appendChild(periods);
//				row.appendChild(Components.label(UUID.randomUUID().toString()));
//				
//				payrolls.getRows().appendChild(row);
			}
		});
		
		tabbox.getTabpanels().getLastChild().appendChild(nrc);
		tabbox.getTabpanels().getLastChild().appendChild(payrolls);
	}
}
