package com.kratonsolution.belian.access.api;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0.0
 */
@Getter
@Setter
public class UserFilter implements Serializable {
    
    private static final long serialVersionUID = -3290749183343753209L;
    
    private String key;
	
	private Integer page = 0;
	
	private Integer size = 50;
	
	public String getLikeKey() {
		return "%"+key+"%";
	}
}
