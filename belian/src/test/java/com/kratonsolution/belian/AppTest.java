package com.kratonsolution.belian;

import java.util.UUID;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kratonsolution.belian.security.dm.User;
import com.kratonsolution.belian.security.dm.UserRepository;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=EntryPoint.class)
@WebAppConfiguration
@IntegrationTest
public class AppTest
{
	@Autowired
	private UserRepository repository;

	private StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
	
	@Test
	public void addUser()
	{
		User admin = new User();
		admin.setId(UUID.randomUUID().toString());
		admin.setName("Admin");
		admin.setEmail("admin@kratonsolution.com");
		admin.setPassword(encryptor.encryptPassword("admin"));
		
		repository.save(admin);
		
		User power = new User();
		power.setId(UUID.randomUUID().toString());
		power.setName("Power User");
		power.setEmail("power-user@kratonsolution.com");
		power.setPassword(encryptor.encryptPassword("power"));
		
		repository.save(power);
		
		User supervisor = new User();
		supervisor.setId(UUID.randomUUID().toString());
		supervisor.setName("Supervisor");
		supervisor.setEmail("supervisor@kratonsolution.com");
		supervisor.setPassword(encryptor.encryptPassword("supervisor"));
		
		repository.save(supervisor);
	}
}
