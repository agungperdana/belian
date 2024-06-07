
package com.kratonsolution.belian.ui.products.product;

import java.util.UUID;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Column;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.svc.ProductService;
import com.kratonsolution.belian.ui.BForm;
import com.kratonsolution.belian.ui.general.uom.UOMList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductForm extends BForm
{	
	private ProductService service = Springs.get(ProductService.class);

	private Datebox start = Components.currentDatebox();

	private Datebox end = Components.datebox();

	private Datebox support = Components.datebox();

	private Textbox name = Components.mandatoryTextBox(false);

	private Textbox comment = Components.textarea(null, false, false);

	private ProductTypeList types = new ProductTypeList(false);

	private UOMList uoms = new UOMList(false);

	private Product product;
	
	private ProductNav nav;
	
	public ProductForm(Product product,ProductNav nav)
	{
		super();
		this.product = product;
		this.nav = nav;

		initToolbar();
		initForm();
	}

	@Override
	public void initToolbar()
	{
		appendBreadcrumb(!Strings.isNullOrEmpty(product.getName())?product.getName().toUpperCase():"");
		appendBreadcrumbSeparator();
		appendBreadcrumb(lang.get("nav.form").toUpperCase());
		
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(start.getValue() == null)
					throw new WrongValueException(start, lang.get("message.field.empty"));
				
				if(name.getText() == null)
					throw new WrongValueException(name, lang.get("message.field.empty"));
				
				product = service.findById(product.getId());
				if(product == null)
				{
					product = new Product();
					product.setId(UUID.randomUUID().toString());
				}
				
				product.setIntroductionDate(DateTimes.sql(start.getValue()));
				product.setDiscontinuationDate(DateTimes.sql(end.getValue()));
				product.setSupportDiscontinuationDate(DateTimes.sql(support.getValue()));
				product.setName(name.getText());
				product.setType(types.getProductType());
				product.setUom(uoms.getDomainAsRef());
				product.setComment(comment.getText());

				service.edit(product);
				
				Clients.showNotification("Data saved");
				
				Flow.next(getParent().getParent().getParent(), new ProductDashboard(service.findById(product.getId())));
			}
		});
	}

	@Override
	public void initForm()
	{
		Product out = service.findById(product.getId());
		if(out != null)
		{
			end.setValue(out.getDiscontinuationDate());
			support.setValue(out.getSupportDiscontinuationDate());
			types.setProductType(out.getType());
			uoms.setDomainAsRef(out.getUom());
			comment.setText(out.getComment());

			if(!Strings.isNullOrEmpty(out.getName()))
				name.setText(out.getName());

			if(out.getIntroductionDate() != null)
				start.setValue(out.getIntroductionDate());
		}
		
		addColumn(new Column(null,null,"115px"));
		addColumn(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("inventory.product.grid.column.name")));
		row1.appendChild(name);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("inventory.product.grid.column.start")));
		row2.appendChild(start);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("inventory.product.grid.column.end")));
		row3.appendChild(end);

		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("inventory.product.grid.column.supportend")));
		row4.appendChild(support);

		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("inventory.product.grid.column.type")));
		row5.appendChild(types);

		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("inventory.product.grid.column.uom")));
		row6.appendChild(uoms);

		Row row7 = new Row();
		row7.appendChild(new Label(lang.get("inventory.product.grid.column.note")));
		row7.appendChild(comment);

		addRow(row1);
		addRow(row2);
		addRow(row3);
		addRow(row4);
		addRow(row5);
		addRow(row6);
		addRow(row7);
	}
}
