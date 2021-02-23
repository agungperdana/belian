package com.kratonsolution.belian.partys.ui;

import org.zkoss.image.AImage;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.event.EventQueues;

import com.kratonsolution.belian.common.ui.AbstractWindow;
import com.kratonsolution.belian.common.ui.event.UIEvent;

import lombok.extern.slf4j.Slf4j;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Slf4j
public class PartyWindow extends AbstractWindow
{	
	private static final long serialVersionUID = -8958011451479566646L;

	public PartyWindow() {

		super();
		try {
			caption.setImageContent(new AImage(getClass().getResource("/images/fisheye/party.png")));
		} 
		catch (Exception e) {
			log.error(e.toString());
		}

		caption.setLabel(Labels.getLabel("label.caption.party.nickname"));
		EventQueues.lookup(PartyUIEvent.class.getSimpleName()).subscribe(e->{

			clearContent();
			
			PartyUIEvent event = (PartyUIEvent)e;
			if(event.getType().equals(UIEvent.GRID)) {
				appendChild(new PartyGridContent());
			}
			else if(event.getType().equals(UIEvent.ADD_FORM)) {
				appendChild(new PartyFormContent());
			}
			else if(event.getType().equals(UIEvent.EDIT_FORM)) {
				appendChild(new PartyEditContent(event.getCode()));
			}
		});
	}
}
