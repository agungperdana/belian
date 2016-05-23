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
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.Dates;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductCategory;
import com.kratonsolution.belian.inventory.dm.ProductType;
import com.kratonsolution.belian.inventory.dm.UnitOfMeasure;
import com.kratonsolution.belian.inventory.svc.ProductCategoryService;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.inventory.svc.UnitOfMeasureService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.inventory.product.code.CodeTab;
import com.kratonsolution.belian.ui.inventory.product.component.ComponentTab;
import com.kratonsolution.belian.ui.inventory.product.cost.CostTab;
import com.kratonsolution.belian.ui.inventory.product.feature.FeatureTab;
import com.kratonsolution.belian.ui.inventory.product.price.PriceTab;
import com.kratonsolution.belian.ui.inventory.product.supplier.SupplierTab;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductEditContent extends FormContent implements Refreshable
{	
	private final ProductService service = Springs.get(ProductService.class);

	private final ProductCategoryService categoryService = Springs.get(ProductCategoryService.class);
	
	private final UnitOfMeasureService unitOfMeasureService = Springs.get(UnitOfMeasureService.class);

	private Datebox start = Components.currentDatebox();

	private Datebox end = new Datebox();
	
	private Textbox code = Components.textBox(null);

	private Textbox name = Components.textBox(null);

	private Listbox categorys = Components.newSelect();

	private Listbox types = Components.newSelect();
	
	private Listbox uoms = Components.newSelect();
	
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
					throw new WrongValueException(start,"Available start date cannot be empty");
			
				if(Strings.isNullOrEmpty(code.getText()))
					throw new WrongValueException(code,"Code cannot be empty");
				
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Name cannot be empty");
			
				if(categorys.getSelectedCount() == 0)
					throw new WrongValueException(categorys,"Please select category first");
				
				if(uoms.getSelectedCount() == 0)
					throw new WrongValueException(uoms,"Please select UoM first");
				
				if(types.getSelectedCount() == 0)
					throw new WrongValueException(categorys,"Please select product type first");
				
				Product product = service.findOne(RowUtils.string(row, 8));
				product.setStart(Dates.sql(start.getValue()));
				product.setEnd(Dates.sql(end.getValue()));
				product.setCode(code.getText());
				product.setName(name.getText());
				product.setType(ProductType.valueOf(Components.string(types)));
				product.setCategory(categoryService.findOne(Components.string(categorys)));
				product.setUom(unitOfMeasureService.findOne(Components.string(uoms)));
				
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
		Product product = service.findOne(RowUtils.string(row, 8));
		if(product != null)
		{
			if(product.getStart() != null)
				start.setValue(product.getStart());
			
			if(product.getEnd() != null)
				end.setValue(product.getEnd());
			
			code.setText(product.getCode());
			name.setText(product.getName());
			
			for(ProductType type:ProductType.values())
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
			
			for(UnitOfMeasure measure:unitOfMeasureService.findAll())
			{
				Listitem listitem = new Listitem(measure.getName(),measure.getId());
				uoms.appendChild(listitem);
				if(product.getUom() != null && measure.getId().equals(product.getUom().getId()))
					uoms.setSelectedItem(listitem);
			}
			
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"120px"));
			grid.getColumns().appendChild(new Column());
			grid.getColumns().appendChild(new Column(null,null,"120px"));
			grid.getColumns().appendChild(new Column());
			grid.setSpan("1");
			
			Row row1 = new Row();
			row1.appendChild(new Label("Start"));
			row1.appendChild(start);
			row1.appendChild(new Label("End"));
			row1.appendChild(end);
			
			Row row2 = new Row();
			row2.appendChild(new Label("Code"));
			row2.appendChild(code);
			row2.appendChild(new Label("Unit of Measure"));
			row2.appendChild(uoms);
			
			Row row3 = new Row();
			row3.appendChild(new Label("Name"));
			row3.appendChild(name);
			row3.appendChild(new Label("Type"));
			row3.appendChild(types);
			
			Row row4 = new Row();
			row4.appendChild(new Label("Category"));
			row4.appendChild(categorys);

			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			rows.appendChild(row4);
		}
	}
	
	protected void initTab()
	{
		Product product = service.findOne(RowUtils.string(row, 8));
	
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
