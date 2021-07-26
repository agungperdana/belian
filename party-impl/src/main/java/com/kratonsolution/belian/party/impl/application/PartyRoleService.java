
package com.kratonsolution.belian.party.impl.application;

import com.kratonsolution.belian.party.api.application.PartyUpdateCommand;
import com.kratonsolution.belian.party.impl.model.Party;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class PartyRoleService {

	public static void update(@NonNull PartyUpdateCommand command, @NonNull Party party) {

//		party.getPartyRoles()
//			.stream()
//			.filter(p->!command.getPartyRoles()
//								.stream()
//								.filter(com->com.getId().equals(p.getId()))
//								.findFirst().isPresent())
//			.collect(Collectors.toList())
//			.forEach(ob->party.removePartyRole(ob.getId()));
//		
//		command.getPartyRoles().forEach(rol -> {
//
//			PartyRole role = party.updatePartyRole(rol.getId());
//			if(role == null) {
//				role = party.createPartyRole(rol.getStart(), rol.getType());
//			}
//
//			role.setEnd(rol.getEnd());
//		});
	}
}
