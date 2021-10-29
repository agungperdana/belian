package com.kratonsolution.belian.access.module.impl.application;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.kratonsolution.belian.access.module.api.ModuleData;
import com.kratonsolution.belian.access.module.api.application.ModuleCreateCommand;
import com.kratonsolution.belian.access.module.api.application.ModuleDeleteCommand;
import com.kratonsolution.belian.access.module.api.application.ModuleFilter;
import com.kratonsolution.belian.access.module.api.application.ModuleService;
import com.kratonsolution.belian.access.module.api.application.ModuleUpdateCommand;
import com.kratonsolution.belian.access.module.impl.model.Module;
import com.kratonsolution.belian.access.module.impl.repository.ModuleRepository;
import com.kratonsolution.belian.common.application.EventSourceName;
import com.kratonsolution.belian.common.application.SystemEvent;

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
        
    public ModuleData create(ModuleCreateCommand command) {

        Module module = new Module(command.getCode(), command.getName(), command.getGroup(), 
                command.getNote(), command.isEnabled());
        
        module.setCreatedBy(command.getCreatedBy());
        module.setCreatedDate(LocalDateTime.now());
        module.setOrganization(command.getOrganization());
        
        repo.save(module);
        
        SystemEvent event = new SystemEvent(EventSourceName.ACCESS_MODULE, SystemEvent.ADD);
        event.add(SystemEvent.PAYLOAD_CODE, module.getCode());
        event.add(SystemEvent.PAYLOAD_NAME, module.getName());
        event.add("group", module.getGroup());
        
        publisher.publishEvent(event);

        log.info("Creating new Module {}", module);
        
        return ModuleMapper.INSTANCE.toData(module);
    }
    
    @Override
    public ModuleData update(ModuleUpdateCommand command) {

        Optional<Module> opt = repo.findOneByCode(command.getCode());
        Preconditions.checkState(opt.isPresent(), "Module does not exist");
        
        opt.get().setName(command.getName());
        opt.get().setGroup(command.getGroup());
        opt.get().setEnabled(command.isEnabled());
        opt.get().setNote(command.getNote());
        opt.get().setLastUpdatedBy(command.getLastUpdatedBy());
        opt.get().setLastUpdatedDate(LocalDateTime.now());
        
        repo.save(opt.get());
        
        SystemEvent event = new SystemEvent(EventSourceName.ACCESS_MODULE, SystemEvent.UPDATE);
        event.add(SystemEvent.PAYLOAD_CODE, opt.get().getCode());
        event.add(SystemEvent.PAYLOAD_NAME, opt.get().getName());
        event.add("group", opt.get().getGroup());
        
        log.info("Updating module {}", opt.get());
        
        return ModuleMapper.INSTANCE.toData(opt.get());
    }
    
    public ModuleData delete(ModuleDeleteCommand command) {

        Optional<Module> opt = repo.findOneByCode(command.getCode());
        Preconditions.checkState(opt.isPresent(), "Module does not exist");
        
        repo.delete(opt.get());
        
        log.info("Deleting module {}", opt.get());
        
        SystemEvent event = new SystemEvent(EventSourceName.ACCESS_MODULE, SystemEvent.DELETE);
        event.add(SystemEvent.PAYLOAD_CODE, command.getCode());
        
        publisher.publishEvent(event);
        
        return ModuleMapper.INSTANCE.toData(opt.get());
    }
    
    public ModuleData getByCode(String code) {

        return ModuleMapper.INSTANCE.toData(repo.findOneByCode(code).orElse(null));
    }
    
    public List<ModuleData> getAllModules() {

        return ModuleMapper.INSTANCE.toDatas(repo.findAll());
    }
    
    public List<ModuleData> getAllModules(int page, int size) {

        return ModuleMapper.INSTANCE.toDatas(repo.findAll(PageRequest.of(page, size)).getContent());
    }
    
    public List<ModuleData> getAllModules(@NonNull ModuleFilter filter, int page, int size) {

    	log.info("Searching module data with key %{}", filter.getKey());
    	
    	if(Strings.isNullOrEmpty(filter.getKey())) {
    		return getAllModules(filter.getPage(), filter.getSize());
    	}
    	
    	return ModuleMapper.INSTANCE.toDatas(repo.getAll("%"+filter.getKey(), PageRequest.of(page, size)));
    }
    
    public int count() {

        return (int)repo.count();
    }
    
    public int count(@NonNull ModuleFilter filter) {
    	
    	return repo.count(filter.getKey()).intValue();
    }

	@Override
	public List<ModuleData> getAllModules(@NonNull ModuleFilter filter) {

		return getAllModules(filter, filter.getPage(), filter.getSize());
	}
}
