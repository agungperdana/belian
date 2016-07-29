/**
 * 
 */
package com.kratonsolution.belian.education.svc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.JournalEntry;
import com.kratonsolution.belian.accounting.svc.AutoJournalCreatorFactory;
import com.kratonsolution.belian.accounting.svc.JournalEntryService;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.education.dm.CourseDiscount;
import com.kratonsolution.belian.education.dm.CourseInstallment;
import com.kratonsolution.belian.education.dm.CourseItem;
import com.kratonsolution.belian.education.dm.CourseRegistration;
import com.kratonsolution.belian.education.dm.CourseRegistrationRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CourseRegistrationService
{
	@Autowired
	private SessionUtils utils;

	@Autowired
	private CourseRegistrationRepository repository;
	
	@Autowired
	private AutoJournalCreatorFactory journalCreatorFactory;

	@Autowired
	private JournalEntryService entryService;
	
	@Secured({"ROLE_COURSE_REGISTRATION_READ","ROLE_SYSTEM_READ"})
	public CourseRegistration findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);

		return null;
	}

	@Secured({"ROLE_COURSE_REGISTRATION_READ","ROLE_SYSTEM_READ"})
	public List<CourseRegistration> findAll()
	{
		return repository.findAll();
	}

	@Secured({"ROLE_COURSE_REGISTRATION_READ","ROLE_SYSTEM_READ"})
	public List<CourseRegistration> findAllNoRoom(String product,String period,String day,String time,String feature)
	{
		if(utils.getOrganizationIds() != null && !utils.getOrganizationIds().isEmpty())
			return repository.findAllWithoutRoom(product,period,day,time,feature,utils.getOrganizationIds());

		return new ArrayList<>();
	}


	@Secured({"ROLE_COURSE_REGISTRATION_READ"})
	public int getSize()
	{
		if(utils.getOrganizationIds() != null && !utils.getOrganizationIds().isEmpty())
			return repository.count(utils.getOrganizationIds()).intValue();

		return 0;
	}

	@Secured({"ROLE_COURSE_REGISTRATION_READ"})
	public int getSize(String key)
	{
		if(Strings.isNullOrEmpty(key))
			return getSize();

		return repository.count(utils.getOrganizationIds(), key).intValue();
	}

	@Secured("ROLE_COURSE_REGISTRATION_CREATE")
	public void add(CourseRegistration reg)
	{
		repository.save(reg);
		
		for(CourseInstallment installment:reg.getInstallments())
		{
			JournalEntry entry = journalCreatorFactory.create(installment);
			if(entry != null)
				entryService.add(entry);
		}
	}

	@Secured("ROLE_COURSE_REGISTRATION_UPDATE")
	public void edit(CourseRegistration reg,Collection<CourseItem> items,Collection<CourseDiscount> discounts,Collection<CourseInstallment> installments)
	{
		reg.getItems().clear();
		reg.getDiscounts().clear();
		reg.getInstallments().clear();

		repository.saveAndFlush(reg);

		reg.getItems().addAll(items);
		reg.getDiscounts().addAll(discounts);
		reg.getInstallments().addAll(installments);

		repository.saveAndFlush(reg);
	}

	@Secured("ROLE_COURSE_REGISTRATION_DELETE")
	public void delete(String id)
	{
		CourseRegistration reg = repository.findOne(id);
		if(reg != null)
		{
			for(CourseInstallment installment:reg.getInstallments())
				if(installment.isPaid())
					throw new RuntimeException("Course already paid or installment,cannot be deleted");

			repository.delete(reg);
		}
	}

	@Secured("ROLE_COURSE_REGISTRATION_READ")
	public List<CourseRegistration> findAll(int pageIndex,int itemsSize)
	{
		if(utils.getOrganizationIds() != null && !utils.getOrganizationIds().isEmpty())
			return repository.findAll(new PageRequest(pageIndex, itemsSize),utils.getOrganizationIds());

		return new ArrayList<>();
	}

	@Secured("ROLE_COURSE_REGISTRATION_READ")
	public List<CourseRegistration> findAll(int pageIndex,int itemsSize,String key)
	{
		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, itemsSize);

		return repository.findAll(new PageRequest(pageIndex, itemsSize), utils.getOrganizationIds(),key);
	}
}
