package com.kratonsolution.belian.common.ui.util;

import org.zkoss.zk.ui.event.EventQueues;

import com.kratonsolution.belian.common.ui.event.UIEvent;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
public class FlowHelper {

	public static void next(@NonNull UIEvent event) {
		
		EventQueues.lookup(event.getClass().getSimpleName()).publish(event);
	}	
}
