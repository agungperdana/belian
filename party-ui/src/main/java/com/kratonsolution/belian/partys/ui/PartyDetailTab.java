package com.kratonsolution.belian.partys.ui;

import java.util.Set;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;

import com.kratonsolution.belian.common.ui.toolbar.NRCToolbar;
import com.kratonsolution.belian.common.ui.util.RowUtils;
import com.kratonsolution.belian.party.api.AddressData;
import com.kratonsolution.belian.party.api.CitizenshipData;
import com.kratonsolution.belian.party.api.ContactData;
import com.kratonsolution.belian.party.api.MaritalStatusData;
import com.kratonsolution.belian.party.api.PartyClassificationData;
import com.kratonsolution.belian.party.api.PartyData;
import com.kratonsolution.belian.party.api.PartyRelationshipData;
import com.kratonsolution.belian.party.api.PartyRoleData;
import com.kratonsolution.belian.party.api.PhysicalCharacteristicData;
import com.kratonsolution.belian.party.api.model.PartyType;
import com.kratonsolution.belian.partys.ui.address.AddressModel;
import com.kratonsolution.belian.partys.ui.address.AddressRowRenderer;
import com.kratonsolution.belian.partys.ui.citizenship.CitizenshipModel;
import com.kratonsolution.belian.partys.ui.citizenship.CitizenshipRowRenderer;
import com.kratonsolution.belian.partys.ui.contact.ContactModel;
import com.kratonsolution.belian.partys.ui.contact.ContactRowRenderer;
import com.kratonsolution.belian.partys.ui.maritalstatus.MaritalStatusModel;
import com.kratonsolution.belian.partys.ui.maritalstatus.MaritalStatusRowRenderer;
import com.kratonsolution.belian.partys.ui.partyclassification.PartyClassificationModel;
import com.kratonsolution.belian.partys.ui.partyclassification.PartyClassificationRowRenderer;
import com.kratonsolution.belian.partys.ui.partyrelationship.PartyRelationshipModel;
import com.kratonsolution.belian.partys.ui.partyrelationship.PartyRelationshipRowRenderer;
import com.kratonsolution.belian.partys.ui.partyrole.PartyRoleModel;
import com.kratonsolution.belian.partys.ui.partyrole.PartyRoleRowRenderer;
import com.kratonsolution.belian.partys.ui.physicalcharacteristic.PhysicalCharacteristicModel;
import com.kratonsolution.belian.partys.ui.physicalcharacteristic.PhysicalCharacteristicRowRenderer;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Slf4j
@Getter
public class PartyDetailTab extends Tabbox {

	private static final long serialVersionUID = 6074616216180529972L;

	private Grid addresses = new Grid();

	private Grid contacts = new Grid();

	private Grid roles = new Grid();

	private Grid relationships = new Grid();

	private Grid classifications = new Grid();
	
	private Grid maritalStatuses = new Grid();
	
	private Grid physicalCharacteristics = new Grid();
	
	private Grid citizenships = new Grid();
	
	private PartyData party;

	public PartyDetailTab(@NonNull PartyData party)
	{
		this.party = party;
		
		setWidth("100%");
		appendChild(new Tabs());
		appendChild(new Tabpanels());
		getTabs().appendChild(new Tab(Labels.getLabel("label.caption.address")));
		getTabs().appendChild(new Tab(Labels.getLabel("label.caption.contact")));
		getTabs().appendChild(new Tab(Labels.getLabel("label.caption.partyrole")));
		getTabs().appendChild(new Tab(Labels.getLabel("label.caption.partyrelationship")));
		getTabs().appendChild(new Tab(Labels.getLabel("label.caption.partyclassification")));
		getTabpanels().appendChild(new Tabpanel());
		getTabpanels().appendChild(new Tabpanel());
		getTabpanels().appendChild(new Tabpanel());
		getTabpanels().appendChild(new Tabpanel());
		getTabpanels().appendChild(new Tabpanel());

		initAddress(party.getAddresses());
		initContacts(party.getContacts());
		initRoles(party.getPartyRoles());
		initRelationships(party.getPartyRelationships());
		initClassification(party.getPartyClassifications());
		
		if(party.getType().equals(PartyType.PERSON)) {
			
			initMaritalStatus(party.getMaritalStatuses());
			initPhysicalCharacteristic(party.getPhysicalCharacteristics());
			initCitizenships(party.getCitizenships());
		}
	}

	private void initAddress(@NonNull Set<AddressData> set)
	{
		addresses.setWidth("100%");
		addresses.setEmptyMessage(Labels.getLabel("message.grid.empty"));
		addresses.appendChild(new Columns());
		addresses.appendChild(new Rows());
		addresses.getColumns().appendChild(new Column(null,null,"25px"));
		addresses.getColumns().appendChild(new Column(Labels.getLabel("address.label.address")));
		addresses.getColumns().appendChild(new Column(Labels.getLabel("address.label.postal"),null,"70px"));
		addresses.getColumns().appendChild(new Column(Labels.getLabel("address.label.type"),null,"150px"));
		addresses.getColumns().appendChild(new Column(Labels.getLabel("address.label.active"),null,"70px"));
		addresses.getColumns().appendChild(new Column(Labels.getLabel("address.label.location"),null,"200px"));
		addresses.getColumns().appendChild(new Column());
		addresses.getColumns().getLastChild().setVisible(false);
		addresses.setSpan("1");
		addresses.setModel(AddressModel.build(set));
		addresses.setRowRenderer(new AddressRowRenderer());

		NRCToolbar toolbar = new NRCToolbar(addresses);
		toolbar.getNewData().addEventListener(Events.ON_CLICK, e -> {

			set.add(new AddressData());
			addresses.setModel(AddressModel.build(set));
			log.info("Add new Address");
		});

		toolbar.getRemove().addEventListener(Events.ON_CLICK, e->{

			addresses.getRows()
			.getChildren()
			.removeIf(ob->RowUtils.isChecked((Row)ob) 
					&& set.removeIf(p->p.getId().equals(RowUtils.id((Row)ob))));

			addresses.setModel(AddressModel.build(set));

			log.info("Removing address data");
		});

		getTabpanels().getFirstChild().appendChild(toolbar);
		getTabpanels().getFirstChild().appendChild(addresses);
	}

	private void initContacts(@NonNull Set<ContactData> set)
	{
		contacts.setWidth("100%");
		contacts.setEmptyMessage(Labels.getLabel("message.grid.empty"));
		contacts.appendChild(new Columns());
		contacts.appendChild(new Rows());
		contacts.setModel(ContactModel.build(set));
		contacts.setRowRenderer(new ContactRowRenderer());
		contacts.getColumns().appendChild(new Column(null,null,"25px"));
		contacts.getColumns().appendChild(new Column(Labels.getLabel("contact.grid.column.contact")));
		contacts.getColumns().appendChild(new Column(Labels.getLabel("contact.grid.column.type"),null,"175px"));
		contacts.getColumns().appendChild(new Column(Labels.getLabel("contact.grid.column.status"),null,"70px"));
		contacts.getColumns().appendChild(new Column());
		contacts.getColumns().getLastChild().setVisible(false);
		contacts.setSpan("1");

		NRCToolbar nrc = new NRCToolbar(contacts);
		nrc.getNewData().addEventListener(Events.ON_CLICK, e->{

			set.add(new ContactData());
			contacts.setModel(ContactModel.build(set));
		});
		nrc.getRemove().addEventListener(Events.ON_CLICK, e->
		contacts.getRows().getChildren().removeIf(row->RowUtils.isChecked((Row)row) && 
				set.removeIf(p->p.getId().equals(RowUtils.id((Row)row)))));

		getTabpanels().getChildren().get(1).appendChild(nrc);
		getTabpanels().getChildren().get(1).appendChild(contacts);
	}

	private void initRoles(@NonNull Set<PartyRoleData> set)
	{
		roles.setWidth("100%");
		roles.setEmptyMessage(Labels.getLabel("message.grid.empty"));
		roles.appendChild(new Columns());
		roles.appendChild(new Rows());
		roles.setModel(PartyRoleModel.build(set));
		roles.setRowRenderer(new PartyRoleRowRenderer());
		roles.getColumns().appendChild(new Column(null,null,"25px"));
		roles.getColumns().appendChild(new Column(Labels.getLabel("partyrole.label.start"),null,"125px"));
		roles.getColumns().appendChild(new Column(Labels.getLabel("partyrole.label.end"),null,"125px"));
		roles.getColumns().appendChild(new Column(Labels.getLabel("partyrole.label.type"),null,"100px"));
		roles.getColumns().appendChild(new Column());
		roles.getColumns().getLastChild().setVisible(false);
		roles.setSpan("3");

		NRCToolbar nrc = new NRCToolbar(roles);
		nrc.getNewData().addEventListener(Events.ON_CLICK, e->{

			set.add(new PartyRoleData());
			roles.setModel(PartyRoleModel.build(set));
		});
		nrc.getRemove().addEventListener(Events.ON_CLICK, e->
		roles.getRows().getChildren().removeIf(row->RowUtils.isChecked((Row)row) && 
				set.removeIf(p->p.getId().equals(RowUtils.id((Row)row)))));

		getTabpanels().getChildren().get(2).appendChild(nrc);
		getTabpanels().getChildren().get(2).appendChild(roles);
	}

	private void initRelationships(@NonNull Set<PartyRelationshipData> set)
	{
		relationships.setWidth("100%");
		relationships.setEmptyMessage(Labels.getLabel("message.grid.empty"));
		relationships.appendChild(new Columns());
		relationships.appendChild(new Rows());
		relationships.setModel(PartyRelationshipModel.build(set));
		relationships.setRowRenderer(new PartyRelationshipRowRenderer());
		relationships.getColumns().appendChild(new Column(null,null,"25px"));
		relationships.getColumns().appendChild(new Column(Labels.getLabel("partyrelationship.label.start"),null,"125px"));
		relationships.getColumns().appendChild(new Column(Labels.getLabel("partyrelationship.label.end"),null,"125px"));
		relationships.getColumns().appendChild(new Column(Labels.getLabel("partyrelationship.label.toparty"),null,"125px"));
		relationships.getColumns().appendChild(new Column(Labels.getLabel("partyrelationship.label.type"),null,"100px"));
		relationships.getColumns().appendChild(new Column(Labels.getLabel("partyrelationship.label.status"),null,"100px"));
		relationships.getColumns().appendChild(new Column());
		relationships.getColumns().getLastChild().setVisible(false);
		relationships.setSpan("3");

		NRCToolbar nrc = new NRCToolbar(relationships);
		nrc.getNewData().addEventListener(Events.ON_CLICK, e->{

			set.add(new PartyRelationshipData());
			relationships.setModel(PartyRelationshipModel.build(set));
		});
		nrc.getRemove().addEventListener(Events.ON_CLICK, e->
		relationships.getRows().getChildren().removeIf(row->RowUtils.isChecked((Row)row) && 
				set.removeIf(p->p.getId().equals(RowUtils.id((Row)row)))));

		getTabpanels().getChildren().get(3).appendChild(nrc);
		getTabpanels().getChildren().get(3).appendChild(relationships);
	}

	private void initClassification(@NonNull Set<PartyClassificationData> set)
	{
		classifications.setWidth("100%");
		classifications.setEmptyMessage(Labels.getLabel("message.grid.empty"));
		classifications.appendChild(new Columns());
		classifications.appendChild(new Rows());
		classifications.setModel(PartyClassificationModel.build(set));
		classifications.setRowRenderer(new PartyClassificationRowRenderer());
		classifications.getColumns().appendChild(new Column(null,null,"25px"));
		classifications.getColumns().appendChild(new Column(Labels.getLabel("partyclassification.label.start"),null,"125px"));
		classifications.getColumns().appendChild(new Column(Labels.getLabel("partyclassification.label.end"),null,"125px"));
		classifications.getColumns().appendChild(new Column(Labels.getLabel("partyclassification.label.value"),null,"150px"));
		classifications.getColumns().appendChild(new Column(Labels.getLabel("partyclassification.label.type"),null,"150px"));
		classifications.getColumns().appendChild(new Column());
		classifications.getColumns().getLastChild().setVisible(false);
		classifications.setSpan("3");

		NRCToolbar nrc = new NRCToolbar(classifications);
		nrc.getNewData().addEventListener(Events.ON_CLICK, e->{

			set.add(new PartyClassificationData());
			classifications.setModel(PartyClassificationModel.build(set));
		});
		nrc.getRemove().addEventListener(Events.ON_CLICK, e->
		classifications.getRows().getChildren().removeIf(row->RowUtils.isChecked((Row)row) && 
				set.removeIf(p->p.getId().equals(RowUtils.id((Row)row)))));

		getTabpanels().getChildren().get(4).appendChild(nrc);
		getTabpanels().getChildren().get(4).appendChild(classifications);
	}
	
	private void initMaritalStatus(@NonNull Set<MaritalStatusData> set)
	{
		maritalStatuses.setWidth("100%");
		maritalStatuses.setEmptyMessage(Labels.getLabel("message.grid.empty"));
		maritalStatuses.appendChild(new Columns());
		maritalStatuses.appendChild(new Rows());
		maritalStatuses.setModel(MaritalStatusModel.build(set));
		maritalStatuses.setRowRenderer(new MaritalStatusRowRenderer());
		maritalStatuses.getColumns().appendChild(new Column(null,null,"25px"));
		maritalStatuses.getColumns().appendChild(new Column(Labels.getLabel("maritalstatus.label.start"),null,"125px"));
		maritalStatuses.getColumns().appendChild(new Column(Labels.getLabel("maritalstatus.label.end"),null,"125px"));
		maritalStatuses.getColumns().appendChild(new Column(Labels.getLabel("maritalstatus.label.type"),null,"150px"));
		maritalStatuses.getColumns().appendChild(new Column());
		maritalStatuses.getColumns().getLastChild().setVisible(false);
		maritalStatuses.setSpan("3");

		NRCToolbar nrc = new NRCToolbar(maritalStatuses);
		nrc.getNewData().addEventListener(Events.ON_CLICK, e->{

			set.add(new MaritalStatusData());
			maritalStatuses.setModel(MaritalStatusModel.build(set));
		});
		
		nrc.getRemove().addEventListener(Events.ON_CLICK, e->
		maritalStatuses.getRows().getChildren().removeIf(row->RowUtils.isChecked((Row)row) && 
				set.removeIf(p->p.getId().equals(RowUtils.id((Row)row)))));
		
		Tabpanel panel = new Tabpanel();
		panel.appendChild(nrc);
		panel.appendChild(maritalStatuses);
		
		getTabs().appendChild(new Tab(Labels.getLabel("label.caption.maritalstatus")));
		getTabpanels().appendChild(panel);
	}
	
	private void initPhysicalCharacteristic(@NonNull Set<PhysicalCharacteristicData> set)
	{
		physicalCharacteristics.setWidth("100%");
		physicalCharacteristics.setEmptyMessage(Labels.getLabel("message.grid.empty"));
		physicalCharacteristics.appendChild(new Columns());
		physicalCharacteristics.appendChild(new Rows());
		physicalCharacteristics.setModel(PhysicalCharacteristicModel.build(set));
		physicalCharacteristics.setRowRenderer(new PhysicalCharacteristicRowRenderer());
		physicalCharacteristics.getColumns().appendChild(new Column(null,null,"25px"));
		physicalCharacteristics.getColumns().appendChild(new Column(Labels.getLabel("physicalcharacteristic.label.start"),null,"125px"));
		physicalCharacteristics.getColumns().appendChild(new Column(Labels.getLabel("physicalcharacteristic.label.end"),null,"125px"));
		physicalCharacteristics.getColumns().appendChild(new Column(Labels.getLabel("physicalcharacteristic.label.value"),null,"125px"));
		physicalCharacteristics.getColumns().appendChild(new Column(Labels.getLabel("physicalcharacteristic.label.type"),null,"150px"));
		physicalCharacteristics.getColumns().appendChild(new Column());
		physicalCharacteristics.getColumns().getLastChild().setVisible(false);
		physicalCharacteristics.setSpan("3");

		NRCToolbar nrc = new NRCToolbar(physicalCharacteristics);
		nrc.getNewData().addEventListener(Events.ON_CLICK, e->{

			set.add(new PhysicalCharacteristicData());
			physicalCharacteristics.setModel(PhysicalCharacteristicModel.build(set));
		});
		
		nrc.getRemove().addEventListener(Events.ON_CLICK, e->
		physicalCharacteristics.getRows().getChildren().removeIf(row->RowUtils.isChecked((Row)row) && 
				set.removeIf(p->p.getId().equals(RowUtils.id((Row)row)))));
		
		Tabpanel panel = new Tabpanel();
		panel.appendChild(nrc);
		panel.appendChild(physicalCharacteristics);
		
		getTabs().appendChild(new Tab(Labels.getLabel("label.caption.physicalcharacteristic")));
		getTabpanels().appendChild(panel);
	}
	
	private void initCitizenships(@NonNull Set<CitizenshipData> set)
	{
		citizenships.setWidth("100%");
		citizenships.setEmptyMessage(Labels.getLabel("message.grid.empty"));
		citizenships.appendChild(new Columns());
		citizenships.appendChild(new Rows());
		citizenships.setModel(CitizenshipModel.build(set));
		citizenships.setRowRenderer(new CitizenshipRowRenderer());
		citizenships.getColumns().appendChild(new Column(null,null,"25px"));
		citizenships.getColumns().appendChild(new Column(Labels.getLabel("citizenship.label.start"),null,"125px"));
		citizenships.getColumns().appendChild(new Column(Labels.getLabel("citizenship.label.end"),null,"125px"));
		citizenships.getColumns().appendChild(new Column(Labels.getLabel("citizenship.label.passportnumber"),null,"125px"));
		citizenships.getColumns().appendChild(new Column(Labels.getLabel("citizenship.label.passportissueddate"),null,"125px"));
		citizenships.getColumns().appendChild(new Column(Labels.getLabel("citizenship.label.passportexpiredDate"),null,"125px"));
		citizenships.getColumns().appendChild(new Column(Labels.getLabel("citizenship.label.passportcountry"),null,"150px"));
		citizenships.getColumns().appendChild(new Column());
		citizenships.getColumns().getLastChild().setVisible(false);
		citizenships.setSpan("3");

		NRCToolbar nrc = new NRCToolbar(citizenships);
		nrc.getNewData().addEventListener(Events.ON_CLICK, e->{

			set.add(new CitizenshipData());
			citizenships.setModel(CitizenshipModel.build(set));
		});
		
		nrc.getRemove().addEventListener(Events.ON_CLICK, e->
		citizenships.getRows().getChildren().removeIf(row->RowUtils.isChecked((Row)row) && 
				set.removeIf(p->p.getId().equals(RowUtils.id((Row)row)))));
		
		Tabpanel panel = new Tabpanel();
		panel.appendChild(nrc);
		panel.appendChild(citizenships);
		
		getTabs().appendChild(new Tab(Labels.getLabel("label.caption.citizenship")));
		getTabpanels().appendChild(panel);
	}	
}