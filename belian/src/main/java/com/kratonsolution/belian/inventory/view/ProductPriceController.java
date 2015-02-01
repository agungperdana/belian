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

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.dm.CurrencyRepository;
import com.kratonsolution.belian.accounting.view.CurrencyEditor;
import com.kratonsolution.belian.accounting.view.PartyEditor;
import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.general.dm.GeographicRepository;
import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.dm.PartyRepository;
import com.kratonsolution.belian.general.view.GeographicEditor;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductPrice;
import com.kratonsolution.belian.inventory.dm.ProductRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/productprices")
public class ProductPriceController
{
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private GeographicRepository geoRepository;
	
	@Autowired
	private PartyRepository partyRepository;
	
	@Autowired
	private CurrencyRepository currencyRepository;
	
	@Autowired
	private CurrencyEditor currencyEditor;
	
	@Autowired
	private GeographicEditor geoEditor;
	
	@Autowired
	private PartyEditor partyEditor;
	
	@InitBinder
	public void binder(WebDataBinder binder)
	{
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
		binder.registerCustomEditor(Currency.class, currencyEditor);
		binder.registerCustomEditor(Geographic.class, geoEditor);
		binder.registerCustomEditor(Party.class,partyEditor);
		binder.registerCustomEditor(BigDecimal.class,new CustomNumberEditor(BigDecimal.class,false));
	}
	
	@Secured("ROLE_PRDPRICE_CREATE")
	@RequestMapping("/preadd/{productId}")
	public String preadd(@PathVariable String productId,Model model)
	{
		model.addAttribute("product",repository.findOne(productId));
		model.addAttribute("price",new ProductPrice());
		model.addAttribute("types",ProductPrice.Type.values());
		model.addAttribute("geographics",geoRepository.findAll());
		model.addAttribute("partys",partyRepository.findAllByRole("Customer"));
		model.addAttribute("currencys",currencyRepository.findAll());
		
		return "productprice-add";
	}
	
	@Secured("ROLE_PRDPRICE_CREATE")
	@RequestMapping(value="/add/{productId}",method=RequestMethod.POST)
	public String add(@PathVariable String productId, ProductPrice price)
	{
		Product product = repository.findOne(productId);
		if(product != null)
		{
			price.setId(UUID.randomUUID().toString());
			product.getPrices().add(price);
		}

		repository.save(product);
		
		return "redirect:/products/preedit/"+productId;
	}
	
	@Secured("ROLE_PRDPRICE_UPDATE")
	@RequestMapping("/preedit/{productId}/{id}")
	public String preedit(@PathVariable String productId,@PathVariable String id,Model model)
	{
		Product product = repository.findOne(productId);
		for(ProductPrice price:product.getPrices())
		{
			if(price.getId().equals(id))
			{
				model.addAttribute("product",product);
				model.addAttribute("price",price);
				model.addAttribute("types",ProductPrice.Type.values());
				model.addAttribute("geographics",geoRepository.findAll());
				model.addAttribute("partys",partyRepository.findAllByRole("Customer"));
				model.addAttribute("currencys",currencyRepository.findAll());
				break;
			}
		}
		
		return "productprice-edit";
	}
	
	@Secured("ROLE_PRDPRICE_UPDATE")
	@RequestMapping(value="/edit/{productId}",method=RequestMethod.POST)
	public String edit(@PathVariable String productId,ProductPrice price)
	{
		Product product = repository.findOne(productId);
		for(ProductPrice comp:product.getPrices())
		{
			if(comp.getId().equals(price.getId()))
			{
				comp.setFrom(price.getFrom());
				comp.setTo(price.getTo());
				comp.setType(price.getType());
				comp.setPrice(price.getPrice());
				comp.setCurrency(price.getCurrency());
				comp.setGeographic(price.getGeographic());
				comp.setParty(price.getParty());
				
				break;
			}
		}
		
		repository.save(product);
		
		return "redirect:/products/preedit/"+productId;
	}
	
	@Secured("ROLE_PRDPRICE_DELETE")
	@RequestMapping("/delete/{productId}/{id}")
	public String delete(@PathVariable String productId,@PathVariable String id)
	{
		Product product = repository.findOne(productId);
		for(ProductPrice comp:product.getPrices())
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
