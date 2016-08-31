/**
 * 
 */
package com.kratonsolution.belian.healtcare.svc;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.dm.PartyRepository;
import com.kratonsolution.belian.healtcare.dm.MedicalTreatmentSales;
import com.kratonsolution.belian.healtcare.dm.MedicalTreatmentSalesItem;
import com.kratonsolution.belian.healtcare.dm.MedicalTreatmentSalesRepository;
import com.kratonsolution.belian.ui.util.Numbers;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DoctorIncomeReportService
{
	@Autowired
	private PartyRepository partyRepo;

	@Autowired
	private MedicalTreatmentSalesRepository salesRepo;
	
	@Autowired
	private MedicalTreatmentSalesRepository repository;
	
	public Map<String,Object> generate(String company,String doctor,Date start,Date end)
	{
		List<Map<String,Object>> contents = new ArrayList<Map<String,Object>>();
		
		BigDecimal total = BigDecimal.ZERO;
		
		for(MedicalTreatmentSales sales:repository.findAll(company, doctor, start, end))
		{
			BigDecimal amount = BigDecimal.ZERO;
			
			for(MedicalTreatmentSalesItem item:sales.getItems())
			{
				if(!item.getProduct().getName().toLowerCase().contains("tuslah"))
					amount = amount.add(item.getPrice().multiply(item.getQuantity()));
			}
			
			if(amount.compareTo(BigDecimal.ZERO) > 0)
			{
				total = total.add(amount);
				
				Map<String,Object> in = new HashMap<String, Object>();
				in.put("date",DateTimes.format(sales.getDate()));
				in.put("patient",sales.getCustomer().getName());
				in.put("amount",Numbers.format(amount));
				
				contents.add(in);
			}
		}
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("company",partyRepo.findOne(company));
		map.put("doctor",partyRepo.findOne(doctor));
		map.put("date",DateTimes.format(start)+" - "+DateTimes.format(end));
		map.put("contents",contents);
		map.put("total",total);
		
		return map;
	}
}
