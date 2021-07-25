package com.kratonsolution.belian.access.api.application;

import java.util.List;

import com.kratonsolution.belian.access.api.RoleData;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0.0
 */
public interface RoleService {
   
    RoleData create(@NonNull RoleCreateCommand command);
    
    RoleData update(@NonNull RoleUpdateCommand command);
    
    RoleData delete(@NonNull RoleDeleteCommand command);

    RoleData getByCode(@NonNull String code);
    
    List<RoleData> getAllRoles();
    
    List<RoleData> getAllRoles(int page, int size);
    
    List<RoleData> getAllRoles(@NonNull RoleFilter filter, int page, int size);
    
    List<RoleData> getAllRoles(@NonNull RoleFilter filter);
    
    int count();
    
    int count(@NonNull RoleFilter filter);
}
