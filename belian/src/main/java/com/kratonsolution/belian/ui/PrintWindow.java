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
	
	public PrintWindow(String printsource,boolean isPos)
	{
		setMode(Mode.HIGHLIGHTED);
		setClosable(true);
		
		if(isPos)
		{
			setWidth("250px");
			setHeight("500px");
			iframe.setWidth("250px");
			iframe.setHeight("500px");
		}
		else
		{
			setWidth("700px");
			setHeight("500px");
			iframe.setWidth("700px");
			iframe.setHeight("500px");
		}
	
		iframe.setSrc(printsource);
		
		appendChild(caption);
		appendChild(iframe);
	}
}
