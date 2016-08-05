/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treeitem;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FamiliFolderItem extends Treeitem
{
	private Treechildren treechildren = new Treechildren();

	public FamiliFolderItem(DoctorAppointment appointment,Component layout)
	{
		Language lang = Springs.get(Language.class);
		setLabel(lang.get("doctordashboard.grid.column.folder"));
		setImage("/icons/famili-folder-info.png");
		appendChild(treechildren);
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				layout.getChildren().clear();
				layout.appendChild(new FamilyFolderPanel(appointment.getPatient()));
			}
		});
	}
}
