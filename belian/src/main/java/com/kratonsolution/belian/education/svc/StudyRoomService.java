/**
 * 
 */
package com.kratonsolution.belian.education.svc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.education.dm.CourseRegistration;
import com.kratonsolution.belian.education.dm.CourseRegistrationRepository;
import com.kratonsolution.belian.education.dm.CourseSchedule;
import com.kratonsolution.belian.education.dm.StudyRoom;
import com.kratonsolution.belian.education.dm.StudyRoomRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class StudyRoomService
{
	@Autowired
	private StudyRoomRepository repository;
	
	@Autowired
	private CourseRegistrationRepository registrationRepo;
	
	@Autowired
	private SessionUtils utils;
		
	@Secured({"ROLE_STUDY_ROOM_READ","ROLE_SYSTEM_READ"})
	public StudyRoom findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);
	
		return null;
	}
	
	@Secured({"ROLE_STUDY_ROOM_READ","ROLE_SYSTEM_READ"})
	public List<StudyRoom> findAll()
	{
		return repository.findAll();
	}
	
	@Secured({"ROLE_STUDY_ROOM_READ","ROLE_SYSTEM_READ"})
	public List<StudyRoom> findAll(String period)
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();
		
		return repository.findAll(utils.getOrganizationIds(),period);
	}
	
	@Secured({"ROLE_STUDY_ROOM_READ","ROLE_SYSTEM_READ"})
	public List<StudyRoom> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();
		
		return repository.findAll(new PageRequest(pageIndex, pageSize), utils.getOrganizationIds());
	}
	
	@Secured({"ROLE_STUDY_ROOM_READ","ROLE_SYSTEM_READ"})
	public List<StudyRoom> findAll(int pageIndex,int pageSize,String key)
	{
		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, pageSize);
		
		return repository.findAll(new PageRequest(pageIndex, pageSize), utils.getOrganizationIds(),key);
	}
	
	@Secured({"ROLE_STUDY_ROOM_READ"})
	public int getSize()
	{
		if(utils.getOrganizationIds() != null && !utils.getOrganizationIds().isEmpty())
			return repository.count(utils.getOrganizationIds()).intValue();

		return 0;
	}
	
	@Secured({"ROLE_STUDY_ROOM_READ"})
	public int getSize(String key)
	{
		if(Strings.isNullOrEmpty(key))
			return getSize();
		
		return repository.count(utils.getOrganizationIds(), key).intValue();
	}
	
	@Secured("ROLE_STUDY_ROOM_CREATE")
	public void add(StudyRoom room,Collection<CourseRegistration> students)
	{
		repository.save(room);
		
		for(CourseRegistration registration:students)
		{
			registration.setRoom(room);
			registrationRepo.save(registration);
		}
	}
	
	@Secured("ROLE_STUDY_ROOM_UPDATE")
	public void edit(StudyRoom room,Vector<CourseSchedule> schedules)
	{	
		room.getEfforts().clear();
		
		for(CourseRegistration registration:room.getRegistrations())
			registrationRepo.save(registration);
		
		repository.saveAndFlush(room);
	
		room.getEfforts().addAll(schedules);
		
		repository.saveAndFlush(room);
	}
	
	@Secured("ROLE_STUDY_ROOM_DELETE")
	public void delete(String id)
	{
		StudyRoom room = findOne(id);
		if(room != null)
		{
			for(CourseRegistration registration:room.getRegistrations())
			{
				registration.setRoom(null);
				registrationRepo.save(registration);
			}
		}
		
		repository.delete(room);
	}
}
