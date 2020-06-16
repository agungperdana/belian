package com.kratonsolution.belian.geographic.ui;

import java.util.Map;

import org.zkoss.image.AImage;
import org.zkoss.util.resource.Labels;

import com.kratonsolution.belian.common.ui.AbstractWindow;
import com.kratonsolution.belian.common.ui.event.WindowContentChangeEvent;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class GeographicWindow extends AbstractWindow
{	
	private static final long serialVersionUID = -8958011451479566646L;

	public GeographicWindow() {

		super();
		try {
			caption.setImageContent(new AImage(getClass().getResource("/images/fisheye/geographic.png")));
		} catch (Exception e) {}

		caption.setLabel(Labels.getLabel("geographic.label.caption"));
	}

	@Override
	public void fireWindowContentChange(String event, Map<String, String> parameter) {

		clearContent();

		if(event.equals(WindowContentChangeEvent.GRID)) {
			appendChild(GeographicContentFactory.createGridContent());
		}
//		else if(event.equals(WindowContentChangeEvent.EDIT_FORM)) {
//			appendChild(GeographicContentFactory.createEditFormContent(parameter.get("code")));
//		}
//		else {
//			appendChild(GeographicContentFactory.createAddFormContent());
//		}
	}
}
