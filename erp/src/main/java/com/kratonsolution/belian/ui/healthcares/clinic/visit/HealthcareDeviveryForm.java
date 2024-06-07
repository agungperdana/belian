
package com.kratonsolution.belian.ui.healthcares.clinic.visit;

import java.math.BigDecimal;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.healtcares.dm.HealthcareDelivery;
import com.kratonsolution.belian.healtcares.dm.Visit;
import com.kratonsolution.belian.healtcares.svc.VisitService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.general.uom.UOMList;
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
public class HealthcareDeviveryForm extends AbstractForm
{	
	private VisitService service = Springs.get(VisitService.class);

	private Datebox date = Components.currentDatetime(false);

	private HealthcareDeliveryTypeList types = new HealthcareDeliveryTypeList(false);
	
	private Textbox note = Components.textarea(null,false,true);
	
	private ProductBox product = new ProductBox(false);
	
	private Decimalbox quantity = Components.decimalbox(BigDecimal.ONE);
	
	private UOMList uomList = new UOMList(false);
	
	private String visit;
	
	public HealthcareDeviveryForm(String visit)
	{
		super();
		this.visit = visit;
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
				Flow.next(getParent(), new VisitEditContent(RowUtils.shield(visit)));
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(product.getDomain() == null)
					throw new WrongValueException(product,lang.get("message.field.empty"));
				
				if(types.getDomain() == null)
					throw new WrongValueException(types,lang.get("message.field.empty"));
				
				if(date.getValue() == null)
					throw new WrongValueException(date,lang.get("message.field.empty"));
				
				if(Strings.isNullOrEmpty(note.getText()))
					throw new WrongValueException(note,lang.get("message.field.empty"));
				
				Visit out = service.findById(visit);
				if(out != null)
				{
					HealthcareDelivery delivery = new HealthcareDelivery();
					delivery.setDate(DateTimes.timestamp(date.getValue()));
					delivery.setNote(note.getText());
					delivery.setProduct(product.getDomainAsRef());
					delivery.setType(types.getDomain());
					delivery.setVisit(out);
					delivery.setQuantity(quantity.getValue());
					delivery.setUom(uomList.getDomainAsRef());
					
					out.getDeliverys().add(delivery);
					
					service.edit(out);
				}
				
				Flow.next(getParent(), new VisitEditContent(RowUtils.shield(visit)));
			}
		});
	}

	@Override
	public void initForm()
	{
		product.addObserver(uomList);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("clinic.visit.grid.column.date")));
		row1.appendChild(date);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("clinic.visit.grid.column.type")));
		row2.appendChild(types);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("clinic.visit.grid.column.note")));
		row3.appendChild(note);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("clinic.visit.grid.column.product")));
		row4.appendChild(product);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("clinic.visit.grid.column.quantity")));
		row5.appendChild(quantity);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("clinic.visit.grid.column.uom")));
		row6.appendChild(uomList);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
	}
}
