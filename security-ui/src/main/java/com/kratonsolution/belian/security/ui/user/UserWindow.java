package com.kratonsolution.belian.security.ui.user;

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
	public void onApplicationEvent(WindowContentChangeEvent event) {
		
		if(event.getType().equals(WindowContentChangeEvent.Type.GRID)) {
			appendChild(UserContentFactory.createGridContent());
		}
		else if(event.getType().equals(WindowContentChangeEvent.Type.ADD_FORM)) {
			appendChild(UserContentFactory.createGridContent());
		}
		else {
			appendChild(UserContentFactory.createGridContent());
		}
	}
}
