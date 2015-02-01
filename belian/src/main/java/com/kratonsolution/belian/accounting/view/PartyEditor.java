/**
 * 
 */
package com.kratonsolution.belian.accounting.view;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.kratonsolution.belian.general.dm.PartyRepository;

/**
 * @author agungdodiperdana
 *
 */
@Component
public class PartyEditor extends PropertyEditorSupport
{
	@Autowired
	private PartyRepository party;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException
	{
		if(!Strings.isNullOrEmpty(text))
			setValue(party.findOne(text));
	}
}
