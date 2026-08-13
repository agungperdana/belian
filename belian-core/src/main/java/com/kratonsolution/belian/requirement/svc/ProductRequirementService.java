
package com.kratonsolution.belian.requirement.svc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.requirement.dm.ProductRequirement;
import com.kratonsolution.belian.requirement.dm.ProductRequirementRepository;
import com.kratonsolution.belian.requirement.dm.RequirementType;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ProductRequirementService extends AbstractService
{
	@Autowired
	private ProductRequirementRepository repository;
	
	@Secured("ROLE_PRODUCT_REQUIREMENT_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_PRODUCT_REQUIREMENT_READ")
	public int size(String key)
	{
		if(!Strings.isNullOrEmpty(key))
			return repository.count(key).intValue();
		else
			return size();
	}
	
	@Secured("ROLE_PRODUCT_REQUIREMENT_READ")
	public ProductRequirement findById(String id)
	{
		return repository.findById(id).orElse(null);
	}
	
	@Secured("ROLE_PRODUCT_REQUIREMENT_READ")
	public List<ProductRequirement> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_PRODUCT_REQUIREMENT_READ")
	public List<ProductRequirement> findAllOpen()
	{
		return repository.findAllOpen();
	}
	
	public List<ProductRequirement> findAllProductActive(String initiator,String product,RequirementType type)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();
		
		return repository.findAllProductActive(utils.getOrganization().getId(), initiator, product,type);
	}
	
	public List<ProductRequirement> findAllProductActive(String product,RequirementType type)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();
		
		return repository.findAllProductActive(utils.getOrganization().getId(), product,type);
	}
	
	public List<ProductRequirement> findAllFeatureActive(String initiator,String feature,RequirementType type)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();
		
		return repository.findAllFeatureActive(utils.getOrganization().getId(), initiator, feature,type);
	}
	
	public List<ProductRequirement> findAllFeatureActive(String feature,RequirementType type)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();
		
		return repository.findAllFeatureActive(utils.getOrganization().getId(), feature,type);
	}
	
	@Secured("ROLE_PRODUCT_REQUIREMENT_READ")
	public List<ProductRequirement> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(PageRequest.of(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_PRODUCT_REQUIREMENT_READ")
	public List<ProductRequirement> findAll(int pageIndex,int pageSize,String key)
	{
		if(!Strings.isNullOrEmpty(key))
			return repository.findAll(PageRequest.of(pageIndex, pageSize),key);
		else
			return findAll(pageIndex, pageSize);
	}
	
	@Secured("ROLE_PRODUCT_REQUIREMENT_CREATE")
	public void add(ProductRequirement item)
	{
		repository.save(item);
	}
	
	@Secured("ROLE_PRODUCT_REQUIREMENT_UPDATE")
	public void edit(ProductRequirement item)
	{
		repository.saveAndFlush(item);
	}
	
	@Secured("ROLE_PRODUCT_REQUIREMENT_DELETE")
	public void delete(String id)
	{
		repository.deleteById(id);
	}
	
	@Secured("ROLE_PRODUCT_REQUIREMENT_DELETE")
	public void delete(Collection<String> ids)
	{
		if(ids != null)
		{
			for(String id:ids)
				delete(id);
		}
	}
}
