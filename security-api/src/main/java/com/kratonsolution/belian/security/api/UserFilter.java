package com.kratonsolution.belian.security.api;

import java.io.Serializable;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Getter
@Setter
public class UserFilter implements Serializable {
    
    private static final long serialVersionUID = -3290749183343753209L;
    
	@NonNull
    private String key;
}
