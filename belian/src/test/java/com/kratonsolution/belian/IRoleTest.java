package com.kratonsolution.belian;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kratonsolution.belian.inc.dm.IRole;
import com.kratonsolution.belian.inc.dm.IRoleRepository;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=EntryPoint.class)
@WebAppConfiguration
@IntegrationTest
public class IRoleTest
{
	@Autowired
	private IRoleRepository repository;

	@Test
	public void doTest()
	{
//		IRole employee = new IEmployee();
//		employee.setName("Jhon Smitiy");
//		
//		IRole customer = new ICustomer();
//		customer.setName("Jhon customer");
//		
//		ISupplier supplier = new ISupplier();
//		supplier.setName("Jhon Supplier");
//		
//		repository.save(employee);
//		repository.save(customer);
//		repository.save(supplier);
		
		for(IRole iRole:repository.findAll())
			System.out.println(iRole.getClass().getName());
	}
}
