package com.kratonsolution.belian.access.role.api;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Getter
@Setter
public class RoleData implements RoleEntity {
    
    private static final long serialVersionUID = -4075374676161919723L;

    private String id;

	@NonNull
    private String code;
    
    @NonNull
    private String name;
    
    private String note;
    
    private boolean enabled;
}
