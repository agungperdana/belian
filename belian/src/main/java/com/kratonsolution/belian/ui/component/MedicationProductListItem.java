/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.products.dm.Product;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class MedicationProductListItem extends Listitem
{
	private Product product;
	
	private Listcell code = new Listcell();
	
	private Listcell name = new Listcell();
	
	private Listcell bpjs = new Listcell();
	
	public MedicationProductListItem(Product product)
	{
		this.product = product;
		
		code.setLabel(product.getCode());
		name.setLabel(product.getName());
		bpjs.setLabel("No");
		
		appendChild(code);
		appendChild(name);
		appendChild(bpjs);
	}
}
