/**
 * 
 */
package com.kratonsolution.belian.hr.svc;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.hr.dm.BenefitType;
import com.kratonsolution.belian.hr.dm.BenefitTypeRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class BenefitTypeService
{
	@Autowired
	private BenefitTypeRepository repository;
	
	@Secured("ROLE_BENEFIT_TYPE_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_BENEFIT_TYPE_READ")
	public BenefitType findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_BENEFIT_TYPE_READ")
	public List<BenefitType> findAll()
	{
		return repository.findAll();
	}
		
	@Secured("ROLE_BENEFIT_TYPE_READ")
	public List<BenefitType> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_BENEFIT_TYPE_CREATE")
	public void add(BenefitType grade)
	{
		grade.setId(UUID.randomUUID().toString());
		repository.save(grade);
	}
	
	@Secured("ROLE_BENEFIT_TYPE_UPDATE")
	public void edit(BenefitType grade)
	{
		repository.saveAndFlush(grade);
	}
	
	@Secured("ROLE_BENEFIT_TYPE_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
