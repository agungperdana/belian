package com.kratonsolution.belian.geographic.ui;

import org.zkoss.image.AImage;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.event.EventQueues;

import com.kratonsolution.belian.common.ui.AbstractWindow;
import com.kratonsolution.belian.common.ui.event.UIEvent;


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
		EventQueues.lookup(GeographicUIEvent.class.getSimpleName()).subscribe(e->{
			
			GeographicUIEvent event = (GeographicUIEvent) e;
			
			clearContent();

			if(event.getType().equals(UIEvent.ADD_FORM)) {
				appendChild(new GeographicFormContent());
			}
			else if(event.getType().equals(UIEvent.EDIT_FORM)) {
				appendChild(new GeographicUpdateContent(event.getCode()));
			}
			else {
				appendChild(new GeographicContent());
			}
		});
	}
}
