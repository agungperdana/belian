package com.kratonsolution.belian.party.impl.application;

import java.util.stream.Collectors;

import com.kratonsolution.belian.party.api.application.PartyUpdateCommand;
import com.kratonsolution.belian.party.impl.model.Contact;
import com.kratonsolution.belian.party.impl.model.Party;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class ContactService {

	public static void update(@NonNull PartyUpdateCommand command, @NonNull Party party) {

		party.getContacts()
			.stream()
			.filter(p->!command.getContacts().
					stream().filter(com->com.getId().equals(p.getId())).findFirst().isPresent())
			.collect(Collectors.toList())
			.forEach(ob->party.removeContact(ob.getId()));
		
		command.getContacts().forEach(con -> {

			Contact contact = party.updateContact(con.getId());
			if(contact == null) {
				contact = party.createContact(con.getContact(), con.getType());
			}

			contact.setActive(con.isActive());
		});
	}
}
