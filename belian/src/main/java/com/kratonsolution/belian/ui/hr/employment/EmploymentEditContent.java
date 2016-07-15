/**
 * 
 */
package com.kratonsolution.belian.ui.hr.employment;

import java.util.UUID;
import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;

import com.kratonsolution.belian.accounting.dm.PeriodType;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.hr.dm.Benefit;
import com.kratonsolution.belian.hr.dm.Employment;
import com.kratonsolution.belian.hr.dm.PayHistory;
import com.kratonsolution.belian.hr.svc.BenefitTypeService;
import com.kratonsolution.belian.hr.svc.EmploymentApplicationService;
import com.kratonsolution.belian.hr.svc.EmploymentService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.component.PersonBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class EmploymentEditContent extends FormContent
{	
	private EmploymentService service = Springs.get(EmploymentService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private EmploymentApplicationService applicationService = Springs.get(EmploymentApplicationService.class);
	
	private BenefitTypeService benefitTypeService = Springs.get(BenefitTypeService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();
	
	private Listbox applications = Components.newSelect();
	
	private PersonBox persons = new PersonBox(false);
	
	private OrganizationList employer = new OrganizationList();

	private Grid salarys = new Grid();
	
	private Grid benefits = new Grid();
	
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
				Employment employment = service.findOne(RowUtils.id(row));
				if(employment != null)
				{
					employment.setStart(DateTimes.sql(start.getValue()));
					employment.setEnd(DateTimes.sql(end.getValue()));
				
					Vector<PayHistory> vector = new Vector<>();
					Vector<Benefit> bVector = new Vector<>();
					
					for(Component com:salarys.getRows().getChildren())
					{
						Row row = (Row)com;
						
						PayHistory history = new PayHistory();
						history.setId(RowUtils.id(row));
						history.setAmount(RowUtils.decimal(row, 3));
						history.setEmployment(employment);
						history.setStart(RowUtils.sql(row, 1));
						history.setEnd(RowUtils.sql(row, 2));
						history.setPeriodType(PeriodType.valueOf(RowUtils.string(row, 4)));
						
						vector.add(history);
					}
					
					for(Component com:benefits.getRows().getChildren())
					{
						Row row = (Row)com;
						
						Benefit benefit = new Benefit();
						benefit.setId(RowUtils.id(row));
						benefit.setAvailableTime(RowUtils.integer(row, 6));
						benefit.setCost(RowUtils.decimal(row, 4));
						benefit.setEmployerPaid(RowUtils.decimal(row, 5));
						benefit.setEnd(RowUtils.sql(row, 2));
						benefit.setPeriodType(PeriodType.valueOf(RowUtils.string(row, 7)));
						benefit.setStart(RowUtils.sql(row, 1));
						benefit.setType(benefitTypeService.findOne(RowUtils.string(row, 3)));
						benefit.setEmployment(employment);
						
						bVector.add(benefit);
					}
					
					service.edit(employment,vector,bVector);
				}
				
				Flow.next(getParent(), new EmploymentGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{		
		Employment employment = service.findOne(RowUtils.id(row));
		if(employment != null)
		{
			start.setValue(employment.getStart());
			end.setValue(employment.getEnd());
			employer.setOrganization(employment.getInternalOrganization().getOrganization());
			persons.setPerson((Person)employment.getEmployee().getParty());
		}
		
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
		row4.appendChild(persons);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("employment.grid.column.application")));
		row5.appendChild(applications);

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}
	
	private void initTabs()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab(lang.get("employment.grid.column.salarys")));
		tabbox.getTabs().appendChild(new Tab(lang.get("employment.grid.column.benefits")));
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
		salarys.getColumns().appendChild(new Column(lang.get("employment.grid.column.start"),null,"110px"));
		salarys.getColumns().appendChild(new Column(lang.get("employment.grid.column.end"),null,"110px"));
		salarys.getColumns().appendChild(new Column(lang.get("employment.grid.column.amount"),null,"110px"));
		salarys.getColumns().appendChild(new Column(lang.get("employment.grid.column.period"),null,"110px"));
		salarys.getColumns().appendChild(new Column());
		salarys.getColumns().getLastChild().setVisible(false);
		salarys.setSpan("4");
		
		Employment employment = service.findOne(RowUtils.id(row));
		if(employment != null)
		{
			for(PayHistory history:employment.getSalarys())
			{
				Listbox periods = Components.fullSpanSelect();
				for(PeriodType type:PeriodType.values())
				{
					Listitem item = periods.appendItem(type.display(), type.name());
					if(history.getPeriodType().equals(type))
						periods.setSelectedItem(item);
				}
				
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox(history.getStart()));
				row.appendChild(Components.fullSpanDatebox(history.getEnd()));
				row.appendChild(Components.doubleBox(history.getAmount().doubleValue()));
				row.appendChild(periods);
				row.appendChild(Components.label(history.getId()));
				
				salarys.getRows().appendChild(row);
			}
		}
		
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Listbox periods = Components.fullSpanSelect();
				for(PeriodType type:PeriodType.values())
					periods.setSelectedItem(periods.appendItem(type.display(), type.name()));
				
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox());
				row.appendChild(Components.fullSpanDatebox(null));
				row.appendChild(Components.doubleBox(0));
				row.appendChild(periods);
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
		
		Employment employment = service.findOne(RowUtils.id(row));
		if(employment != null)
		{
			for(Benefit benefit:employment.getBenefits())
			{
				Listbox periods = Components.fullSpanSelect();
				for(PeriodType type:PeriodType.values())
				{
					Listitem item = periods.appendItem(type.display(), type.name());
					if(benefit.getPeriodType().equals(type))
						periods.setSelectedItem(item);
				}
				
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox(benefit.getStart()));
				row.appendChild(Components.fullSpanDatebox(benefit.getEnd()));
				row.appendChild(Components.fullSpanSelect(benefitTypeService.findAll(),benefit.getType()));
				row.appendChild(Components.doubleBox(benefit.getCost().doubleValue()));
				row.appendChild(Components.doubleBox(benefit.getEmployerPaid().doubleValue()));
				row.appendChild(Components.doubleBox(benefit.getAvailableTime()));
				row.appendChild(periods);
				row.appendChild(Components.label(benefit.getId()));
				
				benefits.getRows().appendChild(row);
			}
		}
		
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Listbox periods = Components.fullSpanSelect();
				for(PeriodType type:PeriodType.values())
					periods.setSelectedItem(periods.appendItem(type.display(), type.name()));
				
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox());
				row.appendChild(Components.fullSpanDatebox(null));
				row.appendChild(Components.fullSpanSelect(benefitTypeService.findAll(),true));
				row.appendChild(Components.doubleBox(0));
				row.appendChild(Components.doubleBox(0));
				row.appendChild(Components.doubleBox(0));
				row.appendChild(periods);
				row.appendChild(Components.label(UUID.randomUUID().toString()));
				
				benefits.getRows().appendChild(row);
			}
		});
		
		tabbox.getTabpanels().getLastChild().appendChild(nrc);
		tabbox.getTabpanels().getLastChild().appendChild(benefits);
	}
}
