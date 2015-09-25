package com.kratonsolution.belian;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kratonsolution.belian.general.dm.PartyRoleRepository;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=EntryPoint.class)
@WebAppConfiguration
@IntegrationTest
public class PartyRoleTypeTest
{
	@Autowired
	private PartyRoleRepository repository;
	
	@Test
	public void initData()
	{
//		PartyRole employee = new Employee();
//		PartyRole holding = new Holding();
//		PartyRole subsidiary = new Subsidiary();
//		PartyRole customer = new Customer();
//		PartyRole supplier = new Supplier();
//		PartyRole employer = new Employer();
//		
//		repository.save(employee);
//		repository.save(holding);
//		repository.save(subsidiary);
//		repository.save(customer);
//		repository.save(supplier);
//		repository.save(employer);
	}
}
