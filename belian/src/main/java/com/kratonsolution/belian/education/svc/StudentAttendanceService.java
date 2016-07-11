/**
 * 
 */
package com.kratonsolution.belian.education.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.education.dm.StudentAttendance;
import com.kratonsolution.belian.education.dm.StudentAttendanceRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class StudentAttendanceService
{
	@Autowired
	private SessionUtils utils;

	@Autowired
	private StudentAttendanceRepository repository;

	@Secured({"ROLE_STUDENT_ATTENDANCE_READ","ROLE_SYSTEM_READ"})
	public StudentAttendance findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);

		return null;
	}

	@Secured({"ROLE_STUDENT_ATTENDANCE_READ","ROLE_SYSTEM_READ"})
	public List<StudentAttendance> findAll()
	{
		return repository.findAll();
	}

	@Secured({"ROLE_STUDENT_ATTENDANCE_READ"})
	public int getSize()
	{
		if(utils.getOrganizationIds() != null && !utils.getOrganizationIds().isEmpty())
			return repository.count(utils.getOrganizationIds()).intValue();

		return 0;
	}

	@Secured({"ROLE_STUDENT_ATTENDANCE_READ"})
	public int getSize(String key)
	{
		if(Strings.isNullOrEmpty(key))
			return getSize();

		return repository.count(utils.getOrganizationIds(), key).intValue();
	}

	@Secured("ROLE_STUDENT_ATTENDANCE_CREATE")
	public void add(StudentAttendance reg)
	{
		repository.save(reg);
	}

	@Secured("ROLE_STUDENT_ATTENDANCE_UPDATE")
	public void edit(StudentAttendance reg)
	{
		repository.saveAndFlush(reg);
	}

	@Secured("ROLE_STUDENT_ATTENDANCE_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}

	@Secured("ROLE_STUDENT_ATTENDANCE_READ")
	public List<StudentAttendance> findAll(int pageIndex,int itemsSize)
	{
		if(utils.getOrganizationIds() != null && !utils.getOrganizationIds().isEmpty())
			return repository.findAll(new PageRequest(pageIndex, itemsSize),utils.getOrganizationIds());

		return new ArrayList<>();
	}

	@Secured("ROLE_STUDENT_ATTENDANCE_READ")
	public List<StudentAttendance> findAll(int pageIndex,int itemsSize,String key)
	{
		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, itemsSize);

		return repository.findAll(new PageRequest(pageIndex, itemsSize), utils.getOrganizationIds(),key);
	}
}
