/**
 * 
 */
package com.kratonsolution.belian.general.view;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.kratonsolution.belian.general.dm.GeographicRepository;

/**
 * @author agungdodiperdana
 *
 */
@Component
public class GeographicEditor extends PropertyEditorSupport
{
	@Autowired
	private GeographicRepository geo;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException
	{
		if(!Strings.isNullOrEmpty(text))
			setValue(geo.findOne(text));
	}
}
