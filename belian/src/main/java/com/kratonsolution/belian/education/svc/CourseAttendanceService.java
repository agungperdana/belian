/**
 * 
 */
package com.kratonsolution.belian.education.svc;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.education.dm.CourseAttendance;
import com.kratonsolution.belian.education.dm.CourseAttendanceRepository;
import com.kratonsolution.belian.education.dm.CourseSchedule;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CourseAttendanceService
{
	@Autowired
	private SessionUtils utils;

	@Autowired
	private CourseAttendanceRepository repository;

	@Secured({"ROLE_COURSE_ATTENDANCE_READ","ROLE_SYSTEM_READ"})
	public CourseAttendance findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);

		return null;
	}

	@Secured({"ROLE_COURSE_ATTENDANCE_READ","ROLE_SYSTEM_READ"})
	public List<CourseAttendance> findAll()
	{
		return repository.findAll();
	}

	@Secured({"ROLE_COURSE_ATTENDANCE_READ"})
	public int getSize()
	{
		if(utils.getOrganizationIds() != null && !utils.getOrganizationIds().isEmpty())
			return repository.count(utils.getOrganizationIds()).intValue();

		return 0;
	}

	@Secured({"ROLE_COURSE_ATTENDANCE_READ"})
	public int getSize(String key)
	{
		if(Strings.isNullOrEmpty(key))
			return getSize();

		return repository.count(utils.getOrganizationIds(), key).intValue();
	}

	@Secured("ROLE_COURSE_ATTENDANCE_CREATE")
	public void add(CourseAttendance reg)
	{
		repository.save(reg);
	}

	@Secured("ROLE_COURSE_ATTENDANCE_UPDATE")
	public void edit(CourseAttendance reg)
	{
		repository.saveAndFlush(reg);
	}

	@Secured("ROLE_COURSE_ATTENDANCE_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}

	@Secured("ROLE_COURSE_ATTENDANCE_READ")
	public List<CourseAttendance> findAll(int pageIndex,int itemsSize)
	{
		if(utils.getOrganizationIds() != null && !utils.getOrganizationIds().isEmpty())
			return repository.findAll(new PageRequest(pageIndex, itemsSize),utils.getOrganizationIds());

		return new ArrayList<>();
	}

	@Secured("ROLE_COURSE_ATTENDANCE_READ")
	public List<CourseAttendance> findAll(int pageIndex,int itemsSize,String key)
	{
		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, itemsSize);

		return repository.findAll(new PageRequest(pageIndex, itemsSize), utils.getOrganizationIds(),key);
	}

	@Secured("ROLE_COURSE_ATTENDANCE_READ")
	public List<CourseSchedule> findAll(String period,List<String> day,Time start,Time end)
	{
		if(utils.getOrganizationIds() == null && utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();
		
		return repository.findAll(utils.getOrganizationIds(), period, day, start, end);
	}
}
