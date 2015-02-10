/**
 * 
 */
package com.kratonsolution.belian.ui.util;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zk.ui.WebApps;

/**
 * @author agungdodiperdana
 *
 */
public class Springs
{
	public static final <T> T get(Class<T> classType)
	{
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(WebApps.getCurrent().getServletContext());
		return context.getBean(classType);
	}
}
