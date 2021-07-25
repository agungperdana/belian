package com.kratonsolution.belian.party.impl.application;

import java.util.stream.Collectors;

import com.kratonsolution.belian.party.api.application.PartyUpdateCommand;
import com.kratonsolution.belian.party.impl.model.MaritalStatus;
import com.kratonsolution.belian.party.impl.model.Party;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class MaritalStatusService {
	
	public static void update(@NonNull PartyUpdateCommand command, @NonNull Party party) {
		
		//Marital Status
		//collect all MaritalStatus not present in command.getMaritalStatus(), its mean the object removed by user.
//		party.getMaritalStatuses()
//			.stream()
//			.filter(ob->!command.getMaritalStatuses()
//								.stream()
//								.filter(m->m.getId().equals(ob.getId())).findAny().isPresent())
//			.collect(Collectors.toList())
//			.forEach(rem -> party.removeMaritalStatus(rem.getId()));
//		
//		//update object or create new
//		command.getMaritalStatuses().forEach(mar -> {
//			
//			MaritalStatus status = party.updateMaritalStatus(mar.getId());
//			if(status == null) {
//				status = party.createMaritalStatus(mar.getStart(), mar.getEnd(), mar.getType());
//			}
//			
//			status.setEnd(mar.getEnd());
//		});
	}
}
