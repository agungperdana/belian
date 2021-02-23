package com.kratonsolution.belian.partys.ui.physicalcharacteristic;

import java.util.Set;

import org.zkoss.zul.ListModelSet;

import com.kratonsolution.belian.party.api.PhysicalCharacteristicData;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class PhysicalCharacteristicModel extends ListModelSet<PhysicalCharacteristicData> {

	private static final long serialVersionUID = 7537643272017903797L;

	private PhysicalCharacteristicModel(@NonNull Set<PhysicalCharacteristicData> data) {
		super(data, true);
	}
	
	public static PhysicalCharacteristicModel build(@NonNull Set<PhysicalCharacteristicData> data) {
		return new PhysicalCharacteristicModel(data);
	}
}
