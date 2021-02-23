package com.kratonsolution.belian.partys.ui.partyrole;

import java.util.Set;

import org.zkoss.zul.ListModelSet;

import com.kratonsolution.belian.party.api.PartyRoleData;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class PartyRoleModel extends ListModelSet<PartyRoleData> {

	private static final long serialVersionUID = 7537643272017903797L;

	private PartyRoleModel(@NonNull Set<PartyRoleData> data) {
		super(data, true);
	}
	
	public static PartyRoleModel build(@NonNull Set<PartyRoleData> data) {
		return new PartyRoleModel(data);
	}
}
