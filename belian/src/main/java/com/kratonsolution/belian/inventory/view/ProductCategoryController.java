/**
 * 
 */
package com.kratonsolution.belian.inventory.view;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kratonsolution.belian.inventory.dm.ProductCategory;
import com.kratonsolution.belian.inventory.dm.ProductCategoryRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/categorys")
public class ProductCategoryController
{
	@Autowired
	private ProductCategoryRepository repository;
	
	@Secured("ROLE_PRDCATEGORY_READ")
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("categorys",repository.findAll());
		return "categorys";
	}
	
	@Secured("ROLE_PRDCATEGORY_CREATE")
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("category",new ProductCategory());
		return "category-add";
	}
	
	@Secured("ROLE_PRDCATEGORY_CREATE")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(ProductCategory category)
	{
		category.setId(UUID.randomUUID().toString());
		
		repository.save(category);
		return "redirect:/categorys/list";
	}
	
	@Secured("ROLE_PRDCATEGORY_UPDATE")
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("category",repository.findOne(id));
		return "category-edit";
	}
	
	@Secured("ROLE_PRDCATEGORY_UPDATE")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(ProductCategory category)
	{
		repository.save(category);
		return "redirect:/categorys/list";
	}
	
	@Secured("ROLE_PRDCATEGORY_DELETE")
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/categorys/list";
	}
}
