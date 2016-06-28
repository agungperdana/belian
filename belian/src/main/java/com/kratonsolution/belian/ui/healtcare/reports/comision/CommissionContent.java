/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.reports.comision;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.healtcare.dm.Laboratory;
import com.kratonsolution.belian.healtcare.dm.Medication;
import com.kratonsolution.belian.healtcare.dm.Treatment;
import com.kratonsolution.belian.inventory.dm.ProductType;
import com.kratonsolution.belian.sales.dm.Billable;
import com.kratonsolution.belian.sales.dm.BillableItem;
import com.kratonsolution.belian.sales.dm.BillableRepository;
import com.kratonsolution.belian.ui.ReportToolbar;
import com.kratonsolution.belian.ui.component.DateRange;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.healtcare.doctor.DoctorBox;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CommissionContent extends Vlayout
{
	private Language lang = Springs.get(Language.class);
	
	private Grid grid = new Grid();
	
	public CommissionContent()
	{
		setWidth("100%");
		init();
	}
	
	private void init()
	{
		grid.setEmptyMessage("no report data available.");
		grid.setWidth("100%");
		grid.appendChild(new Rows());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(lang.get("generic.grid.column.date"),null,"100px"));
		grid.getColumns().appendChild(new Column(lang.get("generic.grid.column.product"),null,"85px"));
		grid.getColumns().appendChild(new Column(lang.get("generic.grid.column.quantity"),null,"100px"));
		grid.getColumns().appendChild(new Column(lang.get("generic.grid.column.amount"),null,"135px"));
		grid.setSpan("1");
		
		ReportToolbar toolbar = new ReportToolbar();
		appendChild(toolbar);
		
		toolbar.getGenerate().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Filter filter = new Filter(CommissionContent.this);
				filter.setPage(getPage());
				filter.doModal();
			}
		});
	}
	
	private class Filter extends Window
	{
		private OrganizationList companys = new OrganizationList();
		private DoctorBox doctorBox = new DoctorBox(false);
		private DateRange range = new DateRange();
		private Checkbox all = new Checkbox("Show Detail");
		private Button generate = new Button(lang.get("label.component.button.generate"));
		private Button close = new Button(lang.get("label.component.button.close"));
		private Caption caption = new Caption(lang.get("label.component.generic.criteria"), "/icons/generate-report.png");
		
		public Filter(Component parent)
		{
			appendChild(caption);
			
			setWidth("300px");
			
			Hbox hbox = new Hbox();
			hbox.setAlign("end");
			hbox.appendChild(close);
			hbox.appendChild(generate);
			hbox.setHflex("1");
			hbox.setPack("end");
			
			Vlayout layout = new Vlayout();
			layout.appendChild(companys);
			layout.appendChild(doctorBox);
			layout.appendChild(range);
			layout.appendChild(all);
			layout.appendChild(hbox);
			
			appendChild(layout);
			
			close.addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event arg0) throws Exception
				{
					Filter.this.detach();
				}
			});
			
			generate.addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event arg0) throws Exception
				{
					if(parent.getChildren().contains(grid))
						grid.getRows().getChildren().clear();
					else
						parent.appendChild(grid);
					
					List<Billable> list = new ArrayList<>();
					
					BillableRepository repository = Springs.get(BillableRepository.class);
				
					if(doctorBox.getDoctor() != null && range.getStart() != null && range.getEnd() != null)
						list.addAll(repository.findAll(range.getStart(), range.getEnd(), companys.getOrganization().getId(), doctorBox.getDoctor().getDoctor().getPerson().getId()));
					else if(doctorBox.getDoctor() == null && range.getStart() != null && range.getEnd() != null )
						list.addAll(repository.findAll(range.getStart(), range.getEnd(), companys.getOrganization().getId()));
					else if(doctorBox.getDoctor() == null && range.getStart() == null && range.getEnd() == null )
						list.addAll(repository.findAllByCompany(companys.getOrganization().getId()));
					else if(doctorBox.getDoctor() != null && range.getStart() == null && range.getEnd() == null )
						list.addAll(repository.findAllBySales(companys.getOrganization().getId(), doctorBox.getDoctor().getDoctor().getPerson().getId()));
						
					for(Billable billable:list)
					{
						if(billable instanceof Laboratory || billable instanceof Medication || billable instanceof Treatment)
						{
							for(BillableItem item:billable.getItems())
							{
								if(item.getProduct().getType().equals(ProductType.FINISHGOOD))
								{
									Row row = new Row();
//									row.appendChild(child)
								}
							}
						}
					}
					
					Filter.this.detach();
				}
			});
		}
	}
}
