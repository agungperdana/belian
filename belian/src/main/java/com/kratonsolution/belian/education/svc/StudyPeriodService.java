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
import com.kratonsolution.belian.education.dm.StudyPeriod;
import com.kratonsolution.belian.education.dm.StudyPeriodRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class StudyPeriodService
{
	@Autowired
	private StudyPeriodRepository repository;
		
	@Secured({"ROLE_STUDY_PERIOD_READ","ROLE_SYSTEM_READ"})
	public StudyPeriod findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);
	
		return null;
	}
	
	@Secured({"ROLE_STUDY_PERIOD_READ","ROLE_SYSTEM_READ"})
	public List<StudyPeriod> findAll()
	{
		return repository.findAll();
	}
	
	@Secured({"ROLE_STUDY_PERIOD_READ"})
	public int getSize()
	{
		return (int)repository.count();
	}
	
	@Secured("ROLE_STUDY_PERIOD_CREATE")
	public void add(StudyPeriod period)
	{
		repository.save(period);
	}
	
	@Secured("ROLE_STUDY_PERIOD_UPDATE")
	public void edit(StudyPeriod period)
	{
		repository.saveAndFlush(period);
	}
	
	@Secured("ROLE_STUDY_PERIOD_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_STUDY_PERIOD_READ")
	public List<StudyPeriod> findAll(int pageIndex,int itemsSize)
	{
		return repository.findAll(new PageRequest(pageIndex, itemsSize)).getContent();
	}
}
