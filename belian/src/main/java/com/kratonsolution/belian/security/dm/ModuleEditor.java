/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;

/**
 * @author agungdodiperdana
 *
 */
@Component
public class ModuleEditor extends PropertyEditorSupport
{
	@Autowired
	private ModuleRepository repository;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException
	{
		if(!Strings.isNullOrEmpty(text))
			setValue(repository.findOne(text));
	}
}
