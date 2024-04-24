
package com.kratonsolution.belian.common;

import java.util.Locale;

import lombok.AllArgsConstructor;
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
	private MessageSource messageSource;

	public Language(MessageSource messageSource)
	{
		this.messageSource = messageSource;
	}

	public String get(String name)
	{
		Locale locale = new Locale("in_id");
		
		return messageSource.getMessage(name,new Object[]{},locale);
	}
}
