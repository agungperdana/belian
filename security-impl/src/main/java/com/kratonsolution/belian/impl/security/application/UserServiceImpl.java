package com.kratonsolution.belian.impl.security.application;

import java.util.List;
import java.util.Optional;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.kratonsolution.belian.impl.security.model.User;
import com.kratonsolution.belian.impl.security.repository.UserRepository;
import com.kratonsolution.belian.api.security.UserData;
import com.kratonsolution.belian.api.security.UserFilter;
import com.kratonsolution.belian.api.security.application.ChangePasswordCommand;
import com.kratonsolution.belian.api.security.application.CreateUserCommand;
import com.kratonsolution.belian.api.security.application.DeleteUserCommand;
import com.kratonsolution.belian.api.security.application.UpdateUserCommand;
import com.kratonsolution.belian.api.security.application.UserService;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository repo;
    
    private StrongPasswordEncryptor enc = new StrongPasswordEncryptor();
    
    @Override
    public Optional<UserData> create(@NonNull CreateUserCommand command) {
        
        User user = new User(command.getName(), command.getEmail(),
        						enc.encryptPassword(command.getPassword()), 
        						command.isEnabled());
        repo.save(user);
        
        log.info("Saving new User {}", user);
        
        return Optional.ofNullable(UserMapper.INSTANCE.toData(user));
    }
    
    @Override
    public Optional<UserData> update(@NonNull UpdateUserCommand command) {
        
        Optional<User> userOpt = repo.findOneByName(command.getName());
        
        Preconditions.checkState(userOpt.isPresent(), "User does not exist.");
        
        userOpt.get().setEnabled(command.isEnabled());
        
        repo.save(userOpt.get());
        
        log.info("Updating user {}", userOpt.get());
        
        return Optional.ofNullable(UserMapper.INSTANCE.toData(userOpt.get()));
    }
    
    @Override
    public Optional<UserData> delete(@NonNull DeleteUserCommand command) {
        
        Optional<User> userOpt = repo.findOneByName(command.getName());
        
        Preconditions.checkState(userOpt.isPresent(), "User does not exist.");
        
        repo.delete(userOpt.get());
        
        log.info("Deleting user {}", userOpt.get());
        
        return Optional.ofNullable(UserMapper.INSTANCE.toData(userOpt.get()));
    }
    
    @Override
    public Optional<UserData> changePassword(@NonNull ChangePasswordCommand command) {
        
        Optional<User> userOpt = repo.findOneByName(command.getName());
        
        Preconditions.checkState(userOpt.isPresent(), "User does not exist.");
        
        userOpt.get().changePassword(command.getNewPassword(), command.getOldPassword());

        log.debug("User {} changed password", userOpt.get());
        
        return Optional.ofNullable(UserMapper.INSTANCE.toData(userOpt.get()));
    }
    
    @Override
    public Optional<UserData> getByName(@NonNull String name) {
        
        return Optional.ofNullable(UserMapper.INSTANCE.toData(repo.findOneByName(name).orElse(null)));
    }
    
    @Override
    public List<UserData> getAllUsers() {
        
        return UserMapper.INSTANCE.toDatas(repo.findAll());
    }
    
    @Override
    public List<UserData> getAllUsers(int page, int size) {
        
        return UserMapper.INSTANCE.toDatas(repo.findAll(PageRequest.of(page, size)).getContent());
    }
    
    @Override
    public List<UserData> getAllUsers(@NonNull UserFilter filter, int page, int size) {
        
        ExampleMatcher matcher = ExampleMatcher.matchingAny();
        matcher.withMatcher("name", GenericPropertyMatchers.contains().ignoreCase());
        matcher.withMatcher("email", GenericPropertyMatchers.contains().ignoreCase());
        
        return UserMapper.INSTANCE.toDatas(repo.findAll(Example.of(new User(filter.getKey(), filter.getKey(), "", false), matcher), PageRequest.of(page, size)).getContent());
    }
    
    @Override
    public int count() {
        
        return (int)repo.count();
    }
    
    @Override
    public int count(@NonNull UserFilter filter) {
        
        return repo.count("%"+filter.getKey()+"%").intValue();
    }

    @Override
    public Optional<UserData> getByEmail(@NonNull String email) {

        return Optional.ofNullable(UserMapper.INSTANCE.toData(repo.findOneByEmail(email).orElse(null)));
    }
}
