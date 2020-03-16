package com.kratonsolution.belian.backoffice.application;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.kratonsolution.belian.common.ui.ModuleRegistryInformation;

import lombok.Getter;
import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
public class ModuleRegistry {

	@Getter
	private Set<ModuleRegistryInformation> registyrs = new HashSet<>();
	
	public void registerModule(@NonNull ModuleRegistryInformation information) {
		
		if(!registyrs.contains(information)) {
			registyrs.add(information);
		}
	}
}
