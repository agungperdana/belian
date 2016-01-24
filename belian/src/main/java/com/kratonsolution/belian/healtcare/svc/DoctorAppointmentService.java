/**
 * 
 */
package com.kratonsolution.belian.healtcare.svc;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.global.svc.SessionAware;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment.Status;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointmentRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DoctorAppointmentService extends SessionAware
{
	@Autowired
	private DoctorAppointmentRepository repository;
	
	@Autowired
	private MedicalRecordService service;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_APPOINTMENT_READ")
	public int size()
	{
		if(utils.getOrganization() != null)
			return repository.count(utils.getOrganization().getId()).intValue();
			
		return 0;
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_APPOINTMENT_READ")
	public int size(Date date,String companyId,String doctorId)
	{
		return repository.findAllTodayByDoctor(date,companyId,doctorId).size();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_APPOINTMENT_READ")
	public DoctorAppointment findOne(String id)
	{
		return repository.findOne(id);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_APPOINTMENT_READ")
	public List<DoctorAppointment> findAll(Date date,String companyId,String doctorId,String customer)
	{
		return repository.findAll(date,companyId,doctorId,customer);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_APPOINTMENT_READ")
	public List<DoctorAppointment> findAll()
	{
		return repository.findAll();
	}
		
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_APPOINTMENT_READ")
	public List<DoctorAppointment> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<DoctorAppointment>();
		else
			return repository.findAll(new PageRequest(pageIndex, pageSize), utils.getOrganization().getId());
	}
	
	@Secured("ROLE_DOCTOR_APPOINTMENT_CREATE")
	public void add(DoctorAppointment appointment)
	{
		repository.save(appointment);
	}
	
	@Secured("ROLE_DOCTOR_APPOINTMENT_UPDATE")
	public void edit(DoctorAppointment appointment)
	{
		repository.saveAndFlush(appointment);
	}
	
	@Secured("ROLE_DOCTOR_APPOINTMENT_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_DOCTOR_APPOINTMENT_UPDATE")
	public void inProgress(String id)
	{
		DoctorAppointment appointment = findOne(id);
		if(appointment != null)
		{
			appointment.setStatus(Status.PROGRESS);
			edit(appointment);
		}
	}
	
	@Secured("ROLE_DOCTOR_APPOINTMENT_UPDATE")
	public void cancel(String id)
	{
		DoctorAppointment appointment = findOne(id);
		if(appointment != null)
		{
			appointment.setStatus(Status.CANCELED);
			edit(appointment);
		}
	}
	
	@Secured("ROLE_DOCTOR_APPOINTMENT_UPDATE")
	public void hold(String id)
	{
		DoctorAppointment appointment = findOne(id);
		if(appointment != null)
		{
			appointment.setStatus(Status.ONHOLD);
			edit(appointment);
		}
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_APPOINTMENT_READ")
	public List<DoctorAppointment> findAllTodayByDoctor(Date date,String companyId,String doctorId)
	{
		return repository.findAllTodayByDoctor(date, companyId, doctorId);
	}
}
