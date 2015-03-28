/**
 * 
 */
package com.kratonsolution.belian.ui.product.price;

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
import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.general.svc.PartyService;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductPrice;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.FormToolbar;
import com.kratonsolution.belian.ui.product.ProductEditContent;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class PriceEditWindow extends AbstractWindow
{
	private Vlayout layout = new Vlayout();

	private FormToolbar toolbar = new FormToolbar();

	private Grid content = new Grid();

	private ProductService service = Springs.get(ProductService.class);

	private GeographicService geographicService = Springs.get(GeographicService.class);

	private PartyService partyService = Springs.get(PartyService.class);

	private CurrencyService currencyService = Springs.get(CurrencyService.class);

	private Product product;

	private Datebox from = new Datebox(new Date());

	private Datebox to = new Datebox();

	private Doublebox price = new Doublebox();

	private Listbox currencys = new Listbox();

	private Listbox types = new Listbox();

	private Listbox geographics = new Listbox();

	private Listbox partys = new Listbox();

	private String priceId;

	public PriceEditWindow(Product product,String priceId)
	{
		super();

		this.product = product;
		this.priceId = priceId;

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
				ProductPrice productPrice = service.findPrice(product, priceId);
				productPrice.setFrom(from.getValue());
				productPrice.setTo(to.getValue());
				productPrice.setPrice(BigDecimal.valueOf(price.getValue()));
				productPrice.setType(ProductPrice.Type.valueOf(types.getSelectedItem().getValue().toString()));
				productPrice.setCurrency(currencyService.findOne(currencys.getSelectedItem().getValue().toString()));
				
				if(geographics.getSelectedCount() > 0)
					productPrice.setGeographic(geographicService.findOne(geographics.getSelectedItem().getValue().toString()));
				
				if(partys.getSelectedCount() > 0)
					productPrice.setParty(partyService.findOne(partys.getSelectedItem().getValue().toString()));
				
				service.editPrice(productPrice);
				
				ProductEditContent parent = (ProductEditContent)getParent();
				parent.refresh();
				parent.setSelectedTab(4);
				
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
		ProductPrice productPrice = service.findPrice(product, priceId);
		
		from.setConstraint("no empty");
		from.setValue(productPrice.getFrom());
		to.setValue(productPrice.getTo());
		price.setConstraint("no empty");
		price.setValue(productPrice.getPrice().doubleValue());

		types.setMold("select");
		geographics.setMold("select");
		currencys.setMold("select");
		partys.setMold("select");

		for(ProductPrice.Type type:ProductPrice.Type.values())
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
		
		for(Party party:partyService.findAll())
		{
			Listitem listitem = new Listitem(party.getName(), party.getId());
			partys.appendChild(listitem);
			
			if(productPrice.getParty() != null && productPrice.getParty().getId().equals(party.getId()))
				partys.setSelectedItem(listitem);
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
		row3.appendChild(price);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Currency"));
		row4.appendChild(currencys);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Type"));
		row5.appendChild(types);
		
		Row row6 = new Row();
		row6.appendChild(new Label("For Area"));
		row6.appendChild(geographics);
		
		Row row7 = new Row();
		row7.appendChild(new Label("For Customer"));
		row7.appendChild(partys);
		
		content.setWidth("100%");
		content.getRows().appendChild(row1);
		content.getRows().appendChild(row2);
		content.getRows().appendChild(row3);
		content.getRows().appendChild(row4);
		content.getRows().appendChild(row5);
		content.getRows().appendChild(row6);
		content.getRows().appendChild(row7);

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