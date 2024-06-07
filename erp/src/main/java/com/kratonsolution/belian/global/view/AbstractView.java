
package com.kratonsolution.belian.global.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.kratonsolution.belian.common.app.Language;
import com.kratonsolution.belian.common.SessionUtils;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class AbstractView
{
	@Autowired
	protected SessionUtils utils;
	
	@Autowired
	protected Language lang;
}
