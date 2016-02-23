/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.product.supplier;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.global.dm.EconomicAgentRepository;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductSupplier;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.FormToolbar;
import com.kratonsolution.belian.ui.inventory.product.ProductEditContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SupplierEditWindow extends AbstractWindow
{
	private Vlayout layout = new Vlayout();
	
	private FormToolbar toolbar = new FormToolbar();
	
	private Grid content = new Grid();
	
	private ProductService service = Springs.get(ProductService.class);
	
	private EconomicAgentRepository partyRepository = Springs.get(EconomicAgentRepository.class);
	
	private Product product;
	
	private Datebox from = Components.currentDatebox();
	
	private Datebox to = Components.datebox();
	
	private Textbox note = new Textbox();
	
	private Listbox suppliers = Components.newSelect();

	private String supplierId;
	
	public SupplierEditWindow(Product product,String supplierId)
	{
		super();

		this.product = product;
		this.supplierId = supplierId;
		
		setMode(Mode.POPUP);
		
		Caption caption = new Caption("Product Supplier");
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
				ProductSupplier supplier = service.findSupplier(product, supplierId);
				if(supplier != null)
				{
					supplier.setTo(to.getValue());
					service.editSupplier(supplier);
				}
				
				ProductEditContent parent = (ProductEditContent)getParent();
				parent.refresh();
				parent.setSelectedTab(3);
				
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
		for(ProductSupplier supplier:product.getSuppliers())
		{
			if(supplier.getId().equals(supplierId))
			{
				from.setValue(supplier.getFrom());
				to.setValue(supplier.getTo());
				note.setText(supplier.getNote());
				suppliers.appendChild(new Listitem(supplier.getSupplier().getName(),supplier.getSupplier().getId()));
				suppliers.setSelectedIndex(0);
				
				content.getColumns().appendChild(new Column(null,null,"125px"));
				content.getColumns().appendChild(new Column());
				
				Row row1 = new Row();
				row1.appendChild(new Label("From"));
				row1.appendChild(from);
				
				Row row2 = new Row();
				row2.appendChild(new Label("To"));
				row2.appendChild(to);
				
				Row row3 = new Row();
				row3.appendChild(new Label("Supplier"));
				row3.appendChild(suppliers);
				
				Row row4 = new Row();
				row4.appendChild(new Label("Note"));
				row4.appendChild(note);
				
				content.setWidth("100%");
				content.getRows().appendChild(row1);
				content.getRows().appendChild(row2);
				content.getRows().appendChild(row3);
				content.getRows().appendChild(row4);
				
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
