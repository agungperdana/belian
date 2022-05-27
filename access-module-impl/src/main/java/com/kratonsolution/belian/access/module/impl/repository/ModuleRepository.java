package com.kratonsolution.belian.access.module.impl.repository;

import com.kratonsolution.belian.access.module.api.ModuleData;
import com.kratonsolution.belian.access.module.impl.model.Module;
import org.springframework.data.domain.Pageable;

import lombok.NonNull;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
public interface ModuleRepository extends R2dbcRepository<Module, String> {

    public Mono<Module> findOneByCode(@NonNull String code);

    @Query("SELECT module FROM access_module module WHERE module.code = ?1 ")
    public Mono<ModuleData> getOne(String code);

    @Query("SELECT * FROM access_module")
    public Flux<ModuleData> loadAllModule();

    @Query("SELECT * FROM access_module")
    public Flux<ModuleData> loadAllModule(Pageable pageable);

    @Query("SELECT * FROM access_module module WHERE module.code LIKE ?1 OR module.name LIKE ?1 ORDER BY module.code, module.name ASC")
    public Flux<ModuleData> loadAllModule(@NonNull String key, Pageable pageable);

    @Query("SELECT COUNT(*) FROM access_module module WHERE module.code LIKE ?1 OR module.name LIKE ?1")
    public Mono<Long> count(@NonNull String key);
}
