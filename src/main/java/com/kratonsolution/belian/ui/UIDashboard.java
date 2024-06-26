
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.North;

import com.kratonsolution.belian.ui.nav.BMenuBar;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class UIDashboard extends Borderlayout
{
	private North north = new North();
	
	private Center center = new Center();
	
	public UIDashboard()
	{
		setHflex("1");
		setVflex("1");
		setSclass("frmaedisplay");
		
		appendChild(north);
		appendChild(center);
		
		north.setBorder("none");
		center.setBorder("none");
		
		north.appendChild(new BMenuBar());
	}
}
