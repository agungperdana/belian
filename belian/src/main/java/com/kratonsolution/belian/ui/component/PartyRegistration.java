/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.util.Collection;
import java.util.Vector;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.dm.Gender;
import com.kratonsolution.belian.general.dm.IndustrySegmentation;
import com.kratonsolution.belian.general.dm.MaritalStatus;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.ui.FormToolbar;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PartyRegistration extends Window
{
	private GeographicService geographicService = Springs.get(GeographicService.class);

	private PersonService service = Springs.get(PersonService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private Collection<PartyRegistrationListener> listeners = new Vector<PartyRegistrationListener>();

	private Vlayout layout = new Vlayout();

	private FormToolbar toolbar = new FormToolbar();

	private Checkbox isPerson = Components.checkbox(true);
	
	private Textbox identity = Components.stdTextBox(null,false);

	private Listbox place = Components.newSelect(geographicService.findAll(),true);
	
	private Textbox name = Components.stdTextBox(null,false);

	private Datebox date = Components.currentDatebox();

	private Textbox tax = Components.stdTextBox(null,false);

	private GenderList genders = new GenderList();

	private MaritalStatusList maritals = new MaritalStatusList();
	
	private IndustrySegmentationList segmentationList = new IndustrySegmentationList();

	public PartyRegistration()
	{
		setWidth("550px");
		setHeight("450px");
		setClosable(true);
		setPosition("center");

		init();
	}

	private void init()
	{
		Caption caption = new Caption("Party Registration");
		caption.setImage("/icons/person.png");
		appendChild(caption);
		
		Grid grid = new Grid();
		grid.appendChild(new Columns());
		grid.appendChild(new Rows());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.setSpan("1");
		grid.getRows().appendChild(RowUtils.row("Is Person", isPerson));
		grid.getRows().appendChild(RowUtils.row("Identity", identity));
		grid.getRows().appendChild(RowUtils.row("Name", name));
		grid.getRows().appendChild(RowUtils.row("Birth Place", place));
		grid.getRows().appendChild(RowUtils.row("Birth Date", date));
		grid.getRows().appendChild(RowUtils.row("Tax Number", tax));
		grid.getRows().appendChild(RowUtils.row("Gender", genders));
		grid.getRows().appendChild(RowUtils.row("Marital Status", maritals));
		grid.getRows().appendChild(RowUtils.row("Industry Segmentation", segmentationList));
		
		if(isPerson.isChecked())
			grid.getRows().getLastChild().setVisible(false);

		isPerson.addEventListener(Events.ON_CHECK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				if(isPerson.isChecked())
				{
					grid.getRows().getChildren().get(6).setVisible(true);
					grid.getRows().getChildren().get(7).setVisible(true);
					grid.getRows().getChildren().get(8).setVisible(false);
				}
				else
				{
					grid.getRows().getChildren().get(6).setVisible(false);
					grid.getRows().getChildren().get(7).setVisible(false);
					grid.getRows().getChildren().get(8).setVisible(true);
				}
			}
		});
		
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				PartyRegistration.this.detach();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				if(Strings.isNullOrEmpty(identity.getText()))
					throw new WrongValueException(identity,"Identity cannot be empty.");
				
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(identity,"Name cannot be empty.");
				
				if(isPerson.isChecked())
				{
					Person person = new Person();
					person.setIdentity(identity.getText());
					person.setBirthPlace(geographicService.findOne(Components.string(place)));
					person.setBirthDate(DateTimes.sql(date.getValue()));
					person.setName(name.getText());
					person.setGender(Gender.valueOf(Components.string(genders)));
					person.setMaritalStatus(MaritalStatus.valueOf(Components.string(maritals)));
					
					service.add(person);
					
					for(PartyRegistrationListener listener:listeners)
						listener.setParty(person);
				}
				else
				{
					Organization organization = new Organization();
					organization.setIdentity(identity.getText());
					organization.setBirthDate(DateTimes.sql(date.getValue()));
					organization.setName(name.getText());
					organization.setType(IndustrySegmentation.valueOf(Components.string(segmentationList)));
					organization.setBirthPlace(geographicService.findOne(Components.string(place)));
					
					organizationService.add(organization);
					
					for(PartyRegistrationListener listener:listeners)
						listener.setParty(organization);
				}
			
				detach();
			}
		});
		
		layout.appendChild(toolbar);
		layout.appendChild(grid);

		appendChild(layout);
	}

	public void addListener(PartyRegistrationListener listener)
	{
		listeners.add(listener);
	}
}
