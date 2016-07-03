/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.patient;

import java.util.Vector;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Cell;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.PatientRelationship;
import com.kratonsolution.belian.healtcare.svc.PatientService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.PersonBox;
import com.kratonsolution.belian.ui.healtcare.doctordashboard.DoctorDashboardWindow;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PatientEditContent extends FormContent
{	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private PatientService service = Springs.get(PatientService.class);

	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();
	
	private PersonBox person = new PersonBox(false);
	
	private Textbox bpjsNumber = new Textbox();
	
	private Listbox companys = Components.newSelect(utils.getOrganization());
	
	private Checkbox bpjsStatus = new Checkbox("Active");
	
	private Row row;

	public PatientEditContent(Row row)
	{
		super();
		this.row = row;
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
				Flow.next(getParent(), new PatientGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PatientRelationship relationship = service.findRelationshi(RowUtils.id(row));
				if(relationship != null)
				{
					relationship.setEnd(DateTimes.sql(end.getValue()));
					service.edit(relationship);
				}
				
				Flow.next(getParent(), new PatientGridContent());
			}
		});
		
		if(utils.isDoctor())
		{
			Toolbarbutton record = new Toolbarbutton("Medical Record", "/icons/medical-record.png");
			toolbar.appendChild(record);
			
			record.addEventListener(Events.ON_CLICK, new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					PatientRelationship relationship = service.findRelationshi(RowUtils.id(row));
					if(relationship != null && !relationship.getPatient().getAppointments().isEmpty())
					{
						Vector<DoctorAppointment> vector = new Vector<>(relationship.getPatient().getAppointments());
						
						DoctorDashboardWindow window = new DoctorDashboardWindow();
						window.setPage(getPage());
						window.removeGrid();
						window.insertEditForm(RowUtils.shield(vector.get(0).getId()));
						window.doOverlapped();
					}
				}
			});
		}
	}

	@Override
	public void initForm()
	{
		PatientRelationship relationship = service.findRelationshi(RowUtils.id(row));
		if(relationship != null)
		{
			start.setValue(relationship.getStart());
			end.setValue(relationship.getEnd());
			person.setPerson(relationship.getPatient().getPerson());
			bpjsNumber.setText(relationship.getPatient().getBpjs().getCard());
			bpjsStatus.setChecked(relationship.getPatient().getBpjs().isActive());
			
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"100px"));
			grid.getColumns().appendChild(new Column());
			
			Row row1 = new Row();
			row1.appendChild(new Label("Start"));
			row1.appendChild(start);
			
			Row row2 = new Row();
			row2.appendChild(new Label("End"));
			row2.appendChild(end);

			Row row3 = new Row();
			row3.appendChild(new Label("Company"));
			row3.appendChild(companys);
			
			Row row4 = new Row();
			row4.appendChild(new Label("Person"));
			row4.appendChild(person);
			
			Cell cell = new Cell();
			cell.appendChild(new Label("BPJS Information"));
			cell.setColspan(2);
			
			Row row5 = new Row();
			row5.appendChild(cell);
			
			Row row6 = new Row();
			row6.appendChild(new Label("Card Number"));
			row6.appendChild(bpjsNumber);
			
			Row row7 = new Row();
			row7.appendChild(new Label("Status"));
			row7.appendChild(bpjsStatus);
			
			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			rows.appendChild(row4);
			rows.appendChild(row5);
			rows.appendChild(row6);
			rows.appendChild(row7);
		}
	}
}
