/**
 * 
 */
package com.kratonsolution.belian.common;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
public class Language
{
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private SessionUtils utils;

	public String get(String name)
	{
		if(messageSource != null && utils != null && !Strings.isNullOrEmpty(utils.getLanguage()))
			return messageSource.getMessage(name,new Object[]{},new Locale(utils.getLanguage()));
		
		return "";
	}
}
