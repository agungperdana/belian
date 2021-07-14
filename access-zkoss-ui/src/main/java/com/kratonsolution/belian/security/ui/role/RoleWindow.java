package com.kratonsolution.belian.security.ui.role;

import org.zkoss.image.AImage;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.event.EventQueues;

import com.kratonsolution.belian.common.ui.AbstractWindow;
import com.kratonsolution.belian.common.ui.event.UIEvent;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
public class RoleWindow extends AbstractWindow
{
	private static final long serialVersionUID = 2532837188647395498L;
	
	public RoleWindow() {

		super();
		try {
			caption.setImageContent(new AImage(getClass().getResource("/images/fisheye/role.png")));
		} catch (Exception e) {}
		
		caption.setLabel(Labels.getLabel("role.caption"));
		
		EventQueues.lookup(RoleUIEvent.class.getSimpleName()).subscribe(e->{
			
			RoleUIEvent event = (RoleUIEvent) e;
			
			clearContent();

			if(event.getType().equals(UIEvent.ADD_FORM)) {
				appendChild(new RoleFormContent());
			}
			else if(event.getType().equals(UIEvent.EDIT_FORM)) {
				appendChild(new RoleEditContent(event.getCode()));
			}
			else {
				appendChild(new RoleGridContent());
			}
		});
	}
}
