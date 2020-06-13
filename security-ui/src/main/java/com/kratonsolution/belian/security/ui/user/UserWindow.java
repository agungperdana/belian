package com.kratonsolution.belian.security.ui.user;

import java.util.Map;

import org.zkoss.image.AImage;
import org.zkoss.util.resource.Labels;

import com.kratonsolution.belian.common.ui.AbstractWindow;
import com.kratonsolution.belian.common.ui.event.WindowContentChangeEvent;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
public class UserWindow extends AbstractWindow
{
	private static final long serialVersionUID = 2532837188647395498L;
	
	public UserWindow() {

		super();
		try {
			caption.setImageContent(new AImage(getClass().getResource("/images/fisheye/user.png")));
		} catch (Exception e) {}
		
		caption.setLabel(Labels.getLabel("user.caption"));
	}

	@Override
	public void fireWindowContentChange(String event, Map<String, String> map) {
		
		clearContent();
		
		if(event.equals(WindowContentChangeEvent.GRID)) {
			appendChild(UserContentFactory.createGridContent());
		}
		else if(event.equals(WindowContentChangeEvent.ADD_FORM)) {
			appendChild(UserContentFactory.createAddFormContent());
		}
		else if(event.equals(WindowContentChangeEvent.EDIT_FORM)) {
			appendChild(UserContentFactory.createEditFormContent(map.get("username")));
		}
		else {
			
			appendChild(UserContentFactory.createChangePasswordFormContent(map.get("username")));
		}
	}
}
