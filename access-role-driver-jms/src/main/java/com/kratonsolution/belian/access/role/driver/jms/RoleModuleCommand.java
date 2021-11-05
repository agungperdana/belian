package com.kratonsolution.belian.access.role.driver.jms;

import java.io.Serializable;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0
 */
@Getter
@Setter
public class RoleModuleCommand implements Serializable {
    
    private static final long serialVersionUID = 8553708770251142638L;

	@NonNull
    private String moduleCode;
    
    @NonNull
    private String moduleName;
    
    private String moduleGroup;
    
    private boolean read;
    
    private boolean add;
    
    private boolean edit;
    
    private boolean delete;
    
    private boolean print;
}
