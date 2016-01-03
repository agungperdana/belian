/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Row;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treecol;
import org.zkoss.zul.Treecols;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.svc.DoctorAppointmentService;
import com.kratonsolution.belian.healtcare.svc.DoctorTypeService;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorDashboardContent extends Hlayout
{	
	private DoctorAppointmentService service = Springs.get(DoctorAppointmentService.class);
	
	private DoctorTypeService typeService = Springs.get(DoctorTypeService.class);
	
	private Vlayout navLayout = new Vlayout();
	
	private Vlayout contentLayout = new Vlayout();

	private Tree tree = new Tree();
	
	private Row row;

	public DoctorDashboardContent(Row row)
	{
		this.row = row;
		
		setSpacing("3px");
		setWidth("100%");
		setHeight("97%");
		setStyle("overflow:auto");

		initLayout();
		initTree();
	}
	
	private void initLayout()
	{
		navLayout.setHeight("100%");
		navLayout.setWidth("225px");
		navLayout.setStyle("over-flow:auto;");
		
		contentLayout.setWidth("100%");
		contentLayout.setHeight("100%");
		
		appendChild(navLayout);
		appendChild(contentLayout);
		
		appendChild(navLayout);
		appendChild(contentLayout);
	}

	private void initTree()
	{
		tree.setWidth("100%");
		tree.setHeight("100%");
		
		Treecols treecols = new Treecols();
		Treechildren children = new Treechildren();
		
		tree.appendChild(treecols);
		tree.appendChild(children);
		
		DoctorAppointment appointment = service.findOne(RowUtils.string(row, 6));
		if(appointment != null)
		{
			Treecol title = new Treecol(appointment.getPatient().getPerson().getName(),"","100%");
			title.setImage("/icons/close24.png");
			title.setStyle("cursor:pointer;");
			title.addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					Component window = getParent();
					if(window instanceof DoctorDashboardWindow)
					{
						((DoctorDashboardWindow)window).removeEditForm();
						((DoctorDashboardWindow)window).insertGrid();
					}
				}
			});
			
			treecols.appendChild(title);
			
			children.appendChild(new CurrentAppointmentItem(appointment, contentLayout));
			children.appendChild(new PatientInformationItem(appointment, contentLayout));
			children.appendChild(new AppointmentItem(appointment,contentLayout));
			children.appendChild(new MedicalRecordItem(appointment, contentLayout));
			children.appendChild(new FamiliFolderItem(appointment, contentLayout));
		}
		
		navLayout.appendChild(tree);
	}
}
