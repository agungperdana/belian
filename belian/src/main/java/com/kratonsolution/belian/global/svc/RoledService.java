/**
 * 
 */
package com.kratonsolution.belian.global.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.global.dm.ApproveAndReviewableRepository;
import com.kratonsolution.belian.global.dm.Review;
import com.kratonsolution.belian.global.dm.ReviewRepository;
import com.kratonsolution.belian.global.dm.Roled;
import com.kratonsolution.belian.global.dm.RoledRepository;
import com.kratonsolution.belian.global.dm.RoledType;
import com.kratonsolution.belian.global.dm.StatusType;
import com.kratonsolution.belian.global.dm.Statuses;
import com.kratonsolution.belian.global.dm.StatusesRepository;
import com.kratonsolution.belian.ui.util.Dates;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class RoledService
{	
	@Autowired
	private RoledRepository repository;
	
	@Autowired
	private StatusesRepository statusesRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private ApproveAndReviewableRepository appAndRevRepository;
	
	@Autowired
	private SessionUtils utils;

	@Secured("ROLE_ROLED_READ")
	public Roled findOne(String id)
	{
		return repository.findOne(id);
	}

	@Secured("ROLE_ROLED_READ")
	public List<Roled> findAll()
	{
		return repository.findAll();
	}
	
	@Secured({"ROLE_ROLED_READ","ROLE_SYSTEM_READ"})
	public List<Roled> allNewApproveable()
	{
		if(!utils.isSysAdmin())
			return repository.findActiveApprover(utils.getUser().getPerson().getId());
		
		return new ArrayList<>();
	}
	
	@Secured({"ROLE_ROLED_READ","ROLE_SYSTEM_READ"})
	public List<Roled> allNewReviewable()
	{
		if(!utils.isSysAdmin())
			return repository.findActiveReview(utils.getUser().getPerson().getId());
	
		return new ArrayList<>();
	}

	@Secured({"ROLE_ROLED_READ","ROLE_SYSTEM_READ"})
	public List<Roled> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}

	@Secured({"ROLE_ROLED_READ","ROLE_SYSTEM_READ"})
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}

	@Secured("ROLE_ROLED_CREATE")
	public void add(Roled roled)
	{
		repository.save(roled);
	}

	@Secured("ROLE_ROLED_UPDATE")
	public void edit(Roled roled)
	{
		repository.saveAndFlush(roled);
	}
	
	@Secured("ROLE_ROLED_UPDATE")
	public void done(Roled roled,StatusType type,String note)
	{
		for(Roled role:roled.getDocument().getRoles())
		{
			if(role.getId().equals(roled.getId()))
			{
				role.setDone(true);
				
				if(role.getType().equals(RoledType.Approver))
				{
					Statuses statuses = role.getDocument().createStatus();
					statuses.setDate(Dates.now());
					statuses.setType(type);
					statuses.setParty(role.getParty());
					statuses.setDescription(note);
					
					roled.getDocument().setLastStatus(statuses);
					
					appAndRevRepository.save(role.getDocument());
				}
				else
				{
					if(!role.getDocument().isDone())
					{
						Statuses statuses = role.getDocument().createStatus();
						statuses.setDate(Dates.now());
						statuses.setType(type);
						statuses.setParty(role.getParty());
						statuses.setDescription(note);
						
						Review review = role.getDocument().createReview();
						review.setDate(Dates.now());
						review.setParty(role.getParty());
						review.setResult(note);
						
						role.getDocument().setLastStatus(statuses);
						
						appAndRevRepository.save(role.getDocument());
					}
				}
				
				break;
			}
		}
	}

	@Secured("ROLE_ROLED_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
