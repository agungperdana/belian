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
import com.kratonsolution.belian.education.dm.CourseSchedule;
import com.kratonsolution.belian.education.dm.CourseScheduleRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CourseScheduleService
{
	@Autowired
	private CourseScheduleRepository repository;
		
	@Secured({"ROLE_COURSE_SCHEDULE_READ","ROLE_STUDY_ROOM_READ","ROLE_SYSTEM_READ"})
	public CourseSchedule findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);
	
		return null;
	}
	
	@Secured({"ROLE_COURSE_SCHEDULE_READ","ROLE_STUDY_ROOM_READ","ROLE_SYSTEM_READ"})
	public List<CourseSchedule> findAll()
	{
		return repository.findAll();
	}
	
	@Secured({"ROLE_COURSE_SCHEDULE_READ","ROLE_STUDY_ROOM_READ"})
	public int getSize()
	{
		return (int)repository.count();
	}
	
	@Secured("ROLE_STUDY_DAY_CREATE")
	public void add(CourseSchedule day)
	{
		repository.save(day);
	}
	
	@Secured("ROLE_STUDY_DAY_UPDATE")
	public void edit(CourseSchedule day)
	{
		repository.saveAndFlush(day);
	}
	
	@Secured("ROLE_STUDY_DAY_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured({"ROLE_COURSE_SCHEDULE_READ","ROLE_STUDY_ROOM_READ"})
	public List<CourseSchedule> findAll(int pageIndex,int itemsSize)
	{
		return repository.findAll(new PageRequest(pageIndex, itemsSize)).getContent();
	}
}
