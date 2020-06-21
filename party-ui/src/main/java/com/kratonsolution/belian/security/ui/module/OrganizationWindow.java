package com.kratonsolution.belian.security.ui.module;

import java.util.Map;

import org.zkoss.image.AImage;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.event.EventQueues;

import com.kratonsolution.belian.common.ui.AbstractWindow;


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

		caption.setLabel(Labels.getLabel("caption.label.organization"));
		EventQueues.lookup(OrganizationUIEvent.class.getSimpleName()).subscribe(e->{
			
			
		});
	}

	@Override
	public void fireWindowContentChange(String event, Map<String, String> parameter) {
		// TODO Auto-generated method stub
		
	}
}
