package com.kratonsolution.belian.party.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.party.api.ContactData;
import com.kratonsolution.belian.party.impl.model.Contact;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface ContactMapper {
    
	ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);
	
    ContactData toData(@NonNull Contact contact);
    
    List<ContactData> toDatas(@NonNull List<Contact> contacts);
}
