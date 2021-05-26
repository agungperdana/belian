package com.kratonsolution.belian.security.api.application;

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
public class UserDeleteCommand implements Serializable {
    
    private static final long serialVersionUID = 8873326380098895541L;
    
	@NonNull
    private String name;
}
