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
import com.kratonsolution.belian.education.dm.StudyTime;
import com.kratonsolution.belian.education.dm.StudyTimeRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class StudyTimeService
{
	@Autowired
	private StudyTimeRepository repository;
		
	@Secured({"ROLE_STUDY_TIME_READ","ROLE_SYSTEM_READ"})
	public StudyTime findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);
	
		return null;
	}
	
	@Secured({"ROLE_STUDY_TIME_READ","ROLE_SYSTEM_READ"})
	public List<StudyTime> findAll()
	{
		return repository.findAll();
	}
	
	@Secured({"ROLE_STUDY_TIME_READ"})
	public int getSize()
	{
		return (int)repository.count();
	}
	
	@Secured("ROLE_STUDY_TIME_CREATE")
	public void add(StudyTime time)
	{
		repository.save(time);
	}
	
	@Secured("ROLE_STUDY_TIME_UPDATE")
	public void edit(StudyTime time)
	{
		repository.saveAndFlush(time);
	}
	
	@Secured("ROLE_STUDY_TIME_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_STUDY_TIME_READ")
	public List<StudyTime> findAll(int pageIndex,int itemsSize)
	{
		return repository.findAll(new PageRequest(pageIndex, itemsSize)).getContent();
	}
}
