package com.kratonsolution.belian.security.api.application;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Getter
@Setter
public class RoleModuleUpdateCommand {
	
	private String moduleCode;
	private boolean read;
	private boolean add;
	private boolean edit;
	private boolean delete;
	private boolean print;
}
