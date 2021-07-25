package com.kratonsolution.belian.common.ui.event;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.event.Event;

import lombok.Getter;
import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
public class UIEvent extends Event {

	private static final long serialVersionUID = 6718613562487127926L;

	public static String GRID = "GRID";
	
	public static String ADD_FORM = "ADD_FORM";
	
	public static String EDIT_FORM = "EDIT_FORM";
	
	public static String OTHER = "OTHER";
	
	@Getter
	private String type = GRID;
	
	private Map<String, Object> parameter = new HashMap<>();
	
	public UIEvent(@NonNull String type) {
		this(UIEvent.class.getName(), type);
	}
	
	public UIEvent(@NonNull String name, @NonNull String type) {
		super(name);
		this.type = type;
	}
	
	public Object get(@NonNull String key) {
		return parameter.get(key);
	}
	
	public void put(@NonNull String key, Object value) {
		parameter.put(key, value);
	}
}
