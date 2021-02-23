package com.kratonsolution.belian.partys.ui.maritalstatus;

import java.util.Set;

import org.zkoss.zul.ListModelSet;

import com.kratonsolution.belian.party.api.MaritalStatusData;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class MaritalStatusModel extends ListModelSet<MaritalStatusData> {

	private static final long serialVersionUID = 7537643272017903797L;

	private MaritalStatusModel(@NonNull Set<MaritalStatusData> data) {
		super(data, true);
	}
	
	public static MaritalStatusModel build(@NonNull Set<MaritalStatusData> data) {
		return new MaritalStatusModel(data);
	}
}
