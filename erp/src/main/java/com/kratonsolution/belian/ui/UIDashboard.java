package com.kratonsolution.belian.ui;

import com.kratonsolution.belian.ui.nav.FishEyes;
import org.zkoss.zul.*;

import com.kratonsolution.belian.ui.nav.BMenuBar;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 * @version 1.0.0
 */
public class UIDashboard extends Borderlayout
{
	private North north = new North();
	
	private Center center = new Center();

	private South south = new South();
	
	public UIDashboard()
	{
		setHflex("1");
		setVflex("1");
		setSclass("frmaedisplay");
		
		appendChild(north);
		appendChild(center);
		appendChild(south);
		
		north.setBorder("none");
		center.setBorder("none");
		south.setBorder("none");
		
		north.appendChild(new BMenuBar());

		FishEyes fishEyes = new FishEyes();

		south.appendChild(fishEyes);
		south.setHflex("1");
	}
}
