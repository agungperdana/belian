
package com.kratonsolution.belian.ui.orders.requirements.product;

import java.math.BigDecimal;
import java.util.Date;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
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
import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.global.dm.AIOStatusType;
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.orders.dm.RoleType;
import com.kratonsolution.belian.requirement.dm.ProductRequirement;
import com.kratonsolution.belian.requirement.dm.RequirementRole;
import com.kratonsolution.belian.requirement.dm.RequirementStatus;
import com.kratonsolution.belian.requirement.svc.ProductRequirementService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.general.companystructure.CompanyStructureList;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.global.AIOStatusTypeList;
import com.kratonsolution.belian.ui.orders.RoleTypeList;
import com.kratonsolution.belian.ui.orders.requirements.RequirementTypeList;
import com.kratonsolution.belian.ui.products.product.ProductBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductRequirementFormContent extends AbstractForm
{	
	private ProductRequirementService service = Springs.get(ProductRequirementService.class);
	
	private Datebox created = Components.currentDatebox();

	private Datebox required = Components.currentDatebox();

	private Textbox description = Components.mandatoryTextBox(false);

	private Textbox reason = Components.mandatoryTextBox(false);

	private RequirementTypeList typeList = new RequirementTypeList(false);

	private CompanyStructureList organizations = new CompanyStructureList(false);

	private Decimalbox estimated = Components.decimalbox(BigDecimal.ZERO);

	private Decimalbox productionQuantity = Components.decimalbox(BigDecimal.ONE);

	private ProductBox productBox = new ProductBox(false);

	private Tabbox tabbox = new Tabbox();

	private Grid statuses = new Grid();

	private Grid roles = new Grid();

	public ProductRequirementFormContent()
	{
		super();
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
				Flow.next(getParent(), new ProductRequirementGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(created.getValue() == null)
					throw new WrongValueException(created,lang.get("message.field.empty"));

				if(Strings.isNullOrEmpty(description.getText()))
					throw new WrongValueException(description,lang.get("message.field.empty"));

				if(Strings.isNullOrEmpty(reason.getText()))
					throw new WrongValueException(reason,lang.get("message.field.empty"));

				if(typeList.getDomain() == null)
					throw new WrongValueException(typeList,lang.get("message.field.empty"));

				if(organizations.getDomain() == null)
					throw new WrongValueException(organizations,lang.get("message.field.empty"));
				
				if(productBox.getDomain() == null)
					throw new WrongValueException(productBox,lang.get("message.field.empty"));
				
				if(productionQuantity.getValue() == null || productionQuantity.getValue().compareTo(BigDecimal.ZERO) <= 0)
					throw new WrongValueException(productionQuantity,lang.get("message.field.empty"));

				ProductRequirement product = new ProductRequirement();
				product.setCreationDate(DateTimes.sql(created.getValue()));
				product.setDescription(description.getText());
				product.setEstimatedBudget(estimated.getValue());
				product.setOrganization(organizations.getDomainAsRef());
				product.setReason(reason.getText());
				product.setRequiredDate(DateTimes.sql(required.getValue()));
				product.setType(typeList.getDomain());
				product.setNumber(generator.generate(product.getCreationDate(), product.getOrganization().getId(), Code.PRQ));
				product.setProduct(productBox.getDomainAsRef());
				product.setQuantity(productionQuantity.getValue());
				
				for(Component com:statuses.getRows().getChildren())
				{
					Row row = (Row)com;
					
					AIOStatusTypeList list = (AIOStatusTypeList)row.getChildren().get(2);
					
					RequirementStatus status = new RequirementStatus();
					status.setDate(RowUtils.sql(row, 1));
					status.setRequirement(product);
					status.setType(list.getDomain());
					
					product.getStatuses().add(status);
				}
				
				for(Component com:roles.getRows().getChildren())
				{
					Row row = (Row)com;
					
					PartyBox box = (PartyBox)row.getChildren().get(3);
					RoleTypeList list = (RoleTypeList)row.getChildren().get(4);
					
					RequirementRole role = new RequirementRole();
					role.setStart(RowUtils.sql(row, 1));
					role.setEnd(RowUtils.sql(row, 2));
					role.setParty(box.getDomainAsRef());
					role.setType(list.getDomain());
					role.setRequirement(product);
					
					product.getRoles().add(role);
				}
				
				service.add(product);

				Flow.next(getParent(), new ProductRequirementGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"150px"));
		grid.getColumns().appendChild(new Column());

		Row row0 = new Row();
		row0.appendChild(new Label(lang.get("workrequirement.grid.column.organization")));
		row0.appendChild(organizations);

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("workrequirement.grid.column.creation")));
		row1.appendChild(created);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("workrequirement.grid.column.required")));
		row2.appendChild(required);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("workrequirement.grid.column.description")));
		row3.appendChild(description);

		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("workrequirement.grid.column.reason")));
		row4.appendChild(reason);

		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("workrequirement.grid.column.type")));
		row5.appendChild(typeList);

		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("workrequirement.grid.column.budget")));
		row6.appendChild(estimated);

		Row row7 = new Row();
		row7.appendChild(new Label(lang.get("workrequirement.grid.column.product")));
		row7.appendChild(productBox);

		Row row8 = new Row();
		row8.appendChild(new Label(lang.get("workrequirement.grid.column.productionquantity")));
		row8.appendChild(productionQuantity);

		rows.appendChild(row0);
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row7);
		rows.appendChild(row8);
	}

	private void initTabbox()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab(lang.get("workrequirement.grid.column.statuses")));
		tabbox.getTabs().appendChild(new Tab(lang.get("workrequirement.grid.column.roles")));
		tabbox.getTabs().appendChild(new Tab(lang.get("workrequirement.grid.column.orders")));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabs().getLastChild().setVisible(false);
		tabbox.getTabpanels().getLastChild().setVisible(false);
		
		appendChild(tabbox);
		
		initStatus();
		initRoles();
	}

	private void initStatus()
	{
		NRCToolbar nrc = new NRCToolbar(statuses);

		statuses.setWidth("100%");
		statuses.setEmptyMessage(lang.get("message.grid.empty"));
		statuses.appendChild(new Rows());
		statuses.appendChild(new Columns());
		statuses.getColumns().appendChild(new Column(null,null,"25px"));
		statuses.getColumns().appendChild(new Column(lang.get("workrequirement.grid.column.date"),null,"135px"));
		statuses.getColumns().appendChild(new Column(lang.get("workrequirement.grid.column.type"),null,"200px"));
		statuses.setSpan("2");
		
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.fullSpanDatebox(new Date()));
				row.appendChild(new AIOStatusTypeList(true));
				
				statuses.getRows().appendChild(row);
			}
		});
		
		AIOStatusTypeList list = new AIOStatusTypeList(true,AIOStatusType.ACTIVE);
		list.setDisabled(true);
		
		Row row = new Row();
		row.appendChild(Components.readOnlyCheckbox());
		row.appendChild(Components.fullSpanReadOnlyDatebox(new Date()));
		row.appendChild(list);
		
		statuses.getRows().appendChild(row);
		
		tabbox.getTabpanels().getFirstChild().appendChild(nrc);
		tabbox.getTabpanels().getFirstChild().appendChild(statuses);
	}
	
	private void initRoles()
	{
		NRCToolbar nrc = new NRCToolbar(roles);

		roles.setWidth("100%");
		roles.setEmptyMessage(lang.get("message.grid.empty"));
		roles.appendChild(new Rows());
		roles.appendChild(new Columns());
		roles.getColumns().appendChild(new Column(null,null,"25px"));
		roles.getColumns().appendChild(new Column(lang.get("workrequirement.grid.column.start"),null,"135px"));
		roles.getColumns().appendChild(new Column(lang.get("workrequirement.grid.column.end"),null,"135px"));
		roles.getColumns().appendChild(new Column(lang.get("workrequirement.grid.column.party"),null,"135px"));
		roles.getColumns().appendChild(new Column(lang.get("workrequirement.grid.column.type"),null,"165px"));
		roles.setSpan("3");
		
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.fullSpanDatebox(new Date()));
				row.appendChild(Components.fullSpanDatebox(null));
				row.appendChild(new PartyBox(false,true,false));
				row.appendChild(new RoleTypeList(true));
				
				roles.getRows().appendChild(row);
			}
		});
		
		PartyBox box = new PartyBox(false,true,false);
		box.setDomain(utils.getPerson());
		box.setDisabled();
		
		RoleTypeList list = new RoleTypeList(true);
		list.setDomain(RoleType.ENTERED_BY);
		list.setDisabled(true);
		
		Row row = new Row();
		row.appendChild(Components.readOnlyCheckbox());
		row.appendChild(Components.fullSpanReadOnlyDatebox(new Date()));
		row.appendChild(Components.fullSpanReadOnlyDatebox(null));
		row.appendChild(box);
		row.appendChild(list);
		
		roles.getRows().appendChild(row);
	
		tabbox.getTabpanels().getChildren().get(1).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(1).appendChild(roles);
	}
}
