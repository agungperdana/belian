package com.kratonsolution.belian.security.access.user.impl.repository;

import com.kratonsolution.belian.security.access.user.impl.entity.R2DBCUserEntity;
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
public interface UserRepository extends R2dbcRepository<R2DBCUserEntity, String> {

    public Mono<R2DBCUserEntity> findOneByName(@NonNull String name);

    @Query("SELECT * FROM access_user usr WHERE usr.email =:email")
    public Mono<R2DBCUserEntity> getByEmail(@NonNull String email);

    @Query("SELECT * FROM access_user usr ORDER BY usr.name  ASC LIMIT :limit OFFSET :offset")
    public Flux<R2DBCUserEntity> getAll(int offset, int limit);

    @Query("SELECT * FROM access_user usr WHERE usr.name LIKE :key OR usr.email LIKE :key ORDER BY usr.name ASC")
    public Flux<R2DBCUserEntity> filter(@NonNull String key);

    @Query("SELECT * FROM access_user usr WHERE usr.name LIKE :key OR usr.email LIKE :key ORDER BY usr.name ASC LIMIT :limit OFFSET :offset")
    public Flux<R2DBCUserEntity> filter(@NonNull String key, int offset, int limit);

    @Query("SELECT COUNT(usr) FROM access_user usr WHERE usr.name LIKE :key")
    public Mono<Long> count(@NonNull String key);
}
