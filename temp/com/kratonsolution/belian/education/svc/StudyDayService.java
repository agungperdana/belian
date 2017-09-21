/**
 * 
 */
package com.kratonsolution.belian.education.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.education.dm.StudyDay;
import com.kratonsolution.belian.education.dm.StudyDayRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class StudyDayService
{
	@Autowired
	private StudyDayRepository repository;
		
	@Secured({"ROLE_STUDY_DAY_READ","ROLE_SYSTEM_READ"})
	public StudyDay findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);
	
		return null;
	}
	
	@Secured({"ROLE_STUDY_DAY_READ","ROLE_SYSTEM_READ"})
	public List<StudyDay> findAll()
	{
		return repository.findAll();
	}
	
	@Secured({"ROLE_STUDY_DAY_READ"})
	public int getSize()
	{
		return (int)repository.count();
	}
	
	@Secured("ROLE_STUDY_DAY_CREATE")
	public void add(StudyDay day)
	{
		repository.save(day);
	}
	
	@Secured("ROLE_STUDY_DAY_UPDATE")
	public void edit(StudyDay day)
	{
		repository.saveAndFlush(day);
	}
	
	@Secured("ROLE_STUDY_DAY_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_STUDY_DAY_READ")
	public List<StudyDay> findAll(int pageIndex,int itemsSize)
	{
		return repository.findAll(new PageRequest(pageIndex, itemsSize)).getContent();
	}
}
