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
import com.kratonsolution.belian.production.dm.TimeEntry;
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
		repository.save(attendance);
		writeTimesheet(attendance);
	}

	private void writeTimesheet(CourseAttendance attendance)
	{
		for(CourseAttendanceItem attend:attendance.getItems())
		{
			if(attend.getAttendance().getSchedule().getTeacher().getId().equals(attend.getPerson().getId()) && attend.getStatus().equals(AttendanceStatus.IN))
			{
				Timesheet timesheet = timesheetRepo.findOne(attendance.getDate(), attend.getPerson().getId());
				if(timesheet == null)
				{
					Employee employee = employeeRepo.findOneByPartyId(attend.getPerson().getId());
					if(employee == null)
						throw new RuntimeException(attend.getPerson().getName()+" not an employee.");
					
					timesheet = new Timesheet();
					timesheet.setStart(DateTimes.firstDay(attendance.getDate()));
					timesheet.setEnd(DateTimes.lastDay(attendance.getDate()));
					timesheet.setEmployee(employee);
					
					timesheetRepo.save(timesheet);
				}
				
				TimeEntry entry = new TimeEntry();
				entry.setComment("Teaching task");
				entry.setDate(attendance.getDate());
				entry.setStart(attend.getAttendance().getSchedule().getStart());
				entry.setEnd(attend.getAttendance().getSchedule().getEnd());
				entry.setTimesheet(timesheet);
				entry.setHour(DateTimes.toHours(entry.getStart(), entry.getEnd()));
				
				timesheet.getTimeEntrys().add(entry);
				timesheetRepo.saveAndFlush(timesheet);

				attend.setTimeEntry(entry);
			}
		}
		
		repository.saveAndFlush(attendance);
	}

	@Secured("ROLE_COURSE_ATTENDANCE_UPDATE")
	public void edit(CourseAttendance attendance,Collection<CourseAttendanceItem> items)
	{
		for(CourseAttendanceItem item:attendance.getItems())
		{
			if(item.getTimeEntry() != null)
				entryRepo.delete(item.getTimeEntry());
		}
		
		attendance.getItems().clear();
		repository.saveAndFlush(attendance);
		
		attendance.getItems().addAll(items);
		repository.saveAndFlush(attendance);
		
		writeTimesheet(attendance);
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
