package com.kratonsolution.belian.partys.ui.organization;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Optional;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.ui.AbstractForm;
import com.kratonsolution.belian.common.ui.event.UIEvent;
import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.common.ui.util.FlowHelper;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.geographic.api.GeographicData;
import com.kratonsolution.belian.geographic.api.GeographicType;
import com.kratonsolution.belian.geographic.api.application.GeographicService;
import com.kratonsolution.belian.party.api.application.OrganizationCreateCommand;
import com.kratonsolution.belian.party.api.application.OrganizationService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class OrganizationFormContent extends AbstractForm
{	
	private static final long serialVersionUID = -7870478694132790931L;
	
	private Textbox code = Components.mandatoryTextBox(false);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private Textbox tax = Components.stdTextBox(null, false);
	
	private Datebox birthDate = new Datebox(LocalDate.now());
	
	private Listbox birthPlace = Components.newSelect();
	
	public OrganizationFormContent()
	{
		super();
		initToolbar();
		initForm();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,e->FlowHelper.next(new OrganizationUIEvent(UIEvent.GRID)));
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,e->{
			
			if(Strings.isNullOrEmpty(code.getText()))
				throw new WrongValueException(code, Labels.getLabel("warning.empty"));
		
			if(Strings.isNullOrEmpty(name.getText()))
				throw new WrongValueException(name, Labels.getLabel("warning.empty"));
		
			OrganizationCreateCommand command = new OrganizationCreateCommand();
			command.setCode(code.getText());
			command.setName(name.getText());
			command.setTaxCode(Optional.ofNullable(tax.getText()));
			command.setBirthDate(Optional.ofNullable(Instant.from(birthDate.getValueInZonedDateTime())));
			command.setBirthPlace(Optional.ofNullable(birthPlace.getSelectedItem().getValue()));
			
			Springs.get(OrganizationService.class).create(command);
			
			FlowHelper.next(new OrganizationUIEvent(UIEvent.GRID));
		});
	}

	@Override
	public void initForm()
	{
		for(GeographicData data:Springs.get(GeographicService.class).getAllByType(GeographicType.KOTA)) {
			
			birthPlace.appendItem(data.getCode()+" - "+data.getName(), data.getCode());
		}
		
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
		row3.appendChild(new Label(Labels.getLabel("party.label.taxcode")));
		row3.appendChild(tax);
		
		Row row4 = new Row();
		row4.appendChild(new Label(Labels.getLabel("party.label.birthdate")));
		row4.appendChild(birthDate);
		
		Row row5 = new Row();
		row5.appendChild(new Label(Labels.getLabel("party.label.birthplace")));
		row5.appendChild(birthPlace);

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}
}
