package com.kratonsolution.belian.module.api.application;

import com.kratonsolution.belian.common.core.DeleteCommand;
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
public class DeleteModuleCommand implements DeleteCommand {

	@NonNull
    private String code;    
}
