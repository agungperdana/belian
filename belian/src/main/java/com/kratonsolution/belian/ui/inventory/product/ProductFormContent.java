/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.product;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductType;
import com.kratonsolution.belian.inventory.svc.ProductCategoryService;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.inventory.svc.UnitOfMeasureService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductFormContent extends FormContent
{	
	private ProductService service = Springs.get(ProductService.class);
	
	private UnitOfMeasureService unitOfMeasureService = Springs.get(UnitOfMeasureService.class);
	
	private ProductCategoryService categoryService = Springs.get(ProductCategoryService.class);
	
	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();
	
	private Textbox code = Components.mandatoryTextBox(false);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private Doublebox min = Components.stdDoubleBox(0);
	
	private Listbox categorys = Components.newSelect(categoryService.findAll(), true);
	
	private Listbox types = Components.newSelect();
	
	private Listbox uoms = Components.newSelect(unitOfMeasureService.findAll(), true);
	
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
					throw new WrongValueException(start,lang.get("message.field.empty"));
			
				if(Strings.isNullOrEmpty(code.getText()))
					throw new WrongValueException(code,lang.get("message.field.empty"));
				
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,lang.get("message.field.empty"));
			
				if(categorys.getSelectedCount() == 0)
					throw new WrongValueException(categorys,lang.get("message.field.empty"));
				
				if(uoms.getSelectedCount() == 0)
					throw new WrongValueException(uoms,lang.get("message.field.empty"));
				
				if(types.getSelectedCount() == 0)
					throw new WrongValueException(categorys,lang.get("message.field.empty"));
				
				Product product = new Product();
				product.setStart(DateTimes.sql(start.getValue()));
				product.setEnd(DateTimes.sql(end.getValue()));
				product.setCode(code.getText());
				product.setName(name.getText());
				product.setType(ProductType.valueOf(Components.string(types)));
				product.setCategory(categoryService.findOne(Components.string(categorys)));
				product.setUom(unitOfMeasureService.findOne(Components.string(uoms)));
				product.setMinStok(min.getValue().intValue());
				
				service.add(product);
				
				ProductWindow window = (ProductWindow)getParent();
				window.removeCreateForm();
				window.insertEditForm(Components.row(9, product.getId()));
			}
		});
	}

	@Override
	public void initForm()
	{		
		for(ProductType type:ProductType.values())
			types.appendChild(new Listitem(type.display(utils.getLanguage()),type.name()));
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"150px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("inventory.product.form.start")));
		row1.appendChild(start);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("inventory.product.form.end")));
		row2.appendChild(end);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("inventory.product.form.code")));
		row3.appendChild(code);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("inventory.product.form.name")));
		row4.appendChild(name);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("inventory.product.form.type")));
		row5.appendChild(types);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("inventory.product.form.category")));
		row6.appendChild(categorys);
		
		Row row7 = new Row();
		row7.appendChild(new Label(lang.get("inventory.product.form.uom")));
		row7.appendChild(uoms);
		
		Row row8 = new Row();
		row8.appendChild(new Label(lang.get("inventory.product.form.minstock")));
		row8.appendChild(min);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row7);
		rows.appendChild(row8);
	}
}
