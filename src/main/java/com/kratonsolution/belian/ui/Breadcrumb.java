
package com.kratonsolution.belian.ui;

import org.zkoss.zul.A;
import org.zkoss.zul.Hbox;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Breadcrumb extends Hbox
{
	public Breadcrumb()
	{
		setHflex("1");
		setHeight("18px");
		setPack("start");
		setAlign("center");
		setStyle("font-weight:bolder;font-size:8px;background-color:#F7F9F9;padding:5px;");
		
		A a = new A();
		a.setIconSclass("z-icon-info-circle");
		
		appendChild(a);
	}
}
