package com.kratonsolution.belian;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kratonsolution.belian.security.dm.ModuleRepository;
import com.kratonsolution.belian.security.dm.RoleRepository;
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
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ModuleRepository moduleRepository;
	
	private StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
	
//	@Test
//	public void createSecurityData()
//	{
//		Module module = new Module();
//		module.setId(UUID.randomUUID().toString());
//		module.setCode("ADMIN");
//		module.setName("Administrator");
//		
//		//Default user
//		User admin = new User();
//		admin.setId(UUID.randomUUID().toString());
//		admin.setName("Admin");
//		admin.setEmail("admin@belian.com");
//		admin.setPassword(encryptor.encryptPassword("admin"));
//		
//		repository.save(admin);
//		
//		Role role = new Role();
//		role.setCode("ADMIN");
//		role.setName("Administrator");
//	}
	
	@Test
	public void testRole()
	{
//		for(Role role:roleRepository.findAll())
//		{
//			System.out.println(role.getName());
//			for(AccessRole accessRole:role.getAccesses())
//				System.out.println("module :"+accessRole.getModule());
//		}
	}
}
