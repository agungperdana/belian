/**
 * 
 */
package com.kratonsolution.belian.asset.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.asset.dm.AssetType;
import com.kratonsolution.belian.asset.dm.AssetTypeRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class AssetTypeService
{
	@Autowired
	private AssetTypeRepository repository;
		
	@Secured({"ROLE_ASSET_TYPE_READ"})
	public AssetType findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);
	
		return null;
	}
	
	@Secured({"ROLE_ASSET_TYPE_READ"})
	public List<AssetType> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_ASSET_TYPE_READ")
	public int size()
	{
		return (int)repository.count();
	}
	
	@Secured("ROLE_ASSET_TYPE_READ")
	public List<AssetType> findAllParent()
	{
		return repository.findAllByParentIsNull();
	}
	
	@Secured("ROLE_ASSET_TYPE_CREATE")
	public void add(AssetType asset)
	{
		repository.save(asset);
	}
	
	@Secured("ROLE_ASSET_TYPE_UPDATE")
	public void edit(AssetType asset)
	{
		repository.saveAndFlush(asset);
	}
	
	@Secured("ROLE_ASSET_TYPE_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_ASSET_TYPE_READ")
	public List<AssetType> findAll(int pageIndex,int itemsSize)
	{
		return repository.findAll(new PageRequest(pageIndex, itemsSize)).getContent();
	}
}
