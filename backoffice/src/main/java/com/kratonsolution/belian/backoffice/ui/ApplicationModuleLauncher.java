package com.kratonsolution.belian.backoffice.ui;

import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.common.ui.ApplicationModule;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ApplicationModuleLauncher implements ApplicationModule {

	private Window window;
	
	private Toolbarbutton remote;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "com.kratonsolution.belian.module.applicationlauncher";
	}

	@Override
	public String getFisheyesImage() {
		// TODO Auto-generated method stub
		return "/static/module-launcher.png";
	}

	@Override
	public void open() {
		
		if(window != null) {
			window.detach();
			window = null;
		}
		
		window = new Window("", "none", false);
		window.setMode("modal");
		window.doModal();
	}

	@Override
	public void hide() {
		
		if(window != null && window.isVisible()) {
			window.setVisible(false);
		}
	}

	@Override
	public void exit() {
		
		if(window != null) {
			
			window.setVisible(false);
			window.detach();
			window = null;
		}
	}

	@Override
	public Toolbarbutton getRemoteControl() {
		
		if(remote == null) {
			
			remote = new Toolbarbutton();
			remote.setImage(getFisheyesImage());
		}
		
		remote.addEventListener(Events.ON_CLICK, click -> {
			
			if(window != null) {
				
				if(window.isVisible()) {
					window.setVisible(false);
				}
				else {
					window.setVisible(true);
				}
			}
		});
		
		return remote;
	}

	@Override
	public void show() {
		
		if(window != null && !window.isVisible()) {
			window.setVisible(true);
		}
	}

	@Override
	public String getRegistryImage() {
		// TODO Auto-generated method stub
		return "/static/module-launcher48.png";
	}
}
