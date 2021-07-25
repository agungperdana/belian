package com.kratonsolution.belian.common.ui;

import java.net.URL;

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
public class ModuleRegistryInformation {

	private int position = 1000;
	
	@NonNull
	private String name;

	@NonNull
	private URL fisheyeImage;

	@NonNull
	private URL launcherImage;
	
	@NonNull
	private String nickName;

	@Override
	public boolean equals(Object obj) {

		if(obj == null || !(obj instanceof ModuleRegistryInformation) || name == null || name.equals(""))
			return false;

		ModuleRegistryInformation info = (ModuleRegistryInformation)obj;
		return info.getName().equals(this.name);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
