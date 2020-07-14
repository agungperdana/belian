package com.kratonsolution.belian.partys.ui;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;

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
import com.kratonsolution.belian.party.api.application.PartyCreateCommand;
import com.kratonsolution.belian.party.api.application.PartyService;
import com.kratonsolution.belian.party.api.model.Gender;
import com.kratonsolution.belian.party.api.model.PartyType;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class PartyFormContent extends AbstractForm
{	
	private static final long serialVersionUID = -7870478694132790931L;
	
	private Textbox code = Components.mandatoryTextBox(false);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private Textbox tax = Components.stdTextBox(null, false);
	
	private Datebox birthDate = new Datebox(LocalDate.now());
	
	private Listbox birthPlace = Components.newSelect();
	
	private Listbox types = Components.newSelect();
	
	private Listbox genders = Components.newSelect();
	
	public PartyFormContent()
	{
		super();
		initToolbar();
		initForm();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,e->FlowHelper.next(new PartyUIEvent(UIEvent.GRID)));
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,e->{
			
			if(Strings.isNullOrEmpty(code.getText()))
				throw new WrongValueException(code, Labels.getLabel("warning.empty"));
		
			if(Strings.isNullOrEmpty(name.getText()))
				throw new WrongValueException(name, Labels.getLabel("warning.empty"));
		
			PartyCreateCommand command = new PartyCreateCommand();
			command.setCode(code.getText());
			command.setName(name.getText());
			command.setTaxCode(tax.getValue());
			command.setType(PartyType.valueOf(types.getSelectedItem().getValue()));
			command.setBirthDate(birthDate.getValue()!=null?Instant.from(birthDate.getValueInLocalDateTime()):null);
			command.setBirthPlace(birthPlace.getSelectedItem()!=null?birthPlace.getSelectedItem().getValue():null);
			command.setGender(genders.getSelectedItem()!=null?Gender.valueOf(genders.getSelectedItem().getValue()):null	);
			
			Springs.get(PartyService.class).create(command);
			
			FlowHelper.next(new PartyUIEvent(UIEvent.GRID));
		});
	}

	@Override
	public void initForm()
	{
		Springs.get(GeographicService.class)
			.getAllGeographics()
			.forEach(geo -> birthPlace.appendItem(geo.getCode()+" "+geo.getName(), geo.getCode()));
		
		Arrays.asList(PartyType.values()).forEach(opt->{
			Listitem item = types.appendItem(opt.name(), opt.name());
			if(opt.equals(PartyType.ORGANIZATION)) {
				types.setSelectedItem(item);
			}
		});

		types.setSelectedItem(null);
		types.addEventListener(Events.ON_SELECT, e->{
			
			if(types.getSelectedItem().getValue().equals(PartyType.ORGANIZATION)) {
				grid.getRows().getChildren().get(6).setVisible(false);
			}
			else {
				grid.getRows().getChildren().get(6).setVisible(true);
			}
		});
		
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
		row3.appendChild(new Label(Labels.getLabel("party.label.types")));
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
		rows.appendChild(row7);
		
		rows.getChildren().get(6).setVisible(false);
	}
}
