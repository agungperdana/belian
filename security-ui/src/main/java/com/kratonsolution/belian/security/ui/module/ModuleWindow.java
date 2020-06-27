package com.kratonsolution.belian.security.ui.module;

import java.util.Map;

import org.zkoss.image.AImage;
import org.zkoss.util.resource.Labels;

import com.kratonsolution.belian.common.ui.AbstractWindow;
import com.kratonsolution.belian.common.ui.event.UIEvent;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class ModuleWindow extends AbstractWindow
{	
	private static final long serialVersionUID = -8958011451479566646L;

	public ModuleWindow() {

		super();
		try {
			caption.setImageContent(new AImage(getClass().getResource("/images/fisheye/module.png")));
		} catch (Exception e) {}

		caption.setLabel(Labels.getLabel("module.caption"));
	}

	@Override
	public void fireWindowContentChange(String event, Map<String, String> parameter) {

		clearContent();

		if(event.equals(UIEvent.GRID)) {
			appendChild(ModuleContentFactory.createGridContent());
		}
		else if(event.equals(UIEvent.EDIT_FORM)) {
			appendChild(ModuleContentFactory.createEditFormContent(parameter.get("code")));
		}
		else {
			appendChild(ModuleContentFactory.createAddFormContent());
		}
	}
}
