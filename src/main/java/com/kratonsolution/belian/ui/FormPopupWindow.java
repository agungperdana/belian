/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Caption;
import org.zkoss.zul.Window;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FormPopupWindow extends Window
{
	public FormPopupWindow(BForm content,String title)
	{
		Caption caption = new Caption(title);
		
		content.setHflex("1");
		content.setVflex("1");
		
		setWidth("500px");
		setHeight("500px");
		setClosable(true);
		
		appendChild(caption);
		appendChild(content);
	}
}
