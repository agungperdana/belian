package com.kratonsolution.belian.backoffice.ui;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.backoffice.ui.window.LauncherWindow;
import com.kratonsolution.belian.common.ui.ApplicationModule;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Launcher implements ApplicationModule {

	private LauncherWindow window;
	
	private Toolbarbutton remote;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "com.kratonsolution.belian.module.applicationlauncher";
	}

	@Override
	public String getFisheyesImage() {
		// TODO Auto-generated method stub
		return "/images/fisheye/launcher.png";
	}

	@Override
	public void open() {

		if(window == null) {
			
			window = new LauncherWindow();
		}

		window.setPage(Executions.getCurrent().getDesktop().getFirstPage());
		window.doOverlapped();
	}

	@Override
	public void close() {
		
		window.setVisible(false);
		window.setPage(null);
		window.detach();
	}

	public Toolbarbutton getFisheyeButton() {
		
		if(remote == null) {
			
			remote = new Toolbarbutton();
			remote.setImage(getFisheyesImage());
		}
		
		remote.addEventListener(Events.ON_CLICK, click -> {
			
			if(window == null || !window.isVisible()) {
				open();
			}
			else {
				close();
			}

		});
		
		return remote;
	}

	@Override
	public String getRegistryImage() {
		// TODO Auto-generated method stub
		return "/images/registry/launcher.png";
	}
}
