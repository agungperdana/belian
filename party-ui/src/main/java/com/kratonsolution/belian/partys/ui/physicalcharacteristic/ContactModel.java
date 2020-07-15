package com.kratonsolution.belian.partys.ui.physicalcharacteristic;

import java.util.Set;

import org.zkoss.zul.ListModelSet;

import com.kratonsolution.belian.party.api.ContactData;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class ContactModel extends ListModelSet<ContactData> {

	private static final long serialVersionUID = 7537643272017903797L;

	private ContactModel(@NonNull Set<ContactData> data) {
		super(data, true);
	}
	
	public static ContactModel build(@NonNull Set<ContactData> data) {
		return new ContactModel(data);
	}
}
