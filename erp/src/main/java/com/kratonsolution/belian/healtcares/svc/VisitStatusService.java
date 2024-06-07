
package com.kratonsolution.belian.healtcares.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.common.app.AbstractService;
import com.kratonsolution.belian.healtcares.dm.VisitStatus;
import com.kratonsolution.belian.healtcares.dm.VisitStatusRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class VisitStatusService extends AbstractService
{
	@Autowired
	private VisitStatusRepository repository;
	
	@Secured("ROLE_VISIT_READ")
	public List<VisitStatus> findAllToday(String doctor)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();
		
		if(Strings.isNullOrEmpty(doctor))
			return repository.findAll(DateTimes.currentDate(),utils.getOrganization().getId());
		
		return repository.findAll(DateTimes.currentDate(),utils.getOrganization().getId(),doctor);
	}
}
