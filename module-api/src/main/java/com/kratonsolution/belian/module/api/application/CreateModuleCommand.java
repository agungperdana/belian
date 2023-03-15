package com.kratonsolution.belian.module.api.application;

import com.kratonsolution.belian.common.core.CreateCommand;
import lombok.Data;
import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0.0
 */
@Data
public class CreateModuleCommand implements CreateCommand {
    
	private static final long serialVersionUID = 6526962330287609499L;

	@NonNull
    private String code;
    
	@NonNull
    private String name;
    
    private String note;
    
    @NonNull
    private String group;
    
    private boolean enabled;
}
