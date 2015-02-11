/**
 * 
 */
package com.kratonsolution.belian.ui.party;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.general.dm.Address;
import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.ui.FormToolbar;
import com.kratonsolution.belian.ui.organization.OrganizationEditContent;
import com.kratonsolution.belian.ui.person.PersonEditContent;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class AddressEditWindow extends Window
{
	private FormToolbar toolbar = new FormToolbar();
	
	private Grid layout = new Grid();
	
	private Textbox address = new Textbox();
	
	private Textbox postal = new Textbox();
	
	private Listbox type = new Listbox();
	
	private Checkbox status = new Checkbox("Active");
	
	private Listbox city = new Listbox();
	
	private Listbox province = new Listbox();
	
	private Listbox country = new Listbox();
	
	private GeographicService geographicController = Springs.get(GeographicService.class);
	
	private PersonService personController = Springs.get(PersonService.class);
	
	private OrganizationService organizationController = Springs.get(OrganizationService.class);
	
	private Party party;
	
	private Address edited;
	
	public AddressEditWindow(Party party,Address edited)
	{
		this.party = party;
		this.edited = edited;
		
		setMode(Mode.POPUP);
		setWidth("450px");
		setHeight("400px");
		setPosition("center");
		
		Caption caption = new Caption("Address");
		caption.setImage("/icons/address.png");
	
		type.setMold("select");
		city.setMold("select");
		province.setMold("select");
		country.setMold("select");
		
		appendChild(caption);
		appendChild(toolbar);
		appendChild(layout);
		setClosable(true);
		
		initToolbar();
		initContent();
	}
	
	protected void initToolbar()
	{
		toolbar.setHeight("35px");
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				detach();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(party instanceof Organization)
				{
					Organization organization = organizationController.findOne(party.getId());
					if(organization != null)
					{
						for(Address on:organization.getAddresses())
						{
							if(on.getId().equals(edited.getId()))
							{
								on.setDescription(address.getText());
								on.setPostal(postal.getText());
								on.setActive(status.isChecked());
								on.setType(Address.Type.valueOf(type.getSelectedItem().getValue().toString()));
								on.setCity(geographicController.findOne(city.getSelectedItem().getValue().toString()));
								on.setProvince(geographicController.findOne(province.getSelectedItem().getValue().toString()));
								on.setCountry(geographicController.findOne(country.getSelectedItem().getValue().toString()));
							}
						}
						
						organizationController.edit(organization);
						
						OrganizationEditContent content = (OrganizationEditContent)getParent();
						content.refresh();
					}
				}
				
				if(party instanceof Person)
				{
					Person person = personController.findOne(party.getId());
					if(person != null)
					{
						for(Address on:person.getAddresses())
						{
							if(on.getId().equals(edited.getId()))
							{
								on.setDescription(address.getText());
								on.setPostal(postal.getText());
								on.setActive(status.isChecked());
								on.setType(Address.Type.valueOf(type.getSelectedItem().getValue().toString()));
								on.setCity(geographicController.findOne(city.getSelectedItem().getValue().toString()));
								on.setProvince(geographicController.findOne(province.getSelectedItem().getValue().toString()));
								on.setCountry(geographicController.findOne(country.getSelectedItem().getValue().toString()));
							}
						}
						
						personController.edit(person);
						
						PersonEditContent content = (PersonEditContent)getParent();
						content.refresh();
					}
				}
				
				detach();
			}
		});
	}
	
	protected void initContent()
	{
		address.setWidth("300px");
		address.setConstraint("no empty");
		address.setText(edited.getDescription());
		
		postal.setWidth("150px");
		postal.setText(edited.getPostal());
		
		status.setChecked(edited.isActive());
		
		layout.appendChild(new Rows());
		layout.appendChild(new Columns());
		layout.getColumns().appendChild(new Column(null,null,"75px"));
		layout.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Address"));
		row1.appendChild(address);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Postal"));
		row2.appendChild(postal);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Status"));
		row3.appendChild(status);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Type"));
		row4.appendChild(type);
		
		Row row5 = new Row();
		row5.appendChild(new Label("City"));
		row5.appendChild(city);
		
		Row row6 = new Row();
		row6.appendChild(new Label("Province"));
		row6.appendChild(province);
		
		Row row7 = new Row();
		row7.appendChild(new Label("Country"));
		row7.appendChild(country);
		
		for(Address.Type _type:Address.Type.values())
		{
			Listitem listitem = new Listitem(_type.name(),_type.name());
			type.appendChild(listitem);
			if(_type.equals(edited.getType()))
				type.setSelectedItem(listitem);
		}
		
		for(Geographic geographic:geographicController.findAll())
		{
			if(geographic.getType().equals(Geographic.Type.CITY))
			{
				Listitem listitem = new Listitem(geographic.getName(), geographic.getId());
				city.appendChild(listitem);
				if(geographic.getId().equals(edited.getCity().getId()))
					city.setSelectedItem(listitem);
			}
			
			if(geographic.getType().equals(Geographic.Type.PROVINCE))
			{
				Listitem listitem = new Listitem(geographic.getName(), geographic.getId());
				province.appendChild(listitem);
				if(geographic.getId().equals(edited.getProvince().getId()))
					province.setSelectedItem(listitem);
			}
			
			if(geographic.getType().equals(Geographic.Type.COUNTRY))
			{
				Listitem listitem = new Listitem(geographic.getName(), geographic.getId());
				country.appendChild(listitem);
				if(geographic.getId().equals(edited.getCountry().getId()))
					country.setSelectedItem(listitem);
			}
		}
				
		layout.getRows().appendChild(row1);
		layout.getRows().appendChild(row2);
		layout.getRows().appendChild(row3);
		layout.getRows().appendChild(row4);
		layout.getRows().appendChild(row5);
		layout.getRows().appendChild(row6);
		layout.getRows().appendChild(row7);
	}
	
	@Override
	public void onClose()
	{
		setVisible(false);
		setParent(null);
	}
}
