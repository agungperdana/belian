
package com.kratonsolution.belian.common;

import java.util.Locale;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@AllArgsConstructor
@Slf4j
@Service
public class Language
{
	private MessageSource messageSource;

	public String get(String name)
	{
		String lang = "in_id";
//		if(!Strings.isNullOrEmpty(utils.getLanguage()))
//			lang = utils.getLanguage();
		
		Locale locale = new Locale(lang);
		
		return messageSource.getMessage(name,new Object[]{},locale);
	}
}
