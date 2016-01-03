/**
 * 
 */
package com.kratonsolution.belian.global.svc;

import org.springframework.beans.factory.annotation.Autowired;

import com.kratonsolution.belian.common.SessionUtils;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SessionAware
{
	@Autowired
	protected SessionUtils utils;
}
