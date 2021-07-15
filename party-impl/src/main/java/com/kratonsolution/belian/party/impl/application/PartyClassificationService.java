package com.kratonsolution.belian.party.impl.application;

import java.util.stream.Collectors;

import com.kratonsolution.belian.party.api.application.PartyUpdateCommand;
import com.kratonsolution.belian.party.impl.model.Party;
import com.kratonsolution.belian.party.impl.model.PartyClassification;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class PartyClassificationService {

	public static void update(@NonNull PartyUpdateCommand command, @NonNull Party party) {

//		party.getPartyClassifications()
//			.stream()
//			.filter(p->!command.getPartyClassifications()
//							.stream()
//							.filter(com->com.getId().equals(p.getId()))
//							.findFirst()
//							.isPresent())
//			.collect(Collectors.toList())
//			.forEach(ob->party.removePartyClassification(ob.getId()));
//		
//		command.getPartyClassifications().forEach(fica -> {
//
//			PartyClassification classification = party.updatePartyClassification(fica.getId());
//			if(classification == null) {
//				classification = party.createPartyClassification(fica.getStart(), fica.getValue(), fica.getType());
//			}
//
//			classification.setEnd(fica.getEnd());
//		});
	}
}