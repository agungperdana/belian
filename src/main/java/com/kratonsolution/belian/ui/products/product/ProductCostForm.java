
package com.kratonsolution.belian.ui.products.product;

import java.math.BigDecimal;

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
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.ProductCost;
import com.kratonsolution.belian.products.svc.ProductService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.accounting.currency.CurrencyList;
import com.kratonsolution.belian.ui.general.geographic.GeographicList;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.products.feature.ProductFeatureList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductCostForm extends AbstractForm
{	
	private ProductService service = Springs.get(ProductService.class);

	private Datebox start = Components.currentDatebox();

	private Datebox end = Components.datebox();

	private Decimalbox estimated = Components.decimalbox(BigDecimal.ZERO);

	private CurrencyList currencys = new CurrencyList(false);

	private ProductCostTypeList types = new ProductCostTypeList(false);

	private GeographicList geographics = new GeographicList(false, null);

	private ProductFeatureList features = new ProductFeatureList(false);
	
	private PartyBox partys = new PartyBox(false);

	private String product;

	public ProductCostForm(String product)
	{
		super();

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
				Flow.next(getParent(), new ProductCostGrid(service.findById(product)));
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Product fresh = service.findById(product);
				if(fresh != null)
				{
					if(start.getValue() == null)
						throw new WrongValueException(start, lang.get("message.field.empty"));
					
					if(estimated.getValue() == null)
						throw new WrongValueException(estimated, lang.get("message.field.empty"));
					
					if(currencys.getDomain() == null)
						throw new WrongValueException(currencys, lang.get("message.field.empty"));
					
					ProductCost cost = new ProductCost();
					cost.setCurrency(currencys.getDomainAsRef());
					cost.setEnd(DateTimes.sql(end.getValue()));
					cost.setFeature(features.getDomainAsRef());
					cost.setArea(geographics.getDomainAsRef());
					cost.setEstimated(estimated.getValue());
					cost.setStart(DateTimes.sql(start.getValue()));
					cost.setType(types.getProductCostType());
					cost.setParty(partys.getDomainAsRef());
					cost.setProduct(fresh);

					fresh.getCosts().add(cost);
					
					service.edit(fresh);
				}

				Flow.next(getParent(), new ProductCostGrid(fresh));
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"115px"));
		grid.getColumns().appendChild(new Column());
		grid.setSpan("1");

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("inventory.product.grid.column.start")));
		row1.appendChild(start);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("inventory.product.grid.column.end")));
		row2.appendChild(end);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("inventory.product.grid.column.price")));
		row3.appendChild(estimated);

		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("inventory.product.grid.column.currency")));
		row5.appendChild(currencys);

		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("inventory.product.grid.column.type")));
		row6.appendChild(types);

		Row row7 = new Row();
		row7.appendChild(new Label(lang.get("inventory.product.grid.column.geographic")));
		row7.appendChild(geographics);
		
		Row row8 = new Row();
		row8.appendChild(new Label(lang.get("inventory.product.grid.column.feature")));
		row8.appendChild(features);

		Row row9 = new Row();
		row9.appendChild(new Label(lang.get("inventory.product.grid.column.party")));
		row9.appendChild(partys);
		
		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
		grid.getRows().appendChild(row5);
		grid.getRows().appendChild(row6);
		grid.getRows().appendChild(row7);
		grid.getRows().appendChild(row8);
		grid.getRows().appendChild(row9);
	}
}
