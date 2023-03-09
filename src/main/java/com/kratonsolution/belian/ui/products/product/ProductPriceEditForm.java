
package com.kratonsolution.belian.ui.products.product;

import java.math.BigDecimal;
import java.util.Iterator;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.products.dm.OrderValue;
import com.kratonsolution.belian.products.dm.PriceComponent;
import com.kratonsolution.belian.products.dm.PriceComponentRepository;
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.QuantityBreak;
import com.kratonsolution.belian.products.svc.ProductService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.accounting.currency.CurrencyList;
import com.kratonsolution.belian.ui.general.geographic.GeographicList;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.products.category.ProductCategoryList;
import com.kratonsolution.belian.ui.products.feature.ProductFeatureList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductPriceEditForm extends AbstractForm
{	
	private ProductService service = Springs.get(ProductService.class);

	private PriceComponentRepository priceComponentRepository = Springs.get(PriceComponentRepository.class);
	
	private Datebox start = Components.currentDatebox();

	private Datebox end = Components.datebox();

	private Decimalbox price = Components.decimalbox(BigDecimal.ZERO);

	private Decimalbox percent = Components.decimalbox(BigDecimal.ZERO);

	private CurrencyList currencys = new CurrencyList(false);

	private PriceComponentTypeList types = new PriceComponentTypeList(false);

	private GeographicList geographics = new GeographicList(false, null);

	private ProductCategoryList categorys = new ProductCategoryList(false);

	private ProductFeatureList features = new ProductFeatureList(false);
	
	private PartyBox customer = new PartyBox(false);

	private SaleTypeList saleTypes = new SaleTypeList(false);

	private Decimalbox breakMin = Components.decimalbox(BigDecimal.ZERO);

	private Decimalbox breakMax = Components.decimalbox(BigDecimal.ZERO);

	private Decimalbox orderMin = Components.decimalbox(BigDecimal.ZERO);

	private Decimalbox orderMax = Components.decimalbox(BigDecimal.ZERO);

	private String pricecom;
	
	private String product;

	public ProductPriceEditForm(String price,String product)
	{
		super();

		this.pricecom = price;
		this.product = product;
		
		initToolbar();
		initForm();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new ProductPriceGrid(service.getOne(product)));
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Product fresh = service.getOne(product);
				if(fresh != null)
				{
					if(start.getValue() == null)
						throw new WrongValueException(start, lang.get("message.field.empty"));
					
					if(price.getValue() == null && percent.getValue() == null)
						throw new WrongValueException(price, lang.get("message.field.empty"));
					
					if(types.getPriceComponentType() == null)
						throw new WrongValueException(types, lang.get("message.field.empty"));
					
					if(saleTypes.getDomain() == null)
						throw new WrongValueException(saleTypes, lang.get("message.field.empty"));
					
					Iterator<PriceComponent> iterator = fresh.getPrices().iterator();
					while (iterator.hasNext())
					{
						PriceComponent in = (PriceComponent) iterator.next();
						if(in.getId().equals(pricecom))
						{
							in.setCategory(categorys.getDomainAsRef());
							in.setCurrency(currencys.getDomainAsRef());
							in.setEnd(DateTimes.sql(end.getValue()));
							in.setFeature(features.getDomainAsRef());
							in.setArea(geographics.getDomainAsRef());
							in.setOrganization(organizations.getDomainAsRef());
							in.setCustomer(customer.getDomainAsRef());
							in.setPrice(price.getValue());
							in.setSaleType(saleTypes.getDomain());
							in.setStart(DateTimes.sql(start.getValue()));
							in.setType(types.getPriceComponentType());
							in.setQuantityBreak(new QuantityBreak());
							in.setOrderValue(new OrderValue());
							in.getQuantityBreak().setMax(breakMax.getValue());
							in.getQuantityBreak().setMin(breakMin.getValue());
							in.getOrderValue().setMin(orderMin.getValue());
							in.getOrderValue().setMax(orderMax.getValue());

							break;
						}
					}

					service.edit(fresh);
				}

				Flow.next(getParent(), new ProductPriceGrid(fresh));
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"115px"));
		grid.getColumns().appendChild(new Column());
		
		PriceComponent out = priceComponentRepository.getOne(pricecom);
		if(out != null)
		{
			start.setValue(out.getStart());
			end.setValue(out.getEnd());
			price.setValue(out.getPrice());
			currencys.setDomainAsRef(out.getCurrency());
			types.setPriceComponentType(out.getType());
			geographics.setDomainAsRef(out.getArea());
			categorys.setDomainAsRef(out.getCategory());
			saleTypes.setDomain(out.getSaleType());
			features.setDomainAsRef(out.getFeature());
			customer.setDomainAsRef(out.getCustomer());
			organizations.setDomainAsRef(out.getOrganization());

			if(out.getQuantityBreak() != null)
			{
				breakMin.setValue(out.getQuantityBreak().getMin());
				breakMax.setValue(out.getQuantityBreak().getMax());
			}

			if(out.getOrderValue() != null)
			{
				orderMin.setValue(out.getOrderValue().getMin());
				orderMax.setValue(out.getOrderValue().getMax());
			}
		}

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("inventory.product.grid.column.organization")));
		row1.appendChild(organizations);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("inventory.product.grid.column.start")));
		row2.appendChild(start);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("inventory.product.grid.column.end")));
		row3.appendChild(end);

		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("inventory.product.grid.column.price")));
		row4.appendChild(price);

		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("inventory.product.grid.column.currency")));
		row5.appendChild(currencys);

		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("inventory.product.grid.column.type")));
		row6.appendChild(types);

		Row row7 = new Row();
		row7.appendChild(new Label(lang.get("inventory.product.grid.column.saletype")));
		row7.appendChild(saleTypes);
		
		Row row8 = new Row();
		row8.appendChild(new Label(lang.get("inventory.product.grid.column.customer")));
		row8.appendChild(customer);
		
		Row row9 = new Row();
		row9.appendChild(new Label(lang.get("inventory.product.grid.column.geographic")));
		row9.appendChild(geographics);

		Row row10 = new Row();
		row10.appendChild(new Label(lang.get("inventory.product.grid.column.category")));
		row10.appendChild(categorys);

		Row row11 = new Row();
		row11.appendChild(new Label(lang.get("inventory.product.grid.column.feature")));
		row11.appendChild(features);
		
		Row row12 = new Row();
		row12.appendChild(new Label(lang.get("inventory.product.grid.column.breakmin")));
		row12.appendChild(breakMin);

		Row row13 = new Row();
		row13.appendChild(new Label(lang.get("inventory.product.grid.column.breakmax")));
		row13.appendChild(breakMax);

		Row row14 = new Row();
		row14.appendChild(new Label(lang.get("inventory.product.grid.column.ordermin")));
		row14.appendChild(orderMin);

		Row row15 = new Row();
		row15.appendChild(new Label(lang.get("inventory.product.grid.column.ordermax")));
		row15.appendChild(orderMax);

		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
		grid.getRows().appendChild(row4);
		grid.getRows().appendChild(row5);
		grid.getRows().appendChild(row6);
		grid.getRows().appendChild(row7);
		grid.getRows().appendChild(row8);
		grid.getRows().appendChild(row9);
		grid.getRows().appendChild(row10);
		grid.getRows().appendChild(row11);
		grid.getRows().appendChild(row12);
		grid.getRows().appendChild(row13);
		grid.getRows().appendChild(row14);
		grid.getRows().appendChild(row15);
	}
	
	public ProductPriceEditForm setFieldFocus()
	{
		price.setFocus(true);
		return this;
	}
}
