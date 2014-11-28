/**
 * 
 */
package com.kratonsolution.belian.inventory.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@InitBinder
	public void binder(WebDataBinder binder)
	{
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}
	
	@Secured("ROLE_PRODUCT_READ")
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("products",repository.findAll());
		return "products";
	}
	
	@Secured("ROLE_PRODUCT_CREATE")
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("product",new Product());
		model.addAttribute("types",Product.Type.values());
		model.addAttribute("currencys",currency.findAll());
		
		return "product-add";
	}
	
	@Secured("ROLE_PRODUCT_CREATE")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Product product)
	{
		product.setId(UUID.randomUUID().toString());
		repository.save(product);
		return "redirect:/products/list";
	}
	
	@Secured("ROLE_PRODUCT_UPDATE")
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("product",repository.findOne(id));
		model.addAttribute("types",Product.Type.values());
		model.addAttribute("currencys",currency.findAll());
		return "product-edit";
	}
	
	@Secured("ROLE_PRODUCT_UPDATE")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(Product product)
	{
		repository.save(product);
		return "redirect:/products/list";
	}
	
	@Secured("ROLE_PRODUCT_DELETE")
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/products/list";
	}
}
