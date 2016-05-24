/**
 * 
 */
package com.kratonsolution.belian.asset.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.asset.dm.Asset;
import com.kratonsolution.belian.asset.dm.AssetRepository;
import com.kratonsolution.belian.common.SessionUtils;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class AssetService
{
	@Autowired
	private AssetRepository repository;
	
	@Autowired
	private SessionUtils utils;
		
	@Secured({"ROLE_ASSET_READ","ROLE_CASHIER_READ"})
	public Asset findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);
	
		return null;
	}
	
	@Secured({"ROLE_ASSET_READ","ROLE_CASHIER_READ"})
	public List<Asset> findAll()
	{
		if(utils.isSysAdmin())
			return repository.findAll();
		
		if(utils.getOrganization() == null)
			return new ArrayList<>();
		
		return repository.findAll(utils.getOrganization().getId());
	}
	
	@Secured({"ROLE_ASSET_READ","ROLE_CASHIER_READ"})
	public List<Asset> findAllUnused()
	{
		if(utils.getOrganization() == null || utils.isSysAdmin())
			return new ArrayList<>();
		
		return repository.findAllUnused(utils.getOrganization().getId());
	}
	
	@Secured("ROLE_ASSET_READ")
	public int size()
	{
		if(utils.isSysAdmin())
			return (int)repository.count();
		
		if(utils.getOrganization() == null)
			return 0;
		
		return repository.count(utils.getOrganization().getId()).intValue();
	}
	
	@Secured("ROLE_ASSET_CREATE")
	public void add(Asset asset)
	{
		repository.save(asset);
	}
	
	@Secured("ROLE_ASSET_UPDATE")
	public void edit(Asset asset)
	{
		repository.saveAndFlush(asset);
	}
	
	@Secured("ROLE_ASSET_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_ASSET_READ")
	public List<Asset> findAll(int pageIndex,int itemsSize)
	{
		if(utils.isSysAdmin())
			return repository.findAll(new PageRequest(pageIndex, itemsSize)).getContent();
		
		if(utils.getOrganization() == null)
			return new ArrayList<>();
		
		return repository.findAll(new PageRequest(pageIndex, itemsSize),utils.getOrganization().getId());
	}
}
