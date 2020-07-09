package com.kratonsolution.belian.security.impl.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.kratonsolution.belian.common.application.EventType;
import com.kratonsolution.belian.common.application.TaskEvent;
import com.kratonsolution.belian.security.api.ModuleData;
import com.kratonsolution.belian.security.api.ModuleGroup;
import com.kratonsolution.belian.security.api.application.ModuleCreateCommand;
import com.kratonsolution.belian.security.api.application.ModuleDeleteCommand;
import com.kratonsolution.belian.security.api.application.ModuleFilter;
import com.kratonsolution.belian.security.api.application.ModuleService;
import com.kratonsolution.belian.security.api.application.ModuleUpdateCommand;
import com.kratonsolution.belian.security.impl.model.Module;
import com.kratonsolution.belian.security.impl.repository.ModuleRepository;

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
public class ModuleServiceImpl implements ModuleService {
    
    @Autowired
    private ModuleRepository repo;
    
    @Autowired
    private ApplicationEventPublisher publisher;
        
    @Secured("ROLE_SCR-MDL_ADD")
    public ModuleData create(ModuleCreateCommand command) {

        Module module = new Module(command.getCode(), command.getName(), command.getGroup(), 
                command.getNote(), command.isEnabled());
        
        log.info("Creating new Module {}", module);
        repo.save(module);
        log.info("Creating new Module {}", module);
        
        TaskEvent event = new TaskEvent("MODULE", EventType.ADD);
        event.getPayload().put("id", module.getId());
        
        publisher.publishEvent(event);
        
        return ModuleMapper.INSTANCE.toData(module);
    }
    
    @Override
    @Secured("ROLE_SCR-MDL_UPDATE")
    public ModuleData update(ModuleUpdateCommand command) {

        Optional<Module> opt = repo.findOneByCode(command.getCode());
        Preconditions.checkState(opt.isPresent(), "Module with code [%s] not exist", command.getCode());
        
        opt.get().setName(command.getName());
        opt.get().setGroup(command.getGroup());
        opt.get().setEnabled(command.isEnabled());
        opt.get().setNote(command.getNote());
        
        repo.save(opt.get());
        
        log.info("Updating module {}", opt.get());
        
        return ModuleMapper.INSTANCE.toData(opt.get());
    }
    
    @Secured("ROLE_SCR-MDL_DELETE")
    public ModuleData delete(ModuleDeleteCommand command) {

        Optional<Module> opt = repo.findOneByCode(command.getCode());
        Preconditions.checkState(opt.isPresent(), "Module with code [%s] not exist", command.getCode());
        
        repo.delete(opt.get());
        
        log.info("Deleting module {}", opt.get());
        
        TaskEvent event = new TaskEvent("MODULE", EventType.DELETE);
        event.getPayload().put("code", command.getCode());
        
        publisher.publishEvent(event);
        
        return ModuleMapper.INSTANCE.toData(opt.get());
    }
    
    @Secured("ROLE_SCR-MDL_READ")
    public ModuleData getByCode(String code) {

        return ModuleMapper.INSTANCE.toData(repo.findOneByCode(code).orElse(null));
    }
    
    @Secured("ROLE_SCR-MDL_READ")
    public List<ModuleData> getAllModules() {

        return ModuleMapper.INSTANCE.toDatas(repo.findAll());
    }
    
    @Secured("ROLE_SCR-MDL_READ")
    public List<ModuleData> getAllModules(int page, int size) {

        return ModuleMapper.INSTANCE.toDatas(repo.findAll(PageRequest.of(page, size)).getContent());
    }
    
    @Secured("ROLE_SCR-MDL_READ")
    public List<ModuleData> getAllModules(@NonNull ModuleFilter filter, int page, int size) {

    	ExampleMatcher matcher = ExampleMatcher.matchingAny();
    	matcher.withMatcher("code", GenericPropertyMatchers.contains().ignoreCase());
    	matcher.withMatcher("name", GenericPropertyMatchers.contains().ignoreCase());

    	return ModuleMapper.INSTANCE.toDatas(
    			repo.findAll(
    					Example.of(new Module(filter.getKey(), filter.getKey(), ModuleGroup.SECURITY), matcher), 
    					PageRequest.of(page, size)).getContent());
    }
    
    @Secured("ROLE_SCR-MDL_READ")
    public int count() {

        return (int)repo.count();
    }
    
    @Secured("ROLE_SCR-MDL_READ")
    public int count(@NonNull ModuleFilter filter) {
    	
    	return repo.count(filter.getKey()).intValue();
    }
}
