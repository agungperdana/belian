/**
 * 
 */
package com.kratonsolution.belian.ui.product;

import java.util.Date;

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
import com.kratonsolution.belian.inventory.dm.UnitOfMeasure;
import com.kratonsolution.belian.inventory.svc.ProductCategoryService;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.inventory.svc.UnitOfMeasureService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class ProductFormContent extends FormContent
{	
	private final ProductService service = Springs.get(ProductService.class);
	
	private final UnitOfMeasureService unitOfMeasureService = Springs.get(UnitOfMeasureService.class);
	
	private final ProductCategoryService categoryService = Springs.get(ProductCategoryService.class);
	
	private Datebox start = new Datebox();
	
	private Datebox end = new Datebox();
	
	private Textbox code = new Textbox();
	
	private Textbox name = new Textbox();
	
	private Listbox categorys = new Listbox();
	
	private Listbox types = new Listbox();
	
	private Listbox uoms = new Listbox();
	
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
				product.setStart(start.getValue());
				product.setEnd(end.getValue());
				product.setCode(code.getText());
				product.setName(name.getText());
				product.setType(Product.Type.valueOf(Components.string(types)));
				product.setCategory(categoryService.findOne(Components.string(categorys)));
				product.setUom(unitOfMeasureService.findOne(Components.string(uoms)));
				
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
		
		code.setConstraint("no empty");
		code.setWidth("250px");
		
		name.setConstraint("no empty");
		name.setWidth("300px");
		
		types.setMold("select");
		categorys.setMold("select");
		uoms.setMold("select");
		
		for(Product.Type type:Product.Type.values())
			types.appendChild(new Listitem(type.name(),type.name()));
		
		for(ProductCategory category:categoryService.findAll())
			categorys.appendChild(new Listitem(category.getName(),category.getId()));
		
		for(UnitOfMeasure measure:unitOfMeasureService.findAll())
			uoms.appendChild(new Listitem(measure.getCode(),measure.getId()));
		
		types.setSelectedIndex(0);

		if(!categorys.getItems().isEmpty())
			categorys.setSelectedIndex(0);
		
		if(!uoms.getChildren().isEmpty())
			uoms.setSelectedIndex(0);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Start"));
		row1.appendChild(start);
		
		Row row2 = new Row();
		row2.appendChild(new Label("End"));
		row2.appendChild(end);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Code"));
		row3.appendChild(code);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Name"));
		row4.appendChild(name);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Type"));
		row5.appendChild(types);
		
		Row row6 = new Row();
		row6.appendChild(new Label("Category"));
		row6.appendChild(categorys);
		
		Row row7 = new Row();
		row7.appendChild(new Label("Unit of Measure"));
		row7.appendChild(uoms);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row7);
	}
}
