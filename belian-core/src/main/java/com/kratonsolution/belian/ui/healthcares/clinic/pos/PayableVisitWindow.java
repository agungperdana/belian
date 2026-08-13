
package com.kratonsolution.belian.ui.healthcares.clinic.pos;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.healtcares.dm.Visit;
import com.kratonsolution.belian.healtcares.svc.VisitService;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PayableVisitWindow extends AbstractWindow
{
	private VisitService service = Springs.get(VisitService.class);
	
	private Vlayout layout = new Vlayout();
	
	private Grid visits = new Grid();
	
	private Listbox payments = Components.fullSpanSelect();
	
	private PartyBox partyBox = PartyBox.organizationNolinkSpan();
	
	public PayableVisitWindow()
	{
		super();
		
		setWidth("500px");
		setHeight("400px");
		
		partyBox.setDisabled();
		
		layout.setHflex("1");
		layout.setVflex("1");
		layout.appendChild(payments);
		layout.appendChild(partyBox);
		layout.appendChild(visits);
		
		payments.appendItem(lang.get("clinic.visit.grid.column.personal"), "Personal");
		payments.appendItem(lang.get("clinic.visit.grid.column.insurance"), "Insurance");
		payments.setSelectedIndex(0);
		payments.addEventListener(Events.ON_SELECT,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				if(payments.getSelectedIndex() == 0)
					partyBox.setDisabled();
				else
					partyBox.setEnabled();
			}
		});
		
		appendChild(layout);
		
		initVisits();
	}
	
	private void initVisits()
	{
		visits.setWidth("100");
		visits.setEmptyMessage(lang.get("message.grid.empty"));
		visits.appendChild(new Rows());
		visits.appendChild(new Columns());
		visits.getColumns().appendChild(new Column(lang.get("clinic.visit.grid.column.number"),null,"25%"));
		visits.getColumns().appendChild(new Column(lang.get("clinic.visit.grid.column.patient"),null,"35%"));
		visits.getColumns().appendChild(new Column(lang.get("clinic.visit.grid.column.doctor"),null,"35%"));
		visits.getColumns().appendChild(new Column());
		visits.getColumns().getLastChild().setVisible(false);
		visits.setSpan("1");
		
		for(Visit visit:service.findAllToday(null))
		{
			if(!visit.isEditable() && !visit.isClosed())
			{
				Row row = new Row();
				row.appendChild(new Label(visit.getCode()));
				row.appendChild(new Label(visit.getPatient().getValue()));
				row.appendChild(new Label(visit.getDoctor().getValue()));
				row.appendChild(new Label(visit.getId()));
				
				visits.getRows().appendChild(row);
			}
		}
	}
	
	public Grid getVisits()
	{
		return visits;
	}
	
	public boolean isInsurance()
	{
		return !partyBox.isDisabled();
	}
	
	public PartyBox getInsurance()
	{
		return partyBox;
	}
}
