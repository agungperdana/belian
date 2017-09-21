/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listhead;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.general.dm.IndustrySegmentation;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.ProductType;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductPoup extends Window
{
	private ProductService service = Springs.get(ProductService.class);
	
	private Caption caption = new Caption("Medicine List");
	
	private Textbox textbox = new Textbox();
	
	private Collection<ProductSelectionListener> listeners = new ArrayList<ProductSelectionListener>();
	
	private Grid fGrid = new Grid();
	
	private Listbox products = new Listbox();
	
	private IndustrySegmentation segmentation = IndustrySegmentation.GENERAL;
	
	private ProductType type = ProductType.FINISH_GOODS;
	
	public ProductPoup(IndustrySegmentation segmentation,ProductType type)
	{
		if(segmentation != null)
			this.segmentation = segmentation;
		
		if(type != null)
			this.type = type;
		
		setWidth("400px");
		setHeight("350px");
		setVisible(false);
		setBorder("normal");
		setMode(Window.POPUP);
		setPosition("center");
		
		textbox.setWidth("100%");
		textbox.addEventListener(Events.ON_CHANGING,new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent event) throws Exception
			{
				initContent(event.getValue());
			}
		});
		
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
		
		initContent(textbox.getText());
	}
	
	private void initList()
	{
		products.getChildren().clear();
		
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
	}
	
	private void initListEvent()
	{
		products.addEventListener(Events.ON_SELECT,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				MedicationProductListItem item = (MedicationProductListItem)products.getSelectedItem();
				for(ProductSelectionListener listener:listeners)
					listener.productSeledted(item.getProduct());
				
				ProductPoup.this.setVisible(false);
				ProductPoup.this.setPage(null);
			}
		});
	}
	
	private void initContent(String name)
	{
		initList();
		initListEvent();
		
		List<Product> datas = new ArrayList<Product>();
		
//		if(Strings.isNullOrEmpty(name))
//			datas.addAll(service.findAllBySegmentation(segmentation,type));
//		else
			datas.addAll(service.findAllBySegmentationAndName(segmentation,name,type));
			
		for(Product product:datas)
			products.appendChild(new MedicationProductListItem(product));
	}
	
	public void addProductSelectionListener(ProductSelectionListener listener)
	{
		if(listener != null)
			listeners.add(listener);
	}
}
