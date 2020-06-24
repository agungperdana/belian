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
public class ContentEvent extends Event {

	private static final long serialVersionUID = 6718613562487127926L;

	public static String GRID = "GRID";
	
	public static String ADD_FORM = "ADD_FORM";
	
	public static String EDIT_FORM = "EDIT_FORM";
	
	public static String OTHER = "OTHER";
	
	public static String NAME = "WINDOW_CONTENT_CHANGE_EVENT";
	
	public static String OPEN_WINDOW = "OPEN WINDOW";
	
	@Getter
	private String type;
	
	private Map<String, Object> parameter = new HashMap<>();
	
	public ContentEvent(String type) {

		super(NAME);
		this.type = type;
	}
	
	public Object get(@NonNull String key) {
		return parameter.get(key);
	}
	
	public void put(@NonNull String key, Object value) {
		parameter.put(key, value);
	}
}
