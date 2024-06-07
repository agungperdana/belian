
package com.kratonsolution.belian.ui.healthcares.clinic.visitqueue;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.A;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listhead;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.common.app.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.healtcares.dm.PractitionerProviderRelationship;
import com.kratonsolution.belian.healtcares.dm.Visit;
import com.kratonsolution.belian.healtcares.dm.VisitStatus;
import com.kratonsolution.belian.healtcares.dm.VisitStatusType;
import com.kratonsolution.belian.healtcares.svc.PractitionerProviderRelationshipService;
import com.kratonsolution.belian.healtcares.svc.VisitService;
import com.kratonsolution.belian.tools.view.KernelTask;
import com.kratonsolution.belian.ui.healthcares.clinic.visit.VisitEditContent;
import com.kratonsolution.belian.ui.healthcares.clinic.visit.VisitWindow;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class VisitQueueContent extends Vlayout
{
	private Language lang = Springs.get(Language.class);
	
	private KernelTask kernel = Springs.get(KernelTask.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private VisitService visitService = Springs.get(VisitService.class);
	
	private PractitionerProviderRelationshipService doctorService = Springs.get(PractitionerProviderRelationshipService.class);
	
	private Listbox queue = new Listbox();
	
	private Listbox signin = new Listbox();
	
	private Listbox concluded = new Listbox();
	
	private Listbox doctors = Components.newSelect();
	
	private Tabbox tabbox = new Tabbox();
	
	public VisitQueueContent()
	{
		setWidth("100%");
		setHeight("100%");
		
		doctors.setHeight("18px");
		
		tabbox.setWidth("100%");
		tabbox.setVflex("1");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab(lang.get("clinic.visit.grid.column.queue")));
		tabbox.getTabs().appendChild(new Tab(lang.get("clinic.visit.grid.column.signin")));
		tabbox.getTabs().appendChild(new Tab(lang.get("clinic.visit.grid.column.finish")));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().getChildren().get(0).appendChild(queue);
		tabbox.getTabpanels().getChildren().get(1).appendChild(signin);
		tabbox.getTabpanels().getChildren().get(2).appendChild(concluded);
		
		for(PractitionerProviderRelationship doctor:doctorService.findAll())
		{
			if(DateTimes.inActiveState(doctor.getStart(), doctor.getEnd()))
			{
				Listitem listitem = doctors.appendItem(doctor.getFromParty().getName(), doctor.getFromParty().getId());
				listitem.addEventListener(Events.ON_CLICK, new EventListener<Event>()
				{
					@Override
					public void onEvent(Event arg0) throws Exception
					{
						initVisit();
					}
				});
				
				if(doctor.getFromParty().getId().equals(utils.getPerson().getId()))
					doctors.setSelectedItem(listitem);
			}
		}
		
		initHeaders();

		A refresh = new A();
		refresh.setImage("/icons/refresh16.png");
		refresh.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				initVisit();
			}
		});
		
		Hbox hbox = new Hbox();
		hbox.setHflex("1");
		hbox.appendChild(refresh);
		hbox.appendChild(doctors);
		hbox.setAlign("start");
		hbox.setSpacing("3px");
		
		this.appendChild(hbox);
		this.appendChild(tabbox);
	
		initVisit();
	}

	private void initHeaders()
	{
		/**
		 * init queue visit
		 */
		queue.setHflex("1");
		queue.setVflex("1");
		
		Listheader queName = new Listheader(lang.get("navbar.menu.healthcares.clinic.patient"));
		queName.setWidth("88%");
		
		Listhead qHead = new Listhead();
		qHead.appendChild(queName);
		qHead.appendChild(new Listheader(""));
		
		queue.appendChild(qHead);
		
		/**
		 * init signed in visit
		 */
		signin.setHflex("1");
		signin.setVflex("1");
		
		Listheader signinName = new Listheader(lang.get("navbar.menu.healthcares.clinic.patient"));
		signinName.setWidth("88%");
		
		Listhead sHead = new Listhead();
		sHead.appendChild(signinName);
		sHead.appendChild(new Listheader(""));
		
		signin.appendChild(sHead);
		
		/**
		 * init concluded visit
		 */
		concluded.setHflex("1");
		concluded.setVflex("1");
		
		Listheader concludeName = new Listheader(lang.get("navbar.menu.healthcares.clinic.patient"));
		concludeName.setWidth("88%");
		
		Listhead conHead = new Listhead();
		conHead.appendChild(concludeName);
		conHead.appendChild(new Listheader(""));
		
		concluded.appendChild(conHead);
	}
	
	private void initVisit()
	{
		queue.getItems().clear();
		signin.getItems().clear();
		concluded.getItems().clear();
		
		for(Visit status:visitService.findAllToday(doctors.getSelectedItem()!=null?doctors.getSelectedItem().getValue():null))
		{
			if(!status.isEditable())
				proccess(status,concluded);
			else if(status.isSignedIn())
				proccess(status, signin);
			else
				proccess(status, queue);
		}
	}

	private void proccess(Visit visit,Listbox conts)
	{
		Listitem listitem = new Listitem();
		
		Listcell vRow = new Listcell("("+DateTimes.formatTime(visit.getLastStatusDate())+") "+visit.getPatient().getValue(), visit.getId());
		vRow.setImage("/icons/visit16.png");
		vRow.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				openWindow(visit.getId());
			}
		});

		A a = new A();
		a.setIconSclass("z-icon-chevron-circle-right");
		a.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(visit.isEditable() && !visit.isSignedIn())
				{
					Visit fresh = visitService.findById(visit.getId());
					if(fresh != null)
					{
						VisitStatus st = new VisitStatus();
						st.setDate(DateTimes.timestamp());
						st.setType(VisitStatusType.SIGNEDIN);
						st.setVisit(fresh);
						
						fresh.getStatuses().add(st);
						
						visitService.edit(fresh);
						
						initVisit();
					}
				}
				else
					openWindow(visit.getId());
			}
		});
		
		Listcell signin = new Listcell();
		signin.appendChild(a);
		
		listitem.appendChild(vRow);
		listitem.appendChild(signin);
		
		conts.appendChild(listitem);
	}
	
	private void openWindow(String id)
	{
		Component window = null;
		
		if(!kernel.isExist(lang.get("navbar.menu.healthcares.clinic.visit")))
			window = kernel.open(VisitWindow.newInstance(getPage()));
		else
			window =  kernel.open(lang.get("navbar.menu.healthcares.clinic.visit"));
	
		if(window != null)
			Flow.next(window, new VisitEditContent(RowUtils.shield(id)));
	}
}
