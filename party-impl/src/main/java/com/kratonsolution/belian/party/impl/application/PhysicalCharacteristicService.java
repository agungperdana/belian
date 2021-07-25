package com.kratonsolution.belian.party.impl.application;

import java.util.stream.Collectors;

import com.kratonsolution.belian.party.api.application.PartyUpdateCommand;
import com.kratonsolution.belian.party.impl.model.Party;
import com.kratonsolution.belian.party.impl.model.PhysicalCharacteristic;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class PhysicalCharacteristicService {
	
	public static void update(@NonNull PartyUpdateCommand command, @NonNull Party party) {
		
		//Physical Characteristic
//				party.getPhysicalCharacteristics()
//					.stream()
//					.filter(p->!command.getPhysicalCharacteristics()
//									.stream()
//									.filter(cat->cat.getId().equals(p.getId())).findFirst().isPresent())
//					.collect(Collectors.toList())
//					.forEach(rem->party.removePhysicalCharacteristic(rem.getId()));
//				
//				command.getPhysicalCharacteristics().forEach(car -> {
//					
//					PhysicalCharacteristic cat = party.updatePhysicalCharacteristic(car.getId());
//					if(cat == null) {
//						cat = party.createPhysicalCharacteristic(car.getStart(), car.getEnd(), car.getValue(), car.getType());
//					}
//					
//					cat.setEnd(car.getEnd());
//					cat.setValue(car.getValue());
//				});
	}
}
