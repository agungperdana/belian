/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.pharmacyorder;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.healtcare.dm.MedicalSales;
import com.kratonsolution.belian.healtcare.dm.MedicalSalesItem;
import com.kratonsolution.belian.healtcare.dm.MedicalSalesStatus;
import com.kratonsolution.belian.healtcare.svc.MedicalSalesService;
import com.kratonsolution.belian.healtcare.svc.PatientService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.CurrencyList;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.component.PharmacyOrderRow;
import com.kratonsolution.belian.ui.component.TaxList;
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
public class PharmacyOrderEditContent extends FormContent
{	
	private PatientService patientService = Springs.get(PatientService.class);

	private MedicalSalesService service = Springs.get(MedicalSalesService.class);

	private Textbox number = Components.readOnlyTextBox();

	private Datebox date = Components.mandatoryDatebox();

	private Doublebox term = Components.readOnlyDoubleBox(0);

	private Textbox bill = Components.moneyBox();

	private Textbox tax = Components.moneyBox();

	private Textbox totalBill = Components.moneyBox();

	private Textbox note = Components.stdTextBox(null, false);

	private Listbox saleses = Components.fullSpanSelect(utils.getUser().getPerson());

	private Listbox customers = Components.fullSpanSelect();

	private CurrencyList currencys = new CurrencyList();

	private OrganizationList companys = new OrganizationList();

	private Listbox locations = Components.fullSpanSelect(utils.getLocation());

	private TaxList taxes = new TaxList();

	private Row row;

	public PharmacyOrderEditContent(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
		initItems();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(),new PharmacyOrderGridContent());
			}
		});
		
		MedicalSales medical = service.findOne(RowUtils.id(row));
		if(medical != null && medical.isPaid())
		{
			if(medical.getStatus().equals(MedicalSalesStatus.FINISHED))
				toolbar.removeChild(toolbar.getSave());
			
			toolbar.getSave().setLabel(lang.get("label.component.button.finish"));
			toolbar.getSave().setImage("/icons/handled.png");
			toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					service.finish(medical);
					Flow.next(getParent(),new PharmacyOrderGridContent());
				}
			});
		}
	}

	@Override
	public void initForm()
	{
		companys.setWidth("100%");
		taxes.setWidth("100%");
		currencys.setWidth("100%");
		
		MedicalSales medical = service.findOne(RowUtils.id(row));
		if(medical != null)
		{
			number.setText(medical.getNumber());
			date.setValue(medical.getDate());

			companys.setOrganization(medical.getOrganization());
			currencys.setCurrency(medical.getCurrency());
			taxes.setTax(medical.getTax());
			
			saleses.appendChild(new Listitem(medical.getSales().getLabel(),medical.getSales().getValue()));
			saleses.setSelectedIndex(0);

			customers.appendChild(new Listitem(medical.getCustomer()!=null?medical.getCustomer().getLabel():"Anonymous",medical.getCustomer()!=null?medical.getCustomer().getLabel():"Anonymous"));
			customers.setSelectedIndex(0);

			if(utils.getLocation() != null)
				locations.appendChild(new Listitem(utils.getLocation().getLabel(),utils.getLocation().getValue()));

			bill.setText(Numbers.format(medical.getBillingAmount()));
			tax.setText(Numbers.format(medical.getTaxAmount()));
			totalBill.setText(Numbers.format(medical.getBillingAmount().add(medical.getTaxAmount())));

			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"100px"));
			grid.getColumns().appendChild(new Column());
			grid.getColumns().appendChild(new Column(null,null,"100px"));
			grid.getColumns().appendChild(new Column());

			Row row1 = new Row();
			row1.appendChild(new Label(lang.get("pharmacyorder.grid.column.company")));
			row1.appendChild(companys);
			row1.appendChild(new Label(lang.get("pharmacyorder.grid.column.currency")));
			row1.appendChild(currencys);
			
			Row row2 = new Row();
			row2.appendChild(new Label(lang.get("pharmacyorder.grid.column.number")));
			row2.appendChild(number);
			row2.appendChild(new Label(lang.get("pharmacyorder.grid.column.customer")));
			row2.appendChild(customers);

			Row row3 = new Row();
			row3.appendChild(new Label(lang.get("pharmacyorder.grid.column.date")));
			row3.appendChild(date);
			row3.appendChild(new Label(lang.get("pharmacyorder.grid.column.note")));
			row3.appendChild(note);
			
			Row row5 = new Row();
			row5.appendChild(new Label(lang.get("pharmacyorder.grid.column.tax")));
			row5.appendChild(taxes);
			row5.appendChild(new Label(lang.get("pharmacyorder.grid.column.sales")));
			row5.appendChild(saleses);

			Row row8 = new Row();
			row8.appendChild(new Label(lang.get("pharmacyorder.grid.column.location")));
			row8.appendChild(locations);

			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			rows.appendChild(row5);
			rows.appendChild(row8);
		}
	}

	private void initItems()
	{
		Grid saleItems = new Grid();
		saleItems.appendChild(new Columns());
		saleItems.appendChild(new Rows());
		saleItems.getColumns().appendChild(new Column(lang.get("pharmacyorder.grid.column.product"),null,"230px"));
		saleItems.getColumns().appendChild(new Column(lang.get("pharmacyorder.grid.column.quantity"),null,"70px"));
		saleItems.getColumns().appendChild(new Column(lang.get("pharmacyorder.grid.column.uom"),null,"75px"));
		saleItems.getColumns().appendChild(new Column(lang.get("pharmacyorder.grid.column.note"),null));
		saleItems.setSpan("3");

		MedicalSales medical = service.findOne(RowUtils.id(row));
		if(medical != null)
		{
			for(MedicalSalesItem item:medical.getItems())
				saleItems.getRows().appendChild(new PharmacyOrderRow(item));
		}
		
		appendChild(saleItems);
	}
}
