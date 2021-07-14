package com.kratonsolution.belian.access.impl.application;

import java.util.List;
import java.util.Optional;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.kratonsolution.belian.access.api.UserData;
import com.kratonsolution.belian.access.api.UserFilter;
import com.kratonsolution.belian.access.api.application.ChangePasswordCommand;
import com.kratonsolution.belian.access.api.application.DeleteUserRoleCommand;
import com.kratonsolution.belian.access.api.application.RegisterNewUserRoleCommand;
import com.kratonsolution.belian.access.api.application.SignInCommand;
import com.kratonsolution.belian.access.api.application.UpdateUserRoleCommand;
import com.kratonsolution.belian.access.api.application.UserCreateCommand;
import com.kratonsolution.belian.access.api.application.UserDeleteCommand;
import com.kratonsolution.belian.access.api.application.UserService;
import com.kratonsolution.belian.access.api.application.UserUpdateCommand;
import com.kratonsolution.belian.access.impl.model.User;
import com.kratonsolution.belian.access.impl.repository.UserRepository;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository repo;
    
    private StrongPasswordEncryptor enc = new StrongPasswordEncryptor();
    
    public UserData create(@NonNull UserCreateCommand command) {
        
    	if(!command.getPassword().equals(command.getRePassword())) {
    		throw new RuntimeException("Password and Re-Password not equals");
    	}
    	
        User user = new User(command.getName(), command.getEmail(),
        						enc.encryptPassword(command.getPassword()), 
        						command.isEnabled());
        
        command.getRoles().forEach(role->{
        	user.addNewRole(role.getRoleCode(), role.getRoleName(), role.isEnabled());
        });
        
        repo.save(user);
        
        log.info("Saving new User {}", user);
        
        return UserMapper.INSTANCE.toData(user);
    }
    
    public UserData update(@NonNull UserUpdateCommand command) {
        
        Optional<User> userOpt = repo.findOneByEmail(command.getEmail());
        Preconditions.checkState(userOpt.isPresent(), "User does not exist.");
        
        userOpt.get().setName(command.getName());
        userOpt.get().setEnabled(command.isEnabled());
        userOpt.get().setLocked(command.isLocked());
        
        command.getRoles().forEach(role -> {
        	userOpt.get().updateRole(role.getRoleCode(), role.getRoleName(), role.isEnabled());
        });
        
        repo.save(userOpt.get());
        
        log.info("Updating user {}", userOpt.get());
        
        return UserMapper.INSTANCE.toData(userOpt.get());
    }
    
    public UserData delete(@NonNull UserDeleteCommand command) {
        
        Optional<User> userOpt = repo.findOneByEmail(command.getEmail());
        if(userOpt.isEmpty()) {
        	userOpt = repo.findOneByName(command.getEmail());
        }
        
        Preconditions.checkState(userOpt.isPresent(), "User does not exist.");
        
        repo.delete(userOpt.get());
        
        log.info("Deleting user {}", userOpt.get());
        
        return UserMapper.INSTANCE.toData(userOpt.get());
    }
    
    public UserData changePassword(@NonNull ChangePasswordCommand command) {
        
        Optional<User> userOpt = repo.findOneByName(command.getName());
        
        Preconditions.checkState(userOpt.isPresent(), "User does not exist.");
        
        boolean ok = userOpt.get().changePassword(command.getNewPassword(), command.getOldPassword());
        Preconditions.checkState(ok, "Change password failed, wrong password.");
        
        log.debug("User {} changed password", userOpt.get());
        
        return UserMapper.INSTANCE.toData(userOpt.get());
    }
    
    public UserData getByName(@NonNull String name) {
        
        return UserMapper.INSTANCE.toData(repo.findOneByName(name).orElse(null));
    }
    
    public List<UserData> getAllUsers() {
        
        return UserMapper.INSTANCE.toDatas(repo.findAll());
    }
    
    public List<UserData> getAllUsers(int page, int size) {
        
        return UserMapper.INSTANCE.toDatas(repo.findAll(PageRequest.of(page, size)).getContent());
    }
    
    public List<UserData> getAllUsers(@NonNull UserFilter filter, int page, int size) {
        
    	return UserMapper.INSTANCE.toDatas(repo.findAll(filter.getLikeKey(), PageRequest.of(page, size)));
    }
    
    @Override
    public int count() {
        
    	log.info("COUNT {}", Long.valueOf(repo.count()).intValue());
        return Long.valueOf(repo.count()).intValue();
    }
    
    @Override
    public int count(@NonNull UserFilter filter) {
        
        return repo.count("%"+filter.getKey()+"%").intValue();
    }

    public UserData getByEmail(@NonNull String email) {

        return UserMapper.INSTANCE.toData(repo.findOneByEmail(email).orElse(null));
    }

	public UserData addNewUserRole(@NonNull RegisterNewUserRoleCommand command) {
		
		Optional<User> opt = repo.findOneByName(command.getUserName());
		Preconditions.checkState(opt.isPresent(), "User with name/email {} does not exist");
		opt.get().addNewRole(command.getRoleCode(), command.getRoleName());

		repo.save(opt.get());
		
		return UserMapper.INSTANCE.toData(opt.get());
	}

	public UserData updateUserRole(@NonNull UpdateUserRoleCommand command) {

		Optional<User> opt = repo.findOneByName(command.getUserName());
		Preconditions.checkState(opt.isPresent(), "User with name/email {} does not exist");
		
		opt.get().updateRole(command.getRoleCode(), command.getRoleName(), command.getEnabled());
		repo.save(opt.get());
		
		return UserMapper.INSTANCE.toData(opt.get());
	}

	public UserData deleteUserRole(@NonNull DeleteUserRoleCommand command) {

		Optional<User> opt = repo.findOneByName(command.getUserName());
		Preconditions.checkState(opt.isPresent(), "User with name/email {} does not exist");
		
		opt.get().deleteRole(command.getRoleCode());
		
		repo.save(opt.get());
		
		return UserMapper.INSTANCE.toData(opt.get());
	}

	@Override
	public UserData signIn(@NonNull SignInCommand command) {

		Optional<User> opt = repo.findOneByName(command.getUsername());
		if(opt.isEmpty()) {
			opt = repo.findOneByEmail(command.getUsername());
		}
		
		if(opt.isPresent() && enc.checkPassword(command.getPassword(), opt.get().getPassword())) {
			
			return UserMapper.INSTANCE.toData(opt.get());
		}
		
		return null;
	}

	@Override
	public List<UserData> getAllUsers(@NonNull UserFilter filter) {
		
		if(Strings.isNullOrEmpty(filter.getKey())) {
			return getAllUsers(filter.getPage(), filter.getSize());
		}
		
		return UserMapper.INSTANCE.toDatas(repo.findAll(filter.getLikeKey(), PageRequest.of(filter.getPage(), filter.getSize())));
	}
}