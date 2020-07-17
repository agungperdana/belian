package com.kratonsolution.belian.party.impl.application;

import java.util.stream.Collectors;

import com.kratonsolution.belian.party.api.application.PartyUpdateCommand;
import com.kratonsolution.belian.party.impl.model.Citizenship;
import com.kratonsolution.belian.party.impl.model.Party;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class CitizenshipService {

	public static void update(@NonNull PartyUpdateCommand command, @NonNull Party party) {

		//citizhenship
		party.getCitizenships()
		.stream()
		.filter(p->!command.getCitizenships()
				.stream()
				.filter(ob->ob.getId().equals(p.getId())).findFirst().isPresent())
		.collect(Collectors.toList())
		.forEach(rem->party.removeCitizenship(rem.getId()));

		command.getCitizenships().forEach(cit -> {

			Citizenship ob = party.updateCitizenship(cit.getId());
			if(ob == null) {
				ob = party.createCitizenship(cit.getStart(), cit.getEnd(), cit.getCountry().getCode(), cit.getCountry().getName());
			}

			ob.setEnd(cit.getEnd());
			ob.setPassportExpiredDate(cit.getPassportExpiredDate());
			ob.setPassportIssuedDate(cit.getPassportIssuedDate());
			ob.setPassportNumber(cit.getPassportNumber());
		});
	}
}
