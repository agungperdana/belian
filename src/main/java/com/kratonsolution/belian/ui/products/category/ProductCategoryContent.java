
package com.kratonsolution.belian.ui.products.category;

import java.io.Serializable;

import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.West;

import com.kratonsolution.belian.products.svc.ProductCategoryService;
import com.kratonsolution.belian.ui.Removeable;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductCategoryContent extends Borderlayout implements Serializable,Removeable
{
	private ProductCategoryService service = Springs.get(ProductCategoryService.class);
	
	private West west = new West();
	
	private Center center = new Center();
	
	public ProductCategoryContent()
	{
		setHflex("1");
		setVflex("1");
		
		west.setWidth("38%");
		west.setBorder("none");
		west.setStyle("overflow:auto");

		center.setBorder("none");
		center.setStyle("overflow:auto");
		
		appendChild(west);
		appendChild(center);
		
		west.appendChild(new ProductCategoryTree(center));
	}
}