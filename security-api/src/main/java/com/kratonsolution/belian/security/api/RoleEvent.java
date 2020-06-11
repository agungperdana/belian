package com.kratonsolution.belian.security.api;

import com.kratonsolution.belian.common.application.EventType;

import lombok.Getter;
import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0
 */
@Getter
public class RoleEvent {
    
    private RoleData data;
    
    private EventType type;
    
    RoleEvent() {
    }
    
    public RoleEvent(@NonNull RoleData data, @NonNull EventType type) {
        
        this.data = data;
        this.type = type;
    }
    
    public static RoleEvent newRole(@NonNull RoleData data) {
    	
    	return new RoleEvent(data, EventType.ADD);
    }
}
