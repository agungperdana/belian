package com.kratonsolution.belian.security.api;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Getter
@Setter
public class UserFilter {
    
    @NonNull
    private String key;
}
