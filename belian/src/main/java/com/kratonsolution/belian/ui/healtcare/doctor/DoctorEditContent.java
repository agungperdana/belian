/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctor;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.healtcare.dm.Doctor;
import com.kratonsolution.belian.healtcare.svc.DoctorService;
import com.kratonsolution.belian.healtcare.svc.DoctorTypeService;
import com.kratonsolution.belian.ui.FormContent;
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
public class DoctorEditContent extends FormContent
{	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private DoctorService service = Springs.get(DoctorService.class);

	private DoctorTypeService doctorTypeService = Springs.get(DoctorTypeService.class);

	private Datebox start = Components.currentDatebox();

	private Datebox end = Components.datebox();

	private Listbox companys = Components.newSelect();

	private PersonBox person = new PersonBox(false);

	private Listbox classifications = Components.newSelect();

	private Row row;

	public DoctorEditContent(Row row)
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
				DoctorWindow window = (DoctorWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Doctor doctor = service.findOne(RowUtils.id(row));
				if(doctor != null)
				{
					doctor.setEnd(DateTimes.sql(end.getValue()));
					service.edit(doctor);
				}
				
				Flow.next(getParent(), new DoctorGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		Doctor doctor = service.findOne(RowUtils.id(row));
		if(doctor != null)
		{
			start.setValue(doctor.getStart());
			end.setValue(doctor.getEnd());
			companys.appendItem(utils.getOrganization().getName(),utils.getOrganization().getId());
			companys.setSelectedIndex(0);
			person.setPerson(doctor.getPerson());
			classifications.appendItem(doctor.getCategory().getName(), doctor.getCategory().getId());
			classifications.setSelectedIndex(0);
			
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"100px"));
			grid.getColumns().appendChild(new Column());
			grid.setSpan("1");
			
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
			
			Row row5 = new Row();
			row5.appendChild(new Label("Classification"));
			row5.appendChild(classifications);
			
			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			rows.appendChild(row4);
			rows.appendChild(row5);
		}
	}
}
