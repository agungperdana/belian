/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Caption;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Window;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PrintWindow extends Window
{
	private Caption caption = new Caption();
	
	private Iframe iframe = new Iframe();
	
	public PrintWindow(String printsource)
	{
		setMode(Mode.HIGHLIGHTED);
		setClosable(true);
		setWidth("750px");
		setHeight("450px");
		
		iframe.setWidth("100%");
		iframe.setHeight("100%");
		iframe.setSrc(printsource);
		
		appendChild(caption);
		appendChild(iframe);
	}
}
