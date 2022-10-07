package com.kratonsolution.belian.security.access.user.impl.application;

import com.kratonsolution.belian.security.access.user.api.UserData;
import com.kratonsolution.belian.security.access.user.api.application.UserCreateCommand;
import com.kratonsolution.belian.security.access.user.api.application.UserDeleteCommand;
import com.kratonsolution.belian.security.access.user.api.application.UserService;
import com.kratonsolution.belian.security.access.user.api.application.UserUpdateCommand;
import com.kratonsolution.belian.security.access.user.impl.domain.User;
import com.kratonsolution.belian.security.access.user.impl.repository.UserRepository;
import com.kratonsolution.belian.shared.kernel.valueobject.Email;
import com.kratonsolution.belian.shared.kernel.valueobject.Enabled;
import com.kratonsolution.belian.shared.kernel.valueobject.Name;
import com.kratonsolution.belian.shared.kernel.valueobject.Source;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0
 */
@Slf4j
@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private UserRepository repo;

    public Mono<UserData> create(@NonNull Mono<UserCreateCommand> command) {

        return command.map(com -> User
                        .builder()
                        .name(new Name(com.getName()))
                        .email(new Email(com.getEmail()))
                        .enabled(new Enabled(com.getEnabled()))
                        .source(new Source(com.getSource()))
                        .build()
                        .validate()
                )
                .map(UserMapper.INSTANCE::toEntity)
                .flatMap(repo::save)
                .map(UserMapper.INSTANCE::entityToData);
    }

    @Override
    public Mono<UserData> update(@NonNull Mono<UserUpdateCommand> command) {

        return command.map(com -> User.builder()
                        .name(Name.is(com.getName()))
                        .enabled(Enabled.is(com.getEnabled()))
                        .email(new Email(com.getEmail()))
                        .build()
                        .validate()
                )
                .flatMap(domain -> {

                    return repo.getByEmail(domain.getEmail().getValue())
                            .switchIfEmpty(Mono.just(UserMapper.INSTANCE.toEntity(domain)))
                            .map(entity -> {

                                entity.setName(domain.getName().getValue());
                                entity.setEnabled(domain.getEnabled().getValue());
                                return entity;
                            })
                            .flatMap(repo::save)
                            .map(UserMapper.INSTANCE::entityToData);

                });
    }

    public Mono<UserData> delete(@NonNull Mono<UserDeleteCommand> command) {

        return command.flatMap(com->repo.getByEmail(com.getEmail()))
                .flatMap(en->repo.delete(en).thenReturn(en))
                .map(UserMapper.INSTANCE::entityToData);
    }

    public Mono<UserData> getByEmail(@NonNull String email) {

        return repo.getByEmail(email).map(UserMapper.INSTANCE::entityToData);
    }

    public Flux<UserData> getAll() {

        return repo.findAll().map(UserMapper.INSTANCE::entityToData);
    }

    public Flux<UserData> getAll(int offset, int limit) {

        return repo.getAll(offset, limit).map(UserMapper.INSTANCE::entityToData);
    }

    public Mono<Long> count() {

        return repo.count();
    }

    public Mono<Long> count(@NonNull String key) {

        return repo.count(key+"%");
    }

    @Override
    public Flux<UserData> filter(@NonNull String key) {
        return repo.filter(key+"%").map(UserMapper.INSTANCE::entityToData);
    }

    public Flux<UserData> filter(@NonNull String key, int offset, int limit) {

        return repo.filter(key+"%", offset, limit).map(UserMapper.INSTANCE::entityToData);
    }
}
