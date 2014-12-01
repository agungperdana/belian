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

import com.google.common.base.Strings;
import com.kratonsolution.belian.inventory.dm.Container;
import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.dm.FacilityRepository;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductRepository;

/**
 * @author agungdodiperdana
 *
 */
@Controller
@RequestMapping("/inventoryitems")
public class InventoryItemController
{
	@Autowired
	private InventoryItemRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Secured("ROLE_INVITEM_READ")
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("inventoryitems",repository.findAll());
		return "inventoryitems";
	}
	
	@Secured("ROLE_INVITEM_CREATE")
	@RequestMapping("/preadd")
	public String preadd(Model model)
	{
		model.addAttribute("inventoryitem",new InventoryItem());
		model.addAttribute("facilitys",facilityRepository.findAll());
		model.addAttribute("products",productRepository.findAllByTypeNot(Product.Type.SERVICE));
		
		return "inventoryitem-add";
	}
	
	@Secured("ROLE_INVITEM_CREATE")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(InventoryItem inventoryitem)
	{
		if(!Strings.isNullOrEmpty(inventoryitem.getFacilityId()))
		{
			inventoryitem.setId(UUID.randomUUID().toString());
			
			Product product = productRepository.findOne(inventoryitem.getProductId());
			if(product != null)
				inventoryitem.setProductName(product.getName());
			
			Facility facility = facilityRepository.findOne(inventoryitem.getFacilityId());
			if(facility != null)
			{
				inventoryitem.setFacilityName(facility.getName());
			
				if(!Strings.isNullOrEmpty(inventoryitem.getContainerId()) && !inventoryitem.getContainerId().equals("0"))
				{
					for(Container container:facility.getContainers())
					{
						if(container.getId().equals(inventoryitem.getContainerId()))
							inventoryitem.setContainerName(container.getName());
					}
				}
			}
			
			repository.save(inventoryitem);
		}
		
		return "redirect:/inventoryitems/list";
	}
	
	@Secured("ROLE_INVITEM_UPDATE")
	@RequestMapping("/preedit/{id}")
	public String preedit(@PathVariable String id,Model model)
	{
		model.addAttribute("inventoryitem",repository.findOne(id));
		model.addAttribute("facilitys",facilityRepository.findAll());
		model.addAttribute("products",productRepository.findAllByTypeNot(Product.Type.SERVICE));
		
		return "inventoryitem-edit";
	}
	
	@Secured("ROLE_INVITEM_UPDATE")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(InventoryItem inventoryitem)
	{
		if(!Strings.isNullOrEmpty(inventoryitem.getFacilityId()))
		{
			Product product = productRepository.findOne(inventoryitem.getProductId());
			if(product != null)
				inventoryitem.setProductName(product.getName());
			
			Facility facility = facilityRepository.findOne(inventoryitem.getFacilityId());
			if(facility != null)
			{
				inventoryitem.setFacilityName(facility.getName());
			
				if(!Strings.isNullOrEmpty(inventoryitem.getContainerId()) && !inventoryitem.getContainerId().equals("0"))
				{
					for(Container container:facility.getContainers())
					{
						if(container.getId().equals(inventoryitem.getContainerId()))
							inventoryitem.setContainerName(container.getName());
					}
				}
			}
			
			repository.save(inventoryitem);
		}
		
		return "redirect:/inventoryitems/list";
	}
	
	@Secured("ROLE_INVITEM_DELETE")
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id)
	{
		repository.delete(id);
		return "redirect:/inventoryitems/list";
	}
}
