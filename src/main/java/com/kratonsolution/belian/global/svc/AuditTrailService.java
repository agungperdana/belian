/**
 * 
 */
package com.kratonsolution.belian.global.svc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.global.dm.AuditTrail;
import com.kratonsolution.belian.global.dm.AuditTrailRepository;
import com.kratonsolution.belian.global.dm.AuditType;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class AuditTrailService
{
	@Autowired
	private AuditTrailRepository repository;
	
	@Autowired
	private SessionUtils utils;
		
	@Secured({"ROLE_AUDIT_TRAIL_READ","ROLE_SYSTEM_READ"})
	public AuditTrail findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);
	
		return null;
	}
	
	@Secured({"ROLE_AUDIT_TRAIL_READ","ROLE_SYSTEM_READ"})
	public List<AuditTrail> findAll()
	{
		return repository.findAll();
	}
	
	@Secured({"ROLE_AUDIT_TRAIL_READ"})
	public int getSize()
	{
		return (int)repository.count();
	}
	
	@Secured("ROLE_AUDIT_TRAIL_CREATE")
	public void add(AuditTrail audit)
	{
		repository.save(audit);
	}
	
	@Secured("ROLE_AUDIT_TRAIL_CREATE")
	public void create(String module,String note)
	{
		AuditTrail audit = new AuditTrail();
		audit.setCompany(utils.getOrganization().getName());
		audit.setDate(new Timestamp(System.currentTimeMillis()));
		audit.setNote(note);
		audit.setService(module);
		audit.setType(AuditType.CREATE);
//		audit.setUser(utils.getUser().getEmail());
		
		add(audit);
	}
	
	@Secured("ROLE_AUDIT_TRAIL_CREATE")
	public void read(String module,String note)
	{
		AuditTrail audit = new AuditTrail();
		audit.setCompany(utils.getOrganization().getName());
		audit.setDate(new Timestamp(System.currentTimeMillis()));
		audit.setNote(note);
		audit.setService(module);
		audit.setType(AuditType.READ);
//		audit.setUser(utils.getUser().getEmail());
		
		add(audit);
	}
	
	@Secured("ROLE_AUDIT_TRAIL_CREATE")
	public void edit(String module,String note)
	{
		AuditTrail audit = new AuditTrail();
		audit.setCompany(utils.getOrganization().getName());
		audit.setDate(new Timestamp(System.currentTimeMillis()));
		audit.setNote(note);
		audit.setService(module);
		audit.setType(AuditType.UPDATE);
//		audit.setUser(utils.getUser().getEmail());
		
		add(audit);
	}
	
	@Secured("ROLE_AUDIT_TRAIL_CREATE")
	public void delete(String module,String note)
	{
		AuditTrail audit = new AuditTrail();
		audit.setCompany(utils.getOrganization().getName());
		audit.setDate(new Timestamp(System.currentTimeMillis()));
		audit.setNote(note);
		audit.setService(module);
		audit.setType(AuditType.DELETE);
//		audit.setUser(utils.getUser().getEmail());
		
		add(audit);
	}
	
	@Secured("ROLE_AUDIT_TRAIL_CREATE")
	public void print(String module,String note)
	{
		AuditTrail audit = new AuditTrail();
		audit.setCompany(utils.getOrganization().getName());
		audit.setDate(new Timestamp(System.currentTimeMillis()));
		audit.setNote(note);
		audit.setService(module);
		audit.setType(AuditType.PRINT);
//		audit.setUser(utils.getUser().getEmail());
		
		add(audit);
	}
	
	@Secured("ROLE_AUDIT_TRAIL_UPDATE")
	public void edit(AuditTrail audit)
	{
		repository.saveAndFlush(audit);
	}
	
	@Secured("ROLE_AUDIT_TRAIL_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_AUDIT_TRAIL_READ")
	public List<AuditTrail> findAll(int pageIndex,int itemsSize)
	{
		return repository.findAll(new PageRequest(pageIndex, itemsSize)).getContent();
	}
}
