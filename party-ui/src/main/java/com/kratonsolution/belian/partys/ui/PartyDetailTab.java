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
import com.kratonsolution.belian.party.api.ContactData;
import com.kratonsolution.belian.party.api.MaritalStatusData;
import com.kratonsolution.belian.party.api.PartyClassificationData;
import com.kratonsolution.belian.party.api.PartyData;
import com.kratonsolution.belian.party.api.PartyRelationshipData;
import com.kratonsolution.belian.party.api.PartyRoleData;
import com.kratonsolution.belian.party.api.model.PartyType;
import com.kratonsolution.belian.partys.ui.address.AddressModel;
import com.kratonsolution.belian.partys.ui.address.AddressRowRenderer;
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

	protected Grid addresses = new Grid();

	protected Grid contacts = new Grid();

	protected Grid roles = new Grid();

	protected Grid relationships = new Grid();

	protected Grid classifications = new Grid();
	
	protected Grid maritalStatuses = new Grid();

	public PartyDetailTab(@NonNull PartyData party)
	{
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
		
		if(party.getType().equals(PartyType.PERSON) && party.getPersonInformation() != null) {
			initMaritalStatus(party.getPersonInformation().getMaritalStatuses());
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
					&& set.removeIf(p->p.getId().equals(ob.getAttribute("DATAID"))));

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
		contacts.getColumns().appendChild(new Column(Labels.getLabel("contact.grid.column.type"),null,"125px"));
		contacts.getColumns().appendChild(new Column(Labels.getLabel("contact.grid.column.status"),null,"70px"));
		contacts.setSpan("1");

		NRCToolbar nrc = new NRCToolbar(contacts);
		nrc.getNewData().addEventListener(Events.ON_CLICK, e->{

			set.add(new ContactData());
			contacts.setModel(ContactModel.build(set));
		});
		nrc.getRemove().addEventListener(Events.ON_CLICK, e->
		contacts.getRows().getChildren().removeIf(row->RowUtils.isChecked((Row)row) && 
				set.removeIf(p->p.getId().equals(row.getAttribute("DATAID")))));

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
		roles.setSpan("3");

		NRCToolbar nrc = new NRCToolbar(roles);
		nrc.getNewData().addEventListener(Events.ON_CLICK, e->{

			set.add(new PartyRoleData());
			roles.setModel(PartyRoleModel.build(set));
		});
		nrc.getRemove().addEventListener(Events.ON_CLICK, e->
		roles.getRows().getChildren().removeIf(row->RowUtils.isChecked((Row)row) && 
				set.removeIf(p->p.getId().equals(row.getAttribute("DATAID")))));

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
		relationships.setSpan("3");

		NRCToolbar nrc = new NRCToolbar(relationships);
		nrc.getNewData().addEventListener(Events.ON_CLICK, e->{

			set.add(new PartyRelationshipData());
			relationships.setModel(PartyRelationshipModel.build(set));
		});
		nrc.getRemove().addEventListener(Events.ON_CLICK, e->
		relationships.getRows().getChildren().removeIf(row->RowUtils.isChecked((Row)row) && 
				set.removeIf(p->p.getDataID().equals(row.getAttribute("DATAID")))));

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
		classifications.setSpan("3");

		NRCToolbar nrc = new NRCToolbar(classifications);
		nrc.getNewData().addEventListener(Events.ON_CLICK, e->{

			set.add(new PartyClassificationData());
			classifications.setModel(PartyClassificationModel.build(set));
		});
		nrc.getRemove().addEventListener(Events.ON_CLICK, e->
		classifications.getRows().getChildren().removeIf(row->RowUtils.isChecked((Row)row) && 
				set.removeIf(p->p.getId().equals(row.getAttribute("DATAID")))));

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
}
