/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.product.component;

import java.math.BigDecimal;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductComponent;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.FormToolbar;
import com.kratonsolution.belian.ui.inventory.product.ProductEditContent;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ComponentEditWindow extends AbstractWindow
{
	private Vlayout layout = new Vlayout();
	
	private FormToolbar toolbar = new FormToolbar();
	
	private Grid content = new Grid();
	
	private ProductService service = Springs.get(ProductService.class);
	
	private Product product;
	
	private Doublebox quantity = new Doublebox();
	
	private Textbox note = new Textbox();
	
	private Listbox products = new Listbox();

	private String componentId;
	
	public ComponentEditWindow(Product product,String componentId)
	{
		super();

		this.product = product;
		this.componentId = componentId;
		
		setMode(Mode.POPUP);
		
		Caption caption = new Caption("Product Component");
		caption.setImage("/icons/product.png");
		
		appendChild(caption);
		
		layout.setWidth("100%");

		layout.appendChild(toolbar);
		layout.appendChild(content);
		
		content.appendChild(new Rows());
		content.appendChild(new Columns());
		
		appendChild(layout);
		
		initToolbar();
		initContent();
	}
	
	protected void initToolbar()
	{
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				ProductComponent component = service.findComponent(product, componentId);
				component.setQuantity(BigDecimal.valueOf(quantity.doubleValue()));
				component.setNote(note.getText());
				component.setProduct(service.findOne(products.getSelectedItem().getValue().toString()));
				
				service.editComponent(component);
				
				ProductEditContent parent = (ProductEditContent)getParent();
				parent.refresh();
				parent.setSelectedTab(2);
				
				onClose();
			}
		});
		
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				onClose();
			}
		});
	}
	
	protected void initContent()
	{
		for(ProductComponent component:product.getComponents())
		{
			if(component.getId().equals(componentId))
			{
				quantity.setValue(component.getQuantity().doubleValue());
				quantity.setConstraint("no empty");
				quantity.setWidth("250px");
				
				note.setText(component.getNote());
				note.setWidth("300px");
				
				products.setMold("select");
				products.appendChild(new Listitem(component.getProduct().getName(),component.getProduct().getId()));
				products.setSelectedIndex(0);
				
				content.getColumns().appendChild(new Column(null,null,"100px"));
				content.getColumns().appendChild(new Column());
				
				Row row1 = new Row();
				row1.appendChild(new Label("Product"));
				row1.appendChild(products);
				
				Row row2 = new Row();
				row2.appendChild(new Label("Quantity"));
				row2.appendChild(quantity);
				
				Row row3 = new Row();
				row3.appendChild(new Label("Note"));
				row3.appendChild(note);
				
				content.setWidth("100%");
				content.getRows().appendChild(row1);
				content.getRows().appendChild(row2);
				content.getRows().appendChild(row3);
				
				break;
			}
		}
		
	}
	
	@Override
	public void onClose()
	{
		setVisible(false);
		setParent(null);
	}
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.HasStatus#insertStatus()
	 */
	@Override
	public void insertStatus()
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.HasStatus#removeStatus()
	 */
	@Override
	public void removeStatus()
	{
		// TODO Auto-generated method stub

	}

}
