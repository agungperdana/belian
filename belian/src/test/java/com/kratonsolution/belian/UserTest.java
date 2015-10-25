package com.kratonsolution.belian;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kratonsolution.belian.security.dm.UserRepository;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=EntryPoint.class)
@WebAppConfiguration
@IntegrationTest
public class UserTest
{
	@Autowired
	private UserRepository repository;
	
	@Test
	public void cleanData()
	{
//		for(User user:repository.findAll())
//		{
//			Iterator<UserRole> iterator = user.getRoles().iterator();
//			while (iterator.hasNext())
//			{
//				UserRole userRole = (UserRole) iterator.next();
//				if(userRole.getRole() == null)
//					iterator.remove();
//			}
//			
//			repository.save(user);
//		}
	}
}
