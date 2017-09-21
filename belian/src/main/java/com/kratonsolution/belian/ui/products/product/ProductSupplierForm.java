/**
 * 
 */
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
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.ProductSupplier;
import com.kratonsolution.belian.products.svc.ProductService;
import com.kratonsolution.belian.ui.BForm;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductSupplierForm extends BForm
{	
	private ProductService service = Springs.get(ProductService.class);

	private Datebox start = Components.currentDatebox();

	private Datebox end = Components.datebox();

	private PartyBox suppliers = new PartyBox(true,false);

	private Textbox note = Components.stdTextBox(null, false);

	private ProductSupplier supplier;

	public ProductSupplierForm(ProductSupplier supplier)
	{
		super();

		this.supplier = supplier;

		initToolbar();
		initForm();
	}

	@Override
	public void initToolbar()
	{
		appendBreadcrumb(supplier.getProduct().getName().toUpperCase());
		appendBreadcrumbSeparator();
		appendBreadcrumb(lang.get("inventory.product.grid.column.suppliers").toUpperCase());
		appendBreadcrumbSeparator();
		appendBreadcrumb(lang.get("nav.form").toUpperCase());
		
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new ProductSupplierGrid(supplier.getProduct()));
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Product fresh = service.findOne(supplier.getProduct().getId());
				if(fresh != null)
				{
					if(start.getValue() == null)
						throw new WrongValueException(start, lang.get("message.field.empty"));
					
					if(suppliers.getDomain() == null)
						throw new WrongValueException(suppliers, lang.get("message.field.empty"));
					
					if(supplier.getId().equals("0"))
					{
						supplier.setId(UUID.randomUUID().toString());
						supplier.setStart(DateTimes.sql(start.getValue()));
						supplier.setEnd(DateTimes.sql(end.getValue()));
						supplier.setSupplier(suppliers.getDomainAsRef());
						supplier.setNote(note.getText());
						supplier.setProduct(fresh);

						fresh.getSuppliers().add(supplier);
					}
					else
					{
						Iterator<ProductSupplier> iterator = fresh.getSuppliers().iterator();
						while (iterator.hasNext())
						{
							ProductSupplier in = (ProductSupplier) iterator.next();
							if(in.getId().equals(in.getId()))
							{
								in.setStart(DateTimes.sql(start.getValue()));
								in.setEnd(DateTimes.sql(end.getValue()));
								in.setSupplier(suppliers.getDomainAsRef());
								in.setNote(note.getText());

								break;
							}
						}
					}

					service.edit(fresh);
				}

				Flow.next(getParent(), new ProductSupplierGrid(fresh));
			}
		});
	}

	@Override
	public void initForm()
	{
		start.setValue(supplier.getStart());
		end.setValue(supplier.getEnd());
		suppliers.setDomainAsRef(supplier.getSupplier());
		note.setText(supplier.getNote());
		
		addColumn(new Column(null,null,"115px"));
		addColumn(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("inventory.product.grid.column.start")));
		row1.appendChild(start);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("inventory.product.grid.column.end")));
		row2.appendChild(end);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("inventory.product.grid.column.party")));
		row3.appendChild(suppliers);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("inventory.product.grid.column.note")));
		row4.appendChild(note);

		addRow(row1);
		addRow(row2);
		addRow(row3);
		addRow(row4);
	}
}
