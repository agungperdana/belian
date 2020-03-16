package com.kratonsolution.belian.security.api.application;

import java.util.List;
import java.util.Optional;

import com.kratonsolution.belian.security.api.UserData;
import com.kratonsolution.belian.security.api.UserFilter;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
public interface UserService {
    
    public Optional<UserData> create(@NonNull CreateUserCommand command);
    
    public Optional<UserData> update(@NonNull UpdateUserCommand command);
    
    public Optional<UserData> delete(@NonNull DeleteUserCommand command);
    
    public Optional<UserData> changePassword(@NonNull ChangePasswordCommand command);
    
    public Optional<UserData> getByName(@NonNull String name);
    
    public Optional<UserData> getByEmail(@NonNull String email);
    
    public List<UserData> getAllUsers();
    
    public List<UserData> getAllUsers(int page, int size);
    
    public List<UserData> getAllUsers(@NonNull UserFilter filter, int page, int size);
    
    public int count();
    
    public int count(@NonNull UserFilter filter);
}
