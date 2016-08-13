/**
 * 
 */
package com.kratonsolution.belian.common;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private SessionUtils utils;

	public String get(String name)
	{
		String lang = "in_id";
		if(!Strings.isNullOrEmpty(utils.getLanguage()))
			lang = utils.getLanguage();
		
		log.debug("Lang "+lang+" key:"+name);
		
		Locale locale = new Locale(lang);
		log.debug("###"+locale.getLanguage());
		log.debug("###"+locale.getCountry());
		
		return messageSource.getMessage(name,new Object[]{},locale);
	}
}
