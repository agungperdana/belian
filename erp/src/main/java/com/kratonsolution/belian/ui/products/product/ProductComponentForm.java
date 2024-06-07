
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
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.ProductComponent;
import com.kratonsolution.belian.products.svc.ProductService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductComponentForm extends AbstractForm
{	
	private ProductService service = Springs.get(ProductService.class);

	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();

	private Decimalbox quantity = Components.decimalbox(BigDecimal.ONE);
	
	private ProductBox productBox = new ProductBox(false, false);
	
	private ProductComponentTypeList types = new ProductComponentTypeList(false);

	private Textbox note = Components.stdTextBox(null, false);
	
	private String product;
	
	public ProductComponentForm(String product)
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
				Flow.next(getParent(), new ProductComponentGrid(service.findById(product)));
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
					
					if(quantity.getValue() == null)
						throw new WrongValueException(quantity, lang.get("message.field.empty"));
					
					if(productBox.getDomain() == null)
						throw new WrongValueException(productBox, lang.get("message.field.empty"));
					
					ProductComponent component = new ProductComponent();
					component.setStart(DateTimes.sql(start.getValue()));
					component.setEnd(DateTimes.sql(end.getValue()));
					component.setProduct(productBox.getDomainAsRef());
					component.setQuantity(quantity.getValue());
					component.setType(types.getProductComponentType());
					component.setNote(note.getText());

					component.setParent(fresh);
					
					fresh.getComponents().add(component);

					service.edit(fresh);
				}
				
				Flow.next(getParent(), new ProductComponentGrid(fresh));
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"115px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("inventory.product.grid.column.start")));
		row1.appendChild(start);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("inventory.product.grid.column.end")));
		row2.appendChild(end);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("inventory.product.grid.column.product")));
		row3.appendChild(productBox);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("inventory.product.grid.column.quantity")));
		row4.appendChild(quantity);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("inventory.product.grid.column.type")));
		row5.appendChild(types);

		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
		grid.getRows().appendChild(row4);
		grid.getRows().appendChild(row5);
	}
}
