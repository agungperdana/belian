package com.kratonsolution.belian.partys.ui.partyrelationship;

import java.util.Set;

import org.zkoss.zul.ListModelSet;

import com.kratonsolution.belian.party.api.PartyRelationshipData;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class PartyRelationshipModel extends ListModelSet<PartyRelationshipData> {

	private static final long serialVersionUID = 7537643272017903797L;

	private PartyRelationshipModel(@NonNull Set<PartyRelationshipData> data) {
		super(data, true);
	}
	
	public static PartyRelationshipModel build(@NonNull Set<PartyRelationshipData> data) {
		return new PartyRelationshipModel(data);
	}
}
