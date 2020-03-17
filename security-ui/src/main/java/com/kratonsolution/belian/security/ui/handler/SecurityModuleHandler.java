package com.kratonsolution.belian.security.ui.handler;

import org.zkoss.image.AImage;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.ui.Fisheyes;
import com.kratonsolution.belian.common.ui.util.UIHelper;
import com.kratonsolution.belian.security.ui.window.ModuleWindow;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SecurityModuleHandler {

	public SecurityModuleHandler() {
		
		ModuleWindow window = new ModuleWindow();
		window.setPage(UIHelper.getPage());
		window.doOverlapped();

		Fisheyes fisheyes = UIHelper.getFisheye();
		if(fisheyes != null) {
			
			try {

				Toolbarbutton button = new Toolbarbutton();
				button.setImageContent(new AImage(getClass().getResource("/images/fisheye/module.png")));
				button.addEventListener(Events.ON_CLICK, e -> {
					
					if(window.isVisible()) {
						window.setVisible(false);
						window.detach();
					}
					else {
						window.setPage(UIHelper.getPage());
						window.doOverlapped();
						window.setTopmost();
					}
				});
				
				fisheyes.appendChild(button);
				
				window.addEventListener(Events.ON_CLOSE, e ->{
					fisheyes.removeChild(button);
					window.detach();
					window.setPage(null);
				});
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
