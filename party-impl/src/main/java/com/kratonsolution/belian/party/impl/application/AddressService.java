package com.kratonsolution.belian.party.impl.application;

import java.util.stream.Collectors;

import com.kratonsolution.belian.party.api.application.PartyUpdateCommand;
import com.kratonsolution.belian.party.impl.model.Address;
import com.kratonsolution.belian.party.impl.model.Party;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class AddressService {

	public static void update(@NonNull PartyUpdateCommand command, @NonNull Party party) {

//		party.getAddresses()
//			.stream()
//			.filter(p->!command.getAddresses()
//							.stream()
//							.filter(com->com.getId().equals(p.getId())).findFirst().isPresent())
//			.collect(Collectors.toList())
//			.forEach(del->party.removeAddress(del.getId()));
//		
//		command.getAddresses().forEach(add -> {
//
//			Address address = party.updateAddress(add.getId());
//			if(address == null) {
//
//				address = party.createAddress(add.getDescription(),
//						add.getType(), add.getLocation().getCode(), add.getLocation().getName());
//			}
//
//			address.setActive(add.isActive());
//			address.setPostal(add.getPostal());
//		});
	}
}
