/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.prodcategory;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.general.dm.IndustrySegmentation;
import com.kratonsolution.belian.inventory.dm.ProductCategory;
import com.kratonsolution.belian.inventory.svc.ProductCategoryService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductCategoryEditContent extends FormContent
{	
	private final ProductCategoryService service = Springs.get(ProductCategoryService.class);
	
	private Textbox code = new Textbox();
	
	private Textbox name = new Textbox();
	
	private Textbox note = new Textbox();
	
	private Listbox segmentations = Components.newSelect();
	
	private Row row;
	
	public ProductCategoryEditContent(Row row)
	{
		super();
		this.row = row;
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
				ProductCategoryWindow window = (ProductCategoryWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(code.getText()))
					throw new WrongValueException(code,"Code cannot be empty");
			
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Name cannot be empty");
				
				if(Strings.isNullOrEmpty(note.getText()))
					throw new WrongValueException(note,"Value cannot be empty");
			
				ProductCategory category = service.findOne(RowUtils.string(row, 4));
				category.setCode(code.getText());
				category.setName(name.getText());
				category.setNote(note.getText());
				category.setSegmentation(IndustrySegmentation.valueOf(Components.string(segmentations)));
				
				service.edit(category);
				
				ProductCategoryWindow window = (ProductCategoryWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		ProductCategory category = service.findOne(RowUtils.string(row, 4));
		if(category != null)
		{
			code.setConstraint("no empty");
			code.setWidth("200px");
			code.setText(category.getCode());
			
			name.setConstraint("no empty");
			name.setWidth("300px");
			name.setText(category.getName());
			
			note.setWidth("350px");
			note.setText(category.getNote());
			
			if(!category.isDeleteable())
			{
				code.setReadonly(true);
				name.setReadonly(true);
			}
			
			for(IndustrySegmentation segmentation:IndustrySegmentation.values())
			{
				Listitem listitem = new Listitem(segmentation.name(), segmentation.name());
				segmentations.appendChild(listitem);
				if(category.getSegmentation() != null && segmentation.equals(category.getSegmentation()))
					segmentations.setSelectedItem(listitem);
			}
			
			if(segmentations.getSelectedItem() != null)
				segmentations.setSelectedIndex(0);
				
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"135px"));
			grid.getColumns().appendChild(new Column());
			
			Row row1 = new Row();
			row1.appendChild(new Label("Code"));
			row1.appendChild(code);
			
			Row row2 = new Row();
			row2.appendChild(new Label("Name"));
			row2.appendChild(name);
			
			Row row3 = new Row();
			row3.appendChild(new Label("Note"));
			row3.appendChild(note);
			
			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
		}
	}
}
