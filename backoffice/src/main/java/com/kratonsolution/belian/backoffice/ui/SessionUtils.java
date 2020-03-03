package com.kratonsolution.belian.backoffice.ui;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.kratonsolution.belian.backoffice.auth.SecurityInformation;


/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
public class SessionUtils
{
	public String getActiveUserName()
	{
		SecurityInformation information = (SecurityInformation)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Preconditions.checkState(information == null || information.getUser() == null, "Please login");
		return information.getUser().getName();
	}
}
