package com.kratonsolution.belian.security.api.application;

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
public class ModuleDeleteCommand implements Serializable {
    
    private static final long serialVersionUID = 7831995735295663929L;
    
	@NonNull
    private String code;    
}
