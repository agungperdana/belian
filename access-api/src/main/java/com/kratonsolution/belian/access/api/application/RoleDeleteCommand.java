package com.kratonsolution.belian.access.api.application;

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
public class RoleDeleteCommand implements Serializable {
    
    private static final long serialVersionUID = 6498906019136983477L;
    
	@NonNull
    private String code;    
}
