package com.kratonsolution.belian.access.module.impl.application;

import java.util.Optional;

import com.kratonsolution.belian.access.module.impl.model.Module;
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

    public Mono<ModuleData> create(Mono<ModuleCreateCommand> monoCommand) {

        return monoCommand.flatMap(command -> {

                Module module = new Module(command.getCode(), command.getName(), command.getGroup(),
                        command.getNote(), command.isEnabled());

                repo.save(module).subscribe();

                SystemEvent event = new SystemEvent(EventSourceName.ACCESS_MODULE, SystemEvent.ADD);
                event.add(SystemEvent.PAYLOAD_CODE, module.getCode());
                event.add(SystemEvent.PAYLOAD_NAME, module.getName());
                event.add("group", module.getGroup());

                publisher.publishEvent(event);

                log.info("Creating new Module {}", module);

                return repo.getOne(command.getCode());
        });
    }
    
    @Override
    public Mono<ModuleData> update(Mono<ModuleUpdateCommand> monoCommand) {

        return monoCommand.flatMap(command->{

            repo.findOneByCode(command.getCode()).subscribe(module -> {

                module.setName(command.getName());
                module.setGroup(command.getGroup());
                module.setEnabled(command.isEnabled());
                module.setNote(command.getNote());

                repo.save(module).subscribe();

                SystemEvent event = new SystemEvent(EventSourceName.ACCESS_MODULE, SystemEvent.UPDATE);
                event.add(SystemEvent.PAYLOAD_CODE, command.getCode());
                event.add(SystemEvent.PAYLOAD_NAME, command.getName());
                event.add("group", command.getGroup());

                log.info("Updating module {}", module);
            });

            return repo.getOne(command.getCode());
        });
    }
    
    public Mono<ModuleData> delete(Mono<ModuleDeleteCommand> command) {

        return command.flatMap(c->{

            Mono<ModuleData> data = repo.getOne(c.getCode());
            repo.findOneByCode(c.getCode()).subscribe(m->repo.delete(m));

            return data;
        });
    }
    
    public Mono<ModuleData> getByCode(Mono<String> code) {

        return code.flatMap(c->repo.getOne(c));
    }
    
    public Flux<ModuleData> getAll() {

        return repo.loadAllModule();
    }

    public Mono<Long> count() {

        return repo.count();
    }

    public Mono<Long> count(@NonNull Mono<ModuleFilter> filter) {

        return filter.flatMap(f -> {

            if(Strings.isNullOrEmpty(f.getKey())) {
                return count();
            }
            else {
                return repo.count(f.getKey());
            }
        });
    }

	@Override
	public Flux<ModuleData> filter(@NonNull Mono<ModuleFilter> filter) {

        return filter.flatMapMany(f->{

            if(!Strings.isNullOrEmpty(f.getKey()) && f.getPage() != null && f.getSize() != null) {
                return allWithFilterAndPaging(f.getKey(), f.getPage(), f.getSize());
            }
            else if(Strings.isNullOrEmpty(f.getKey()) && f.getPage() != null && f.getSize() != null) {
                return allWithPaging(f.getPage(), f.getSize());
            }
            else {
                return getAll();
            }
        });
	}

    private Flux<ModuleData> allWithPaging(int page, int size) {

        return repo.loadAllModule(PageRequest.of(page, size));
    }

    private Flux<ModuleData> allWithFilterAndPaging(@NonNull String key, int page, int size) {

        return repo.loadAllModule(key, PageRequest.of(page, size));
    }
}
