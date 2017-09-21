/**
 * 
 */
package com.kratonsolution.belian.ui.finance.invoices.sales;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Comboitem;

import com.google.common.base.Strings;
import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.api.dm.Observer;
import com.kratonsolution.belian.invoice.dm.Invoice;
import com.kratonsolution.belian.invoice.svc.SalesInvoiceService;
import com.kratonsolution.belian.payments.dm.InvoiceRef;
import com.kratonsolution.belian.ui.component.AbstractCombobox;
import com.kratonsolution.belian.ui.util.Springs;

import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Setter
public class SalesInvoiceBox extends AbstractCombobox<Invoice> implements Observer
{
	private SalesInvoiceService service = Springs.get(SalesInvoiceService.class);
	
	private String customer;

	public SalesInvoiceBox(boolean showCreateLink)
	{
		this(showCreateLink,false,null);
	}

	public SalesInvoiceBox(boolean showCreateLink,boolean fullspan)
	{
		this(showCreateLink,fullspan,null);
	}

	public SalesInvoiceBox(boolean showCreateLink,boolean fullspan,Invoice invoice)
	{
		super(showCreateLink,fullspan);

		if(invoice != null)
			setDomain(invoice);

		input.addEventListener(Events.ON_CHANGING, new OnEventListener());
		input.addEventListener(Events.ON_SELECT, new OnEventListener());
		input.addEventListener(Events.ON_BLUR, new OnEventListener());

		link.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
			}
		});
	}

	private class OnEventListener implements EventListener<Event>
	{
		@Override
		public void onEvent(Event event) throws Exception
		{
			if(Strings.isNullOrEmpty(customer))
			{
				Clients.showNotification("Please select customer first.");
				return;
			}
			
			if(event instanceof InputEvent)
			{
				InputEvent ev = (InputEvent)event;

				input.getItems().clear();

				for(Invoice invoice:service.findAllUnpaid(customer,ev.getValue()))
				{
					if(!invoice.isPaid())
					{
						Comboitem comboitem = input.appendItem(invoice.getNumber());
						comboitem.setAttribute("invoice_id",invoice.getId());

						if(!maps.containsKey(invoice.getId()))
							maps.put(invoice.getId(), invoice);
					}
				}
			}
			else
			{
				Comboitem selected = input.getSelectedItem();

				if(selected != null)
				{
					for(Observer observer:observers)
						observer.valueChange(getDomainAsRef());
				}
			}
		}
	}

	@Override
	public Invoice getDomain()
	{
		if(input.getSelectedItem() != null && maps.containsKey(input.getSelectedItem().getAttribute("invoice_id")))
			return maps.get(input.getSelectedItem().getAttribute("invoice_id").toString());

		return null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		if(input.getSelectedItem() != null && maps.containsKey(input.getSelectedItem().getAttribute("invoice_id")))
		{
			Invoice product = maps.get(input.getSelectedItem().getAttribute("invoice_id").toString());
			if(product != null)
			{
				IDValueRef ref = new IDValueRef();
				ref.setId(product.getId());
				ref.setValue(product.getNumber());
				ref.setType(Invoice.class.getSimpleName());

				return ref;
			}
		}

		return null;
	}
	
	public InvoiceRef getInvoiceRef()
	{
		if(input.getSelectedItem() != null && maps.containsKey(input.getSelectedItem().getAttribute("invoice_id")))
		{
			Invoice invoice = maps.get(input.getSelectedItem().getAttribute("invoice_id").toString());
			if(invoice != null)
			{
				InvoiceRef ref = new InvoiceRef();
				ref.setId(invoice.getId());
				ref.setNumber(invoice.getNumber());
				ref.setDate(invoice.getDate());
				ref.setType(Invoice.class.getSimpleName());

				return ref;
			}
		}

		return null;
	}

	@Override
	public void setDomain(Invoice ref)
	{
		if(ref != null)
		{
			input.getItems().clear();
			Comboitem comboitem = input.appendItem(ref.getValue());
			comboitem.setAttribute("invoice_id",ref.getId());

			input.setSelectedItem(comboitem);

			if(!maps.containsKey(ref.getId()))
				maps.put(ref.getId(), ref);
		}
		else
			input.setSelectedItem(null);
	}

	@Override
	public void setDomainAsRef(IDValueRef ref)
	{
		if(ref != null)
		{
			input.getItems().clear();
			Comboitem comboitem = input.appendItem(ref.getValue());
			comboitem.setAttribute("invoice_id",ref.getId());

			input.setSelectedItem(comboitem);

			if(!maps.containsKey(ref.getId()))
				maps.put(ref.getId(), new Invoice(ref));

			for(Observer observer:observers)
				observer.valueChange(ref);
		}
		else
			input.setSelectedItem(null);
	}

	@Override
	public void valueChange(IDValueRef value)
	{
		if(value != null && !Strings.isNullOrEmpty(value.getId()))
			setCustomer(value.getId());
	}
}
