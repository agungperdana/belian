package com.kratonsolution.belian.common.app;

import java.util.Locale;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
public class Language
{
	private MessageSource messageSource;

	public String get(String name)
	{
		Locale locale = new Locale("in_id");
		
		return messageSource.getMessage(name,new Object[]{},locale);
	}
}
