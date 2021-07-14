package com.kratonsolution.belian.backoffice.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.kratonsolution.belian.access.api.RoleData;
import com.kratonsolution.belian.access.api.UserData;
import com.kratonsolution.belian.access.api.application.RoleService;
import com.kratonsolution.belian.access.api.application.UserService;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Slf4j
@Service
public class AuthenticationService implements UserDetailsService
{
    @Autowired
    private UserService service;
    
    @Autowired
    private RoleService roleService;
    
    @Override
    public UserDetails loadUserByUsername(@NonNull String name) throws UsernameNotFoundException
    {
    	UserData userOpt = service.getByName(name);
        
        if(userOpt == null) {
            userOpt = service.getByEmail(name);
        }
        
        Preconditions.checkState(userOpt != null, "User does not exist");
        
        List<Authority> list = new ArrayList<>();
        userOpt.getRoles().forEach(role -> {
            
            if(role.isEnabled()) {
                
            	RoleData rd = roleService.getByCode(role.getRoleCode());
                if(rd != null) {
                    
                    log.info("role {}", rd);
                    log.info("role module {}", rd.getModules());
                    
                    rd.getModules().forEach(m -> {
                        
                        if(m.isRead()) {
                            list.add(new Authority("ROLE_"+m.getModuleCode().toUpperCase()+"_READ"));
                        }
                        
                        if(m.isAdd()) {
                            list.add(new Authority("ROLE_"+m.getModuleCode().toUpperCase()+"_ADD"));
                        }
                        
                        if(m.isEdit()) {
                            list.add(new Authority("ROLE_"+m.getModuleCode().toUpperCase()+"_UPDATE"));
                        }
                        
                        if(m.isDelete()) {
                            list.add(new Authority("ROLE_"+m.getModuleCode().toUpperCase()+"_DELETE"));
                        }
                        
                        if(m.isPrint()) {
                            list.add(new Authority("ROLE_"+m.getModuleCode().toUpperCase()+"_PRINT"));
                        }
                    });
                }
            }
        });
        
        log.info("Authorized for {}", list);
        
        return new SecurityInformation(userOpt, list);
    }
}
