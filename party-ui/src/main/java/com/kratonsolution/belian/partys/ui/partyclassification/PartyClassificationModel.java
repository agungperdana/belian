package com.kratonsolution.belian.partys.ui.partyclassification;

import java.util.Set;

import org.zkoss.zul.ListModelSet;

import com.kratonsolution.belian.party.api.PartyClassificationData;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class PartyClassificationModel extends ListModelSet<PartyClassificationData> {

	private static final long serialVersionUID = 7537643272017903797L;

	private PartyClassificationModel(@NonNull Set<PartyClassificationData> data) {
		super(data, true);
	}
	
	public static PartyClassificationModel build(@NonNull Set<PartyClassificationData> data) {
		return new PartyClassificationModel(data);
	}
}
