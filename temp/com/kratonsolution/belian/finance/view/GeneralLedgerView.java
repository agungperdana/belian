/**
 * 
 */
package com.kratonsolution.belian.finance.view;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.finance.svc.GeneralLedgerService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Controller
public class GeneralLedgerView
{
	@Autowired
	private GeneralLedgerService service;
	
	@RequestMapping({"/generalledgerreport"})
	public String print(Model model,
						@RequestParam("company")String company,
						@RequestParam("account")String account,
						@RequestParam("start")
						@DateTimeFormat(pattern="dd-MM-yyyy")
						Date start,
						@RequestParam("end")
						@DateTimeFormat(pattern="dd-MM-yyyy")
						Date end)
	{
		model.addAllAttributes(service.generate(company,account,DateTimes.sql(start),DateTimes.sql(end)));
		return "generalledgerreport";
	}
}
