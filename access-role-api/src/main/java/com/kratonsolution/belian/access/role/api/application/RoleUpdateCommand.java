package com.kratonsolution.belian.access.role.api.application;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
public class RoleUpdateCommand {
 
    private static final long serialVersionUID = 4915477311846745294L;

	@NonNull
    private String code;

    private String note;
    
    private boolean enabled;
}
