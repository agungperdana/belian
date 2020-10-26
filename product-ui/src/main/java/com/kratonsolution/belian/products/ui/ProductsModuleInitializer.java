package com.kratonsolution.belian.products.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import org.zkoss.util.resource.Labels;

import com.kratonsolution.belian.common.ui.MenuPosition;
import com.kratonsolution.belian.common.ui.ModuleRegistryInformation;
import com.kratonsolution.belian.common.ui.event.ModuleRegistrationEvent;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
public class ProductsModuleInitializer implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private ApplicationEventPublisher publisher;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		ModuleRegistryInformation info = new ModuleRegistryInformation();
		info.setPosition(MenuPosition.PRODUCT_CATEGORY);
		info.setName(Labels.getLabel("label.caption.products.category"));
		info.setNickName(Labels.getLabel("label.caption.products.category.nickname"));
		info.setFisheyeImage(getClass().getResource("/images/fisheye/product-category.png"));
		info.setLauncherImage(getClass().getResource("/images/registry/product-category.png"));
		
		publisher.publishEvent(new ModuleRegistrationEvent(this, info));
	}
}
