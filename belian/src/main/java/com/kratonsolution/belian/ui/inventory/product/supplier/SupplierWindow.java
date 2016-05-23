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
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.common.Dates;
import com.kratonsolution.belian.general.dm.PartyRepository;
import com.kratonsolution.belian.global.svc.EconomicAgentService;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductSupplier;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.FormToolbar;
import com.kratonsolution.belian.ui.inventory.product.ProductEditContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SupplierWindow extends AbstractWindow
{
	private EconomicAgentService agentService = Springs.get(EconomicAgentService.class);
	
	private Vlayout layout = new Vlayout();
	
	private FormToolbar toolbar = new FormToolbar();
	
	private Grid content = new Grid();
	
	private ProductService service = Springs.get(ProductService.class);
	
	private PartyRepository partyRepository = Springs.get(PartyRepository.class);
	
	private Product product;
	
	private Datebox from = Components.currentDatebox();
	
	private Datebox to = Components.datebox();
	
	private Textbox note = new Textbox();
	
	private Listbox suppliers = Components.newSelect(agentService.findAll(), true);
	
	public SupplierWindow(Product product)
	{
		super();
		
		this.product = product;
		
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
				ProductSupplier supplier = new ProductSupplier();
				supplier.setFrom(Dates.sql(from.getValue()));
				supplier.setTo(Dates.sql(to.getValue()));
				supplier.setNote(note.getText());
				supplier.setSupplier(partyRepository.findOne(suppliers.getSelectedItem().getValue().toString()));

				service.addSupplier(product, supplier);
				
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
		note.setWidth("300px");

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
