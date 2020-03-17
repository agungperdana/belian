package com.kratonsolution.belian.security.ui;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.zkoss.image.AImage;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.ui.AbstractScreen;
import com.kratonsolution.belian.common.ui.Fisheyes;
import com.kratonsolution.belian.common.ui.ModuleCommunicationEvent;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Slf4j
@Service
public class SecurityModuleCommunicationEventListener implements ApplicationListener<ModuleCommunicationEvent> {

	@Override
	public void onApplicationEvent(ModuleCommunicationEvent event) {

		if(event.getModuleName().equals(SecurityModuleInitializer.SECURITY_MODULE)) {

			if(event.getType().equals(ModuleCommunicationEvent.Type.OPEN)) {

				Page page = Executions.getCurrent().getDesktop().getFirstPage();

				ModuleWindow window = new ModuleWindow();
				window.setPage(page);
				window.doOverlapped();

				Fisheyes fisheyes = getFisheye(page);
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
								window.setPage(page);
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
	}
	
	private Fisheyes getFisheye(Page page) {

		for(Component com:page.getRoots()) {
			log.info("Fellow {}", com.getClass().getName());
			if(com instanceof AbstractScreen) {
				return ((AbstractScreen)com).getFisheye();
			}
		}
		
		return null;
	}
}
