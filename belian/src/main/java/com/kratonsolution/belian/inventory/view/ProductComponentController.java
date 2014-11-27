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

import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductComponent;
import com.kratonsolution.belian.inventory.dm.ProductRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/productcomponents")
public class ProductComponentController
{
	@Autowired
	private ProductRepository repository;

	@Secured("ROLE_PRDCOMPONENT_CREATE")
	@RequestMapping("/preadd/{productId}")
	public String preadd(@PathVariable String productId,Model model)
	{
		model.addAttribute("component",new ProductComponent());
		model.addAttribute("products",repository.findAll());
		return "productcomponent-add";
	}

	@Secured("ROLE_PRDCOMPONENT_CREATE")
	@RequestMapping(value="/add/{productId}",method=RequestMethod.POST)
	public String add(@PathVariable String productId, ProductComponent component)
	{
		Product root = repository.findOne(productId);

		Product product = repository.findOne(component.getProductId());
		if(product != null)
		{
			component.setId(UUID.randomUUID().toString());
			component.setProductName(product.getName());

			root.getComponents().add(component);
		}

		repository.save(root);

		return "redirect:/products/preedit/"+productId;
	}

	@Secured("ROLE_PRDCOMPONENT_UPDATE")
	@RequestMapping("/preedit/{productId}/{id}")
	public String preedit(@PathVariable String productId,@PathVariable String id,Model model)
	{
		Product product = repository.findOne(productId);
		for(ProductComponent component:product.getComponents())
		{
			if(component.getId().equals(id))
			{
				model.addAttribute("component",component);
				model.addAttribute("products",repository.findAll());
				break;
			}
		}

		return "productcomponent-edit";
	}

	@Secured("ROLE_PRDCOMPONENT_UPDATE")
	@RequestMapping(value="/edit/{productId}",method=RequestMethod.POST)
	public String edit(@PathVariable String productId,ProductComponent component)
	{
		Product product = repository.findOne(productId);
		for(ProductComponent comp:product.getComponents())
		{
			if(comp.getId().equals(component.getId()))
			{
				comp.setAmount(component.getAmount());
				comp.setDeleted(component.isDeleted());
				comp.setProductId(component.getProductId());
				comp.setProductName(component.getProductName());
				break;
			}
		}

		repository.save(product);

		return "redirect:/products/preedit/"+productId;
	}

	@Secured("ROLE_PRDCOMPONENT_DELETE")
	@RequestMapping("/delete/{productId}/{id}")
	public String delete(@PathVariable String productId,@PathVariable String id)
	{
		Product product = repository.findOne(productId);
		for(ProductComponent comp:product.getComponents())
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
