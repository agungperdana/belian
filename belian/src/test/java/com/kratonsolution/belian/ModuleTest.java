package com.kratonsolution.belian;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kratonsolution.belian.security.svc.ModuleService;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=EntryPoint.class)
@WebAppConfiguration
@IntegrationTest
public class ModuleTest
{
	@Autowired
	private ModuleService service;
	
	@Test
	public void updateModule()
	{
//		for(Module module:service.findAll())
//		{
//			Module one = new Module();
//			one.setId(UUID.randomUUID().toString());
//			one.setCode(module.getCode());
//			one.setEnabled(true);
//			one.setName(module.getName());
//			one.setNote(module.getNote());
//			
//			service.delete(module.getId());
//			service.add(one);
//		}
	}
}
