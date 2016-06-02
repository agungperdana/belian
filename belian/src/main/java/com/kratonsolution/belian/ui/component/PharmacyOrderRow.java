/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.math.BigDecimal;

import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.healtcare.dm.MedicalSalesItem;
import com.kratonsolution.belian.healtcare.dm.PharmacySalesItem;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductRepository;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PharmacyOrderRow extends Row
{
	private SessionUtils utils = Springs.get(SessionUtils.class);

	private ProductRepository repository = Springs.get(ProductRepository.class);

	private Listbox products = Components.fullSpanSelect();

	private Listbox uoms = Components.fullSpanSelect();

	private Doublebox quantity = Components.doubleOne();

	private Textbox note = Components.textBox(null);

	public PharmacyOrderRow(MedicalSalesItem item)
	{
		appendChild(products);
		appendChild(quantity);
		appendChild(uoms);
		appendChild(note);
		
		if(item != null)
			setItem(item);
	}

	public Product getProduct()
	{
		return null;
	}

	public PharmacySalesItem getItem()
	{
		PharmacySalesItem item = new PharmacySalesItem();
		item.setProduct(getProduct());
		item.setNote(note.getText());
		item.setQuantity(BigDecimal.valueOf(quantity.doubleValue()));

		return item;
	}
	
	public void setItem(MedicalSalesItem item)
	{
		products.appendItem(item.getProduct().getName(),item.getProduct().getId());
		quantity.setValue(item.getQuantity().doubleValue());
		uoms.appendItem(item.getMeasure(), item.getMeasure());
		
		products.setSelectedIndex(0);
		Components.setDefault(uoms);
	}
}
