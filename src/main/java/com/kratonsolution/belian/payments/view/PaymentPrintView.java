package com.kratonsolution.belian.payments.view;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kratonsolution.belian.global.view.AbstractView;
import com.kratonsolution.belian.invoice.dm.Invoice;
import com.kratonsolution.belian.invoice.dm.InvoiceItem;
import com.kratonsolution.belian.invoice.dm.InvoiceRepository;
import com.kratonsolution.belian.invoice.dm.OrderItemBilling;
import com.kratonsolution.belian.orders.dm.OrderItem;
import com.kratonsolution.belian.orders.dm.OrderItemRepository;
import com.kratonsolution.belian.partys.svc.PartyService;
import com.kratonsolution.belian.payments.dm.PaymentApplication;
import com.kratonsolution.belian.payments.dm.Receipt;
import com.kratonsolution.belian.payments.svc.ReceiptService;
import com.kratonsolution.belian.shipment.dm.ShipmentItemRepository;
import com.kratonsolution.belian.ui.util.Numbers;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Controller
public class PaymentPrintView extends AbstractView
{
	@Autowired
	private ReceiptService service;
	
	@Autowired
	private PartyService partyService;
	
	@Autowired
	private InvoiceRepository invRepo;
	
	@Autowired
	private OrderItemRepository itemRepo;
	
	@Autowired
	private ShipmentItemRepository shipItemRepo;
	
	@RequestMapping("/receiptprint")
	public String receipt(Model model,@RequestParam("id")String id)
	{
		Receipt receipt = service.findById(id);

		BigDecimal total = BigDecimal.ZERO;
		
		Vector<Map<String,String>> items = new Vector<>();
		for(PaymentApplication application:receipt.getApplications())
		{
			Invoice invoice = invRepo.findById(application.getInvoice().getId()).orElse(null);
			if(invoice != null)
			{
				for(InvoiceItem item:invoice.getItems())
				{
					for(OrderItemBilling billing:item.getOrderItemBillings())
					{
						OrderItem orderItem = itemRepo.findById(billing.getOrderItem().getId()).orElse(null);
						if(orderItem != null)
						{
							Map<String,String> map = new HashMap<>();
							map.put("product", orderItem.getProduct().getValue());
							map.put("quantity", Numbers.format(orderItem.getQuantity()));
							map.put("price", Numbers.format(orderItem.getUntitPrice())+"/"+orderItem.getUom().getValue());
							map.put("amount", Numbers.format(orderItem.getQuantity().multiply(orderItem.getUntitPrice())));
						
							total = total.add(orderItem.getQuantity().multiply(orderItem.getUntitPrice()));
						
							items.add(map);
						}
					}
				}
			}
		}
		
		
		model.addAttribute("inv",receipt);
		model.addAttribute("util", utils);
		model.addAttribute("title",lang.get("receipt.grid.column.print.title"));
		model.addAttribute("method",receipt.getMethod().display(utils.getLanguage()));
		model.addAttribute("receiver",partyService.findById(receipt.getReceiver().getId()));
		model.addAttribute("payer",partyService.findById(receipt.getPayer().getId()));
		model.addAttribute("applications",items);
		model.addAttribute("total",Numbers.format(total));
		
		return "receiptprint";
	}
}
