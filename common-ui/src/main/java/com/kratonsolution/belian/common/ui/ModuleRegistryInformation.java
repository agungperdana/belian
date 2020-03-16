package com.kratonsolution.belian.common.ui;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
public class ModuleRegistryInformation {

	public String name;

	public String fisheyeImage;

	public String launcherImage;
	
	public String nickName;

	@Override
	public boolean equals(Object obj) {

		if(obj == null || !(obj instanceof ModuleRegistryInformation) || name == null)
			return false;

		ModuleRegistryInformation info = (ModuleRegistryInformation)obj;
		return info.getName().equals(this.name);
	}

	@Override
	public String toString() {
		return this.name;
	}
}