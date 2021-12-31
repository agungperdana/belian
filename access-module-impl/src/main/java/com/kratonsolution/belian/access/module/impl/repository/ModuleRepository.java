package com.kratonsolution.belian.access.module.impl.repository;

import java.util.List;
import java.util.Optional;

import com.kratonsolution.belian.access.module.api.ModuleData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kratonsolution.belian.access.module.impl.model.Module;

import lombok.NonNull;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
public interface ModuleRepository extends R2dbcRepository<Module, String> {

    public Mono<Module> findOneByCode(@NonNull String code);

    @Query("SELECT * FROM access_module")
    public Flux<ModuleData> loadAllModule();

    @Query("SELECT * FROM access_module")
    public Flux<ModuleData> loadAllModule(Pageable pageable);
}
