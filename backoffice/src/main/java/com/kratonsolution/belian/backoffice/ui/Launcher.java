package com.kratonsolution.belian.backoffice.ui;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.backoffice.ui.window.LauncherWindow;
import com.kratonsolution.belian.common.ui.util.UIHelper;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
public class Launcher extends Toolbarbutton {

	private static final long serialVersionUID = 1L;

	public Launcher() {
		
		setImage("/images/fisheye/launcher.png");
		addEventListener(Events.ON_CLICK, e->{
			
			boolean exist = false;
			
			Page page = UIHelper.getPage();
			if(page != null) {
				
				for(Component com:page.getRoots()) {
					
					if(com instanceof LauncherWindow) {
						
						com.setVisible(false);
						com.detach();
						com.setPage(null);
						
						exist = true;
						break;
					}
				}
				
				if(!exist) {
					
					Window window = new LauncherWindow();
					window.setPage(page);
					window.doOverlapped();
					window.setTopmost();
				}
			}
		});
	}
}
