/**
 * 
 */
package com.kratonsolution.belian.ui.product.cost;

import java.math.BigDecimal;
import java.util.Date;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.svc.CurrencyService;
import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductCost;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.FormToolbar;
import com.kratonsolution.belian.ui.product.ProductEditContent;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class CostEditWindow extends AbstractWindow
{
	private Vlayout layout = new Vlayout();

	private FormToolbar toolbar = new FormToolbar();

	private Grid content = new Grid();

	private ProductService service = Springs.get(ProductService.class);

	private GeographicService geographicService = Springs.get(GeographicService.class);

	private CurrencyService currencyService = Springs.get(CurrencyService.class);

	private Product product;

	private Datebox from = new Datebox(new Date());

	private Datebox to = new Datebox();

	private Doublebox cost = new Doublebox();

	private Listbox currencys = new Listbox();

	private Listbox types = new Listbox();

	private Listbox geographics = new Listbox();

	private String costId;

	public CostEditWindow(Product product,String priceId)
	{
		super();

		this.product = product;
		this.costId = priceId;

		setMode(Mode.POPUP);

		Caption caption = new Caption("Product Feature");
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
				ProductCost productCost = service.findCost(product, costId);
				productCost.setFrom(from.getValue());
				productCost.setTo(to.getValue());
				productCost.setEstimated(BigDecimal.valueOf(cost.getValue()));
				productCost.setType(ProductCost.Type.valueOf(types.getSelectedItem().getValue().toString()));
				productCost.setCurrency(currencyService.findOne(currencys.getSelectedItem().getValue().toString()));
				
				if(geographics.getSelectedCount() > 0)
					productCost.setGeographic(geographicService.findOne(geographics.getSelectedItem().getValue().toString()));
				
				service.editCost(productCost);
				
				ProductEditContent parent = (ProductEditContent)getParent();
				parent.refresh();
				parent.setSelectedTab(5);
				
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
		ProductCost productPrice = service.findCost(product, costId);
		
		from.setConstraint("no empty");
		from.setValue(productPrice.getFrom());
		to.setValue(productPrice.getTo());
		cost.setConstraint("no empty");
		cost.setValue(productPrice.getEstimated().doubleValue());

		types.setMold("select");
		geographics.setMold("select");
		currencys.setMold("select");

		for(ProductCost.Type type:ProductCost.Type.values())
		{
			Listitem listitem = new Listitem(type.name(),type.name());
			types.appendChild(listitem);
			if(type.equals(productPrice.getType()))
				types.setSelectedItem(listitem);
		}
		
		for(Geographic geographic:geographicService.findAll())
		{
			Listitem listitem = new Listitem(geographic.getName(),geographic.getId());
			geographics.appendChild(listitem);
			
			if(productPrice.getGeographic() != null && geographic.getId().equals(productPrice.getGeographic().getId()))
				geographics.setSelectedItem(listitem);
		}
		
		for(Currency currency:currencyService.findAll())
		{
			Listitem listitem = new Listitem(currency.getCode(),currency.getId());
			currencys.appendChild(listitem);
			
			if(currency.getId().equals(productPrice.getCurrency().getId()))
				currencys.setSelectedItem(listitem);
		}
		
		content.getColumns().appendChild(new Column(null,null,"100px"));
		content.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("From"));
		row1.appendChild(from);
		
		Row row2 = new Row();
		row2.appendChild(new Label("To"));
		row2.appendChild(to);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Price"));
		row3.appendChild(cost);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Currency"));
		row4.appendChild(currencys);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Type"));
		row5.appendChild(types);
		
		Row row6 = new Row();
		row6.appendChild(new Label("For Area"));
		row6.appendChild(geographics);
		
		content.setWidth("100%");
		content.getRows().appendChild(row1);
		content.getRows().appendChild(row2);
		content.getRows().appendChild(row3);
		content.getRows().appendChild(row4);
		content.getRows().appendChild(row5);
		content.getRows().appendChild(row6);
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