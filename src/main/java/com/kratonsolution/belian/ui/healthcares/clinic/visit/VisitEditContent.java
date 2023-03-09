package com.kratonsolution.belian.ui.healthcares.clinic.visit;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.healtcares.dm.HealthcareDelivery;
import com.kratonsolution.belian.healtcares.dm.Visit;
import com.kratonsolution.belian.healtcares.dm.VisitRole;
import com.kratonsolution.belian.healtcares.dm.VisitStatus;
import com.kratonsolution.belian.healtcares.dm.VisitStatusType;
import com.kratonsolution.belian.healtcares.svc.VisitService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.healthcares.clinic.patient.PatientBox;
import com.kratonsolution.belian.ui.healthcares.clinic.practitioner.PractitionerBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class VisitEditContent extends AbstractForm
{	
	private VisitService service = Springs.get(VisitService.class);

	private Datebox date = Components.currentDatebox();

	private Textbox reason = Components.textarea(null,false,true);

	private Textbox note = Components.textarea(null,false,true);

	private PatientBox patient = new PatientBox(false);

	private PractitionerBox doctor = new PractitionerBox(false);

	private Tabbox tabbox = new Tabbox();

	private Grid roles = new Grid();

	private Grid statuses = new Grid();
	
	private Grid deliverys = new Grid();

	private Row row;

	public VisitEditContent(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
		initTabbox();
	}

	@Override
	public void initToolbar()
	{
		Visit out = service.getOne(RowUtils.id(row));
		if(out.isEditable() && out.isSignedIn() && out.getDoctor().getId().equals(utils.getPerson().getId()))
		{
			Toolbarbutton done = new Toolbarbutton(lang.get("clinic.visit.grid.column.finish"),"/icons/handled.png");
			done.addEventListener(Events.ON_CLICK, new EventListener<Event>()
			{
				@Override
				public void onEvent(Event arg0) throws Exception
				{
					edit(VisitStatusType.CONCLUDED);
					Flow.next(getParent(), new VisitGridContent());
				}
			});
			
			toolbar.appendChild(done);
		}
		
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new VisitGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(organizations.getDomain() == null)
					throw new WrongValueException(organizations,lang.get("message.field.empty"));

				if(patient.getDomain() == null)
					throw new WrongValueException(patient,lang.get("message.field.empty"));

				if(doctor.getDomain() == null)
					throw new WrongValueException(doctor,lang.get("message.field.empty"));

				if(date.getValue() == null)
					throw new WrongValueException(date,lang.get("message.field.empty"));

				if(Strings.isNullOrEmpty(reason.getText()))
					throw new WrongValueException(reason,lang.get("message.field.empty"));

				if(Strings.isNullOrEmpty(note.getText()))
					throw new WrongValueException(note,lang.get("message.field.empty"));

				edit(null);

				Flow.next(getParent(), new VisitGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		Visit visit = service.getOne(RowUtils.id(row));
		if(visit != null)
		{
			date.setValue(visit.getDate());
			patient.setDomainAsRef(visit.getPatient());
			doctor.setDomainAsRef(visit.getDoctor());
			reason.setText(visit.getReason());
			note.setText(visit.getNote());
		}

		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("clinic.visit.grid.column.date")));
		row1.appendChild(date);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("clinic.visit.grid.column.patient")));
		row2.appendChild(patient);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("clinic.visit.grid.column.doctor")));
		row3.appendChild(doctor);

		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("clinic.visit.grid.column.reason")));
		row4.appendChild(reason);

		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("clinic.visit.grid.column.note")));
		row5.appendChild(note);

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}

	private void initTabbox()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabpanels());
		tabbox.appendChild(new Tabs());
		tabbox.getTabs().appendChild(new Tab(lang.get("clinic.visit.grid.column.roles")));
		tabbox.getTabs().appendChild(new Tab(lang.get("clinic.visit.grid.column.statuses")));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());

		appendChild(tabbox);

		initRoles();
		initStatus();
		
		Visit visit = service.getOne(RowUtils.id(row));
		if(visit != null && visit.getDoctor().getId().equals(utils.getPerson().getId()))
		{
			tabbox.getTabs().appendChild(new Tab(lang.get("clinic.visit.grid.column.deliverys")));
			tabbox.getTabpanels().appendChild(new Tabpanel());
			tabbox.setSelectedIndex(2);
			
			initDeliverys();
		}
	}

	private void initRoles()
	{
		NRCToolbar nrc = new NRCToolbar(roles);

		roles.setWidth("100%");
		roles.setEmptyMessage(lang.get("message.grid.empty"));
		roles.appendChild(new Rows());
		roles.appendChild(new Columns());
		roles.getColumns().appendChild(new Column(null,null,"25px"));
		roles.getColumns().appendChild(new Column(lang.get("clinic.visit.grid.column.party"),null,"25px"));
		roles.getColumns().appendChild(new Column(lang.get("clinic.visit.grid.column.type"),null,"125px"));
		roles.getColumns().appendChild(new Column());
		roles.getColumns().getLastChild().setVisible(false);
		roles.setSpan("1");

		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(PartyBox.personNolinkSpan());
				row.appendChild(new VisitRoleTypeList(true));
				row.appendChild(new Label(UUID.randomUUID().toString()));

				roles.getRows().appendChild(row);
			}
		});

		Visit visit = service.getOne(RowUtils.id(row));
		if(visit != null)
		{
			for(VisitRole role:visit.getRoles())
			{
				PartyBox box = PartyBox.personNolinkSpan();
				box.setDomainAsRef(role.getParty());

				VisitRoleTypeList list = new VisitRoleTypeList(true);
				list.setDomain(role.getType());
				
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(box);
				row.appendChild(list);
				row.appendChild(new Label(role.getId()));
				
				roles.getRows().appendChild(row);
			}
		}

		tabbox.getTabpanels().getFirstChild().appendChild(nrc);
		tabbox.getTabpanels().getFirstChild().appendChild(roles);
	}

	private void initStatus()
	{
		NRCToolbar nrc = new NRCToolbar(statuses);

		statuses.setWidth("100%");
		statuses.setEmptyMessage(lang.get("message.grid.empty"));
		statuses.appendChild(new Rows());
		statuses.appendChild(new Columns());
		statuses.getColumns().appendChild(new Column(null,null,"25px"));
		statuses.getColumns().appendChild(new Column(lang.get("clinic.visit.grid.column.date"),null,"175px"));
		statuses.getColumns().appendChild(new Column(lang.get("clinic.visit.grid.column.type"),null,"125px"));
		statuses.getColumns().appendChild(new Column());
		statuses.getColumns().getLastChild().setVisible(false);
		statuses.setSpan("2");

		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.datetime(DateTimes.timestamp(),true));
				row.appendChild(new VisitStatusTypeList(true));
				row.appendChild(new Label(UUID.randomUUID().toString()));

				statuses.getRows().appendChild(row);
			}
		});

		Visit visit = service.getOne(RowUtils.id(row));
		if(visit != null)
		{
			for(VisitStatus status:visit.getStatuses())
			{
				VisitStatusTypeList list = new VisitStatusTypeList(true);
				list.setDomain(status.getType());

				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.datetime(status.getDate(),true));
				row.appendChild(list);
				row.appendChild(new Label(status.getId()));

				statuses.getRows().appendChild(row);
			}
		}

		tabbox.getTabpanels().getChildren().get(1).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(1).appendChild(statuses);
	}
	
	private void initDeliverys()
	{
		NRCToolbar nrc = new NRCToolbar(deliverys);

		deliverys.setWidth("100%");
		deliverys.setEmptyMessage(lang.get("message.grid.empty"));
		deliverys.appendChild(new Rows());
		deliverys.appendChild(new Columns());
		deliverys.getColumns().appendChild(new Column(null,null,"25px"));
		deliverys.getColumns().appendChild(new Column(lang.get("clinic.visit.grid.column.date"),null,"115px"));
		deliverys.getColumns().appendChild(new Column(lang.get("clinic.visit.grid.column.type"),null,"125px"));
		deliverys.getColumns().appendChild(new Column(lang.get("clinic.visit.grid.column.note"),null,"125px"));
		deliverys.getColumns().appendChild(new Column(lang.get("clinic.visit.grid.column.product"),null,"250px"));
		deliverys.getColumns().appendChild(new Column(lang.get("clinic.visit.grid.column.quantity"),null,"75px"));
		deliverys.getColumns().appendChild(new Column(lang.get("clinic.visit.grid.column.uom"),null,"100px"));
		deliverys.getColumns().appendChild(new Column());
		deliverys.getColumns().getLastChild().setVisible(false);
		deliverys.setSpan("3");

		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new HealthcareDeviveryForm(RowUtils.id(row)));
			}
		});

		Visit visit = service.getOne(RowUtils.id(row));
		if(visit != null)
		{
			for(HealthcareDelivery delivery:visit.getDeliverys())
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(new Label(DateTimes.formatDateTime(delivery.getDate())));
				row.appendChild(new Label(delivery.getType().display(utils.getLanguage())));
				row.appendChild(new Label(delivery.getNote()));
				row.appendChild(new Label(delivery.getProduct().getValue()));
				row.appendChild(new Label(Numbers.format(delivery.getQuantity())));
				row.appendChild(new Label(delivery.getUom()!=null?delivery.getUom().getValue():""));
				row.appendChild(new Label(delivery.getId()));

				deliverys.getRows().appendChild(row);
			}
		}

		tabbox.getTabpanels().getLastChild().appendChild(nrc);
		tabbox.getTabpanels().getLastChild().appendChild(deliverys);
	}
	
	private void edit(VisitStatusType type)
	{
		Visit visit = service.getOne(RowUtils.id(row));
		if(visit != null && visit.isEditable())
		{
			visit.setDate(DateTimes.sql(date.getValue()));
			visit.setNote(note.getText());
			visit.setOrganization(utils.getOrganization().toRef());
			visit.setReason(reason.getText());

			Map<String,VisitRole> vRoles = new HashMap<>();
			Map<String,VisitStatus> vStatuses = new HashMap<>();

			for(VisitRole role:visit.getRoles())
				vRoles.put(role.getId(), role);
			
			for(VisitStatus status:visit.getStatuses())
				vStatuses.put(status.getId(), status);

			visit.getRoles().clear();
			visit.getStatuses().clear();
			
			for(Component com:roles.getRows().getChildren())
			{
				Row _rw = (Row)com;

				PartyBox box = (PartyBox)_rw.getChildren().get(1);
				VisitRoleTypeList list = (VisitRoleTypeList)_rw.getChildren().get(2);

				VisitRole role = vRoles.containsKey(RowUtils.id(_rw))?vRoles.get(RowUtils.id(_rw)):new VisitRole();
				role.setParty(box.getDomainAsRef());
				role.setType(list.getDomain());
				role.setVisit(visit);

				visit.getRoles().add(role);
			}

			for(Component com:statuses.getRows().getChildren())
			{
				Row _rw = (Row)com;

				VisitStatusTypeList list = (VisitStatusTypeList)_rw.getChildren().get(2);

				VisitStatus status = vStatuses.containsKey(RowUtils.id(_rw))?vStatuses.get(RowUtils.id(_rw)):new VisitStatus();
				status.setDate(RowUtils.timestam(_rw, 1));
				status.setType(list.getDomain());
				status.setVisit(visit);

				visit.getStatuses().add(status);
			}

			if(type != null)
			{
				VisitStatus status = new VisitStatus();
				status.setDate(DateTimes.timestamp());
				status.setType(type);
				status.setVisit(visit);
				
				visit.getStatuses().add(status);
			}
			
			service.edit(visit);
		}
	}
}
