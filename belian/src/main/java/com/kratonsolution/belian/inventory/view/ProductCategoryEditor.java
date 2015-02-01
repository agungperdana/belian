/**
 * 
 */
package com.kratonsolution.belian.inventory.view;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.kratonsolution.belian.inventory.dm.ProductCategoryRepository;

/**
 * @author agungdodiperdana
 *
 */
@Component
public class ProductCategoryEditor extends PropertyEditorSupport
{
	@Autowired
	private ProductCategoryRepository repository;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException
	{
		if(!Strings.isNullOrEmpty(text))
			setValue(repository.findOne(text));
	}
}
