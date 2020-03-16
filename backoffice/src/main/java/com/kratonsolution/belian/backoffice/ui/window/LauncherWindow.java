package com.kratonsolution.belian.backoffice.ui.window;

import org.zkoss.image.AImage;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.backoffice.application.ModuleRegistry;
import com.kratonsolution.belian.backoffice.application.PublisherAdapter;
import com.kratonsolution.belian.backoffice.ui.Springs;
import com.kratonsolution.belian.common.ui.ModuleCommunicationEvent;
import com.kratonsolution.belian.common.ui.ModuleRegistryInformation;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class LauncherWindow extends Window {

	private static final long serialVersionUID = 1L;

	private Vbox box = new Vbox();

	public LauncherWindow() {

		setBorder(false);
		setWidth("50%");
		setHeight("40%");
		setPosition("center");
		setTopmost();

		box.setHflex("1");
		box.setVflex("1");

		appendChild(box);

		initContent();
	}

	private void initContent() {

		PublisherAdapter publisher = Springs.get(PublisherAdapter.class);
		if(publisher != null) {

			ModuleRegistry registry = Springs.get(ModuleRegistry.class);
			if(registry != null) {

				Hbox hbox = new Hbox();
				hbox.setHeight("70px");
				hbox.setHflex("1");

				for(ModuleRegistryInformation info:registry.getRegistyrs()) {

					try {
						
						Button button = new Button();
						button.setImageContent(new AImage(info.getLauncherImage()));
						button.setLabel(info.nickName);
						button.setOrient("vertical");
						button.addEventListener(Events.ON_CLICK, e -> {

							publisher.publish(new ModuleCommunicationEvent(this, info.name, ModuleCommunicationEvent.Type.OPEN));

							LauncherWindow.this.setVisible(false);
							LauncherWindow.this.detach();
						});
						
						hbox.appendChild(button);
						
					} catch (Exception e) {
					}
				}
				
				box.appendChild(hbox);
			}
		}
	}
}
