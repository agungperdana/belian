/**
 * 
 */
package com.kratonsolution.belian.healtcare.svc;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

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
public class DoctorAppointmentService
{
	@Autowired
	private DoctorAppointmentRepository repository;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_APPOINTMENT_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_APPOINTMENT_READ")
	public DoctorAppointment findOne(String id)
	{
		return repository.findOne(id);
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
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_DOCTOR_APPOINTMENT_CREATE")
	public void add(DoctorAppointment type)
	{
		type.setId(UUID.randomUUID().toString());
		repository.save(type);
	}
	
	@Secured("ROLE_DOCTOR_APPOINTMENT_UPDATE")
	public void edit(DoctorAppointment type)
	{
		repository.saveAndFlush(type);
	}
	
	@Secured("ROLE_DOCTOR_APPOINTMENT_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
	
	public void inProgress(String id)
	{
		DoctorAppointment appointment = findOne(id);
		if(appointment != null)
		{
			appointment.setStatus(Status.PROGRESS);
			edit(appointment);
		}
	}
}
