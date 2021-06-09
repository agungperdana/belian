package com.kratonsolution.belian.access.impl.application;

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
import com.kratonsolution.belian.access.api.RoleData;
import com.kratonsolution.belian.access.api.application.RoleCreateCommand;
import com.kratonsolution.belian.access.api.application.RoleDeleteCommand;
import com.kratonsolution.belian.access.api.application.RoleEvent;
import com.kratonsolution.belian.access.api.application.RoleFilter;
import com.kratonsolution.belian.access.api.application.RoleModuleCommand;
import com.kratonsolution.belian.access.api.application.RoleService;
import com.kratonsolution.belian.access.api.application.RoleUpdateCommand;
import com.kratonsolution.belian.access.impl.model.Module;
import com.kratonsolution.belian.access.impl.model.Role;
import com.kratonsolution.belian.access.impl.model.RoleModule;
import com.kratonsolution.belian.access.impl.repository.ModuleRepository;
import com.kratonsolution.belian.access.impl.repository.RoleRepository;
import com.kratonsolution.belian.common.application.EventType;
import com.kratonsolution.belian.common.application.TaskEvent;

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
public class RoleServiceImpl implements RoleService, ApplicationListener<PayloadApplicationEvent<TaskEvent>> {
    
    @Autowired
    private RoleRepository roleRepo;
    
    @Autowired
    private ModuleRepository moduleRepo;
    
    @Autowired
    private ApplicationEventPublisher publisher;
    
    public RoleData create(RoleCreateCommand command) {
        
        Role role = new Role(command.getCode(), command.getName(), command.getNote(), command.isEnabled());
        
        command.getModules().forEach(m -> {
            
            RoleModule module = new RoleModule(role, m.getModuleCode(), m.getModuleName(), m.getModuleGroup(),
                    m.isRead(), m.isAdd(), m.isEdit(), m.isDelete(), m.isPrint());
            
            role.addRoleModule(module);
        });
        
        roleRepo.save(role);
        
        RoleData data = RoleMapper.INSTANCE.toData(role);
        
        publisher.publishEvent(RoleEvent.newRole(data));
        
        log.info("Creating new Role {}", role);
        
        return data;
    }
    
    public RoleData update(RoleUpdateCommand command) {
        
        Optional<Role> opt = roleRepo.findOneByCode(command.getCode());
        Preconditions.checkState(opt.isPresent(), "Role does not exist");
        
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
    
    public RoleData delete(RoleDeleteCommand command) {
        
        Optional<Role> opt = roleRepo.findOneByCode(command.getCode());
        Preconditions.checkState(opt.isPresent(), "Role does not exist");
        
        roleRepo.delete(opt.get());
        
        log.info("Deleting role {}", opt.get());
        
        RoleData data = RoleMapper.INSTANCE.toData(opt.get());
    
        publisher.publishEvent(RoleEvent.deleteRole(data));
        
        return data;
    }
    
    public RoleData getByCode(String code) {
        
        return RoleMapper.INSTANCE.toData(roleRepo.findOneByCode(code).orElse(null));
    }
    
    public List<RoleData> getAllRoles() {
        
        return RoleMapper.INSTANCE.toRoleDatas(roleRepo.findAll());
    }
    
    public List<RoleData> getAllRoles(int page, int size) {
        
        return RoleMapper.INSTANCE.toRoleDatas(roleRepo.findAll(PageRequest.of(page, size)).getContent());
    }
    
    public List<RoleData> getAllRoles(@NonNull RoleFilter filter, int page, int size) {
        
    	ExampleMatcher matcher = ExampleMatcher.matchingAny();
    	matcher.withMatcher("code", GenericPropertyMatchers.contains().ignoreCase());
    	matcher.withMatcher("name", GenericPropertyMatchers.contains().ignoreCase());
    	
        return RoleMapper.INSTANCE.toRoleDatas(
        		roleRepo.findAll(Example.of(new Role(filter.getKey(), filter.getKey()), matcher), 
        				PageRequest.of(page, size)).getContent());
    }
    
    public int count() {
        
        return (int)roleRepo.count();
    }
    
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
					role.getModules().add(new RoleModule(role, mod.getCode(), mod.getName(), mod.getGroup(), 
							false, false, false, false, false)); 

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
