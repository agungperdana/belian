package com.kratonsolution.belian.backoffice.ui;

import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.common.ui.ApplicationModule;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Launcher implements ApplicationModule {

	private Window window;
	
	private Toolbarbutton remote;
	
	private Page page;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "com.kratonsolution.belian.module.applicationlauncher";
	}

	@Override
	public String getFisheyesImage() {
		// TODO Auto-generated method stub
		return "/images/module-launcher.png";
	}

	@Override
	public void open() {

		if(window == null) {
			
			window = new Window("", "none", false);
			window.setWidth("50%");
			window.setHeight("40%");
		}

		window.setPage(page);
		window.setPosition("center");
		window.setTopmost();
		window.doOverlapped();
	}

	@Override
	public void close() {
		
		window.setVisible(false);
		window.setPage(null);
		window.detach();
	}

	@Override
	public Toolbarbutton getRemoteControl(@NonNull Page page) {
		
		this.page = page;
		
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
		return "/images/module-launcher48.png";
	}
}
