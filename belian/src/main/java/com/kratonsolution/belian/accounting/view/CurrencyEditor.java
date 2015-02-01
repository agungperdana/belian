/**
 * 
 */
package com.kratonsolution.belian.accounting.view;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.CurrencyRepository;

/**
 * @author agungdodiperdana
 *
 */
@Component
public class CurrencyEditor extends PropertyEditorSupport
{
	@Autowired
	private CurrencyRepository currencyRepository;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException
	{
		if(!Strings.isNullOrEmpty(text))
			setValue(currencyRepository.findOne(text));
	}
}
