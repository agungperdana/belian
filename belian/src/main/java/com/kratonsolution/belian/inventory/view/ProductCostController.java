/**
 * 
 */
package com.kratonsolution.belian.inventory.view;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.dm.CurrencyRepository;
import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.general.dm.GeographicRepository;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductCost;
import com.kratonsolution.belian.inventory.dm.ProductRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/productcosts")
public class ProductCostController
{
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private GeographicRepository geographicRepository;
	
	@Autowired
	private CurrencyRepository currencyRepository;
	
	@InitBinder
	public void binder(WebDataBinder binder)
	{
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
		binder.registerCustomEditor(BigDecimal.class,new CustomNumberEditor(BigDecimal.class, false));
	}

	@Secured("ROLE_PRDCOST_CREATE")
	@RequestMapping("/preadd/{productId}")
	public String preadd(@PathVariable String productId,Model model)
	{
		model.addAttribute("cost",new ProductCost());
		model.addAttribute("types",ProductCost.Type.values());
		model.addAttribute("geographics",geographicRepository.findAll());
		model.addAttribute("currencys",currencyRepository.findAll());
		return "productcost-add";
	}

	@Secured("ROLE_PRDCOST_CREATE")
	@RequestMapping(value="/add/{productId}",method=RequestMethod.POST)
	public String add(@PathVariable String productId, ProductCost cost)
	{
		cost.setId(UUID.randomUUID().toString());
		
		if(!Strings.isNullOrEmpty(cost.getAreaId()))
		{
			Geographic geographic = geographicRepository.findOne(cost.getAreaId());
			if(geographic != null)
				cost.setAreaName(geographic.getName());
		}
		
		if(!Strings.isNullOrEmpty(cost.getCurrencyId()))
		{
			Currency currency = currencyRepository.findOne(cost.getCurrencyId());
			if(currency != null)
				cost.setCurrencyCode(currency.getCode());
		}
		
		Product root = repository.findOne(productId);
		root.getCosts().add(cost);

		repository.save(root);

		return "redirect:/products/preedit/"+productId;
	}

	@Secured("ROLE_PRDCOST_UPDATE")
	@RequestMapping("/preedit/{productId}/{id}")
	public String preedit(@PathVariable String productId,@PathVariable String id,Model model)
	{
		Product product = repository.findOne(productId);
		for(ProductCost cost:product.getCosts())
		{
			if(cost.getId().equals(id))
			{
				model.addAttribute("cost",cost);
				model.addAttribute("productId",productId);
				model.addAttribute("types",ProductCost.Type.values());
				model.addAttribute("geographics",geographicRepository.findAll());
				model.addAttribute("currencys",currencyRepository.findAll());
				break;
			}
		}

		return "productcost-edit";
	}

	@Secured("ROLE_PRDCOST_UPDATE")
	@RequestMapping(value="/edit/{productId}",method=RequestMethod.POST)
	public String edit(@PathVariable String productId,ProductCost cost)
	{
		Product product = repository.findOne(productId);
		for(ProductCost comp:product.getCosts())
		{
			if(comp.getId().equals(cost.getId()))
			{
				comp.setFrom(cost.getFrom());
				comp.setTo(cost.getTo());
				comp.setEstimated(cost.getEstimated());
				comp.setDeleted(cost.isDeleted());
				comp.setType(cost.getType());
				
				if(!Strings.isNullOrEmpty(cost.getAreaId()))
				{
					Geographic geographic = geographicRepository.findOne(cost.getAreaId());
					if(geographic != null)
						cost.setAreaName(geographic.getName());
				}
				
				if(!Strings.isNullOrEmpty(cost.getCurrencyId()))
				{
					Currency currency = currencyRepository.findOne(cost.getCurrencyId());
					if(currency != null)
						cost.setCurrencyCode(currency.getCode());
				}
				
				break;
			}
		}

		repository.save(product);

		return "redirect:/products/preedit/"+productId;
	}

	@Secured("ROLE_PRDCOST_DELETE")
	@RequestMapping("/delete/{productId}/{id}")
	public String delete(@PathVariable String productId,@PathVariable String id)
	{
		Product product = repository.findOne(productId);
		for(ProductCost comp:product.getCosts())
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
