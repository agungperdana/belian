package com.kratonsolution.belian.common.ui.toolbar;

import org.zkoss.image.AImage;
import org.zkoss.util.resource.Labels;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Getter
public class FormToolbar extends Toolbar
{
	private static final long serialVersionUID = -8833383711789529370L;

	private Toolbarbutton cancel = new Toolbarbutton(Labels.getLabel("toolbar.cancel"));
	
	private Toolbarbutton save = new Toolbarbutton(Labels.getLabel("toolbar.save"));
	
	public FormToolbar()
	{
		setWidth("100%");
		setHeight("36px");
		
		try {
			cancel.setImageContent(new AImage(getClass().getResource("/images/toolbar/cancel.png")));
			save.setImageContent(new AImage(getClass().getResource("/images/toolbar/save.png")));
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		appendChild(cancel);
		appendChild(save);
	}
}
