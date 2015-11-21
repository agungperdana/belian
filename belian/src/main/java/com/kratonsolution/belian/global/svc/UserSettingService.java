/**
 * 
 */
package com.kratonsolution.belian.global.svc;

import java.util.UUID;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.global.dm.UserSetting;
import com.kratonsolution.belian.security.dm.User;
import com.kratonsolution.belian.security.dm.UserRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class UserSettingService
{
	@Autowired
	private UserRepository userRepository;
		
	private StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
		
	@Secured("ROLE_USER_SETTING_READ")
	public User findOne(String id)
	{
		User user = userRepository.findOne(id);
		if(user != null && user.getSetting() == null)
		{
			UserSetting setting = new UserSetting();
			setting.setId(UUID.randomUUID().toString());
			setting.setLanguage("en_US");
			
			user.setSetting(setting);
			
			userRepository.save(user);
		}
		
		return user;
	}
	
	@Secured("ROLE_USER_SETTING_UPDATE")
	public void edit(User user)
	{
		userRepository.save(user);
	}
}
