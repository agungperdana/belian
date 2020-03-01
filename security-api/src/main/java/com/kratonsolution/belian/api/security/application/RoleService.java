package com.kratonsolution.belian.api.security.application;

import java.util.List;
import java.util.Optional;

import com.kratonsolution.belian.api.security.RoleData;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
public interface RoleService {
   
    RoleData create(@NonNull RoleCreateCommand command);
    
    RoleData update(@NonNull RoleUpdateCommand command);
    
    RoleData delete(@NonNull RoleDeleteCommand command);

    Optional<RoleData> getByCode(@NonNull String code);
    
    List<RoleData> getAllRoles();
    
    List<RoleData> getAllRoles(int page, int size);
    
    List<RoleData> getAllRoles(@NonNull RoleFilter filter, int page, int size);
    
    int count();
    
    int count(@NonNull RoleFilter filter);
}
