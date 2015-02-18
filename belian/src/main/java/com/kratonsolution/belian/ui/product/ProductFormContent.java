/**
 * 
 */
package com.kratonsolution.belian.ui.product;

import java.util.Date;
import java.util.UUID;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductCategory;
import com.kratonsolution.belian.inventory.svc.ProductCategoryService;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class ProductFormContent extends FormContent
{	
	private final ProductService service = Springs.get(ProductService.class);
	
	private final ProductCategoryService categoryService = Springs.get(ProductCategoryService.class);
	
	private Datebox start = new Datebox();
	
	private Datebox end = new Datebox();
	
	private Textbox name = new Textbox();
	
	private Listbox categorys = new Listbox();
	
	private Listbox types = new Listbox();
	
	public ProductFormContent()
	{
		super();
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
				ProductWindow window = (ProductWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(start.getValue() == null)
					throw new WrongValueException(start,"Code cannot be empty");
			
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Name cannot be empty");
			
				Product product = new Product();
				product.setId(UUID.randomUUID().toString());
				product.setStart(start.getValue());
				product.setEnd(end.getValue());
				product.setName(name.getText());
				product.setType(Product.Type.valueOf(types.getSelectedItem().getValue().toString()));
				product.setCategory(categoryService.findOne(categorys.getSelectedItem().getValue().toString()));
				
				service.add(product);
				
				ProductWindow window = (ProductWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		start.setConstraint("no empty");
		start.setValue(new Date());
		
		name.setConstraint("no empty");
		name.setWidth("300px");
		
		types.setMold("select");
		categorys.setMold("select");
		
		for(Product.Type type:Product.Type.values())
			types.appendChild(new Listitem(type.name(),type.name()));
		
		for(ProductCategory category:categoryService.findAll())
			categorys.appendChild(new Listitem(category.getName(),category.getId()));
		
		types.setSelectedIndex(0);

		if(!categorys.getItems().isEmpty())
			categorys.setSelectedIndex(0);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Start"));
		row1.appendChild(start);
		
		Row row2 = new Row();
		row2.appendChild(new Label("End"));
		row2.appendChild(end);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Name"));
		row3.appendChild(name);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Type"));
		row4.appendChild(types);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Category"));
		row5.appendChild(categorys);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}
}
