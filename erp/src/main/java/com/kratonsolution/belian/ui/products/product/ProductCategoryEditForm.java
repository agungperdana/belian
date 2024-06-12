package com.kratonsolution.belian.ui.products.product;

import java.util.Iterator;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.product.impl.orm.Product;
import com.kratonsolution.belian.product.impl.orm.ProductCategoryClassification;
import com.kratonsolution.belian.product.impl.application.ProductService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.products.category.ProductCategoryList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public class ProductCategoryEditForm extends AbstractForm
{	
	private ProductService service = Springs.get(ProductService.class);

	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();
	
	private ProductCategoryList categorys = new ProductCategoryList(false);
	
	private Checkbox primary = new Checkbox();

	private Textbox comment = Components.textarea(null, false, false);

	private ProductCategoryClassification classification;
	
	public ProductCategoryEditForm(ProductCategoryClassification classification)
	{
		super();

		this.classification = classification;
		
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
				Flow.next(getParent(), new ProductCategoryGrid(classification.getProduct()));
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Product fresh = service.findById(classification.getProduct().getId());
				if(fresh != null && classification != null)
				{
					if(start.getValue() == null)
						throw new WrongValueException(start, lang.get("message.field.empty"));
					
					if(categorys.getDomain() == null)
						throw new WrongValueException(categorys, lang.get("message.field.empty"));
					
					Iterator<ProductCategoryClassification> iterator = fresh.getClassifications().iterator();
					while (iterator.hasNext())
					{
						ProductCategoryClassification in = (ProductCategoryClassification) iterator.next();
						if(in.getId().equals(classification.getId()))
						{
							in.setCategory(categorys.getDomainAsRef());
							in.setStart(DateTimes.sql(start.getValue()));
							in.setEnd(DateTimes.sql(end.getValue()));
							in.setPrimary(primary.isChecked());
							in.setComment(comment.getText());
							
							break;
						}
					}

					service.edit(fresh);
				}
				
				Flow.next(getParent(), new ProductCategoryGrid(fresh));
			}
		});
	}

	@Override
	public void initForm()
	{
		if(classification != null)
		{
			start.setValue(classification.getStart());
			end.setValue(classification.getEnd());
			categorys.setDomainAsRef(classification.getCategory());
			comment.setText(classification.getComment());
			primary.setChecked(classification.isPrimary());
		}
		
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
		row3.appendChild(new Label(lang.get("inventory.product.grid.column.category")));
		row3.appendChild(categorys);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("inventory.product.grid.column.primary")));
		row4.appendChild(primary);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("inventory.product.grid.column.note")));
		row5.appendChild(comment);

		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
		grid.getRows().appendChild(row4);
		grid.getRows().appendChild(row5);
	}
}
