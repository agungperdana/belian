package com.kratonsolution.belian.access.module.impl.repository;

import com.kratonsolution.belian.access.module.api.ModuleData;
import com.kratonsolution.belian.access.module.impl.entity.R2DBCModuleEntity;

import lombok.NonNull;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 * @version 2.0.1
 */
public interface ModuleRepository extends R2dbcRepository<R2DBCModuleEntity, String> {

    public Mono<R2DBCModuleEntity> findOneByCode(@NonNull String code);

    @Query("SELECT am.id, am.code, am.name, am.module_group as group, am.note, am.enabled FROM access_module am")
    public Flux<ModuleData> getAll();

    @Query("SELECT mdl.id, mdl.code, mdl.name, mdl.module_group as group, mdl.note, mdl.enabled FROM access_module mdl " +
            "ORDER BY mdl.code ASC LIMIT :limit OFFSET :offset")
    public Flux<ModuleData> getAll(int offset, int limit);

    @Query("SELECT mdl.id, mdl.code, mdl.name, mdl.module_group as group, mdl.note, mdl.enabled FROM access_module mdl " +
            "WHERE mdl.code LIKE :key OR mdl.name LIKE :key ORDER BY mdl.code, mdl.name ASC")
    public Flux<ModuleData> filter(@NonNull String key);

    @Query("SELECT mdl.id, mdl.code, mdl.name, mdl.module_group as group, mdl.note, mdl.enabled FROM access_module mdl " +
            "WHERE mdl.code LIKE :key OR mdl.name LIKE :key " +
            "ORDER BY mdl.code ASC LIMIT :limit OFFSET :offset")
    public Flux<ModuleData> filter(@NonNull String key, int offset, int limit);

    @Query("SELECT COUNT(mdl) FROM access_module mdl WHERE mdl.code LIKE :key OR mdl.name LIKE :key")
    public Mono<Long> count(@NonNull String key);
}
