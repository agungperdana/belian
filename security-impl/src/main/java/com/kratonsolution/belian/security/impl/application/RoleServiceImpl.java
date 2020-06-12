package com.kratonsolution.belian.security.impl.application;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.kratonsolution.belian.common.application.EventType;
import com.kratonsolution.belian.common.application.TaskEvent;
import com.kratonsolution.belian.security.api.RoleData;
import com.kratonsolution.belian.security.api.application.RoleCreateCommand;
import com.kratonsolution.belian.security.api.application.RoleDeleteCommand;
import com.kratonsolution.belian.security.api.application.RoleEvent;
import com.kratonsolution.belian.security.api.application.RoleFilter;
import com.kratonsolution.belian.security.api.application.RoleService;
import com.kratonsolution.belian.security.api.application.RoleUpdateCommand;
import com.kratonsolution.belian.security.api.application.RoleModuleCommand;
import com.kratonsolution.belian.security.impl.model.Module;
import com.kratonsolution.belian.security.impl.model.Role;
import com.kratonsolution.belian.security.impl.model.RoleModule;
import com.kratonsolution.belian.security.impl.repository.ModuleRepository;
import com.kratonsolution.belian.security.impl.repository.RoleRepository;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService, ApplicationListener<PayloadApplicationEvent<TaskEvent>> {
    
    @Autowired
    private RoleRepository roleRepo;
    
    @Autowired
    private ModuleRepository moduleRepo;
    
    @Autowired
    private ApplicationEventPublisher publisher;
    
    @Override
    public RoleData create(RoleCreateCommand command) {
        
        Role role = new Role(command.getCode(), command.getName(), command.getNote(), command.isEnabled());
        
        command.getModules().forEach(m -> {
            
            RoleModule module = new RoleModule(role, m.getModuleCode(), m.getModuleName(), 
                    m.isRead(), m.isAdd(), m.isEdit(), 
                    m.isDelete(), m.isPrint());
            
            role.addModule(module);
        });
        
        roleRepo.save(role);
        
        RoleData data = RoleMapper.INSTANCE.toData(role);
        
        publisher.publishEvent(RoleEvent.newRole(data));
        
        log.info("Creating new Role {}", role);
        
        return data;
    }
    
    @Override
    public RoleData update(RoleUpdateCommand command) {
        
        Optional<Role> opt = roleRepo.findOneByCode(command.getCode());
        Preconditions.checkState(opt.isPresent(), "Role with code [%s] not exist", command.getCode());
        
        opt.get().setEnabled(command.isEnabled());
        opt.get().setNote(command.getNote());
        
        if(Strings.isNotBlank(command.getName())) {
        	opt.get().setName(command.getName());
        }
        
        opt.get().getModules().forEach(mod -> {
        	
        	Optional<RoleModuleCommand> cmd = command.getModules().stream()
        			.filter(p->p.getModuleCode().equals(mod.getModuleCode()))
        			.findFirst();
        	
        	if(cmd.isPresent()) {
        		
        		mod.setAdd(cmd.get().isAdd());
        		mod.setDelete(cmd.get().isDelete());
        		mod.setEdit(cmd.get().isEdit());
        		mod.setPrint(cmd.get().isPrint());
        		mod.setRead(cmd.get().isRead());
        	}
        });
        
        roleRepo.save(opt.get());

        log.info("Updating role {}", opt.get());
        
        RoleData data = RoleMapper.INSTANCE.toData(opt.get());
        
        if(Strings.isNotBlank(command.getName())) {
            publisher.publishEvent(RoleEvent.updateRole(data));
        }
        
        return data;
    }
    
    @Override
    public RoleData delete(RoleDeleteCommand command) {
        
        Optional<Role> opt = roleRepo.findOneByCode(command.getCode());
        Preconditions.checkState(opt.isPresent(), "Role with code [%s] not exist", command.getCode());
        
        roleRepo.delete(opt.get());
        
        log.info("Deleting role {}", opt.get());
        
        RoleData data = RoleMapper.INSTANCE.toData(opt.get());
    
        publisher.publishEvent(RoleEvent.deleteRole(data));
        
        return data;
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

	@Transactional
	public void onApplicationEvent(PayloadApplicationEvent<TaskEvent> event) {

		TaskEvent model = event.getPayload();
		if(model.getPayload().containsKey("id")) {
			
			if(model.getType().equals(EventType.ADD)) {
				
				roleRepo.findAll().forEach(role -> {
					
					Module mod = moduleRepo.getOne(model.getPayload().get("id").toString());
					role.getModules().add(new RoleModule(role, mod.getCode(), mod.getName(), false, false, false, false, false)); 

					roleRepo.save(role);
				});
			}
			else {
				
				roleRepo.findAll().forEach(role -> {
					
					role.getModules().removeIf(mod -> mod.getModuleCode().equals(model.getPayload().get("id")));
					roleRepo.save(role);
				});
			}
		}
	}
}
