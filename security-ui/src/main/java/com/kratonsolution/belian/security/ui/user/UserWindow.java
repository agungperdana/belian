package com.kratonsolution.belian.security.ui.user;

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
		caption.setLabel(Labels.getLabel("security.user.caption"));
		caption.setImage("/images/fisheye/user.png");
		appendChild(new UserGridContent());
	}
}
