package com.kratonsolution.belian.party.impl.application;

import java.util.stream.Collectors;

import com.kratonsolution.belian.party.api.application.PartyUpdateCommand;
import com.kratonsolution.belian.party.impl.model.Party;
import com.kratonsolution.belian.party.impl.model.PartyRelationship;
import com.kratonsolution.belian.party.impl.repository.PartyRepository;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class PartyRelationshipService {

	public static void update(@NonNull PartyRepository repo , @NonNull PartyUpdateCommand command, @NonNull Party party) {

//		party.getPartyRelationships()
//			.stream()
//			.filter(p->!command.getPartyRelationships()
//							.stream()
//							.filter(com->com.getId().equals(p.getId()))
//							.findFirst()
//							.isPresent())
//			.collect(Collectors.toList())
//			.forEach(ob->party.removePartyRelationship(ob.getId()));
//		
//
//		command.getPartyRelationships().forEach(rel -> {
//
//			PartyRelationship relation = party.updatePartyRelationship(rel.getId());
//			if(relation == null) {
//				relation = party.createPartyRelationship(repo.findOneByCode(rel.getToPartyCode()),
//						rel.getStart(), rel.getType());
//			}
//
//			relation.setEnd(rel.getEnd());
//		});
	}
}
