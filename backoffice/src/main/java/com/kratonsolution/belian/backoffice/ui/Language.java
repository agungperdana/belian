package com.kratonsolution.belian.backoffice.ui;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
public class Language
{
	@Autowired
	private MessageSource messageSource;

	public String get(@NonNull String name) {
		
		String lang = "en_US";
		Locale locale = new Locale(lang);
		
		return messageSource.getMessage(name,new Object[]{},locale);
	}
}
