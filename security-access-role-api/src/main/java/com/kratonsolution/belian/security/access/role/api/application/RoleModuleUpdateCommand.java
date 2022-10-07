package com.kratonsolution.belian.security.access.role.api.application;

import lombok.*;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleModuleUpdateCommand {

	@NonNull
    private String name;

    private boolean read;
    
    private boolean add;
    
    private boolean edit;
    
    private boolean delete;
    
    private boolean print;
}
