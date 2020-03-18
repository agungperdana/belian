package com.kratonsolution.belian.security.ui.user;

import org.zkoss.image.AImage;
import org.zkoss.util.resource.Labels;

import com.kratonsolution.belian.common.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class UserWindow extends AbstractWindow
{
	private static final long serialVersionUID = 2532837188647395498L;
	
	public UserWindow() {
		super();
	}
	
	protected void init()
	{
		try {
			caption.setImageContent(new AImage(getClass().getResource("/images/fisheye/user.png")));
		} catch (Exception e) {}
		
		caption.setLabel(Labels.getLabel("user.caption"));
		appendChild(new UserGridContent());
	}
}
