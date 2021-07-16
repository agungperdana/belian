package com.kratonsolution.belian.partys.ui;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.WrongValueException;
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
import com.kratonsolution.belian.common.ui.AbstractForm;
import com.kratonsolution.belian.common.ui.event.UIEvent;
import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.common.ui.util.FlowHelper;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.geographic.api.application.GeographicService;
import com.kratonsolution.belian.party.api.PartyData;
import com.kratonsolution.belian.party.api.application.PartyService;
import com.kratonsolution.belian.party.api.application.PartyUpdateCommand;
import com.kratonsolution.belian.party.api.model.Gender;
import com.kratonsolution.belian.party.api.model.PartyType;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Slf4j
public class PartyEditContent extends AbstractForm
{	
	private static final long serialVersionUID = -4267104303139844670L;

	private Textbox code = Components.mandatoryTextBox(false);

	private Textbox name = Components.mandatoryTextBox(false);

	private Textbox tax = Components.stdTextBox(null, false);

	private Datebox birthDate = Components.datebox();

	private Listbox birthPlace = Components.newSelect();

	private Listbox types = Components.newSelect();

	private Listbox genders = Components.newSelect();

	private String partyCode;

	private PartyDetailTab tab;

	public PartyEditContent(@NonNull String partyCode)
	{
		super();
		this.partyCode = partyCode;
		initToolbar();
		initForm();
		initTab();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK, e->FlowHelper.next(new PartyUIEvent(UIEvent.GRID)));

		toolbar.getSave().addEventListener(Events.ON_CLICK, e->{

			if(Strings.isNullOrEmpty(code.getText()))
				throw new WrongValueException(code, Labels.getLabel("warning.empty"));

			if(Strings.isNullOrEmpty(name.getText()))
				throw new WrongValueException(name,Labels.getLabel("warning.empty"));

			log.info("Tab {}", tab.getParty());
			log.info("tab.getAddress {}", tab.getParty().getAddresses());
			
			PartyUpdateCommand command = new PartyUpdateCommand();
			command.setCode(this.partyCode);
			command.setCode(code.getText());
			command.setName(name.getText());
			command.setTaxCode(tax.getValue());
			command.setType(PartyType.valueOf(types.getSelectedItem().getValue()));
//			command.setBirthDate(birthDate.getValue()!=null?Instant.from(birthDate.getValueInZonedDateTime()):null);
			command.setBirthPlace(birthPlace.getSelectedItem()!=null?birthPlace.getSelectedItem().getValue():null);
			command.setGender(genders.getSelectedItem()!=null?Gender.valueOf(genders.getSelectedItem().getValue()):null	);			
//			command.getAddresses().addAll(tab.getParty().getAddresses());
//			command.getContacts().addAll(tab.getParty().getContacts());
//			command.getPartyRoles().addAll(tab.getParty().getPartyRoles());
//			command.getPartyRelationships().addAll(tab.getParty().getPartyRelationships());
//			command.getPartyClassifications().addAll(tab.getParty().getPartyClassifications());
//			command.getMaritalStatuses().addAll(tab.getParty().getMaritalStatuses());
//			command.getCitizenships().addAll(tab.getParty().getCitizenships());
//			command.getPhysicalCharacteristics().addAll(tab.getParty().getPhysicalCharacteristics());
			
			Springs.get(PartyService.class).update(command);

			FlowHelper.next(new PartyUIEvent(UIEvent.GRID));
		});
	}

	@Override
	public void initForm()
	{
		PartyData opt = Springs.get(PartyService.class).getByCode(this.partyCode);
		if(opt != null) {

			code.setText(opt.getCode());
			name.setText(opt.getName());
			tax.setText(opt.getTaxCode());
			
			Arrays.asList(PartyType.values()).forEach(type->{
				
				Listitem itm = types.appendItem(type.name(), type.name());
				if(type.equals(opt.getType())) {
					types.setSelectedItem(itm);
				}
			});

			if(opt.getBirthDate() != null) {
				birthDate.setValue(Date.from(opt.getBirthDate()));
			}

			Springs.get(GeographicService.class).getAllGeographics().forEach(geo->{
				
				Listitem itm = birthPlace.appendItem(geo.getCode()+" "+geo.getName(), geo.getCode());
//				if(opt.getBirthPlace() != null && opt.getBirthPlace().getCode().equals(geo.getCode())) {
//					birthPlace.setSelectedItem(itm);
//				}
			});
		}
		
		Arrays.asList(Gender.values()).forEach(gen->{
			
			Listitem itm = genders.appendItem(gen.name(), gen.name());
			if(opt.getGender() != null && opt.getGender().equals(gen)) {
				genders.setSelectedItem(itm);
			}
		});

		types.setDisabled(true);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(Labels.getLabel("party.label.code")));
		row1.appendChild(code);
		
		Row row2 = new Row();
		row2.appendChild(new Label(Labels.getLabel("party.label.name")));
		row2.appendChild(name);
				
		Row row3 = new Row();
		row3.appendChild(new Label(Labels.getLabel("party.label.type")));
		row3.appendChild(types);
		
		Row row4 = new Row();
		row4.appendChild(new Label(Labels.getLabel("party.label.birthdate")));
		row4.appendChild(birthDate);
		
		Row row5 = new Row();
		row5.appendChild(new Label(Labels.getLabel("party.label.birthplace")));
		row5.appendChild(birthPlace);
		
		Row row6 = new Row();
		row6.appendChild(new Label(Labels.getLabel("party.label.taxcode")));
		row6.appendChild(tax);
		
		Row row7 = new Row();
		row7.appendChild(new Label(Labels.getLabel("party.label.gender")));
		row7.appendChild(genders);

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		
		if(opt.getType().equals(PartyType.PERSON)) {
			rows.appendChild(row7);
		}
	}

	private void initTab() {

		PartyData opt = Springs.get(PartyService.class).getByCode(this.partyCode);
		if(opt != null) {
			tab = new PartyDetailTab(opt);
			appendChild(tab);
		}
	}
}
