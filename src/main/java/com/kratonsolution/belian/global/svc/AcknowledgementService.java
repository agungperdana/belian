
package com.kratonsolution.belian.global.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.global.dm.Acknowledgement;
import com.kratonsolution.belian.global.dm.AcknowledgementRepository;
import com.kratonsolution.belian.global.dm.ApproverStatus;
import com.kratonsolution.belian.tools.view.NotificationService;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class AcknowledgementService extends AbstractService
{
	@Autowired
	private AcknowledgementRepository repository;
	
	@Autowired
	private NotificationService manager;
	
	@Secured("ROLE_ACKNOWLEDGEMENT_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Acknowledgement getOne(String id)
	{
		return repository.getOne(id);
	}
	
	@Secured("ROLE_ACKNOWLEDGEMENT_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Acknowledgement> findAll()
	{
		return repository.findAll(Sort.by(Sort.Direction.ASC,"code"));
	}
	
	@Secured("ROLE_ACKNOWLEDGEMENT_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Acknowledgement> findAll(int pageindex,int itemSize)
	{
		return repository.findAll(PageRequest.of(pageindex, itemSize,Sort.by(Direction.ASC, "code"))).getContent();
	}
	
	@Secured("ROLE_ACKNOWLEDGEMENT_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_ACKNOWLEDGEMENT_CREATE")
	public void add(Acknowledgement acknowledgement)
	{
		repository.save(acknowledgement);
	}
	
	@Secured("ROLE_ACKNOWLEDGEMENT_UPDATE")
	public void edit(Acknowledgement acknowledgement)
	{
		repository.save(acknowledgement);
		
		if(!acknowledgement.getApproverStatus().equals(ApproverStatus.PENDING) || !acknowledgement.getApproverStatus().equals(ApproverStatus.SUBMITTED))
			manager.minus();
	}
	
	@Secured("ROLE_ACKNOWLEDGEMENT_DELETE")
	public void delete(String id)
	{
		repository.deleteById(id);
	}
}
