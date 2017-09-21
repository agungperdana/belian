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
import com.kratonsolution.belian.global.svc.CodeGenerator;
import com.kratonsolution.belian.healtcare.dm.MedicalRecord;
import com.kratonsolution.belian.healtcare.dm.MedicalRecordRepository;
import com.kratonsolution.belian.sales.dm.BillableRepository;

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
	private BillableRepository billingRepository;
	
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
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_MEDICAL_RECORD_READ")
	public List<MedicalRecord> findAllByPatientId(String patientId)
	{
		return repository.findAllByPatientId(patientId);
	}
	
	@Secured("ROLE_MEDICAL_RECORD_CREATE")
	public void add(MedicalRecord record)
	{
		repository.save(record);
	}
	
	@Secured("ROLE_MEDICAL_RECORD_UPDATE")
	public void edit(MedicalRecord record)
	{
		repository.saveAndFlush(record);
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
