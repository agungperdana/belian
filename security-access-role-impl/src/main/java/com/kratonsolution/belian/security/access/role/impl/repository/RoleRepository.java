package com.kratonsolution.belian.security.access.role.impl.repository;

import com.kratonsolution.belian.security.access.role.api.RoleData;
import com.kratonsolution.belian.security.access.role.impl.entity.R2DBCRoleEntity;

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
public interface RoleRepository extends R2dbcRepository<R2DBCRoleEntity, String> {

    public Mono<R2DBCRoleEntity> findOneByName(@NonNull String name);

    @Query("SELECT * FROM access_role ORDER BY name ASC")
    public Flux<R2DBCRoleEntity> getAll();

    @Query("SELECT * FROM access_role role ORDER BY role.name ASC LIMIT :limit OFFSET :offset")
    public Flux<R2DBCRoleEntity> getAll(int offset, int limit);

    @Query("SELECT * FROM access_role role WHERE role.name LIKE :key ORDER BY role.name ASC")
    public Flux<R2DBCRoleEntity> filter(@NonNull String key);

    @Query("SELECT * FROM access_role role WHERE role.name LIKE :key ORDER BY role.name ASC LIMIT :limit OFFSET :offset")
    public Flux<R2DBCRoleEntity> filter(@NonNull String key, int offset, int limit);

    @Query("SELECT COUNT(role) FROM access_role role WHERE role.name LIKE :key")
    public Mono<Long> count(@NonNull String key);

    @Query("DELETE FROM access_role WHERE name =:name")
    public Mono<Void> deleteByName(@NonNull String name);
}
