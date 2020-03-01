package com.kratonsolution.belian.api.security;

import com.kratonsolution.belian.common.application.EventType;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
public class RoleEvent {
    
    private String code;
    
    private EventType type;
    
    RoleEvent() {
    }
    
    public RoleEvent(@NonNull String code, @NonNull EventType type) {
        
        this.code = code;
        this.type = type;
    }

	public String getCode() {
		return code;
	}

	public EventType getType() {
		return type;
	}
}
