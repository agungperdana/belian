/**
 * 
 */
package com.kratonsolution.belian.education.svc;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.AccountingPeriodRepository;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.education.dm.AttendanceStatus;
import com.kratonsolution.belian.education.dm.CourseAttendance;
import com.kratonsolution.belian.education.dm.CourseAttendanceItem;
import com.kratonsolution.belian.education.dm.CourseAttendanceRepository;
import com.kratonsolution.belian.education.dm.CourseSchedule;
import com.kratonsolution.belian.education.dm.TimeEntryRepository;
import com.kratonsolution.belian.hr.dm.Employee;
import com.kratonsolution.belian.hr.dm.EmployeeRepository;
import com.kratonsolution.belian.production.dm.Timesheet;
import com.kratonsolution.belian.production.dm.TimesheetRepository;

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
	private AccountingPeriodRepository periodRepo;
	
	@Autowired
	private TimesheetRepository timesheetRepo;
	
	@Autowired
	private TimeEntryRepository entryRepo;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
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
	public void add(CourseAttendance attendance)
	{
		for(CourseAttendanceItem item:attendance.getItems())
		{
			Employee employee = employeeRepo.findOneByPartyId(item.getPerson().getId());
			if(employee != null)
			{
				Timesheet timesheet = timesheetRepo.findOne(attendance.getDate(), item.getPerson().getId());
				if(timesheet == null)
				{
					timesheet = new Timesheet();
					timesheet.setEmployee(employee);
					timesheet.setEnd(DateTimes.lastDay(attendance.getDate()));
					timesheet.setStart(DateTimes.firstDay(attendance.getDate()));
					
					timesheetRepo.save(timesheet);
				}
				
				item.setTimesheet(timesheet);
			}
		}
		
		repository.save(attendance);
	}

	@Secured("ROLE_COURSE_ATTENDANCE_UPDATE")
	public void edit(CourseAttendance attendance,Collection<CourseAttendanceItem> items)
	{
		attendance.getItems().clear();
		repository.saveAndFlush(attendance);
		
		for(CourseAttendanceItem item:items)
		{
			Employee employee = employeeRepo.findOneByPartyId(item.getPerson().getId());
			if(employee != null && item.getStatus().equals(AttendanceStatus.IN))
			{			
				Timesheet timesheet = timesheetRepo.findOne(attendance.getDate(), item.getPerson().getId());
				if(timesheet == null)
				{
					timesheet = new Timesheet();
					timesheet.setEmployee(employee);
					timesheet.setEnd(DateTimes.lastDay(attendance.getDate()));
					timesheet.setStart(DateTimes.firstDay(attendance.getDate()));
					
					timesheetRepo.save(timesheet);
				}
				
				item.setTimesheet(timesheet);
			}
		}
		
		attendance.getItems().addAll(items);
		repository.saveAndFlush(attendance);
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
