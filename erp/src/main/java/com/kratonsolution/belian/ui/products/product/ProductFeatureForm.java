
package com.kratonsolution.belian.ui.products.product;

import java.util.Iterator;
import java.util.UUID;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;

import com.kratonsolution.belian.common.util.DateTimes;
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.ProductFeatureApplicability;
import com.kratonsolution.belian.products.svc.ProductService;
import com.kratonsolution.belian.ui.BForm;
import com.kratonsolution.belian.ui.products.feature.ProductFeatureCategoryList;
import com.kratonsolution.belian.ui.products.feature.ProductFeatureList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductFeatureForm extends BForm
{	
	private ProductService service = Springs.get(ProductService.class);

	private Datebox start = Components.currentDatebox();

	private Datebox end = Components.datebox();

	private ProductFeatureList features = new ProductFeatureList(false);

	private ProductFeatureCategoryList categorys = new ProductFeatureCategoryList(false);

	private ProductFeatureApplicability feature;

	public ProductFeatureForm(ProductFeatureApplicability feature)
	{
		super();

		this.feature = feature;

		initToolbar();
		initForm();
	}

	@Override
	public void initToolbar()
	{
		appendBreadcrumb(feature.getProduct().getName().toUpperCase());
		appendBreadcrumbSeparator();
		appendBreadcrumb(lang.get("inventory.product.grid.column.features").toUpperCase());
		appendBreadcrumbSeparator();
		appendBreadcrumb(lang.get("nav.form").toUpperCase());
		
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new ProductComponentGrid(feature.getProduct()));
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Product fresh = service.getOne(feature.getProduct().getId());
				if(fresh != null)
				{
					if(start.getValue() == null)
						throw new WrongValueException(start, lang.get("message.field.empty"));
					
					if(features.getDomain() == null)
						throw new WrongValueException(features, lang.get("message.field.empty"));
					
					if(categorys.getProductFeatureCategory() == null)
						throw new WrongValueException(categorys, lang.get("message.field.empty"));
					
					if(feature.getId().equals("0"))
					{
						feature.setId(UUID.randomUUID().toString());
						feature.setStart(DateTimes.sql(start.getValue()));
						feature.setEnd(DateTimes.sql(end.getValue()));
						feature.setFeature(features.getDomainAsRef());
						feature.setCategory(categorys.getProductFeatureCategory());
						feature.setProduct(fresh);

						fresh.getFeatures().add(feature);
					}
					else
					{
						Iterator<ProductFeatureApplicability> iterator = fresh.getFeatures().iterator();
						while (iterator.hasNext())
						{
							ProductFeatureApplicability in = (ProductFeatureApplicability) iterator.next();
							if(in.getId().equals(in.getId()))
							{
								in.setStart(DateTimes.sql(start.getValue()));
								in.setEnd(DateTimes.sql(end.getValue()));
								in.setFeature(features.getDomainAsRef());
								in.setCategory(categorys.getProductFeatureCategory());

								break;
							}
						}
					}

					service.edit(fresh);
				}

				Flow.next(getParent(), new ProductFeatureGrid(fresh));
			}
		});
	}

	@Override
	public void initForm()
	{
		start.setValue(feature.getStart());
		end.setValue(feature.getEnd());
		features.setDomainAsRef(feature.getFeature());
		categorys.setProductFeatureCategory(feature.getCategory());
		
		addColumn(new Column(null,null,"115px"));
		addColumn(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("inventory.product.grid.column.start")));
		row1.appendChild(start);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("inventory.product.grid.column.end")));
		row2.appendChild(end);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("inventory.product.grid.column.feature")));
		row3.appendChild(features);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("inventory.product.grid.column.category")));
		row4.appendChild(categorys);

		addRow(row1);
		addRow(row2);
		addRow(row3);
		addRow(row4);
	}
}
