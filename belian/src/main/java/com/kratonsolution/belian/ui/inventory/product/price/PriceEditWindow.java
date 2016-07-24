/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.product.price;

import java.math.BigDecimal;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Checkbox;
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

import com.kratonsolution.belian.accounting.svc.CurrencyService;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.general.svc.PartyService;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductFeature;
import com.kratonsolution.belian.inventory.dm.ProductPrice;
import com.kratonsolution.belian.inventory.dm.ProductPriceType;
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
public class PriceEditWindow extends AbstractWindow
{
	private SessionUtils utils = Springs.get(SessionUtils.class);

	private Language lang = Springs.get(Language.class);

	private Vlayout layout = new Vlayout();

	private FormToolbar toolbar = new FormToolbar();

	private Grid content = new Grid();

	private ProductService service = Springs.get(ProductService.class);

	private GeographicService geographicService = Springs.get(GeographicService.class);

	private PartyService partyService = Springs.get(PartyService.class);

	private CurrencyService currencyService = Springs.get(CurrencyService.class);

	private Product product;

	private Datebox from = Components.currentDatebox();

	private Datebox to = Components.datebox();

	private Doublebox price = Components.stdDoubleBox(0);

	private Listbox currencys = Components.newSelect(currencyService.findAll(), true);

	private Listbox types = Components.newSelect();

	private Listbox geographics = Components.newSelect(geographicService.findAll(),false);

	private Listbox partys = Components.newSelect(partyService.findAll(),false);

	private Listbox features = Components.newSelect();
	
	private Checkbox percent = Components.checkbox(false);

	private String priceId;

	public PriceEditWindow(Product product,String priceId)
	{
		super();

		this.product = product;
		this.priceId = priceId;

		setMode(Mode.POPUP);

		Caption caption = new Caption(lang.get("inventory.product.detail.price"));
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
				productPrice.setFrom(new java.sql.Date(from.getValue().getTime()));
				productPrice.setTo(to.getValue()!=null?new java.sql.Date(to.getValue().getTime()):null);
				productPrice.setPrice(BigDecimal.valueOf(price.getValue()));
				productPrice.setType(ProductPriceType.valueOf(types.getSelectedItem().getValue().toString()));
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

		for(ProductFeature feature:productPrice.getProduct().getFeatures())
			features.appendItem(feature.getValue(), feature.getId());
			
		from.setValue(productPrice.getFrom());
		to.setValue(productPrice.getTo());
		price.setValue(productPrice.getPrice().doubleValue());
		percent.setChecked(productPrice.isPercent());

		for(ProductPriceType type:ProductPriceType.values())
		{
			Listitem listitem = new Listitem(type.display(utils.getLanguage()),type.name());
			types.appendChild(listitem);
			if(type.equals(productPrice.getType()))
				types.setSelectedItem(listitem);
		}

		if(productPrice.getGeographic() != null)
		{
			for(Listitem item:geographics.getItems())
			{
				if(item.getValue().toString().equals(productPrice.getGeographic().getId()))
				{
					geographics.setSelectedItem(item);
					break;
				}
			}
		}
		
		if(productPrice.getParty() != null)
		{
			for(Listitem item:partys.getItems())
			{
				if(item.getValue().toString().equals(productPrice.getParty().getId()))
				{
					partys.setSelectedItem(item);
					break;
				}
			}
		}

		if(productPrice.getCurrency() != null)
		{
			for(Listitem item:currencys.getItems())
			{
				if(item.getValue().toString().equals(productPrice.getCurrency().getId()))
				{
					currencys.setSelectedItem(item);
					break;
				}
			}
		}
		
		if(productPrice.getFeature() != null)
		{
			for(Listitem item:features.getItems())
			{
				if(item.getValue().toString().equals(productPrice.getFeature().getId()))
				{
					features.setSelectedItem(item);
					break;
				}
			}
		}

		content.getColumns().appendChild(new Column(null,null,"100px"));
		content.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("generic.grid.column.start")));
		row1.appendChild(from);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generic.grid.column.end")));
		row2.appendChild(to);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("generic.grid.column.sellingprice")));
		row3.appendChild(price);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("generic.grid.column.persent")));
		row4.appendChild(percent);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("generic.grid.column.currency")));
		row5.appendChild(currencys);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("generic.grid.column.type")));
		row6.appendChild(types);
		
		Row row7 = new Row();
		row7.appendChild(new Label(lang.get("generic.grid.column.feature")));
		row7.appendChild(features);
		
		Row row8 = new Row();
		row8.appendChild(new Label(lang.get("generic.grid.column.geographic")));
		row8.appendChild(geographics);
		
		Row row9 = new Row();
		row9.appendChild(new Label(lang.get("generic.grid.column.customer")));
		row9.appendChild(partys);
		
		content.setWidth("100%");
		content.getRows().appendChild(row1);
		content.getRows().appendChild(row2);
		content.getRows().appendChild(row3);
		content.getRows().appendChild(row4);
		content.getRows().appendChild(row5);
		content.getRows().appendChild(row6);
		content.getRows().appendChild(row7);
		content.getRows().appendChild(row8);
		content.getRows().appendChild(row9);
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