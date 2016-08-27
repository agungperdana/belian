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
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.dm.UnitOfMeasure;
import com.kratonsolution.belian.inventory.dm.ProductType;
import com.kratonsolution.belian.inventory.svc.ProductCategoryService;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.inventory.svc.UnitOfMeasureService;
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.ProductCategory;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.inventory.product.code.CodeTab;
import com.kratonsolution.belian.ui.inventory.product.component.ComponentTab;
import com.kratonsolution.belian.ui.inventory.product.cost.CostTab;
import com.kratonsolution.belian.ui.inventory.product.feature.FeatureTab;
import com.kratonsolution.belian.ui.inventory.product.price.PriceTab;
import com.kratonsolution.belian.ui.inventory.product.supplier.SupplierTab;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductEditContent extends FormContent implements Refreshable
{	
	private ProductService service = Springs.get(ProductService.class);

	private ProductCategoryService categoryService = Springs.get(ProductCategoryService.class);

	private UnitOfMeasureService unitOfMeasureService = Springs.get(UnitOfMeasureService.class);

	private Datebox start = Components.currentDatebox();

	private Datebox end = new Datebox();

	private Textbox code = Components.textBox(null);

	private Textbox name = Components.textBox(null);

	private Listbox categorys = Components.newSelect();

	private Listbox types = Components.newSelect();

	private Listbox uoms = Components.newSelect();
	
	private Doublebox min = Components.stdDoubleBox(0);

	private Tabbox tabbox;

	private Row row;

	public ProductEditContent(Row row)
	{
		super();
		this.row = row;
		this.tabbox = new Tabbox();
		this.tabbox.appendChild(new Tabs());
		this.tabbox.appendChild(new Tabpanels());
		
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
				Flow.next(getParent(), new ProductGridContent());
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

				Product product = service.findOne(RowUtils.id(row));
				product.setStart(DateTimes.sql(start.getValue()));
				product.setEnd(DateTimes.sql(end.getValue()));
				product.setCode(code.getText());
				product.setName(name.getText());
				product.setType(ProductType.valueOf(Components.string(types)));
				product.setCategory(categoryService.findOne(Components.string(categorys)));
				product.setUom(unitOfMeasureService.findOne(Components.string(uoms)));
				product.setMinStok(min.getValue().intValue());

				service.edit(product);

				Flow.next(getParent(), new ProductGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		Product product = service.findOne(RowUtils.id(row));
		if(product != null)
		{
			if(product.getStart() != null)
				start.setValue(product.getStart());

			if(product.getEnd() != null)
				end.setValue(product.getEnd());

			code.setText(product.getCode());
			name.setText(product.getName());
			min.setValue(product.getMinStok());

			for(ProductType type:ProductType.values())
			{
				Listitem listitem = new Listitem(type.display(utils.getLanguage()),type.name());
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
			row1.appendChild(new Label(lang.get("inventory.product.form.start")));
			row1.appendChild(start);
			row1.appendChild(new Label(lang.get("inventory.product.form.end")));
			row1.appendChild(end);

			Row row2 = new Row();
			row2.appendChild(new Label(lang.get("inventory.product.form.code")));
			row2.appendChild(code);
			row2.appendChild(new Label(lang.get("inventory.product.form.uom")));
			row2.appendChild(uoms);

			Row row3 = new Row();
			row3.appendChild(new Label(lang.get("inventory.product.form.name")));
			row3.appendChild(name);
			row3.appendChild(new Label(lang.get("inventory.product.form.type")));
			row3.appendChild(types);

			Row row4 = new Row();
			row4.appendChild(new Label(lang.get("inventory.product.form.category")));
			row4.appendChild(categorys);
			row4.appendChild(new Label(lang.get("inventory.product.form.minstock")));
			row4.appendChild(min);

			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			rows.appendChild(row4);
		}
	}

	protected void initTab()
	{
		Product product = service.findOne(RowUtils.id(row));

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
