package com.kratonsolution.belian.common.application;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Getter
@Setter
public class ModelEvent {
    
    private String target;
    
    private EventType type;
    
    private Map<String, Object> payload = new HashMap<>();
    
    public ModelEvent(@NonNull String target, @NonNull EventType type) {
        
        this.target = target;
        this.type = type;
    }
}
