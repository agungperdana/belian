/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treecol;
import org.zkoss.zul.Treecols;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Vbox;

import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.svc.DoctorAppointmentService;
import com.kratonsolution.belian.healtcare.svc.DoctorTypeService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorDashboardEditContent extends FormContent
{	
	private DoctorAppointmentService service = Springs.get(DoctorAppointmentService.class);
	
	private DoctorTypeService typeService = Springs.get(DoctorTypeService.class);
	
	private Hbox layout = new Hbox();
	
	private Vbox navLayout = new Vbox();
	
	private Vbox contentLayout = new Vbox();

	private Tree tree = new Tree();
	
	private Row row;

	public DoctorDashboardEditContent(Row row)
	{
		super();
		this.row = row;
		initLayout();
		initTree();
		initForm();
		initToolbar();
	}
	
	private void initLayout()
	{
		layout.setHeight("100%");
		layout.setWidth("100%");
		
		navLayout.setHeight("100%");
		navLayout.setWidth("30%");
		navLayout.setStyle("over-flow:auto;");
		
		contentLayout.setHeight("100%");
		
		layout.appendChild(navLayout);
		layout.appendChild(contentLayout);
		
		layout.appendChild(navLayout);
		layout.appendChild(contentLayout);
		
		removeChild(toolbar);
		removeChild(grid);
		appendChild(layout);
	}

	private void initTree()
	{
		tree.setWidth("100%");
		tree.setHeight("100%");
		tree.setStyle("over-flow:auto;");
		
		Treecols treecols = new Treecols();
		Treechildren children = new Treechildren();
		
		tree.appendChild(treecols);
		tree.appendChild(children);
		
		DoctorAppointment appointment = service.findOne(RowUtils.string(row, 6));
		if(appointment != null)
		{
			treecols.appendChild(new Treecol(appointment.getPatient().getPerson().getName(),"","100%"));
			
			Treeitem records = new Treeitem("Medical Record Information");
			records.setImage("/icons/medical-record-info.png");
			records.appendChild(new Treechildren());
			
			Treeitem folder = new Treeitem("Famili Folder");
			folder.setImage("/icons/famili-folder-info.png");
			folder.appendChild(new Treechildren());
			
			children.appendChild(new PersonalItem(appointment, contentLayout));
			children.appendChild(new AppointmentItem(appointment));
			children.appendChild(records);
			children.appendChild(folder);
		}
		
		navLayout.appendChild(tree);
	}
	
	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				DoctorDashboardWindow window = (DoctorDashboardWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
			}
		});
	}

	@Override
	public void initForm()
	{
	}
}
