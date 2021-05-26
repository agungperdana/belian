package com.kratonsolution.belian.access.impl.application;

import java.util.List;
import java.util.Optional;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.kratonsolution.belian.access.api.application.ChangePasswordCommand;
import com.kratonsolution.belian.access.api.application.DeleteUserRoleCommand;
import com.kratonsolution.belian.access.api.application.RegisterNewUserRoleCommand;
import com.kratonsolution.belian.access.api.application.UpdateUserRoleCommand;
import com.kratonsolution.belian.access.api.application.UserCreateCommand;
import com.kratonsolution.belian.access.api.application.UserDeleteCommand;
import com.kratonsolution.belian.access.api.application.UserService;
import com.kratonsolution.belian.access.api.application.UserUpdateCommand;
import com.kratonsolution.belian.access.impl.model.User;
import com.kratonsolution.belian.access.impl.repository.UserRepository;
import com.kratonsolution.belian.access.api.UserData;
import com.kratonsolution.belian.access.api.UserFilter;

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
    
    @Secured({"ROLE_SCR-USR_ADD"})
    public UserData create(@NonNull UserCreateCommand command) {
        
        User user = new User(command.getName(), command.getEmail(),
        						enc.encryptPassword(command.getPassword()), 
        						command.isEnabled());
        repo.save(user);
        
        log.info("Saving new User {}", user);
        
        return UserMapper.INSTANCE.toData(user);
    }
    
    @Secured({"ROLE_SCR-USR_UPDATE"})
    public UserData update(@NonNull UserUpdateCommand command) {
        
        Optional<User> userOpt = repo.findOneByName(command.getName());
        
        Preconditions.checkState(userOpt.isPresent(), "User does not exist.");
        
        userOpt.get().setEnabled(command.isEnabled());
        userOpt.get().setEmail(command.getEmail());
        
        
        repo.save(userOpt.get());
        
        log.info("Updating user {}", userOpt.get());
        
        return UserMapper.INSTANCE.toData(userOpt.get());
    }
    
    @Secured({"ROLE_SCR-USR_DELETE"})
    public UserData delete(@NonNull UserDeleteCommand command) {
        
        Optional<User> userOpt = repo.findOneByName(command.getName());
        
        Preconditions.checkState(userOpt.isPresent(), "User does not exist.");
        
        repo.delete(userOpt.get());
        
        log.info("Deleting user {}", userOpt.get());
        
        return UserMapper.INSTANCE.toData(userOpt.get());
    }
    
    @Secured({"ROLE_SCR-USR_UPDATE"})
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
    
    @Secured({"ROLE_SCR-USR_READ"})
    public List<UserData> getAllUsers() {
        
        return UserMapper.INSTANCE.toDatas(repo.findAll());
    }
    
    @Secured({"ROLE_SCR-USR_READ"})
    public List<UserData> getAllUsers(int page, int size) {
        
        return UserMapper.INSTANCE.toDatas(repo.findAll(PageRequest.of(page, size)).getContent());
    }
    
    @Secured({"ROLE_SCR-USR_READ"})
    public List<UserData> getAllUsers(@NonNull UserFilter filter, int page, int size) {
        
        ExampleMatcher matcher = ExampleMatcher.matchingAny();
        matcher.withMatcher("name", GenericPropertyMatchers.contains().ignoreCase());
        matcher.withMatcher("email", GenericPropertyMatchers.contains().ignoreCase());
        
        return UserMapper.INSTANCE.toDatas(repo.findAll(Example.of(new User(filter.getKey(), filter.getKey(), "", false), matcher), PageRequest.of(page, size)).getContent());
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

    @Secured({"ROLE_SCR-USR_UPDATE"})
	public UserData addNewUserRole(@NonNull RegisterNewUserRoleCommand command) {
		
		Optional<User> opt = repo.findOneByName(command.getUserName());
		Preconditions.checkState(opt.isPresent(), "User with name/email {} does not exist");
		opt.get().addNewRole(command.getRoleCode(), command.getRoleName());

		repo.save(opt.get());
		
		return UserMapper.INSTANCE.toData(opt.get());
	}

    @Secured({"ROLE_SCR-USR_UPDATE"})
	public UserData updateUserRole(@NonNull UpdateUserRoleCommand command) {

		Optional<User> opt = repo.findOneByName(command.getUserName());
		Preconditions.checkState(opt.isPresent(), "User with name/email {} does not exist");
		
		opt.get().updateRole(command.getRoleCode(), command.getRoleName(), command.getEnabled());
		repo.save(opt.get());
		
		return UserMapper.INSTANCE.toData(opt.get());
	}

    @Secured({"ROLE_SCR-USR_UPDATE"})
	public UserData deleteUserRole(@NonNull DeleteUserRoleCommand command) {

		Optional<User> opt = repo.findOneByName(command.getUserName());
		Preconditions.checkState(opt.isPresent(), "User with name/email {} does not exist");
		
		opt.get().deleteRole(command.getRoleCode());
		
		repo.save(opt.get());
		
		return UserMapper.INSTANCE.toData(opt.get());
	}
}
