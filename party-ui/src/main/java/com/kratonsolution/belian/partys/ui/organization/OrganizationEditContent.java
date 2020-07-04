package com.kratonsolution.belian.partys.ui.organization;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

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
import com.kratonsolution.belian.geographic.api.GeographicType;
import com.kratonsolution.belian.geographic.api.application.GeographicService;
import com.kratonsolution.belian.party.api.OrganizationData;
import com.kratonsolution.belian.party.api.application.OrganizationService;
import com.kratonsolution.belian.party.api.application.OrganizationUpdateCommand;
import com.kratonsolution.belian.partys.ui.PartyDetailTab;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class OrganizationEditContent extends AbstractForm
{	
	private static final long serialVersionUID = -4267104303139844670L;

	private Textbox code = Components.mandatoryTextBox(false);

	private Textbox name = Components.mandatoryTextBox(false);

	private Textbox tax = Components.stdTextBox(null, false);
	
	private Datebox birthDate = Components.datebox();

	private Listbox birthPlace = Components.newSelect();

	private String partyCode;
	
	private PartyDetailTab tab;
	
	public OrganizationEditContent(@NonNull String partyCode)
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
		toolbar.getCancel().addEventListener(Events.ON_CLICK, e->FlowHelper.next(new OrganizationUIEvent(UIEvent.GRID)));

		toolbar.getSave().addEventListener(Events.ON_CLICK, e->{
			
			if(Strings.isNullOrEmpty(code.getText()))
				throw new WrongValueException(code, Labels.getLabel("warning.empty"));

			if(Strings.isNullOrEmpty(name.getText()))
				throw new WrongValueException(name,Labels.getLabel("warning.empty"));
			
			OrganizationUpdateCommand command = new OrganizationUpdateCommand();
			command.setCode(this.partyCode);
			command.setName(Optional.ofNullable(name.getText()));
			command.setTaxCode(Optional.ofNullable(tax.getText()));
			command.setBirthDate(Optional.ofNullable(Instant.from(birthDate.getValueInZonedDateTime())));
			command.setBirthPlace(Optional.ofNullable(birthPlace.getSelectedItem().getValue()));
			
			Springs.get(OrganizationService.class).update(command);
			
			FlowHelper.next(new OrganizationUIEvent(UIEvent.GRID));
		});
	}

	@Override
	public void initForm()
	{
		Optional<OrganizationData> opt = Springs.get(OrganizationService.class).getByCode(this.partyCode);
		if(opt.isPresent()) {
			
			code.setText(opt.get().getCode());
			name.setText(opt.get().getName());
			tax.setText(opt.get().getTaxCode());

			if(opt.get().getBirthDate() != null) {
				birthDate.setValue(Date.from(opt.get().getBirthDate()));
			}
			
			Springs.get(GeographicService.class).getAllByType(GeographicType.CITY).forEach(geo -> {
				
				Listitem item = birthPlace.appendItem(geo.getCode()+" - "+geo.getName(), geo.getCode());
				if(opt.get().getBirthPlace() != null && geo.getCode().equals(opt.get().getBirthPlace().getCode())) {
					birthPlace.setSelectedItem(item);
				}
			});
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
	
	private void initTab() {
		
		Optional<OrganizationData> opt = Springs.get(OrganizationService.class).getByCode(this.partyCode);
		if(opt.isPresent()) {
			
			tab = new PartyDetailTab(this.partyCode, opt.get().getAddresses(), 
					opt.get().getContacts(), opt.get().getPartyRoles(), 
					opt.get().getPartyRelationships(), opt.get().getPartyClassifications());
			
			appendChild(tab);
		}
	}
}
