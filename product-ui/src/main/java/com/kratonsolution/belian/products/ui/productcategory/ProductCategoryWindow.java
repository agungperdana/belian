package com.kratonsolution.belian.products.ui.productcategory;

import org.zkoss.image.AImage;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.event.EventQueues;

import com.kratonsolution.belian.common.ui.AbstractWindow;
import com.kratonsolution.belian.common.ui.event.UIEvent;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class ProductCategoryWindow extends AbstractWindow
{	
	private static final long serialVersionUID = -8958011451479566646L;

	public ProductCategoryWindow() {

		super();
		try {
			caption.setImageContent(new AImage(getClass().getResource("/images/fisheye/module.png")));
		} catch (Exception e) {}

		caption.setLabel(Labels.getLabel("module.caption"));

		EventQueues.lookup(ProductCategoryUIEvent.class.getSimpleName()).subscribe(e->{

			ProductCategoryUIEvent event = (ProductCategoryUIEvent) e;

			clearContent();

			if(event.getType().equals(UIEvent.ADD_FORM)) {
				appendChild(new ProductCategoryFormContent());
			}
			else if(event.getType().equals(UIEvent.EDIT_FORM)) {
				appendChild(new ProductCategoryEditContent(event.getCategory()));
			}
			else {
				appendChild(new ProductCategoryGridContent());
			}
		});
	}
}
