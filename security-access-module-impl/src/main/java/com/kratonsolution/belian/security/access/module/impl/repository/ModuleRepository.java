package com.kratonsolution.belian.security.access.module.impl.repository;

import com.kratonsolution.belian.security.access.module.api.ModuleData;
import com.kratonsolution.belian.security.access.module.impl.entity.R2DBCModuleEntity;
import lombok.NonNull;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 * @version 2.0.1
 */
public interface ModuleRepository extends R2dbcRepository<R2DBCModuleEntity, String> {

    public Mono<R2DBCModuleEntity> findOneByName(@NonNull String name);

    @Query("SELECT mdl.id, mdl.name, mdl.module_group, mdl.description, mdl.enabled, mdl.version FROM access_module mdl ORDER BY mdl.name ASC LIMIT :limit OFFSET :offset")
    public Flux<R2DBCModuleEntity> getAll(int offset, int limit);

    @Query("SELECT mdl.id, mdl.name, mdl.module_group, mdl.description, mdl.enabled, mdl.version FROM access_module mdl WHERE mdl.name LIKE :key ORDER BY mdl.name ASC")
    public Flux<R2DBCModuleEntity> filter(@NonNull String key);

    @Query("SELECT  mdl.id, mdl.name, mdl.module_group, mdl.description, mdl.enabled, mdl.version FROM access_module mdl WHERE mdl.name LIKE :key ORDER BY mdl.name ASC LIMIT :limit OFFSET :offset")
    public Flux<R2DBCModuleEntity> filter(@NonNull String key, int offset, int limit);

    @Query("SELECT COUNT(mdl) FROM access_module mdl WHERE mdl.name LIKE :key")
    public Mono<Long> count(@NonNull String key);
}
