package com.kratonsolution.belian.common.ui.util;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.Component;

import com.kratonsolution.belian.common.ui.AbstractWindow;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
public class FlowHelper {

	public static void next(@NonNull Component window, @NonNull String event) {

		if(window instanceof AbstractWindow) {

			AbstractWindow com = (AbstractWindow) window;
			com.fireWindowContentChange(event, new HashMap<>());
		}
	}

	public static void next(@NonNull Component window, @NonNull String event, @NonNull Map<String, String> map) {

		if(window instanceof AbstractWindow) {

			AbstractWindow com = (AbstractWindow) window;
			com.fireWindowContentChange(event, map);
		}
	}
}
