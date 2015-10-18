/**
 * 
 */
package com.kratonsolution.belian.hr.svc;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.hr.dm.PayGrade;
import com.kratonsolution.belian.hr.dm.PayGradeRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PayGradeService
{
	@Autowired
	private PayGradeRepository repository;
	
	@Secured("ROLE_PAY_GRADE_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_PAY_GRADE_READ")
	public PayGrade findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_PAY_GRADE_READ")
	public List<PayGrade> findAll()
	{
		return repository.findAll();
	}
		
	@Secured("ROLE_PAY_GRADE_READ")
	public List<PayGrade> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_PAY_GRADE_CREATE")
	public void add(PayGrade grade)
	{
		grade.setId(UUID.randomUUID().toString());
		repository.save(grade);
	}
	
	@Secured("ROLE_PAY_GRADE_UPDATE")
	public void edit(PayGrade grade)
	{
		repository.saveAndFlush(grade);
	}
	
	@Secured("ROLE_PAY_GRADE_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
