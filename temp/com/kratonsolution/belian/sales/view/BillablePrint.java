/**
 * 
 */
package com.kratonsolution.belian.sales.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kratonsolution.belian.sales.dm.BillableRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Controller
public class BillablePrint
{
	@Autowired
	private BillableRepository service;
	
	@RequestMapping({"/billableposprint"})
	public String pos(Model model,@RequestParam("id")String id)
	{
		model.addAttribute("billable",service.findOne(id));
		return "billableposprint";
	}
	
	@RequestMapping({"/billablestandardprint"})
	public String std(Model model,@RequestParam("id")String id)
	{
		model.addAttribute("billable",service.findOne(id));
		return "billablestandardprint";
	}

	public static String GEN(String id,boolean isPOS)
	{
		if(isPOS)
			return "/billableposprint.htm?id="+id;
		else
			return "/billablestandardprint.htm?id="+id;
	}
}
