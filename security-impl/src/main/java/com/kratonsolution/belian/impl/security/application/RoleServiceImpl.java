package com.kratonsolution.belian.impl.security.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.kratonsolution.belian.impl.security.model.Role;
import com.kratonsolution.belian.impl.security.model.RoleModule;
import com.kratonsolution.belian.impl.security.repository.ModuleRepository;
import com.kratonsolution.belian.impl.security.repository.RoleRepository;
import com.kratonsolution.belian.api.security.RoleData;
import com.kratonsolution.belian.api.security.application.RoleCreateCommand;
import com.kratonsolution.belian.api.security.application.RoleDeleteCommand;
import com.kratonsolution.belian.api.security.application.RoleFilter;
import com.kratonsolution.belian.api.security.application.RoleService;
import com.kratonsolution.belian.api.security.application.RoleUpdateCommand;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    private RoleRepository roleRepo;
    
    private ModuleRepository moduleRepo;
        
    @Override
    public RoleData create(RoleCreateCommand command) {
        
        Role role = new Role(command.getCode(), command.getName(), command.getNote(), command.isEnabled());
        
        command.getModules().forEach(m -> {
            
            RoleModule module = new RoleModule(role,
            		moduleRepo.findOneByCode(m.getModule().getCode()).orElse(null), 
                    m.isRead(), m.isAdd(), m.isEdit(), 
                    m.isDelete(), m.isPrint());
            
            role.addModule(module);
        });
        
        roleRepo.save(role);
        log.info("Creating new Role {}", role);
        
        return RoleMapper.INSTANCE.toData(role);
    }
    
    @Override
    public RoleData update(RoleUpdateCommand command) {
        
        Optional<Role> opt = roleRepo.findOneByCode(command.getCode());
        Preconditions.checkState(opt.isPresent(), "Role with code [%s] not exist", command.getCode());
        
        opt.get().setEnabled(command.isEnabled());
        opt.get().setNote(command.getNote());
        
        command.getModules().forEach(m -> {
            
            RoleModule module = new RoleModule(opt.get(), 
            		moduleRepo.findOneByCode(m.getModule().getCode()).orElse(null), 
                    m.isRead(), m.isAdd(), m.isEdit(), 
                    m.isDelete(), m.isPrint());
            
            opt.get().addModule(module);
        });
        
        roleRepo.save(opt.get());
        
        log.info("Updating role {}", opt.get());
        
        return RoleMapper.INSTANCE.toData(opt.get());
    }
    
    @Override
    public RoleData delete(RoleDeleteCommand command) {
        
        Optional<Role> opt = roleRepo.findOneByCode(command.getCode());
        Preconditions.checkState(opt.isPresent(), "Role with code [%s] not exist", command.getCode());
        
        roleRepo.delete(opt.get());
        
        log.info("Deleting role {}", opt.get());
        
        return RoleMapper.INSTANCE.toData(opt.get());
    }
    
    @Override
    public Optional<RoleData> getByCode(String code) {
        
        return Optional.ofNullable(RoleMapper.INSTANCE.toData(roleRepo.findOneByCode(code).orElse(null)));
    }
    
    @Override
    public List<RoleData> getAllRoles() {
        
        return RoleMapper.INSTANCE.toRoleDatas(roleRepo.findAll());
    }
    
    @Override
    public List<RoleData> getAllRoles(int page, int size) {
        
        return RoleMapper.INSTANCE.toRoleDatas(roleRepo.findAll(PageRequest.of(page, size)).getContent());
    }
    
    @Override
    public List<RoleData> getAllRoles(@NonNull RoleFilter filter, int page, int size) {
        
    	ExampleMatcher matcher = ExampleMatcher.matchingAny();
    	matcher.withMatcher("code", GenericPropertyMatchers.contains().ignoreCase());
    	matcher.withMatcher("name", GenericPropertyMatchers.contains().ignoreCase());
    	
        return RoleMapper.INSTANCE.toRoleDatas(
        		roleRepo.findAll(Example.of(new Role(filter.getKey(), filter.getKey()), matcher), 
        				PageRequest.of(page, size)).getContent());
    }
    
    @Override
    public int count() {
        
        return (int)roleRepo.count();
    }
    
    @Override
    public int count(@NonNull RoleFilter filter) {
    	
    	return roleRepo.count("%"+filter.getKey()+"%").intValue();
    }
}
