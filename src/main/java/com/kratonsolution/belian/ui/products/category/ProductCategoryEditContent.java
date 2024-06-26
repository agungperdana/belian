
package com.kratonsolution.belian.ui.products.category;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.products.dm.ProductCategory;
import com.kratonsolution.belian.products.svc.ProductCategoryService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductCategoryEditContent extends AbstractForm
{	
	private ProductCategoryService service = Springs.get(ProductCategoryService.class);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private Textbox note = Components.stdTextBox(null,false);
	
	private ProductCategoryList parents = new ProductCategoryList(false);
	
	private ProductCategory category;

	private Component canvas;
	
	public ProductCategoryEditContent(Component canvas,ProductCategory category)
	{
		super();
		this.canvas = canvas;
		this.category = category;
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
				Flow.next(canvas,null);
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(category != null)
				{
					category.setName(name.getText());
					category.setNote(note.getText());
					category.setParent(parents.getDomain());
					
					service.edit(category);
					
					Flow.next(canvas.getParent().getParent(), new ProductCategoryContent());
					
					Clients.showNotification(lang.get("message.updatedata"));
				}
			}
		});
		
		Toolbarbutton toolbarbutton = new Toolbarbutton(lang.get("generic.grid.column.child"), "/icons/new-warehouse.png");
		toolbarbutton.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(category != null)
				{
					Flow.next(canvas, new ProductCategoryFormContent(category));
				}
			}
		});
		
		toolbar.appendChild(toolbarbutton);
	}

	@Override
	public void initForm()
	{
		if(category != null)
		{
			name.setText(category.getName());
			note.setText(category.getNote());
			parents.setDomain(category.getParent());
		}
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("inventory.product.grid.column.name")));
		row1.appendChild(name);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("inventory.product.grid.column.note")));
		row2.appendChild(note);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("inventory.product.grid.column.parent")));
		row3.appendChild(parents);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
	}
}
