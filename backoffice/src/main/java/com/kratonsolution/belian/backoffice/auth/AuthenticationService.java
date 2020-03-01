package com.kratonsolution.belian.backoffice.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.kratonsolution.belian.api.security.UserData;
import com.kratonsolution.belian.api.security.RoleData;
import com.kratonsolution.belian.api.security.application.RoleService;
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
public class AuthenticationService implements UserDetailsService
{
    @Autowired
    private UserService service;
    
    @Autowired
    private RoleService roleService;
    
    @Override
    public UserDetails loadUserByUsername(@NonNull String name) throws UsernameNotFoundException
    {
        Optional<UserData> userOpt = service.getByName(name);
        
        if(!userOpt.isPresent()) {
            userOpt = service.getByEmail(name);
        }
        
        Preconditions.checkState(userOpt.isPresent(), "User does not exist");
        
        List<Authority> list = new ArrayList<>();
        userOpt.get().getRoles().forEach(role -> {
            
            if(role.isEnabled()) {
                
                Optional<RoleData> rd = roleService.getByCode(role.getRoleCode());
                if(rd.isPresent()) {
                    
                    log.info("role {}", rd.get());
                    log.info("role module {}", rd.get().getModules());
                    
                    rd.get().getModules().forEach(m -> {
                        
                        if(m.isRead()) {
                            list.add(new Authority("ROLE_"+m.getModule().getCode().toUpperCase()));
                        }
                        
                        if(m.isAdd()) {
                            list.add(new Authority("ROLE_"+m.getModule().getCode().toUpperCase()+"_ADD"));
                        }
                        
                        if(m.isEdit()) {
                            list.add(new Authority("ROLE_"+m.getModule().getCode().toUpperCase()+"_EDIT"));
                        }
                        
                        if(m.isDelete()) {
                            list.add(new Authority("ROLE_"+m.getModule().getCode().toUpperCase()+"_DELETE"));
                        }
                        
                        if(m.isPrint()) {
                            list.add(new Authority("ROLE_"+m.getModule().getCode().toUpperCase()+"_PRINT"));
                        }
                    });
                }
            }
        });
        
        return new SecurityInformation(userOpt.get(), list);
    }
}
