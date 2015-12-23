/**
 * 
 */
package com.kratonsolution.belian.ui.doctor;

import java.util.List;
import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Cell;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
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
import com.kratonsolution.belian.general.dm.OrganizationUnit;
import com.kratonsolution.belian.general.dm.PartyRelationship;
import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.general.dm.PartyRole.Type;
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
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorFormContent extends FormContent
{	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private BranchRepository branchRepository = Springs.get(BranchRepository.class);
	
	private DoctorService service = Springs.get(DoctorService.class);
	
	private DoctorTypeService doctorTypeService = Springs.get(DoctorTypeService.class);
	
	private DoctorPartnershipRepository partnershipRepository = Springs.get(DoctorPartnershipRepository.class);
	
	private GeographicService geographicService = Springs.get(GeographicService.class);
	
	private PersonService personService = Springs.get(PersonService.class);
	
	private OrganizationUnitService unitService = Springs.get(OrganizationUnitService.class);
	
	private Combobox identity = Components.autoComplete();
	
	private Combobox name = Components.autoComplete();
	
	private Textbox taxNumber = new Textbox();

	private Listbox genders = Components.newSelect();
	
	private Listbox statuses = Components.newSelect();
	
	private Listbox classifications = Components.newSelect(doctorTypeService.findAll(), true);
	
	private Listbox birthPlace = Components.newSelect(geographicService.findAll(),true);
	
	private Datebox start = Components.currentDatebox();
	
	private Datebox birthDate = Components.currentDatebox();
	
	private Grid partnerships = new Grid();
	
	private Listbox orgs = new Listbox();
	
	public DoctorFormContent()
	{
		super();
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
				window.removeCreateForm();
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
				
				Person person = personService.findOneByIdentity(identity.getValue());
				if(person == null)
				{
					person = new Person();
					person.setBirthDate(birthDate.getValue());
					person.setBirthPlace(geographicService.findOne(Components.string(birthPlace)));
					person.setDeleteadble(true);
					person.setGender(Gender.valueOf(Components.string(genders)));
					person.setIdentity(identity.getText());
					person.setMaritalStatus(MaritalStatus.valueOf(Components.string(statuses)));
					person.setName(name.getText());
					person.setTaxCode(taxNumber.getText());
					
					personService.add(person);
					
					Doctor doctor = new Doctor();
					doctor.setCategory(doctorTypeService.findOne(Components.string(classifications)));
					doctor.setFrom(start.getValue());
					doctor.setParty(person);
					doctor.setType(PartyRole.Type.DOCTOR);
					
					service.add(doctor);

					for(Component component:orgs.getChildren())
					{
						CheckboxItem item = (CheckboxItem)component;
						if(item.isSelected())
						{
							Branch branch = branchRepository.findOneByPartyId(item.getId());
							if(branch != null)
							{
								DoctorPartnership partnership = new DoctorPartnership();
								partnership.setFrom(start.getValue());
								partnership.setChild(doctor);
								partnership.setParent(branch);
								partnership.setType(PartyRelationship.Type.DOCTORPARTNERSHIP);
								
								partnershipRepository.save(partnership);
							}
						}
					}
				}
				else
				{
					person.setBirthDate(birthDate.getValue());
					person.setBirthPlace(geographicService.findOne(Components.string(birthPlace)));
					person.setDeleteadble(true);
					person.setGender(Gender.valueOf(Components.string(genders)));
					person.setIdentity(identity.getText());
					person.setMaritalStatus(MaritalStatus.valueOf(Components.string(statuses)));
					person.setName(name.getText());
					person.setTaxCode(taxNumber.getText());
					
					personService.edit(person);
					
					/**
					 * Person exist, check if he/she already a doctor?
					 * if not register new role as a doctor and partnership to organization
					 */
					Doctor doctor = service.findOneByPartyIdAndType(person.getId(), Type.DOCTOR);
					if(doctor == null)
					{
						doctor = new Doctor();
						doctor.setCategory(doctorTypeService.findOne(Components.string(classifications)));
						doctor.setFrom(start.getValue());
						doctor.setParty(person);
						doctor.setType(PartyRole.Type.DOCTOR);
						
						service.add(doctor);
						
						for(Component component:orgs.getChildren())
						{
							CheckboxItem item = (CheckboxItem)component;
							if(item.isSelected())
							{
								Branch branch = branchRepository.findOneByPartyId(item.getId());
								if(branch != null)
								{
									DoctorPartnership partnership = new DoctorPartnership();
									partnership.setFrom(start.getValue());
									partnership.setChild(doctor);
									partnership.setParent(branch);
									partnership.setType(PartyRelationship.Type.DOCTORPARTNERSHIP);
									
									partnershipRepository.save(partnership);
								}
							}
						}
					}
					/**
					 * The doctor already registered into one or more organization as a doctor
					 */
					else
					{
						for(Component component:orgs.getChildren())
						{
							CheckboxItem item = (CheckboxItem)component;
							if(item.isSelected())
							{
								Branch branch = branchRepository.findOneByPartyId(item.getId());
								if(branch != null)
								{
									DoctorPartnership partner = partnershipRepository.findOneByParentIdAndChildId(doctor.getId(), branch.getId());
									if(partner == null)
									{
										partner = new DoctorPartnership();
										partner.setFrom(start.getValue());
										partner.setChild(doctor);
										partner.setParent(branch);
										partner.setType(PartyRelationship.Type.DOCTORPARTNERSHIP);
										
										partnershipRepository.save(partner);
									}
								}
							}
						}
					}
				}
				
				DoctorWindow window = (DoctorWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		for(Gender gender:Gender.values())
			genders.appendChild(new Listitem(gender.name(), gender.name()));
		
		for(MaritalStatus status:MaritalStatus.values())
			statuses.appendChild(new Listitem(status.name(), status.name()));
		
		identity.setConstraint("no empty");
		identity.addEventListener(Events.ON_CHANGING, new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent event) throws Exception
			{
				List<Person> list = personService.findAllByIdentity(event.getValue());
				
				identity.getChildren().clear();
				for(Person person:list)
					identity.appendItem(person.getIdentity());
			}
		});
		
		identity.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				fillForm(personService.findOneByIdentity(identity.getValue()));
			}
		});

		name.setConstraint("no empty");
		name.addEventListener(Events.ON_CHANGING, new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent event) throws Exception
			{
				List<Person> list = personService.findAllByName(event.getValue());
				name.getChildren().clear();
				for(Person person:list)
					name.appendItem(person.getName());
			}
		});
		
		name.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				fillForm(personService.findOneByName(name.getValue()));
			}
		});
		
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
			orgs.appendChild(new CheckboxItem(organization.getId(), organization.getName()));
		
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
	
	private void fillForm(Person person)
	{
		if(person != null)
		{
			identity.setValue(person.getIdentity());
			name.setValue(person.getName());
			birthDate.setValue(person.getBirthDate());
			taxNumber.setText(person.getTaxCode());
			
			if(person.getBirthPlace() != null)
			{
				for(Component component:birthPlace.getChildren())
				{
					Listitem listitem = (Listitem)component;
					if(listitem.getValue().equals(person.getBirthPlace().getId()))
						birthPlace.setSelectedItem(listitem);
				}
			}
			
			if(person.getMaritalStatus() != null)
			{
				for(Component component:statuses.getChildren())
				{
					Listitem listitem = (Listitem)component;
					if(listitem.getValue().equals(person.getMaritalStatus().name()))
						statuses.setSelectedItem(listitem);
				}
			}
			
			if(person.getGender() != null)
			{
				for(Component component:genders.getChildren())
				{
					Listitem listitem = (Listitem)component;
					if(listitem.getValue().equals(person.getGender().name()))
						genders.setSelectedItem(listitem);
				}
			}
			
			Doctor doctor = service.findOneByPartyIdAndType(person.getId(), Type.DOCTOR);
			if(doctor != null)
			{
				for(Component component:orgs.getChildren())
				{
					CheckboxItem checkboxItem = (CheckboxItem)component;
				
					OrganizationUnit unit = unitService.findOneByPartyIdAndType(checkboxItem.getId(), Type.SUBSIDIARY);
					if(unit == null)
						throw new RuntimeException("Company not inside organization structure");
					
					DoctorPartnership partner = partnershipRepository.findOneByParentIdAndChildId(unit.getId(),doctor.getId() );
					if(partner != null)
						checkboxItem.selected();
				}
			}
		}
	}
}
