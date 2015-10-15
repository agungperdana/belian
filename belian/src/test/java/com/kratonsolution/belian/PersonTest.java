package com.kratonsolution.belian;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kratonsolution.belian.general.dm.PersonRepository;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=EntryPoint.class)
@WebAppConfiguration
@IntegrationTest
public class PersonTest
{
	@Autowired
	private PersonRepository repository;
	
	@Test
	public void testQuery()
	{
//		for(Person person:repository.findAllByNameNot("Umi"))
//		{
//			System.out.println("####### "+person.getId());
//			System.out.println("####### "+person.getName());
//		}
	}
}
