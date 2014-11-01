/**
 * 
 */
package com.kratonsolution.belian.inventory.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kratonsolution.belian.accounting.dm.CurrencyRepository;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/products")
public class ProductController
{
	@Autowired
	private ProductRepository repository;
		
	@Autowired
	private CurrencyRepository currency;
	
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("products",repository.findAll());
		return "products";
	}
	
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("product",Product.newInstance());
		model.addAttribute("types",Product.Type.values());
		model.addAttribute("currencys",currency.findAll());
		
		return "product-add";
	}
	
	@RequestMapping("/add")
	public String add(Product product)
	{
		repository.save(product);
		return "redirect:/products/list";
	}
	
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("product",repository.findOne(id));
		model.addAttribute("types",Product.Type.values());
		model.addAttribute("currencys",currency.findAll());
		return "product-edit";
	}
	
	@RequestMapping("/edit")
	public String edit(Product product)
	{
		repository.save(product);
		return "redirect:/products/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/products/list";
	}
}
