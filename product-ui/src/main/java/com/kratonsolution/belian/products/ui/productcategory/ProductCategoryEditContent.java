package com.kratonsolution.belian.products.ui.productcategory;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.ui.AbstractForm;
import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.common.ui.util.FlowHelper;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.products.api.application.ProductCategoryService;
import com.kratonsolution.belian.products.api.application.ProductCategoryUpdateCommand;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class ProductCategoryEditContent extends AbstractForm
{	
	private static final long serialVersionUID = -4267104303139844670L;

	private ProductCategoryService service = Springs.get(ProductCategoryService.class);

	private Textbox name = Components.mandatoryTextBox(false);

	private Textbox comment = Components.stdTextBox(null, false);
	
	private Listbox parents = Components.newSelect();

	private String ProductCategoryCode;
	
	public ProductCategoryEditContent(@NonNull String ProductCategoryCode)
	{
		super();
		this.ProductCategoryCode= ProductCategoryCode;
		initToolbar();
		initForm();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK, e->FlowHelper.next(ProductCategoryUIEvent.toGrid()));
		toolbar.getSave().addEventListener(Events.ON_CLICK, e->{
			
			if(Strings.isNullOrEmpty(name.getText()))
				throw new WrongValueException(name,Labels.getLabel("warning.empty"));

			ProductCategoryUpdateCommand command = new ProductCategoryUpdateCommand();
			command.setName(name.getText());
			command.setComment(comment.getText());
			
			service.update(command);
			
			FlowHelper.next(ProductCategoryUIEvent.toGrid());
		});
	}

	@Override
	public void initForm()
	{
//		ProductCategoryData opt = service.getByCode(this.ProductCategoryCode);
//		if(opt != null)
//		{
//			code.setText(opt.getCode());
//			name.setText(opt.getName());
//			note.setText(opt.getNote());
//			enabled.setChecked(opt.isEnabled());
//			
//			ProductCategoryGroupUIHelper.select(groups, opt.getGroup());
//		}
//		
//		grid.appendChild(new Columns());
//		grid.getColumns().appendChild(new Column(null,null,"100px"));
//		grid.getColumns().appendChild(new Column());
//
//		Row row1 = new Row();
//		row1.appendChild(new Label(Labels.getLabel("label.code")));
//		row1.appendChild(code);
//
//		Row row2 = new Row();
//		row2.appendChild(new Label(Labels.getLabel("label.name")));
//		row2.appendChild(name);
//
//		Row row3 = new Row();
//		row3.appendChild(new Label(Labels.getLabel("label.note")));
//		row3.appendChild(note);
//
//		Row row4 = new Row();
//		row4.appendChild(new Label(Labels.getLabel("ProductCategory.grid.group")));
//		row4.appendChild(groups);
//		
//		Row row5 = new Row();
//		row5.appendChild(new Label(Labels.getLabel("label.status")));
//		row5.appendChild(enabled);
//
//		rows.appendChild(row1);
//		rows.appendChild(row2);
//		rows.appendChild(row3);
//		rows.appendChild(row4);
//		rows.appendChild(row5);
	}
}
