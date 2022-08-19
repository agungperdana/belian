package com.kratonsolution.belian.access.module.impl.application;

import com.kratonsolution.belian.access.module.impl.domain.AccessModule;
import com.kratonsolution.belian.access.module.impl.entity.R2DBCModuleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.access.module.api.ModuleData;
import com.kratonsolution.belian.access.module.api.application.ModuleCreateCommand;
import com.kratonsolution.belian.access.module.api.application.ModuleDeleteCommand;
import com.kratonsolution.belian.access.module.api.application.ModuleService;
import com.kratonsolution.belian.access.module.api.application.ModuleUpdateCommand;
import com.kratonsolution.belian.access.module.impl.repository.ModuleRepository;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

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

        R2DBCModuleEntity module = R2DBCModuleEntity.builder()
                            .id(UUID.randomUUID().toString())
                            .code(command.getCode())
                            .name(command.getName())
                            .group(command.getGroup())
                            .note(command.getNote())
                            .enabled(command.isEnabled())
                            .build();

        repo.save(module).subscribe();
        return Mono.just(ModuleMapper.INSTANCE.toData(module));
    }
    
    @Override
    public Mono<ModuleData> update(ModuleUpdateCommand command) {

        return repo.findOneByCode(command.getCode())
                .map(entity -> {

                    AccessModule.withEntity(entity)
                                .changeNote(command.getNote())
                                .changeActiveStatus(command.isEnabled());

                    repo.save(entity).subscribe();

                    return ModuleMapper.INSTANCE.toData(entity);
                });
    }
    
    public Mono<ModuleData> delete(ModuleDeleteCommand command) {

        return repo.findOneByCode(command.getCode())
                .map(module -> {

                    repo.delete(module).subscribe();
                    return ModuleMapper.INSTANCE.toData(module);
                });
    }

    public Mono<ModuleData> getById(@NonNull String id) {

        return repo.findById(id).map(mod -> ModuleMapper.INSTANCE.toData(mod));
    }

    public Mono<ModuleData> getByCode(@NonNull String code) {

        return repo.findOneByCode(code).map(module -> ModuleMapper.INSTANCE.toData(module));
    }
    
    public Flux<ModuleData> getAll() {

        return repo.getAll();
    }

    public Flux<ModuleData> getAll(int offset, int limit) {

        return repo.getAll(offset, limit);
    }

    public Mono<Long> count() {

        return repo.count();
    }

    public Mono<Long> count(@NonNull String key) {

        return repo.count(key+"%");
    }

	@Override
	public Flux<ModuleData> filter(@NonNull String key) {
        return repo.filter(key+"%");
	}

    public Flux<ModuleData> filter(@NonNull String key, int offset, int limit) {

        return repo.filter(key+"%", offset, limit);
    }
}
