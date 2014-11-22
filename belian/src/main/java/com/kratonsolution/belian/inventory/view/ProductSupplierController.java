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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kratonsolution.belian.general.dm.Party;
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
	
	@RequestMapping("/preadd/{productId}")
	public String preadd(@PathVariable String productId,Model model)
	{
		model.addAttribute("supplier",new ProductSupplier());
		model.addAttribute("product",repository.findOne(productId));
		model.addAttribute("suppliers",partyRepository.findAllByRole("Supplier"));
		
		return "productsupplier-add";
	}

	@RequestMapping(value="/add/{productId}",method=RequestMethod.POST)
	public String add(@PathVariable String productId, ProductSupplier supplier)
	{
		Product product = repository.findOne(productId);

		Party party = partyRepository.findOne(supplier.getPartyId());
		if(party != null)
		{
			supplier.setId(UUID.randomUUID().toString());
			supplier.setPartyName(party.getName());

			product.getSuppliers().add(supplier);
		}

		repository.save(product);

		return "redirect:/products/preedit/"+productId;
	}

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
				
				Party party = partyRepository.findOne(supplier.getPartyId());
				if(party != null)
				{
					comp.setPartyId(party.getId());
					comp.setPartyName(party.getName());					
				}

				break;
			}
		}

		repository.save(product);

		return "redirect:/products/preedit/"+productId;
	}

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
