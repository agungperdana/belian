/**
 * 
 */
package com.kratonsolution.belian.healtcare.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.global.dm.SequenceNumber;
import com.kratonsolution.belian.global.svc.CodeGenerator;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointmentBilling;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointmentBillingItem;
import com.kratonsolution.belian.healtcare.dm.Laboratory;
import com.kratonsolution.belian.healtcare.dm.MedicalRecord;
import com.kratonsolution.belian.healtcare.dm.MedicalRecordRepository;
import com.kratonsolution.belian.healtcare.dm.Medication;
import com.kratonsolution.belian.healtcare.dm.Treatment;
import com.kratonsolution.belian.sales.dm.BillingRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MedicalRecordService
{
	@Autowired
	private MedicalRecordRepository repository;
	
	@Autowired
	private BillingRepository billingRepository;
	
	@Autowired
	private CodeGenerator generator;
	
	@Autowired
	private SessionUtils utils;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_MEDICAL_RECORD_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_MEDICAL_RECORD_READ")
	public MedicalRecord findOne(String id)
	{
		return repository.findOne(id);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_MEDICAL_RECORD_READ")
	public List<MedicalRecord> findAll()
	{
		return repository.findAll();
	}
		
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_MEDICAL_RECORD_READ")
	public List<MedicalRecord> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_MEDICAL_RECORD_CREATE")
	public void add(MedicalRecord type)
	{
		repository.save(type);
	}
	
	@Secured("ROLE_MEDICAL_RECORD_UPDATE")
	public void edit(MedicalRecord type)
	{
		repository.saveAndFlush(type);
	}

	@Secured("ROLE_MEDICAL_RECORD_UPDATE")
	public void createBilling(DoctorAppointment appointment)
	{
		MedicalRecord record = repository.findOneByAppointmentId(appointment.getId());
		if(record != null)
		{
			DoctorAppointmentBilling appointmentBilling = new DoctorAppointmentBilling();
			appointmentBilling.setNumber(generator.generate(appointment.getDate(), appointment.getCompany(),SequenceNumber.Code.BLDP));
			appointmentBilling.setAppointment(appointment);
			appointmentBilling.setCurrency(utils.getCurrency());
			appointmentBilling.setCustomer(appointment.getPatient().getPerson());
			appointmentBilling.setDate(appointment.getDate());
			appointmentBilling.setOrganization(utils.getOrganization());
			appointmentBilling.setSales(appointment.getDoctor().getPerson());
			
			for(Medication medication:record.getMedications())
			{
				if(!medication.isBilled())
				{
					DoctorAppointmentBillingItem item = new DoctorAppointmentBillingItem();
					item.setBilling(appointmentBilling);
					item.setNote(medication.getDescription());
					item.setQuantity(medication.getQuantity());
					item.setResource(medication.getMedicine().getName());
					item.setCategory(Medication.class.getSimpleName());
					
					appointmentBilling.getItems().add(item);
					
					medication.setBilled(true);
				}
			}
			
			for(Treatment treatment:record.getTreatments())
			{
				if(!treatment.isBilled())
				{
					DoctorAppointmentBillingItem item = new DoctorAppointmentBillingItem();
					item.setBilling(appointmentBilling);
					item.setNote(treatment.getDescription());
					item.setQuantity(treatment.getQuantity());
					item.setResource(treatment.getService().getName());
					item.setCategory(Treatment.class.getSimpleName());
					
					appointmentBilling.getItems().add(item);
					
					treatment.setBilled(true);
				}
			}
			
			for(Laboratory lab:record.getLaboratorys())
			{
				if(!lab.isBilled())
				{
					DoctorAppointmentBillingItem item = new DoctorAppointmentBillingItem();
					item.setBilling(appointmentBilling);
					item.setNote(lab.getDescription());
					item.setQuantity(lab.getQuantity());
					item.setResource(lab.getService().getName());
					item.setCategory(Laboratory.class.getSimpleName());
					
					appointmentBilling.getItems().add(item);
					
					lab.setBilled(true);
				}
			}
			
			billingRepository.save(appointmentBilling);
			repository.save(record);
		}
	}
	
	@Secured("ROLE_MEDICAL_RECORD_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_MEDICAL_RECORD_READ")
	public MedicalRecord findOneByAppointmentId(String appointmentId)
	{
		return repository.findOneByAppointmentId(appointmentId);
	}
}
