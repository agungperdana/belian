/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.Row;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treecol;
import org.zkoss.zul.Treecols;
import org.zkoss.zul.West;

import com.google.common.base.Strings;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.svc.DoctorAppointmentService;
import com.kratonsolution.belian.healtcare.svc.DoctorTypeService;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorDashboardContent extends Borderlayout
{	
	private DoctorAppointmentService service = Springs.get(DoctorAppointmentService.class);
	
	private DoctorTypeService typeService = Springs.get(DoctorTypeService.class);
	
	private West west = new West();
	
	private Center center = new Center();

	private Tree tree = new Tree();
	
	private Row row;

	public DoctorDashboardContent(Row row)
	{
		this.row = row;
		
		setWidth("100%");
		setHeight("100%");
		
		initLayout();
		initTree();
	}
	
	private void initLayout()
	{
		west.setWidth("30%");
		west.setStyle("over-flow:auto;");
		west.setBorder("none");
		
		center.setStyle("over-flow:auto;");
		center.setBorder("none");
		
		appendChild(west);
		appendChild(center);
	}

	private void initTree()
	{
		tree.setWidth("100%");
		tree.setHeight("97%");
		
		Treecols treecols = new Treecols();
		Treechildren children = new Treechildren();
		
		tree.appendChild(treecols);
		tree.appendChild(children);
		
		DoctorAppointment appointment = service.findOne(RowUtils.id(row));
		if(appointment != null)
		{
			StringBuilder builder = new StringBuilder();
			builder.append(appointment.getPatient().getPerson().getName());
			
			if(appointment.getPatient().getBpjs() != null && !Strings.isNullOrEmpty(appointment.getPatient().getBpjs().getCard()))
				builder.append(" (BPJS : "+appointment.getPatient().getBpjs().getCard()+")");
			
			Treecol title = new Treecol(builder.toString(),"100%");
			title.setImage("/icons/close24.png");
			title.setStyle("cursor:pointer;");
			title.addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					Flow.next(getParent(), new DoctorDashboardGridContent());
				}
			});
			
			treecols.appendChild(title);
			
			children.appendChild(new CurrentAppointmentItem(appointment, center));
			children.appendChild(new PatientInformationItem(appointment, center));
			children.appendChild(new AppointmentItem(appointment,center));
			children.appendChild(new MedicalRecordItem(appointment, center));
			children.appendChild(new FamiliFolderItem(appointment, center));
		}
		
		west.appendChild(tree);
	}
}
