
package com.kratonsolution.belian.ui.component;

import org.zkoss.zul.Tabpanel;

import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.common.orm.Observer;
import com.kratonsolution.belian.product.impl.application.ProductService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductTabpanel extends Tabpanel implements Observer
{
	private ProductService service = Springs.get(ProductService.class);
	
	@Override
	public void valueChange(IDValueRef value)
	{
		
	}
}
