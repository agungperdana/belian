package com.kratonsolution.belian.access.module.api.application;

import java.io.Serializable;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0.0
 */
@Getter
@Setter
public class ModuleFilter implements Serializable {
 
    private static final long serialVersionUID = 7878294784897732945L;

    private String key;
    
    @NonNull
    private Integer page = 0;
    
    @NonNull
    private Integer size = 50;
	
}
