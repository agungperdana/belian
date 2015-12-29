/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import lombok.Getter;
import lombok.Setter;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.inventory.dm.Product;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
public class MedicationProductBox extends Hbox implements ProductSelectionListener
{
	private String productId;
	
	private Textbox textbox = new Textbox();
	
	private Button search = new Button("", "/icons/popup16.png");
	
	private MedicationProductPoup poup = new MedicationProductPoup();
	
	public MedicationProductBox(Row parent)
	{
		textbox.setWidth("250px");
		textbox.setReadonly(true);
		
		search.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				poup.setPage(getPage());
				poup.setVisible(true);
			}
		});
		
		appendChild(textbox);
		appendChild(search);
		
		poup.addProductSelectionListener(this);
	}

	@Override
	public void productSeledted(Product product)
	{
		this.productId = product.getId();
		this.textbox.setText(product.getName());
	}
}
