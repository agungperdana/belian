package com.kratonsolution.belian.user.impl.application;

import com.kratonsolution.belian.user.api.*;
import com.kratonsolution.belian.user.impl.orm.User;
import com.kratonsolution.belian.user.impl.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
@AllArgsConstructor
public class UserServiceImpl implements UserService
{
	private UserMapper userMapper;

	private UserRepository repository;
		
	public UserData getOne(String id)
	{
		return userMapper.toUserData(repository.findByEmail(id));
	}
	
	public List<UserData> findAll()
	{
		return userMapper.toUserDataList(repository.findAll());
	}
	
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	public List<UserData> findAll(int offset,int limit)
	{
		return userMapper.toUserDataList(repository.findAll(PageRequest.of(offset, limit)).getContent());
	}
	
	public void add(@NonNull UserCreateCommand command)
	{
		User user = null;
		StrongPasswordEncryptor encryptor = null;

		try {

			encryptor = new StrongPasswordEncryptor();

			user = userMapper.fromCreate(command);
			user.setPassword(encryptor.encryptPassword(user.getPassword()));

			repository.save(user);
		}
		finally {

			// lets explisitly dereference unused object
			encryptor = null;
			user = null;
		}
	}
	
	public void edit(UserUpdateCommand command)
	{
		User user = null;

		try {
			user = repository.findByEmail(command.getEmail());
			if(user != null) {

				user.setUserName(command.getUserName());
				user.setEnabled(command.isEnabled());
				user.setDeleteable(command.isDeletable());

				repository.save(user);
			}
		}
		finally {
			user = null;
		}
	}
	
	public void delete(@NonNull UserDeleteCommand command)
	{
		User user = null;
		try {

			user = repository.findByEmail(command.getEmail());
			if(user != null) {
				repository.delete(user);
			}
		}
		finally {
			user = null;
		}
	}
	
	public void changePassword(@NonNull ChangePasswordCommand command)
	{
		User user = null;
		StrongPasswordEncryptor encryptor = null;

		try {

			user = repository.findByEmail(command.getEmail());
			if(user != null)
			{
				encryptor = new StrongPasswordEncryptor();

				if(!encryptor.checkPassword(command.getOldPassword(), user.getPassword()))
					throw new RuntimeException("Wrong password");

				if(encryptor.checkPassword(command.getNewPassword(), user.getPassword()))
					throw new RuntimeException("New password cannot be same as old password");

				if(!command.getNewPassword().equals(command.getReNewPassword()))
					throw new RuntimeException("New Password not equals");

				user.setPassword(encryptor.encryptPassword(command.getNewPassword()));

				repository.save(user);
			}
		}
		finally {
			encryptor = null;
			user = null;
		}
	}
}