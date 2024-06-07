
package com.kratonsolution.belian.ui.orders.purchaseorder;

import java.math.BigDecimal;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.common.orm.Observer;
import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.orders.dm.PurchaseOrderItem;
import com.kratonsolution.belian.orders.svc.PurchaseOrderService;
import com.kratonsolution.belian.requirement.dm.ProductRequirement;
import com.kratonsolution.belian.requirement.dm.RequirementOrderCommitment;
import com.kratonsolution.belian.requirement.dm.RequirementType;
import com.kratonsolution.belian.requirement.svc.ProductRequirementService;
import com.kratonsolution.belian.ui.BForm;
import com.kratonsolution.belian.ui.products.feature.ProductFeatureList;
import com.kratonsolution.belian.ui.products.product.ProductBox;
import com.kratonsolution.belian.ui.products.product.ProductCostBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class POItemForm extends BForm
{	
	private PurchaseOrderService service = Springs.get(PurchaseOrderService.class);
	
	private ProductRequirementService productRequirementService = Springs.get(ProductRequirementService.class);
	
	private ProductBox productBox = new ProductBox(false);
	
	private ProductFeatureList featureList = new ProductFeatureList(false);
	
	private Decimalbox quantity = Components.decimalbox(BigDecimal.ZERO);
	
	private ProductCostBox costBox = new ProductCostBox(false);
	
	private Textbox total = Components.readOnlyMoneyBox(BigDecimal.ZERO,false);

	private Textbox note = Components.stdTextBox(null, false);

	private Tabbox tabbox = new Tabbox();
	
	private Grid fulfillments = new Grid();

	private PurchaseOrderItem item;
	
	public POItemForm(PurchaseOrderItem item)
	{
		super();
		
		this.item = item;
		
		initToolbar();
		initForm();
		initTabbox();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new POEditContent(RowUtils.shield(item.getOrder().getId())));
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(productBox.getDomain() == null)
					throw new WrongValueException(productBox,lang.get("message.field.empty"));

				if(quantity.getValue() == null || quantity.getValue().compareTo(BigDecimal.ZERO) <= 0)
					throw new WrongValueException(quantity,lang.get("message.field.empty"));

				if(costBox.getNominal() == null || costBox.getNominal().getValue() == null || costBox.getNominal().getValue().compareTo(BigDecimal.ZERO) <= 0)
					throw new WrongValueException(costBox,lang.get("message.field.empty"));

				if(item.getOrder() != null)
				{
					item.setFeature(featureList.getDomainAsRef());
					item.setNote(note.getText());
					item.setProduct(productBox.getDomainAsRef());
					item.setQuantity(quantity.getValue());
					item.setUntitPrice(costBox.getNominal().getValue());
					item.setUom(productBox.getDomain()!=null?productBox.getDomain().getUom():null);
					
					for(Component com:fulfillments.getRows().getChildren())
					{
						Row iRow = (Row)com;
						if(RowUtils.isChecked(iRow))
						{
							RequirementOrderCommitment commitment = new RequirementOrderCommitment();
							commitment.setOrderItem(item);
							commitment.setQuantity(RowUtils.decimal(iRow, 3));
							commitment.setRequirement(new IDValueRef());
							commitment.getRequirement().setId(RowUtils.id(iRow));
							commitment.getRequirement().setValue(RowUtils.string(iRow, 1));
							
							item.getOrderCommitments().add(commitment);
						}
					}
					
					service.addItem(item);
				}

				Flow.next(getParent(), new POEditContent(RowUtils.shield(item.getOrder().getId())));
			}
		});
	}

	@Override
	public void initForm()
	{
		addColumn(new Column(null,null,"150px"));
		addColumn(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("order.items.grid.column.product")));
		row1.appendChild(productBox);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("order.items.grid.column.feature")));
		row2.appendChild(featureList);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("order.items.grid.column.quantity")));
		row3.appendChild(quantity);

		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("order.items.grid.column.unitprice")));
		row4.appendChild(costBox);

		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("order.items.grid.column.amount")));
		row5.appendChild(total);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("order.items.grid.column.note")));
		row6.appendChild(note);

		addRow(row1);
		addRow(row2);
		addRow(row3);
		addRow(row4);
		addRow(row5);
		addRow(row6);
		
		
		costBox.setParty(item!=null?item.getOrder().getPartyTakingOrder():null);
		costBox.addObserver(new Observer()
		{
			@Override
			public void valueChange(IDValueRef value)
			{
				if(value != null && !Strings.isNullOrEmpty(value.getValue()))
					calculate();
			}
		});
		
		featureList.addObserver(costBox);
		featureList.addObserver(new Observer()
		{
			@Override
			public void valueChange(IDValueRef value)
			{
				if(value != null && !Strings.isNullOrEmpty(value.getId()))
				{
					productBox.setDomain(null);
					
					fulfillments.getRows().getChildren().clear();
					
					for(ProductRequirement requirement:productRequirementService.findAllFeatureActive(value.getId(),RequirementType.INTERNAL_REQUIREMENT))
					{
						Checkbox checkbox = Components.checkbox(false);
						checkbox.addEventListener(Events.ON_CHECK, new EventListener<Event>()
						{
							@Override
							public void onEvent(Event arg0)throws Exception
							{
								calculate();
							}
						});
						
						Row row = new Row();
						row.appendChild(checkbox);
						row.appendChild(Components.checkbox(false));
						row.appendChild(new Label(DateTimes.format(requirement.getCreationDate())));
						row.appendChild(new Label(requirement.getNumber()));
						row.appendChild(Components.fullspanDecimalbox(requirement.getQuantity()));
						row.appendChild(new Label(requirement.getReason()));
						row.appendChild(new Label(requirement.getDescription()));
						row.appendChild(new Label(requirement.getId()));
						
						fulfillments.getRows().appendChild(row);
					}
				}
			}
		});
		
		productBox.addObserver(costBox);
		productBox.addObserver(new Observer()
		{
			@Override
			public void valueChange(IDValueRef value)
			{
				if(value != null && !Strings.isNullOrEmpty(value.getId()))
				{
					fulfillments.getRows().getChildren().clear();
					featureList.setSelectedItem(null);
					
					for(ProductRequirement requirement:productRequirementService.findAllProductActive(value.getId(),RequirementType.INTERNAL_REQUIREMENT))
					{
						Checkbox checkbox = Components.checkbox(false);
						checkbox.addEventListener(Events.ON_CHECK, new EventListener<Event>()
						{
							@Override
							public void onEvent(Event arg0)throws Exception
							{
								calculate();
							}
						});
						
						Row row = new Row();
						row.appendChild(checkbox);
						row.appendChild(new Label(DateTimes.format(requirement.getCreationDate())));
						row.appendChild(new Label(requirement.getNumber()));
						row.appendChild(Components.fullspanDecimalbox(requirement.getQuantity()));
						row.appendChild(new Label(requirement.getReason()));
						row.appendChild(new Label(requirement.getDescription()));
						row.appendChild(new Label(requirement.getId()));
						
						fulfillments.getRows().appendChild(row);
					}
				}
			}
		});
	}

	private void initTabbox()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabpanels());
		tabbox.appendChild(new Tabs());
		tabbox.getTabs().appendChild(new Tab(lang.get("order.items.grid.column.fulfillments")));
		tabbox.getTabpanels().appendChild(new Tabpanel());

		appendChild(tabbox);

		initFulfillments();
	}
	
	private void initFulfillments()
	{
		fulfillments.setWidth("100%");
		fulfillments.setEmptyMessage(lang.get("message.grid.empty"));
		fulfillments.appendChild(new Rows());
		fulfillments.appendChild(new Columns());
		fulfillments.getColumns().appendChild(new Column(null,null,"25px"));
		fulfillments.getColumns().appendChild(new Column(lang.get("order.grid.column.entrydate"),null,"100px"));
		fulfillments.getColumns().appendChild(new Column(lang.get("order.grid.column.number"),null,"135px"));
		fulfillments.getColumns().appendChild(new Column(lang.get("order.items.grid.column.quantity"),null,"100px"));
		fulfillments.getColumns().appendChild(new Column(lang.get("order.items.grid.column.reason"),null,"200px"));
		fulfillments.getColumns().appendChild(new Column(lang.get("order.items.grid.column.description"),null,"200px"));
		fulfillments.getColumns().appendChild(new Column());
		fulfillments.getColumns().getLastChild().setVisible(false);
		fulfillments.setSpan("4");
		
		tabbox.getTabpanels().getFirstChild().appendChild(fulfillments);
	}
	
	private void calculate()
	{
		BigDecimal quan = BigDecimal.ZERO;
		
		for(Component com:fulfillments.getRows().getChildren())
		{
			Row row = (Row)com;
			quan = quan.add(RowUtils.decimal(row, 3));
		}
		
		quantity.setValue(quan);
		total.setText(Numbers.format(quantity.getValue().multiply(costBox.getNominal().getValue())));
	}
}
