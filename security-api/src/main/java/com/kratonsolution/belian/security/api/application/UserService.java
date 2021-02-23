package com.kratonsolution.belian.security.api.application;

import java.util.List;

import com.kratonsolution.belian.security.api.UserData;
import com.kratonsolution.belian.security.api.UserFilter;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 1.0
 */
public interface UserService {
    
    public UserData create(@NonNull UserCreateCommand command);
    
    public UserData update(@NonNull UserUpdateCommand command);
    
    public UserData delete(@NonNull UserDeleteCommand command);
    
    public UserData changePassword(@NonNull ChangePasswordCommand command);
    
    public UserData getByName(@NonNull String name);
    
    public UserData getByEmail(@NonNull String email);
    
    public List<UserData> getAllUsers();
    
    public List<UserData> getAllUsers(int page, int size);
    
    public List<UserData> getAllUsers(@NonNull UserFilter filter, int page, int size);
    
    public int count();
    
    public int count(@NonNull UserFilter filter);
    
    public UserData addNewUserRole(@NonNull RegisterNewUserRoleCommand command);
    
    public UserData updateUserRole(@NonNull UpdateUserRoleCommand command);
    
    public UserData deleteUserRole(@NonNull DeleteUserRoleCommand command);
}
