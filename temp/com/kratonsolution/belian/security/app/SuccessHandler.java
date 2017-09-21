/**
 * 
 */
package com.kratonsolution.belian.security.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.LiteDeviceResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.common.SessionUtils;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
public class SuccessHandler implements AuthenticationSuccessHandler
{
	@Autowired
	private SessionUtils utils;

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.AuthenticationSuccessHandler#onAuthenticationSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication auth)
			throws IOException, ServletException
	{
		LiteDeviceResolver resolver = new LiteDeviceResolver();
		Device device = resolver.resolveDevice(request);
	
		String flag = "NORMAL";
		
		if(device.isMobile())
			flag = "MOBILE";
		
		if(device.isTablet())
			flag = "TABLET";
		
		HttpSession session = request.getSession();
		session.setAttribute("device", flag);
		
		response.sendRedirect("/svc/home");
	}

}
