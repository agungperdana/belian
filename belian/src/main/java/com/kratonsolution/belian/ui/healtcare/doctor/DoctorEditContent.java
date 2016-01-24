/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctor;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.dm.Person.Gender;
import com.kratonsolution.belian.general.dm.Person.MaritalStatus;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.healtcare.dm.Doctor;
import com.kratonsolution.belian.healtcare.dm.DoctorPartnershipRepository;
import com.kratonsolution.belian.healtcare.svc.DoctorService;
import com.kratonsolution.belian.healtcare.svc.DoctorTypeService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
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

	private DoctorPartnershipRepository partnershipRepository = Springs.get(DoctorPartnershipRepository.class);

	private GeographicService geographicService = Springs.get(GeographicService.class);

	private PersonService personService = Springs.get(PersonService.class);

	private OrganizationService organizationService = Springs.get(OrganizationService.class);

	private Listbox companys = Components.newSelect();
	
	private Textbox identity = Components.mandatoryTextBox();

	private Textbox name = Components.mandatoryTextBox();

	private Textbox taxNumber = new Textbox();

	private Listbox genders = Components.newSelect();

	private Listbox statuses = Components.newSelect();

	private Listbox classifications = Components.newSelect(doctorTypeService.findAll(), true);

	private Listbox birthPlace = Components.newSelect(geographicService.findAll(),true);

	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();

	private Datebox birthDate = Components.currentDatebox();

	private Listbox orgs = new Listbox();

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
				if(Strings.isNullOrEmpty(identity.getText()))
					throw new WrongValueException(identity,"Identity cannot be empty");

				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Name cannot be empty");

				Doctor doctor = service.findOne(RowUtils.string(row, 5));
				if(doctor != null)
				{
					Person person = doctor.getPerson();
					person.setBirthDate(birthDate.getValue());
					person.setBirthPlace(geographicService.findOne(Components.string(birthPlace)));
					person.setGender(Gender.valueOf(Components.string(genders)));
					person.setIdentity(identity.getText());
					person.setMaritalStatus(MaritalStatus.valueOf(Components.string(statuses)));
					person.setName(name.getText());
					person.setTaxCode(taxNumber.getText());

					personService.edit(person);
				
					doctor.setTo(end.getValue());
					doctor.setCompany(organizationService.findOne(Components.string(companys)));
				
					service.edit(doctor);
				}

				DoctorWindow window = (DoctorWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		Doctor doctor = service.findOne(RowUtils.string(row, 5));
		if(doctor != null)
		{
			identity.setWidth("250px");
			identity.setText(doctor.getPerson().getIdentity());

			name.setWidth("300px");
			name.setText(doctor.getPerson().getName());
			
			birthDate.setValue(doctor.getPerson().getBirthDate());
			taxNumber.setText(doctor.getPerson().getTaxCode());

			start.setValue(doctor.getFrom());
			
			if(doctor.getCompany() != null)
			{
				companys.appendChild(new Listitem(doctor.getCompany().getLabel(), doctor.getCompany().getValue()));
				companys.setSelectedIndex(0);
			}
			else
			{
				if(utils.getOrganization() != null)
				{
					companys.appendChild(new Listitem(utils.getOrganization().getLabel(), utils.getOrganization().getValue()));
					companys.setSelectedIndex(0);
				}
			}

			for(Gender gender:Gender.values())
			{
				Listitem listitem = new Listitem(gender.name(), gender.name());
				genders.appendChild(listitem);

				if(gender.equals(doctor.getPerson().getGender()))
					genders.setSelectedItem(listitem);
			}

			for(MaritalStatus status:MaritalStatus.values())
			{
				Listitem listitem = new Listitem(status.name(), status.name());
				statuses.appendChild(listitem);
				if(status.equals(doctor.getPerson().getMaritalStatus()))
					statuses.setSelectedItem(listitem);
			}

			for(Component component:birthPlace.getChildren())
			{
				Listitem listitem = (Listitem)component;
				if(doctor.getParty() != null && doctor.getParty().getBirthPlace() != null && listitem.getValue().equals(doctor.getParty().getBirthPlace().getId()))
					birthPlace.setSelectedItem(listitem);
			}

			for(Component component:classifications.getChildren())
			{
				Listitem listitem = (Listitem)component;
				if(listitem.getValue().equals(doctor.getCategory().getId()))
					classifications.setSelectedItem(listitem);
			}

			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"100px"));
			grid.getColumns().appendChild(new Column(null,null,"40%"));
			grid.setSpan("1");
			
			
			Row row002 = new Row();
			row002.appendChild(new Label("Company"));
			row002.appendChild(companys);
			
			Row row001 = new Row();
			row001.appendChild(new Label("Start Date"));
			row001.appendChild(start);
			
			Row row003 = new Row();
			row003.appendChild(new Label("End Date"));
			row003.appendChild(end);

			Row row0 = new Row();
			row0.appendChild(new Label("Classification"));
			row0.appendChild(classifications);

			Row row1 = new Row();
			row1.appendChild(new Label("Identity"));
			row1.appendChild(identity);

			Row row2 = new Row();
			row2.appendChild(new Label("Name"));
			row2.appendChild(name);

			Row row3 = new Row();
			row3.appendChild(new Label("Birth Place"));
			row3.appendChild(birthPlace);

			Row row4 = new Row();
			row4.appendChild(new Label("Birth Date"));
			row4.appendChild(birthDate);

			Row row5 = new Row();
			row5.appendChild(new Label("Tax Number"));
			row5.appendChild(taxNumber);

			Row row6 = new Row();
			row6.appendChild(new Label("Gender"));
			row6.appendChild(genders);

			Row row7 = new Row();
			row7.appendChild(new Label("Status"));
			row7.appendChild(statuses);

			rows.appendChild(row002);
			rows.appendChild(row001);
			rows.appendChild(row0);
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
