/**
 * 
 */
package com.kratonsolution.belian.sales.srv;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.accounting.svc.AutoJournalCreatorFactory;
import com.kratonsolution.belian.accounting.svc.JournalEntryService;
import com.kratonsolution.belian.asset.dm.Asset;
import com.kratonsolution.belian.asset.dm.AssetRepository;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.global.svc.AuditTrailService;
import com.kratonsolution.belian.partys.dm.Person;
import com.kratonsolution.belian.sales.dm.CashierShift;
import com.kratonsolution.belian.sales.dm.CashierShiftRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CashierShiftService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private CashierShiftRepository repository;
	
	@Autowired
	private AssetRepository assetRepo;
	
	@Autowired
	private AuditTrailService audit;
	
	@Autowired
	private AutoJournalCreatorFactory journalFactory;
	
	@Autowired
	private JournalEntryService journalService;
	
	@Secured("ROLE_CASHIER_READ")
	public int size()
	{
		return (int)repository.count();
	}
	
	@Secured("ROLE_CASHIER_READ")
	public CashierShift findToday()
	{
		if(utils.isEmployee())
			return repository.findOne(DateTimes.currentDate(), utils.getEmployee().getId());
		
		return null;
	}
	
	@Secured("ROLE_CASHIER_READ")
	public CashierShift findToday(Date date,Person employee)
	{
		if(date != null && employee != null)
			return repository.findOne(date, employee.getId());
		
		return null;
	}
	
	@Secured("ROLE_CASHIER_READ")
	public CashierShift findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_CASHIER_READ")
	public List<CashierShift> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_CASHIER_READ")
	public List<CashierShift> findAllPendingBefore(Date date,String employee)
	{
		return repository.findAllPendingBefore(date!=null?date:DateTimes.currentDate(), employee);
	}
	
	@Secured("ROLE_CASHIER_CREATE")
	public void add(CashierShift shift)
	{
		if(findToday(shift.getDate(),shift.getEmployee()) != null)
			throw new RuntimeException("Shift already created and active.");
		
		repository.save(shift);
		audit.create("Cashier Shift", "Open new shift for cashier on "+shift.getMachine().getName());
	}
	
	@Secured("ROLE_CASHIER_CREATE")
	public void open(CashierShift shift)
	{
		add(shift);
		
		Asset asset = assetRepo.findOne(shift.getMachine().getId());
		if(asset != null)
		{
			asset.setUsedBy(shift);
			assetRepo.save(asset);
		}
	}
	
	@Secured("ROLE_CASHIER_UPDATE")
	public String close()
	{
		return close(findToday());
	}
	
	@Secured("ROLE_CASHIER_UPDATE")
	public String close(CashierShift shift)
	{
		if(shift != null)
		{
			shift.setClosed(true);
			shift.setEnd(DateTimes.currentTime());
			repository.save(shift);
			
			Asset asset = assetRepo.findOne(shift.getMachine().getId());
			if(asset != null)
			{
				asset.setUsedBy(null);
				assetRepo.save(asset);
			}

			journalService.silence(journalFactory.create(shift));
			
			audit.create("Cashier Shift", "Closed shift session for cashier on "+shift.getMachine().getName());
		}
		
		return shift.getId();
	}
	
	@Secured("ROLE_CASHIER_UPDATE")
	public void edit(CashierShift shift)
	{
		repository.saveAndFlush(shift);
	}
	
	@Secured("ROLE_CASHIER_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
