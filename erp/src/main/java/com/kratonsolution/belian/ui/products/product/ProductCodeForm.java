
package com.kratonsolution.belian.ui.products.product;

import java.util.Iterator;
import java.util.UUID;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.ProductIdentification;
import com.kratonsolution.belian.products.svc.ProductService;
import com.kratonsolution.belian.ui.BForm;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductCodeForm extends BForm
{	
	private ProductService service = Springs.get(ProductService.class);

	private Textbox name = Components.mandatoryTextBox(false);

	private Textbox comment = Components.textarea(null, false, false);

	private ProductIdentificationTypeList types = new ProductIdentificationTypeList(false);

	private ProductIdentification code;
	
	public ProductCodeForm(ProductIdentification code)
	{
		super();

		this.code = code;
		
		initToolbar();
		initForm();
	}

	@Override
	public void initToolbar()
	{
		appendBreadcrumb(code.getProduct().getName().toUpperCase());
		appendBreadcrumbSeparator();
		appendBreadcrumb(lang.get("inventory.product.grid.column.codes").toUpperCase());
		appendBreadcrumbSeparator();
		appendBreadcrumb(lang.get("nav.form").toUpperCase());
		
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new ProductComponentGrid(code.getProduct()));
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Product fresh = service.getOne(code.getProduct().getId());
				if(fresh != null)
				{
					if(name.getText() == null)
						throw new WrongValueException(name, lang.get("message.field.empty"));
					
					if(code.getId().equals("0"))
					{
						code.setId(UUID.randomUUID().toString());
						code.setType(types.getProductIdentificationType());
						code.setValue(name.getText());
						code.setNote(comment.getText());
						code.setProduct(fresh);
						
						fresh.getCodes().add(code);
					}
					else
					{
						Iterator<ProductIdentification> iterator = fresh.getCodes().iterator();
						while (iterator.hasNext())
						{
							ProductIdentification in = (ProductIdentification) iterator.next();
							if(in.getId().equals(in.getId()))
							{
								in.setType(types.getProductIdentificationType());
								in.setValue(name.getText());
								in.setNote(comment.getText());
								
								break;
							}
						}
					}

					service.edit(fresh);
				}
				
				Flow.next(getParent(), new ProductCodeGrid(fresh));
			}
		});
	}

	@Override
	public void initForm()
	{
		if(!Strings.isNullOrEmpty(code.getValue()))
			name.setText(code.getValue());
		
		types.setProductIdentificationType(code.getType());
		comment.setText(code.getNote());
		
		addColumn(new Column(null,null,"115px"));
		addColumn(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("inventory.product.grid.column.type")));
		row1.appendChild(types);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("inventory.product.grid.column.description")));
		row2.appendChild(name);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("inventory.product.grid.column.note")));
		row3.appendChild(comment);

		addRow(row1);
		addRow(row2);
		addRow(row3);
	}
}
