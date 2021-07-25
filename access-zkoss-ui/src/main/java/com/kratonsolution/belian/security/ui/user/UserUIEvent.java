package com.kratonsolution.belian.security.ui.user;

import com.kratonsolution.belian.common.ui.event.UIEvent;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class UserUIEvent extends UIEvent {

	private static final long serialVersionUID = 4510223896199093865L;
	
	@Getter
	@Setter
	private String username;
	
	public UserUIEvent(@NonNull String type) {
		super(type);
	}
	
	public UserUIEvent(@NonNull String username, @NonNull String type) {
		super(type);
		this.username = username;
	}
	
	public static UserUIEvent toGrid() {
		return new UserUIEvent(UIEvent.GRID);
	}
	
	public static UserUIEvent newForm() {
		return new UserUIEvent(UIEvent.ADD_FORM);
	}
	
	public static UserUIEvent editForm(@NonNull String username) {
		
		UserUIEvent ev = new UserUIEvent(UIEvent.EDIT_FORM);
		ev.setUsername(username);
		
		return ev;
	}
}
