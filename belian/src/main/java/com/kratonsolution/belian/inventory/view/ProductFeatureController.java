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

import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductFeature;
import com.kratonsolution.belian.inventory.dm.ProductRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/productfeatures")
public class ProductFeatureController
{
	@Autowired
	private ProductRepository repository;
	
	@RequestMapping("/preadd/{productId}")
	public String preadd(@PathVariable String productId,Model model)
	{
		model.addAttribute("feature",new ProductFeature());
		model.addAttribute("types",ProductFeature.Type.values());
		
		return "productfeature-add";
	}
	
	@RequestMapping(value="/add/{productId}",method=RequestMethod.POST)
	public String add(@PathVariable String productId, ProductFeature feature)
	{
		Product product = repository.findOne(productId);
		if(product != null)
		{
			feature.setId(UUID.randomUUID().toString());
			product.getFeatures().add(feature);
		}

		repository.save(product);
		
		return "redirect:/products/preedit/"+productId;
	}
	
	@RequestMapping("/preedit/{productId}/{id}")
	public String preedit(@PathVariable String productId,@PathVariable String id,Model model)
	{
		Product product = repository.findOne(productId);
		for(ProductFeature feature:product.getFeatures())
		{
			if(feature.getId().equals(id))
			{
				model.addAttribute("feature",feature);
				model.addAttribute("types",ProductFeature.Type.values());
				break;
			}
		}
		
		return "productfeature-edit";
	}
	
	@RequestMapping(value="/edit/{productId}",method=RequestMethod.POST)
	public String edit(@PathVariable String productId,ProductFeature feature)
	{
		Product product = repository.findOne(productId);
		for(ProductFeature comp:product.getFeatures())
		{
			if(comp.getId().equals(feature.getId()))
			{
				comp.setValue(feature.getValue());
				comp.setType(feature.getType());
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
		for(ProductFeature comp:product.getFeatures())
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
