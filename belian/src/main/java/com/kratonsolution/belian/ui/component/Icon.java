/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Vbox;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Icon extends Vbox
{
	private Image image = new Image();
	
	private Label label = new Label();
	
	public Icon()
	{
		this("","");
	}
	
	public Icon(String title,String icon)
	{
		image.setSrc(icon);
		image.setWidth("100%");
		image.setVflex("1");
		
		label.setValue(title);
		label.setWidth("100%");
		label.setStyle("align:right");
		
		setWidth("70px");
		setHeight("70px");
		setSpacing("0px");
		setAlign("center");
		setPack("center");
		
		appendChild(image);
		appendChild(label);
	}
}
