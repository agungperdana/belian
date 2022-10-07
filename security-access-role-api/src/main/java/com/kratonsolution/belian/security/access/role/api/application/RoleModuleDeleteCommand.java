package com.kratonsolution.belian.security.access.role.api.application;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0
 */
@Getter
@Setter
public class RoleModuleDeleteCommand implements Serializable {
    
    private static final long serialVersionUID = 8553708770251142638L;

    @NonNull
    private String code;

	@NonNull
    private String moduleCode;
}
