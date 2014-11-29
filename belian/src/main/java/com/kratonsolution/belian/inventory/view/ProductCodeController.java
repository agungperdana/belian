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
import com.kratonsolution.belian.inventory.dm.ProductCode;
import com.kratonsolution.belian.inventory.dm.ProductRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/productcodes")
public class ProductCodeController
{
	@Autowired
	private ProductRepository repository;

	@Secured("ROLE_PRDCODE_CREATE")
	@RequestMapping("/preadd/{productId}")
	public String preadd(@PathVariable String productId,Model model)
	{
		model.addAttribute("code",new ProductCode());
		model.addAttribute("types",ProductCode.Type.values());
		return "productcode-add";
	}

	@Secured("ROLE_PRDCODE_CREATE")
	@RequestMapping(value="/add/{productId}",method=RequestMethod.POST)
	public String add(@PathVariable String productId, ProductCode code)
	{
		code.setId(UUID.randomUUID().toString());
		
		Product root = repository.findOne(productId);
		root.getCodes().add(code);

		repository.save(root);

		return "redirect:/products/preedit/"+productId;
	}

	@Secured("ROLE_PRDCODE_UPDATE")
	@RequestMapping("/preedit/{productId}/{id}")
	public String preedit(@PathVariable String productId,@PathVariable String id,Model model)
	{
		Product product = repository.findOne(productId);
		for(ProductCode code:product.getCodes())
		{
			if(code.getId().equals(id))
			{
				model.addAttribute("code",code);
				model.addAttribute("productId",productId);
				model.addAttribute("types",ProductCode.Type.values());
				break;
			}
		}

		return "productcode-edit";
	}

	@Secured("ROLE_PRDCODE_UPDATE")
	@RequestMapping(value="/edit/{productId}",method=RequestMethod.POST)
	public String edit(@PathVariable String productId,ProductCode code)
	{
		Product product = repository.findOne(productId);
		for(ProductCode comp:product.getCodes())
		{
			if(comp.getId().equals(code.getId()))
			{
				comp.setCode(code.getCode());
				comp.setType(code.getType());
				
				break;
			}
		}

		repository.save(product);

		return "redirect:/products/preedit/"+productId;
	}

	@Secured("ROLE_PRDCODE_DELETE")
	@RequestMapping("/delete/{productId}/{id}")
	public String delete(@PathVariable String productId,@PathVariable String id)
	{
		Product product = repository.findOne(productId);
		for(ProductCode comp:product.getCodes())
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
