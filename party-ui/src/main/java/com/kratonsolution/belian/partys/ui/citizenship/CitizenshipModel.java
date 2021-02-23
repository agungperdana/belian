package com.kratonsolution.belian.partys.ui.citizenship;

import java.util.Set;

import org.zkoss.zul.ListModelSet;

import com.kratonsolution.belian.party.api.CitizenshipData;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class CitizenshipModel extends ListModelSet<CitizenshipData> {

	private static final long serialVersionUID = 7537643272017903797L;

	private CitizenshipModel(@NonNull Set<CitizenshipData> data) {
		super(data, true);
	}
	
	public static CitizenshipModel build(@NonNull Set<CitizenshipData> data) {
		return new CitizenshipModel(data);
	}
}
