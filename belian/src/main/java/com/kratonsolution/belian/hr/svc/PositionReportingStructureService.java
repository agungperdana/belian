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

import com.kratonsolution.belian.hr.dm.PositionReportingStructure;
import com.kratonsolution.belian.hr.dm.PositionReportingStructureRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PositionReportingStructureService
{
	@Autowired
	private PositionReportingStructureRepository repository;
	
	@Secured("ROLE_POSITION_REPORTING_STRUCTURE_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_POSITION_REPORTING_STRUCTURE_READ")
	public PositionReportingStructure findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_POSITION_REPORTING_STRUCTURE_READ")
	public List<PositionReportingStructure> findAll()
	{
		return repository.findAll();
	}
		
	@Secured("ROLE_POSITION_REPORTING_STRUCTURE_READ")
	public List<PositionReportingStructure> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_POSITION_REPORTING_STRUCTURE_CREATE")
	public void add(PositionReportingStructure report)
	{
		report.setId(UUID.randomUUID().toString());
		repository.save(report);
	}
	
	@Secured("ROLE_POSITION_REPORTING_STRUCTURE_UPDATE")
	public void edit(PositionReportingStructure report)
	{
		repository.saveAndFlush(report);
	}
	
	@Secured("ROLE_POSITION_REPORTING_STRUCTURE_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
