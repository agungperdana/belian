package com.kratonsolution.belian.products.ui.productcategory;

import com.kratonsolution.belian.common.ui.event.UIEvent;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class ProductCategoryUIEvent extends UIEvent {

	private static final long serialVersionUID = 4510223896199093865L;
	
	@Getter
	@Setter
	private String category;
	
	public ProductCategoryUIEvent(@NonNull String type) {
		super(type);
	}
	
	public static ProductCategoryUIEvent toGrid() {
		return new ProductCategoryUIEvent(UIEvent.GRID);
	}
	
	public static ProductCategoryUIEvent newForm() {
		return new ProductCategoryUIEvent(UIEvent.ADD_FORM);
	}
	
	public static ProductCategoryUIEvent editForm(@NonNull String categoryName) {
		
		ProductCategoryUIEvent ev = new ProductCategoryUIEvent(UIEvent.EDIT_FORM);
		ev.setCategory(categoryName);
		
		return ev;
	}
}
