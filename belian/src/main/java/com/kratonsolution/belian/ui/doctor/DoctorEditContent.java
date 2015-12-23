/**
 * 
 */
package com.kratonsolution.belian.ui.doctor;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Cell;
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
import com.kratonsolution.belian.general.dm.Branch;
import com.kratonsolution.belian.general.dm.BranchRepository;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.dm.Person.Gender;
import com.kratonsolution.belian.general.dm.Person.MaritalStatus;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.general.svc.OrganizationUnitService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.healtcare.dm.Doctor;
import com.kratonsolution.belian.healtcare.dm.DoctorPartnership;
import com.kratonsolution.belian.healtcare.dm.DoctorPartnershipRepository;
import com.kratonsolution.belian.healtcare.svc.DoctorService;
import com.kratonsolution.belian.healtcare.svc.DoctorTypeService;
import com.kratonsolution.belian.ui.CheckboxItem;
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

	private BranchRepository branchRepository = Springs.get(BranchRepository.class);

	private DoctorTypeService doctorTypeService = Springs.get(DoctorTypeService.class);

	private DoctorPartnershipRepository partnershipRepository = Springs.get(DoctorPartnershipRepository.class);

	private GeographicService geographicService = Springs.get(GeographicService.class);

	private PersonService personService = Springs.get(PersonService.class);

	private OrganizationUnitService unitService = Springs.get(OrganizationUnitService.class);

	private Textbox identity = Components.mandatoryTextBox();

	private Textbox name = Components.mandatoryTextBox();

	private Textbox taxNumber = new Textbox();

	private Listbox genders = Components.newSelect();

	private Listbox statuses = Components.newSelect();

	private Listbox classifications = Components.newSelect(doctorTypeService.findAll(), true);

	private Listbox birthPlace = Components.newSelect(geographicService.findAll(),true);

	private Datebox start = Components.currentDatebox();

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

					for(Component component:orgs.getChildren())
					{
						CheckboxItem item = (CheckboxItem)component;

						Branch branch = branchRepository.findOneByPartyId(item.getId());
						if(branch != null)
						{
							DoctorPartnership partnership = partnershipRepository.findOneByParentIdAndChildId(branch.getId(), doctor.getId());
							if(partnership != null && !item.isSelected())
							{
								partnershipRepository.delete(partnership);
							}
							else if(partnership == null && item.isSelected())
							{
								partnership = new DoctorPartnership();
								partnership.setFrom(new Date());
								partnership.setChild(doctor);
								partnership.setParent(branch);

								partnershipRepository.save(partnership);
							}
						}
					}
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
			identity.setText(doctor.getPerson().getIdentity());
			name.setText(doctor.getPerson().getName());
			birthDate.setValue(doctor.getPerson().getBirthDate());
			taxNumber.setText(doctor.getPerson().getTaxCode());
			start.setValue(doctor.getFrom());

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
				if(listitem.getValue().equals(doctor.getParty().getBirthPlace().getId()))
					birthPlace.setSelectedItem(listitem);
			}

			for(Component component:classifications.getChildren())
			{
				Listitem listitem = (Listitem)component;
				if(listitem.getValue().equals(doctor.getCategory().getId()))
					classifications.setSelectedItem(listitem);
			}

			Vector<Organization> vOrgs = new Vector<Organization>();

			List<Branch> branchs = branchRepository.findAll();
			for(Branch branch:branchs)
			{
				for(Organization organization:utils.getOrganizations())
				{
					if(organization.getId().equals(branch.getParty().getId()))
					{
						vOrgs.add(organization);
						break;
					}
				}
			}

			for(Organization organization:vOrgs)
			{
				CheckboxItem checkboxItem = new CheckboxItem(organization.getId(), organization.getName());
				orgs.appendChild(checkboxItem);
				Branch branch = branchRepository.findOneByPartyId(checkboxItem.getId());
				if(branch != null)
				{
					DoctorPartnership partnership = partnershipRepository.findOneByParentIdAndChildId(branch.getId(), doctor.getId());
					if(partnership != null)
						checkboxItem.selected();
				}
			}

			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"15%"));
			grid.getColumns().appendChild(new Column(null,null,"40%"));
			grid.getColumns().appendChild(new Column(null,null,"45%"));

			Cell cell = new Cell();
			cell.setRowspan(10);
			cell.appendChild(orgs);
			cell.setValign("top");

			Row row001 = new Row();
			row001.appendChild(new Label("Start Date"));
			row001.appendChild(start);
			row001.appendChild(cell);

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
