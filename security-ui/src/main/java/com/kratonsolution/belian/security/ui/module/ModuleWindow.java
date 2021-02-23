package com.kratonsolution.belian.security.ui.module;

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
public class ModuleWindow extends AbstractWindow
{	
	private static final long serialVersionUID = -8958011451479566646L;

	public ModuleWindow() {

		super();
		try {
			caption.setImageContent(new AImage(getClass().getResource("/images/fisheye/module.png")));
		} catch (Exception e) {}

		caption.setLabel(Labels.getLabel("module.caption"));

		EventQueues.lookup(ModuleUIEvent.class.getSimpleName()).subscribe(e->{

			ModuleUIEvent event = (ModuleUIEvent) e;

			clearContent();

			if(event.getType().equals(UIEvent.ADD_FORM)) {
				appendChild(new ModuleFormContent());
			}
			else if(event.getType().equals(UIEvent.EDIT_FORM)) {
				appendChild(new ModuleEditContent(event.getCode()));
			}
			else {
				appendChild(new ModuleGridContent());
			}
		});
	}
}
