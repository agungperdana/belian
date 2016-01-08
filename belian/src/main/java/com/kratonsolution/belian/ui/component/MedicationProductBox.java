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
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.inventory.dm.IndustrySegmentation;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.Product.Type;

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
	
	private ProductPoup propopup = null;
	
	public static MedicationProductBox getInstance(boolean readOnly)
	{
		return new MedicationProductBox(null,null,readOnly);
	}
	
	public static MedicationProductBox getInstance()
	{
		return new MedicationProductBox(null,null,false);
	}
	
	public static MedicationProductBox getInstance(IndustrySegmentation segmentation,Type type)
	{
		return new MedicationProductBox(segmentation,type,false);
	}
	
	public static MedicationProductBox getInstance(IndustrySegmentation segmentation,Type type,boolean readOnly)
	{
		return new MedicationProductBox(segmentation,type,readOnly);
	}
	
	private MedicationProductBox()
	{
		this(null,null,false);
	}
	
	private MedicationProductBox(IndustrySegmentation segmentation,Type type,boolean readOnly)
	{
		propopup = new ProductPoup(segmentation, type);
		
		textbox.setWidth("250px");
		textbox.setReadonly(true);
		
		search.setDisabled(readOnly);
		search.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				propopup.setPage(getPage());
				propopup.setVisible(true);
			}
		});
		
		appendChild(textbox);
		appendChild(search);
		
		propopup.addProductSelectionListener(this);
	}

	@Override
	public void productSeledted(Product product)
	{
		this.productId = product.getId();
		this.textbox.setText(product.getName());
	}
}
