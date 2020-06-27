package com.kratonsolution.belian.partys.ui.organization;

import java.util.Map;

import org.zkoss.image.AImage;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.event.EventQueues;

import com.kratonsolution.belian.common.ui.AbstractWindow;
import com.kratonsolution.belian.common.ui.event.UIEvent;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class OrganizationWindow extends AbstractWindow
{	
	private static final long serialVersionUID = -8958011451479566646L;

	public OrganizationWindow() {

		super();
		try {
			caption.setImageContent(new AImage(getClass().getResource("/images/fisheye/organization.png")));
		} 
		catch (Exception e) {}

		caption.setLabel(Labels.getLabel("label.caption.organization"));
		EventQueues.lookup(OrganizationUIEvent.class.getSimpleName()).subscribe(e->{

			clearContent();
			
			OrganizationUIEvent event = (OrganizationUIEvent)e;
			if(event.getType().equals(UIEvent.GRID)) {
				appendChild(new OrganizationGridContent());
			}
			else if(event.getType().equals(UIEvent.ADD_FORM)) {
				appendChild(new OrganizationFormContent());
			}
			else if(event.getType().equals(UIEvent.EDIT_FORM)) {
				appendChild(new OrganizationEditContent(event.getCode()));
			}
		});
	}

	@Override
	public void fireWindowContentChange(String event, Map<String, String> parameter) {
		// TODO Auto-generated method stub
		
	}
}
