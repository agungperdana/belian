package com.kratonsolution.belian.partys.ui.address;

import java.util.Set;

import org.zkoss.zul.ListModelSet;

import com.kratonsolution.belian.party.api.AddressData;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class AddressModel extends ListModelSet<AddressData> {

	private static final long serialVersionUID = 7537643272017903797L;

	private AddressModel(@NonNull Set<AddressData> data) {
		super(data, true);
	}
	
	public static AddressModel build(@NonNull Set<AddressData> data) {
		return new AddressModel(data);
	}
}
