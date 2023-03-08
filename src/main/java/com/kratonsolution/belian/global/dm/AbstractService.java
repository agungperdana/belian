/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import org.springframework.beans.factory.annotation.Autowired;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.global.svc.NumberGenerator;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class AbstractService
{
	@Autowired
	protected SessionUtils utils;
	
	@Autowired
	protected Language lang;
	
	@Autowired
	protected NumberGenerator gen;
}
