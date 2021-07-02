package com.kratonsolution.belian.access.api;

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
public class UserFilter implements Serializable {
    
    private static final long serialVersionUID = -3290749183343753209L;
    
	@NonNull
    private String key;
	
	UserFilter() {
	}
	
	public UserFilter(@NonNull String key) {
		this.key = key;
	}
	
	public static UserFilter forKey(@NonNull String key) {
		return new UserFilter(key);
	}
	
	public String getLikeKey() {
		return "%"+key+"%";
	}
}
