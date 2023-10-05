
package com.kratonsolution.belian.ui.products.product;

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

import com.kratonsolution.belian.common.util.DateTimes;
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.ProductCategoryClassification;
import com.kratonsolution.belian.products.svc.ProductService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.products.category.ProductCategoryList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductCategoryForm extends AbstractForm
{	
	private ProductService service = Springs.get(ProductService.class);

	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();
	
	private ProductCategoryList categorys = new ProductCategoryList(false);
	
	private Checkbox primary = new Checkbox();

	private Textbox comment = Components.textarea(null, false, false);

	private String product;
	
	public ProductCategoryForm(String product)
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
				Flow.next(getParent(), new ProductCategoryGrid(service.getOne(product)));
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
					
					if(categorys.getDomain() == null)
						throw new WrongValueException(categorys, lang.get("message.field.empty"));
					
					ProductCategoryClassification classification = new ProductCategoryClassification();
					classification.setCategory(categorys.getDomainAsRef());
					classification.setStart(DateTimes.sql(start.getValue()));
					classification.setEnd(DateTimes.sql(end.getValue()));
					classification.setPrimary(primary.isChecked());
					classification.setComment(comment.getText());
					classification.setProduct(fresh);
					
					fresh.getClassifications().add(classification);

					service.edit(fresh);
				}
				
				Flow.next(getParent(), new ProductCategoryGrid(fresh));
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
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
