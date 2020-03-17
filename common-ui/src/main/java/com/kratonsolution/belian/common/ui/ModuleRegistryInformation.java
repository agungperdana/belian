package com.kratonsolution.belian.common.ui;

import java.net.URL;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
public class ModuleRegistryInformation {

	private String name;

	private URL fisheyeImage;

	private URL launcherImage;
	
	private String nickName;

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
