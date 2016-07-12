/**
 * 
 */
package com.kratonsolution.belian.procurement.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.InternalOrganization;
import com.kratonsolution.belian.general.dm.InternalOrganizationRepository;
import com.kratonsolution.belian.procurement.dm.Supplier;
import com.kratonsolution.belian.procurement.dm.SupplierRelationship;
import com.kratonsolution.belian.procurement.dm.SupplierRelationshipRepository;
import com.kratonsolution.belian.procurement.dm.SupplierRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class SupplierRelationshipService
{
	@Autowired
	private SupplierRelationshipRepository repository;
	
	@Autowired
	private SupplierRepository supplierRepo;
	
	@Autowired
	private InternalOrganizationRepository interRepo;
	
	@Autowired
	private SessionUtils utils;
	
	@Secured("ROLE_SUPPLIER_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_SUPPLIER_READ")
	public SupplierRelationship findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_SUPPLIER_READ")
	public List<SupplierRelationship> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_SUPPLIER_READ")
	public List<SupplierRelationship> findAll(String name)
	{
		if(Strings.isNullOrEmpty(name))
			return findAll(utils.getOrganization().getId());
		
		return repository.findAll(name,utils.getOrganization().getId());
	}
	
	@Secured("ROLE_SUPPLIER_READ")
	public List<SupplierRelationship> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Secured("ROLE_SUPPLIER_CREATE")
	public void add(SupplierRelationship relation)
	{
		SupplierRelationship out = repository.findOne(relation.getSupplier().getParty().getId(), relation.getOrganization().getParty().getId());
		if(out != null)
			throw new RuntimeException("Supplier already exist.");
		
		Supplier supplier = supplierRepo.findOneByPartyId(relation.getSupplier().getParty().getId());
		if(supplier == null)
		{
			relation.getSupplier().setStart(relation.getStart());
			supplierRepo.save(relation.getSupplier());
		}
		else
			relation.setSupplier(supplier);
		
		InternalOrganization organization = interRepo.findOneByPartyId(relation.getOrganization().getParty().getId());
		if(organization == null)
		{
			relation.getOrganization().setStart(relation.getStart());
			interRepo.save(relation.getOrganization());
		}
		else
			relation.setOrganization(organization);
		
		repository.save(relation);
	}
	
	@Secured("ROLE_SUPPLIER_UPDATE")
	public void edit(SupplierRelationship relation)
	{
		repository.saveAndFlush(relation);
	}
	
	@Secured("ROLE_SUPPLIER_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}