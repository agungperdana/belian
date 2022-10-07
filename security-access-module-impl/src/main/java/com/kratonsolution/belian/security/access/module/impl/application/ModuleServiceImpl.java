package com.kratonsolution.belian.security.access.module.impl.application;

import com.kratonsolution.belian.security.access.module.api.ModuleData;
import com.kratonsolution.belian.security.access.module.api.application.ModuleCreateCommand;
import com.kratonsolution.belian.security.access.module.api.application.ModuleDeleteCommand;
import com.kratonsolution.belian.security.access.module.api.application.ModuleService;
import com.kratonsolution.belian.security.access.module.api.application.ModuleUpdateCommand;
import com.kratonsolution.belian.security.access.module.impl.domain.AccessModule;
import com.kratonsolution.belian.security.access.module.impl.repository.ModuleRepository;
import com.kratonsolution.belian.shared.kernel.valueobject.Description;
import com.kratonsolution.belian.shared.kernel.valueobject.Enabled;
import com.kratonsolution.belian.shared.kernel.valueobject.Group;
import com.kratonsolution.belian.shared.kernel.valueobject.Name;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class ModuleServiceImpl implements ModuleService {
    
    private ModuleRepository repo;

    public Mono<ModuleData> create(@NonNull Mono<ModuleCreateCommand> command) {

        return command.map(com -> {

            AccessModule domain = AccessModule
                                        .builder()
                                        .name(Name.is(com.getName()))
                                        .group(Group.is(com.getGroup()))
                                        .enabled(Enabled.is(com.getEnabled()))
                                        .description(Description.is(com.getDescription()))
                                        .build()
                                        .validate();

            return ModuleMapper.INSTANCE.toEntity(domain);
        }).flatMap(entity -> {

            entity.setId(UUID.randomUUID().toString());
            repo.save(entity).subscribe();
            return Mono.just(ModuleMapper.INSTANCE.toData(entity));
        });
    }
    
    @Override
    public Mono<ModuleData> update(@NonNull Mono<ModuleUpdateCommand> command) {

        return command.map(com -> AccessModule.builder()
                                                .name(Name.is(com.getName()))
                                                .enabled(Enabled.is(com.getEnabled()))
                                                .description(Description.is(com.getDescription()))
                                                .build()
                                                .validate()
                        )
                        .flatMap(domain ->

                            repo.findOneByName(domain.getName().toString()).map(entity -> {

                                entity.setDescription(domain.getDescription().getValue());
                                entity.setEnabled(domain.getEnabled().getValue());

                                return repo.save(entity);
                            }).thenReturn(domain)
                        ).map(ModuleMapper.INSTANCE::toData);
    }
    
    public Mono<ModuleData> delete(@NonNull Mono<ModuleDeleteCommand> command) {

        return command.flatMap(com -> repo.findOneByName(com.getName())).map(entity->{

            repo.delete(entity).subscribe();
            return ModuleMapper.INSTANCE.toData(entity);
        });
    }

    public Mono<ModuleData> getByName(@NonNull String name) {

        return repo.findOneByName(name).map(ModuleMapper.INSTANCE::toData);
    }
    
    public Flux<ModuleData> getAll() {

        return repo.findAll().map(ModuleMapper.INSTANCE::toData);
    }

    public Flux<ModuleData> getAll(int offset, int limit) {

        return repo.getAll(offset, limit).map(ModuleMapper.INSTANCE::toData);
    }

    public Mono<Long> count() {

        return repo.count();
    }

    public Mono<Long> count(@NonNull String key) {

        return repo.count(key+"%");
    }

	@Override
	public Flux<ModuleData> filter(@NonNull String key) {
        return repo.filter(key+"%").map(ModuleMapper.INSTANCE::toData);
	}

    public Flux<ModuleData> filter(@NonNull String key, int offset, int limit) {

        return repo.filter(key+"%", offset, limit).map(ModuleMapper.INSTANCE::toData);
    }
}
