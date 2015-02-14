/**
 * 
 */
package com.kratonsolution.belian.inventory.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.kratonsolution.belian.general.dm.PartyRepository;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductRepository;
import com.kratonsolution.belian.inventory.dm.ProductSupplier;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/productsuppliers")
public class ProductSupplierController
{
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private PartyRepository partyRepository;
	
	@InitBinder
	public void binder(WebDataBinder binder)
	{
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}
	
	@Secured("ROLE_PRDSUPPLIER_CREATE")
	@RequestMapping("/preadd/{productId}")
	public String preadd(@PathVariable String productId,Model model)
	{
		model.addAttribute("supplier",new ProductSupplier());
		model.addAttribute("product",repository.findOne(productId));
		model.addAttribute("suppliers",partyRepository.findAllByRole("Supplier"));
		
		return "productsupplier-add";
	}

	@Secured("ROLE_PRDSUPPLIER_CREATE")
	@RequestMapping(value="/add/{productId}",method=RequestMethod.POST)
	public String add(@PathVariable String productId, ProductSupplier supplier)
	{
		Product product = repository.findOne(productId);
		product.getSuppliers().add(supplier);

		repository.save(product);

		return "redirect:/products/preedit/"+productId;
	}

	@Secured("ROLE_PRDSUPPLIER_UPDATE")
	@RequestMapping("/preedit/{productId}/{id}")
	public String preedit(@PathVariable String productId,@PathVariable String id,Model model)
	{
		Product product = repository.findOne(productId);
		for(ProductSupplier supplier:product.getSuppliers())
		{
			if(supplier.getId().equals(id))
			{
				model.addAttribute("supplier",supplier);
				model.addAttribute("suppliers",partyRepository.findAllByRole("Supplier"));
				model.addAttribute("product",repository.findOne(productId));
				break;
			}
		}

		return "productsupplier-edit";
	}

	@Secured("ROLE_PRDSUPPLIER_UPDATE")
	@RequestMapping(value="/edit/{productId}",method=RequestMethod.POST)
	public String edit(@PathVariable String productId,ProductSupplier supplier)
	{
		Product product = repository.findOne(productId);
		for(ProductSupplier comp:product.getSuppliers())
		{
			if(comp.getId().equals(supplier.getId()))
			{
				comp.setFrom(supplier.getFrom());
				comp.setTo(supplier.getTo());
				comp.setSupplier(supplier.getSupplier());
				
				break;
			}
		}

		repository.save(product);

		return "redirect:/products/preedit/"+productId;
	}

	@Secured("ROLE_PRDSUPPLIER_DELETE")
	@RequestMapping("/delete/{productId}/{id}")
	public String delete(@PathVariable String productId,@PathVariable String id)
	{
		Product product = repository.findOne(productId);
		for(ProductSupplier comp:product.getSuppliers())
		{
			if(comp.getId().equals(id))
			{
				comp.setDeleted(true);
				break;
			}
		}

		repository.save(product);
		
		return "redirect:/products/preedit/"+productId;
	}
}
