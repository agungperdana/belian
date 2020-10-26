package com.kratonsolution.belian.products.ui.productcategory;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.ui.AbstractForm;
import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.common.ui.util.FlowHelper;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.products.api.application.ProductCategoryCreateCommand;
import com.kratonsolution.belian.products.api.application.ProductCategoryService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class ProductCategoryFormContent extends AbstractForm
{	
	private static final long serialVersionUID = -7870478694132790931L;

	private ProductCategoryService service = Springs.get(ProductCategoryService.class);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private Textbox comment = Components.stdTextBox(null, false);
	
	private Listbox parents = Components.newSelect();
	
	public ProductCategoryFormContent()
	{
		super();
		initToolbar();
		initForm();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK, e->FlowHelper.next(ProductCategoryUIEvent.toGrid()));
		
		toolbar.getSave().addEventListener(Events.ON_CLICK, e->{
			
			if(Strings.isNullOrEmpty(name.getText()))
				throw new WrongValueException(name, Labels.getLabel("warning.empty"));
		
			ProductCategoryCreateCommand command = new ProductCategoryCreateCommand();
			command.setName(name.getText());
			command.setComment(comment.getText());
			
			service.create(command);
			
			FlowHelper.next(ProductCategoryUIEvent.toGrid());
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(Labels.getLabel("label.code")));
		row1.appendChild(name);
		
		Row row2 = new Row();
		row2.appendChild(new Label(Labels.getLabel("label.name")));
		row2.appendChild(comment);
		
		Row row3 = new Row();
		row3.appendChild(new Label(Labels.getLabel("label.note")));
		row3.appendChild(parents);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
	}
}
