/**
 * 
 */
package com.kratonsolution.belian.inventory.view;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kratonsolution.belian.inventory.dm.UnitOfMeasure;
import com.kratonsolution.belian.inventory.dm.UnitOfMeasureRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/uoms")
public class UnitOfMeasureController
{
	@Autowired
	private UnitOfMeasureRepository repository;
	
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("uoms",repository.findAll());
		return "uoms";
	}
	
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("uom",new UnitOfMeasure());
		
		return "uom-add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(UnitOfMeasure uom)
	{
		uom.setId(UUID.randomUUID().toString());
		repository.save(uom);
		return "redirect:/uoms/list";
	}
	
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("uom",repository.findOne(id));
		return "uom-edit";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(UnitOfMeasure uom)
	{
		repository.save(uom);
		return "redirect:/uoms/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/uoms/list";
	}
}
