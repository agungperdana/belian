
package com.kratonsolution.belian.global.svc;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.security.impl.dm.UserSetting;
import com.kratonsolution.belian.security.impl.dm.UserSettingRepository;
import com.kratonsolution.belian.security.impl.dm.User;
import com.kratonsolution.belian.security.impl.dm.UserRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class UserSettingService
{
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserRepository userRepository;
		
	@Autowired
	private UserSettingRepository settingRepository;
	
	private StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
	
	@Secured("ROLE_SYSTEM_UPDATE")
	public void add(UserSetting setting)
	{
		settingRepository.save(setting);
	}
	
	@Secured("ROLE_SYSTEM_UPDATE")
	public UserSetting getOne(String id)
	{
		return settingRepository.getOne(id);
	}
	
	@Secured({"ROLE_USER_SETTING_UPDATE","ROLE_SYSTEM_UPDATE"})
	public void edit(User user)
	{
		userRepository.saveAndFlush(user);
	}
	
	@Secured({"ROLE_USER_SETTING_UPDATE","ROLE_SYSTEM_UPDATE"})
	public void edit(UserSetting setting)
	{
		settingRepository.saveAndFlush(setting);
	}
}
