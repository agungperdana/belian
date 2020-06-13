package com.kratonsolution.belian.backoffice.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kratonsolution.belian.common.ui.ModuleRegistryInformation;

import lombok.Getter;
import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Service
public class ModuleRegistry {

	@Getter
	private List<ModuleRegistryInformation> registyrs = new ArrayList<>();
	
	public void registerModule(@NonNull ModuleRegistryInformation information) {
		
		if(!registyrs.contains(information)) {
			registyrs.add(information);
		}

		Collections.sort(registyrs, new Comparator<ModuleRegistryInformation>() {

			@Override
			public int compare(ModuleRegistryInformation o1, ModuleRegistryInformation o2) {

				if(o1.getPosition() < o2.getPosition()) {
					return -1;
				}
				else if(o1.getPosition() > o2.getPosition()) {
					return 1;
				}
				
				return 0;
			}
		});
	}
}
