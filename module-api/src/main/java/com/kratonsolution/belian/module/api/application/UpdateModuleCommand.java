package com.kratonsolution.belian.module.api.application;

import com.kratonsolution.belian.common.core.UpdateCommand;
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
public class UpdateModuleCommand implements UpdateCommand {

	@NonNull
    private String code;
    
    private String name;
    
    private String group;
    
    private String note;
    
    private Boolean enabled;
}
