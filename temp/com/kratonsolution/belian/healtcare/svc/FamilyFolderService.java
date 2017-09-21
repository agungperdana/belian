/**
 * 
 */
package com.kratonsolution.belian.healtcare.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.healtcare.dm.FamilyFolder;
import com.kratonsolution.belian.healtcare.dm.FamilyFolderRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class FamilyFolderService
{
	@Autowired
	private FamilyFolderRepository repository;
	
	@Secured("ROLE_FAMILY_FOLDER_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_FAMILY_FOLDER_READ")
	public FamilyFolder findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_FAMILY_FOLDER_READ")
	public List<FamilyFolder> findAll()
	{
		return repository.findAll();
	}
		
	@Secured("ROLE_FAMILY_FOLDER_READ")
	public List<FamilyFolder> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_FAMILY_FOLDER_CREATE")
	public void add(FamilyFolder folder)
	{
		repository.save(folder);
	}
	
	@Secured("ROLE_FAMILY_FOLDER_UPDATE")
	public void edit(FamilyFolder type)
	{
		repository.saveAndFlush(type);
	}
	
	@Secured("ROLE_FAMILY_FOLDER_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
