
package com.kratonsolution.belian.payments.view;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.svc.CompanyStructureService;
import com.kratonsolution.belian.global.view.AbstractView;
import com.kratonsolution.belian.partys.dm.PartyRepository;
import com.kratonsolution.belian.payments.dm.Disbursement;
import com.kratonsolution.belian.payments.dm.DisbursementRepository;
import com.kratonsolution.belian.payments.dm.Payment;
import com.kratonsolution.belian.payments.dm.PaymentMethodType;
import com.kratonsolution.belian.payments.dm.PaymentRepository;
import com.kratonsolution.belian.payments.dm.Receipt;
import com.kratonsolution.belian.payments.dm.ReceiptRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Controller
public class PaymentReportView extends AbstractView
{
	@Autowired
	private PaymentRepository paymentRepo;
	
	@Autowired
	private ReceiptRepository receiptRepo;
	
	@Autowired
	private DisbursementRepository disbursementRepo;
	
	@Autowired
	private PartyRepository partyRepo;
	
	@Autowired
	private CompanyStructureService structureService;
	
	@RequestMapping("/paymentreportsview")
	public String paymentreportsview(Model model,
									@RequestParam("organization")String organization,
									@RequestParam("from")String from,
									@RequestParam("to")String to) throws Exception
	{
		List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
		
		BigDecimal grand = BigDecimal.ZERO;
		
		model.addAttribute("title",lang.get("payments.grid.column.report.title"));
		model.addAttribute("company",partyRepo.getOne(organization));
		model.addAttribute("from",from);
		model.addAttribute("to",to);
		model.addAttribute("datas", lists);
		model.addAttribute("total", grand);
		
		Date _from = DateTimes.parse(from);
		Date _to = DateTimes.parse(to);
		
		List<String> companys = new ArrayList<>();
		companys.add(organization);
		companys.addAll(structureService.findAllChild(organization));
		
		for(String company:companys)
		{
			List<Payment> payments = paymentRepo.findAll(company, _from, _to);
			if(!payments.isEmpty())
			{
				Map<String,Object> map = new HashMap<>();
				map.put("company",partyRepo.getOne(company));
				map.put("payments",payments);
				
				BigDecimal total = BigDecimal.ZERO;
				BigDecimal cash = BigDecimal.ZERO;
				BigDecimal debit = BigDecimal.ZERO;
				BigDecimal cc = BigDecimal.ZERO;
				
				for(Payment payment:payments)
				{
					total = total.add(payment.getPaymentAmt());
					
					if(payment.getMethod().equals(PaymentMethodType.CASH))
						cash = cash.add(payment.getPaymentAmt());
					else if(payment.getMethod().equals(PaymentMethodType.TRANSFER))
						debit = debit.add(payment.getPaymentAmt());
					else if(payment.getMethod().equals(PaymentMethodType.CREDITCARD))
						cc = cc.add(payment.getPaymentAmt());
				}
				
				map.put("cash",cash);
				map.put("debit",debit);
				map.put("cc",cc);
				map.put("total",total);
				
				grand = grand.add(total);
				
				lists.add(map);
			}
		}
		
		return "paymentreport";
	}
	
	@RequestMapping("/receiptreportview")
	public String receiptreportview(Model model,
									@RequestParam("organization")String organization,
									@RequestParam("from")String from,
									@RequestParam("to")String to) throws Exception
	{
		List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
		
		BigDecimal grand = BigDecimal.ZERO;
		
		model.addAttribute("title",lang.get("payments.grid.column.report.receipt.title"));
		model.addAttribute("company",partyRepo.getOne(organization));
		model.addAttribute("from",from);
		model.addAttribute("to",to);
		model.addAttribute("datas", lists);
		model.addAttribute("total", grand);
		
		Date _from = DateTimes.parse(from);
		Date _to = DateTimes.parse(to);
		
		List<String> companys = new ArrayList<>();
		companys.add(organization);
		companys.addAll(structureService.findAllChild(organization));
		
		for(String company:companys)
		{
			List<Receipt> receipts = receiptRepo.findAll(company, _from, _to);
			if(!receipts.isEmpty())
			{
				Map<String,Object> map = new HashMap<>();
				map.put("company",partyRepo.getOne(company));
				map.put("receipts",receipts);
				
				BigDecimal total = BigDecimal.ZERO;
				BigDecimal cash = BigDecimal.ZERO;
				BigDecimal debit = BigDecimal.ZERO;
				BigDecimal cc = BigDecimal.ZERO;
				
				for(Receipt receipt:receipts)
				{
					total = total.add(receipt.getAmount());
					
					if(receipt.getMethod().equals(PaymentMethodType.CASH))
						cash = cash.add(receipt.getAmount());
					else if(receipt.getMethod().equals(PaymentMethodType.TRANSFER))
						debit = debit.add(receipt.getAmount());
					else if(receipt.getMethod().equals(PaymentMethodType.CREDITCARD))
						cc = cc.add(receipt.getAmount());
				}
				
				map.put("cash",cash);
				map.put("debit",debit);
				map.put("cc",cc);
				map.put("total",total);
				
				grand = grand.add(total);
				
				lists.add(map);
			}
		}
		
		return "receiptreport";
	}
	
	@RequestMapping("/disbursementreportview")
	public String disbursementreportview(Model model,
										 @RequestParam("organization")String organization,
										 @RequestParam("from")String from,
										 @RequestParam("to")String to) throws Exception
	{
		List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
		
		BigDecimal grand = BigDecimal.ZERO;
		
		model.addAttribute("title",lang.get("payments.grid.column.report.disbursement.title"));
		model.addAttribute("company",partyRepo.getOne(organization));
		model.addAttribute("from",from);
		model.addAttribute("to",to);
		model.addAttribute("datas", lists);
		model.addAttribute("total", grand);
		
		Date _from = DateTimes.parse(from);
		Date _to = DateTimes.parse(to);
		
		List<String> companys = new ArrayList<>();
		companys.add(organization);
		companys.addAll(structureService.findAllChild(organization));
		
		for(String company:companys)
		{
			List<Disbursement> disbursements = disbursementRepo.findAll(company, _from, _to);
			if(!disbursements.isEmpty())
			{
				Map<String,Object> map = new HashMap<>();
				map.put("company",partyRepo.getOne(company));
				map.put("disbursements",disbursements);
				
				BigDecimal total = BigDecimal.ZERO;
				BigDecimal cash = BigDecimal.ZERO;
				BigDecimal debit = BigDecimal.ZERO;
				BigDecimal cc = BigDecimal.ZERO;
				
				for(Disbursement receipt:disbursements)
				{
					total = total.add(receipt.getAmount());
					
					if(receipt.getMethod().equals(PaymentMethodType.CASH))
						cash = cash.add(receipt.getAmount());
					else if(receipt.getMethod().equals(PaymentMethodType.TRANSFER))
						debit = debit.add(receipt.getAmount());
					else if(receipt.getMethod().equals(PaymentMethodType.CREDITCARD))
						cc = cc.add(receipt.getAmount());
				}
				
				map.put("cash",cash);
				map.put("debit",debit);
				map.put("cc",cc);
				map.put("total",total);
				
				grand = grand.add(total);
				
				lists.add(map);
			}
		}
		
		return "disbursementreport";
	}
}
