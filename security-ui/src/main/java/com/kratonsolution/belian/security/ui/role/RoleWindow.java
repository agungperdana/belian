package com.kratonsolution.belian.security.ui.role;

import java.util.Map;

import org.zkoss.image.AImage;
import org.zkoss.util.resource.Labels;

import com.kratonsolution.belian.common.ui.AbstractWindow;
import com.kratonsolution.belian.common.ui.event.ContentEvent;

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
	}

	@Override
	public void fireWindowContentChange(String event, Map<String, String> map) {
		
		clearContent();
		
		if(event.equals(ContentEvent.GRID)) {
			appendChild(RoleContentFactory.createGridContent());
		}
		else if(event.equals(ContentEvent.ADD_FORM)) {
			appendChild(RoleContentFactory.createAddFormContent());
		}
		else if(event.equals(ContentEvent.EDIT_FORM)) {
			appendChild(RoleContentFactory.createEditFormContent(map.get("code")));
		}
	}
}
