package com.kratonsolution.belian.access.role.impl.repository;

import com.kratonsolution.belian.access.role.api.RoleData;
import com.kratonsolution.belian.access.role.api.RoleEntity;
import com.kratonsolution.belian.access.role.impl.entity.R2DBCRoleEntity;

import lombok.NonNull;
import org.springframework.data.r2dbc.repository.Modifying;
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

    public Mono<R2DBCRoleEntity> findOneByCode(@NonNull String code);

    @org.springframework.data.r2dbc.repository.Query("SELECT am.id, am.code, am.name, am.note, am.enabled FROM access_role am")
    public Flux<RoleData> getAll();

    @org.springframework.data.r2dbc.repository.Query("SELECT role.id, role.code, role.name, role.note, role.enabled FROM access_role role " +
            "ORDER BY role.code ASC LIMIT :limit OFFSET :offset")
    public Flux<RoleData> getAll(int offset, int limit);

    @org.springframework.data.r2dbc.repository.Query("SELECT role.id, role.code, role.name, role.note, role.enabled FROM access_role role " +
            "WHERE role.code LIKE :key OR role.name LIKE :key ORDER BY role.code, role.name ASC")
    public Flux<RoleData> filter(@NonNull String key);

    @org.springframework.data.r2dbc.repository.Query("SELECT role.id, role.code, role.name, role.note, role.enabled FROM access_role role " +
            "WHERE role.code LIKE :key OR role.name LIKE :key " +
            "ORDER BY role.code ASC LIMIT :limit OFFSET :offset")
    public Flux<RoleData> filter(@NonNull String key, int offset, int limit);

    @Query("SELECT COUNT(role) FROM access_role role WHERE role.code LIKE :key OR role.name LIKE :key")
    public Mono<Long> count(@NonNull String key);

    @Query("DELETE FROM access_role WHERE code =:code")
    public Mono<Void> deleteByCode(@NonNull String code);
}
