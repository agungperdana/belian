/**
 * 
 */
package com.kratonsolution.belian.healtcare.svc;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.global.svc.SessionAware;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointmentRepository;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointmentStatus;
import com.kratonsolution.belian.healtcare.dm.MedicalRecordRepository;

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
	private MedicalRecordRepository medicalRecordRepository;
	
	@Autowired
	private ClinicSalesService medicationService;
	
	@Autowired
	private MedicalTreatmentSalesService treatmentService;
	
	@Autowired
	private LaboratorySalesService labService;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_APPOINTMENT_READ")
	public int size()
	{
		if(utils.getOrganizationIds().isEmpty())
			return 0;

		return repository.count(utils.getOrganizationIds()).intValue();
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
		if(utils.getOrganizationIds().isEmpty())
			return new ArrayList<DoctorAppointment>();
		else
			return repository.findAll(new PageRequest(pageIndex, pageSize), utils.getOrganizationIds());
	}
	
	@Secured("ROLE_DOCTOR_APPOINTMENT_CREATE")
	public void add(DoctorAppointment appointment)
	{
		repository.save(appointment);
	}
	
	@Secured("ROLE_DOCTOR_APPOINTMENT_UPDATE")
	public void edit(DoctorAppointment appointment)
	{
		
	}
	
	@Secured("ROLE_DOCTOR_APPOINTMENT_UPDATE")
	public void done(DoctorAppointment appointment)
	{
		SimpleDateFormat format = new SimpleDateFormat("ddMMyy");
		
		StringBuilder build = new StringBuilder();
		build.append(Code.DrApt.toString().toUpperCase());
		build.append("-");
		build.append(format.format(appointment.getDate()));
		build.append("-");
		build.append(appointment.getQueue()+"");
		
		if(appointment.getRecord() != null)
		{
			appointment.getRecord().getMedication().setQueue(appointment.getQueue());
			appointment.getRecord().getMedication().setNumber(build.toString());
			medicationService.add(appointment.getRecord().getMedication());
		}
		if(appointment.getRecord().getTreatment() != null)
		{
			appointment.getRecord().getTreatment().setNumber(build.toString());
			treatmentService.add(appointment.getRecord().getTreatment());
		}
		if(appointment.getRecord().getLaboratory() != null)
		{
			appointment.getRecord().getLaboratory().setNumber(build.toString());
			labService.add(appointment.getRecord().getLaboratory());
		}

		appointment.setStatus(DoctorAppointmentStatus.DONE);
		appointment.getRecord().setAppointment(appointment);

		medicalRecordRepository.save(appointment.getRecord());
		repository.save(appointment);
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
			appointment.setStatus(DoctorAppointmentStatus.PROGRESS);
			edit(appointment);
		}
	}
	
	@Secured("ROLE_DOCTOR_APPOINTMENT_UPDATE")
	public void cancel(String id)
	{
		DoctorAppointment appointment = findOne(id);
		if(appointment != null)
		{
			appointment.setStatus(DoctorAppointmentStatus.CANCELED);
			edit(appointment);
		}
	}
	
	@Secured("ROLE_DOCTOR_APPOINTMENT_UPDATE")
	public void hold(String id)
	{
		DoctorAppointment appointment = findOne(id);
		if(appointment != null)
		{
			appointment.setStatus(DoctorAppointmentStatus.ONHOLD);
			edit(appointment);
		}
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_DOCTOR_APPOINTMENT_READ","ROLE_STOCK_ADMIN_READ"})
	public List<DoctorAppointment> findAllTodayByDoctor(Date date,String companyId,String person)
	{
		return repository.findAllTodayByDoctor(date, companyId, person);
	}
}
