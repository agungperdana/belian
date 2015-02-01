/**
 * 
 */
package com.kratonsolution.belian.general.view;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.kratonsolution.belian.general.dm.PartyRelationshipTypeRepository;

/**
 * @author agungdodiperdana
 *
 */
@Component
public class PartyRelationshipTypeEditor extends PropertyEditorSupport
{
	@Autowired
	private PartyRelationshipTypeRepository repository;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException
	{
		if(!Strings.isNullOrEmpty(text))
			setValue(repository.findOne(text));
	}
}
