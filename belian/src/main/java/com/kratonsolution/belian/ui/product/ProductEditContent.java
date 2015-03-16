/**
 * 
 */
package com.kratonsolution.belian.ui.product;

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
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductCategory;
import com.kratonsolution.belian.inventory.svc.ProductCategoryService;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.product.code.CodeTab;
import com.kratonsolution.belian.ui.product.component.ComponentTab;
import com.kratonsolution.belian.ui.product.cost.CostTab;
import com.kratonsolution.belian.ui.product.feature.FeatureTab;
import com.kratonsolution.belian.ui.product.price.PriceTab;
import com.kratonsolution.belian.ui.product.supplier.SupplierTab;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class ProductEditContent extends FormContent implements Refreshable
{	
	private final ProductService service = Springs.get(ProductService.class);

	private final ProductCategoryService categoryService = Springs.get(ProductCategoryService.class);

	private Datebox start = new Datebox();

	private Datebox end = new Datebox();
	
	private Textbox code = new Textbox();

	private Textbox name = new Textbox();

	private Listbox categorys = new Listbox();

	private Listbox types = new Listbox();
	
	private Tabbox tabbox;

	private Row row;
		
	public ProductEditContent(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
		initTab();
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
				window.removeEditForm();
				window.insertGrid();
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(start.getValue() == null)
					throw new WrongValueException(start,"Availability Start cannot be empty");

				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Name cannot be empty");

				Product product = service.findOne(RowUtils.rowValue(row, 7));
				product.setStart(start.getValue());
				product.setEnd(end.getValue());
				product.setCode(code.getText());
				product.setName(name.getText());
				product.setType(Product.Type.valueOf(types.getSelectedItem().getValue().toString()));
				product.setCategory(categoryService.findOne(categorys.getSelectedItem().getValue().toString()));

				service.edit(product);

				ProductWindow window = (ProductWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		Product product = service.findOne(RowUtils.rowValue(row, 7));
		
		start.setConstraint("no empty");
		start.setValue(product.getStart());
		
		end.setValue(product.getEnd());
		
		code.setConstraint("no empty");
		code.setWidth("250px");
		code.setText(product.getCode());
		
		name.setConstraint("no empty");
		name.setWidth("300px");
		name.setText(product.getName());
		
		types.setMold("select");
		categorys.setMold("select");
		
		for(Product.Type type:Product.Type.values())
		{
			Listitem listitem = new Listitem(type.name(),type.name());
			types.appendChild(listitem);
			if(type.equals(product.getType()))
				types.setSelectedItem(listitem);
		}
		
		for(ProductCategory category:categoryService.findAll())
		{
			Listitem listitem = new Listitem(category.getName(),category.getId());
			categorys.appendChild(listitem);
			if(category.getId().equals(product.getCategory().getId()))
				categorys.setSelectedItem(listitem);
		}
		
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
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
	}
	
	protected void initTab()
	{
		Product product = service.findOne(RowUtils.rowValue(row, 7));
	
		tabbox = new Tabbox();
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		
		CodeTab code = new CodeTab(product,this);
		FeatureTab feature = new FeatureTab(product,this);
		ComponentTab component = new ComponentTab(product,this);
		SupplierTab supplier = new SupplierTab(product,this);
		PriceTab price = new PriceTab(product, this);
		CostTab cost = new CostTab(product, this);
		
		tabbox.getTabs().appendChild(code.getHeader());
		tabbox.getTabs().appendChild(feature.getHeader());
		tabbox.getTabs().appendChild(component.getHeader());
		tabbox.getTabs().appendChild(supplier.getHeader());
		tabbox.getTabs().appendChild(price.getHeader());
		tabbox.getTabs().appendChild(cost.getHeader());
		
		tabbox.getTabpanels().appendChild(code.getBody());
		tabbox.getTabpanels().appendChild(feature.getBody());
		tabbox.getTabpanels().appendChild(component.getBody());
		tabbox.getTabpanels().appendChild(supplier.getBody());
		tabbox.getTabpanels().appendChild(price.getBody());
		tabbox.getTabpanels().appendChild(cost.getBody());
		
		appendChild(tabbox);
	}

	@Override
	public void refresh()
	{
		removeChild(tabbox);
		initTab();
	}
	
	public void setSelectedTab(int index)
	{
		this.tabbox.setSelectedIndex(index);
	}
}
