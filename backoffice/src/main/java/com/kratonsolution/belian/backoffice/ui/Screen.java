package com.kratonsolution.belian.backoffice.ui;

import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.backoffice.ui.menu.TopMenuBar;
import com.kratonsolution.belian.common.ui.AbstractScreen;
import com.kratonsolution.belian.common.ui.Fisheyes;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Screen extends AbstractScreen {

	private static final long serialVersionUID = 1L;

	private Vlayout midle = new Vlayout();

	private TopMenuBar menubar = new TopMenuBar();

	private Fisheyes fisheyes = new Fisheyes();

	public Screen() {

		setSclass("frmaedisplay");
		setWidth("99%");
		setHeight("99%");
		setAlign("center");
		setPack("center");
	}
	
	public void init() {
		
		initTop();
		initMiddle();
		initFisheye();
	}

	private void initTop() {

		appendChild(menubar);
	}

	private void initMiddle() {

		midle.setVflex("1");
		midle.setHflex("1");
		appendChild(midle);
	}

	private void initFisheye() {

		fisheyes.appendChild(new Launcher());
		fisheyes.insertSpace(true);
		
		appendChild(fisheyes);
	}

	@Override
	public Fisheyes getFisheye() {

		return this.fisheyes;
	}
}
