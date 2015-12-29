/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.util.ArrayList;
import java.util.Collection;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listhead;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.inventory.dm.IndustrySegmentation;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class MedicationProductPoup extends Window
{
	private ProductService service = Springs.get(ProductService.class);
	
	private Caption caption = new Caption("Medicine List");
	
	private Textbox textbox = new Textbox();

	private Tabbox tabbox = new Tabbox();
	
	private Collection<ProductSelectionListener> listeners = new ArrayList<ProductSelectionListener>();
	
	private Grid fGrid = new Grid();
	
	private Listbox products = new Listbox();
	
	public MedicationProductPoup()
	{
		setWidth("400px");
		setHeight("350px");
		setVisible(false);
		setBorder("normal");
		setMode(Window.POPUP);
		setPosition("center");
		
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab("Standard"));
		tabbox.getTabs().appendChild(new Tab("BPJS"));
		
		textbox.setWidth("100%");
		
		fGrid.setWidth("100%");
		fGrid.appendChild(new Rows());
		fGrid.appendChild(new Columns());
		fGrid.getColumns().appendChild(new Column(null,null,"85px"));
		fGrid.getColumns().appendChild(new Column());
		fGrid.setSpan("1");
		fGrid.getRows().appendChild(RowUtils.row("Filter", textbox));
		
		appendChild(caption);
		appendChild(fGrid);
		appendChild(products);
		
		initContent();
	}
	
	private void initContent()
	{
		Listhead listhead = new Listhead();
		Listheader code = new Listheader("Code");
		code.setWidth("100px");
		
		Listheader name = new Listheader("Name");
		name.setWidth("150px");
		
		Listheader bpjs = new Listheader("BPJS");
		bpjs.setWidth("80px");
		
		listhead.appendChild(code);
		listhead.appendChild(name);
		listhead.appendChild(bpjs);
		
		products.setWidth("100%");
		products.appendChild(listhead);
		
		for(Product product:service.findAllBySegmentation(IndustrySegmentation.MEDICAL))
			products.appendChild(new MedicationProductListItem(product));
		
		products.addEventListener(Events.ON_SELECT,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				MedicationProductListItem item = (MedicationProductListItem)products.getSelectedItem();
				for(ProductSelectionListener listener:listeners)
					listener.productSeledted(item.getProduct());
				
				MedicationProductPoup.this.setVisible(false);
				MedicationProductPoup.this.setPage(null);
			}
		});
	}
	
	public void addProductSelectionListener(ProductSelectionListener listener)
	{
		if(listener != null)
			listeners.add(listener);
	}
}
