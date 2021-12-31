package com.kratonsolution.belian.access.module.impl.application;

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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class ModuleServiceImpl implements ModuleService {
    
    @Autowired
    private ModuleRepository repo;
    
    @Autowired
    private ApplicationEventPublisher publisher;
        
    public Mono<ModuleData> create(ModuleCreateCommand command) {

        Module module = new Module(command.getCode(), command.getName(), command.getGroup(), 
                command.getNote(), command.isEnabled());

        repo.save(module);
        
        SystemEvent event = new SystemEvent(EventSourceName.ACCESS_MODULE, SystemEvent.ADD);
        event.add(SystemEvent.PAYLOAD_CODE, module.getCode());
        event.add(SystemEvent.PAYLOAD_NAME, module.getName());
        event.add("group", module.getGroup());
        
        publisher.publishEvent(event);

        log.info("Creating new Module {}", module);
        
        return Mono.just(ModuleMapper.INSTANCE.toData(module));
    }
    
    @Override
    public Mono<ModuleData> update(ModuleUpdateCommand command) {

        Optional<Module> opt = repo.findOneByCode(command.getCode()).blockOptional();
        Preconditions.checkState(opt.isPresent(), "Module does not exist");
        
        opt.get().setName(command.getName());
        opt.get().setGroup(command.getGroup());
        opt.get().setEnabled(command.isEnabled());
        opt.get().setNote(command.getNote());

        repo.save(opt.get());
        
        SystemEvent event = new SystemEvent(EventSourceName.ACCESS_MODULE, SystemEvent.UPDATE);
        event.add(SystemEvent.PAYLOAD_CODE, opt.get().getCode());
        event.add(SystemEvent.PAYLOAD_NAME, opt.get().getName());
        event.add("group", opt.get().getGroup());
        
        log.info("Updating module {}", opt.get());
        
        return Mono.just(ModuleMapper.INSTANCE.toData(opt.get()));
    }
    
    public Mono<ModuleData> delete(ModuleDeleteCommand command) {

        Optional<Module> opt = repo.findOneByCode(command.getCode()).blockOptional();
        Preconditions.checkState(opt.isPresent(), "Module does not exist");
        
        repo.delete(opt.get());
        
        log.info("Deleting module {}", opt.get());
        
        SystemEvent event = new SystemEvent(EventSourceName.ACCESS_MODULE, SystemEvent.DELETE);
        event.add(SystemEvent.PAYLOAD_CODE, command.getCode());
        
        publisher.publishEvent(event);
        
        return Mono.just(ModuleMapper.INSTANCE.toData(opt.get()));
    }
    
    public Mono<ModuleData> getByCode(String code) {

        return Mono.just(ModuleMapper.INSTANCE.toData(repo.findOneByCode(code).block()));
    }
    
    public Flux<ModuleData> allModules() {

        return repo.loadAllModule();
    }
    
    public Flux<ModuleData> allWithPaging(int page, int size) {

        return repo.loadAllModule(PageRequest.of(page, size));
    }
    
    public Flux<ModuleData> allWithFilterAndPaging(@NonNull ModuleFilter filter, int page, int size) {

    	if(Strings.isNullOrEmpty(filter.getKey())) {
    		return allWithPaging(filter.getPage(), filter.getSize());
    	}
    	
    	log.info("Searching module data with key {}", filter.toLikeQuery());
    	
    	return Flux.fromIterable(
                ModuleMapper.INSTANCE.toDatas(
                        repo.findAll().collectList().block()));
    }

    public Mono<Long> count() {

        return repo.count();
    }

    public Mono<Long> count(@NonNull ModuleFilter filter) {

    	return repo.count(null);
    }

	@Override
	public Flux<ModuleData> allWithFilter(@NonNull ModuleFilter filter) {

		return allWithFilterAndPaging(filter, filter.getPage(), filter.getSize());
	}
}
