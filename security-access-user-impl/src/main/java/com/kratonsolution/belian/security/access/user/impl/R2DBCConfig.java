package com.kratonsolution.belian.security.access.user.impl;

import com.kratonsolution.belian.security.access.user.impl.entity.R2DBCUserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.mapping.event.BeforeConvertCallback;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Configuration
public class R2DBCConfig {

    @Bean
    BeforeConvertCallback<R2DBCUserEntity> genUserID(DatabaseClient client) {

        return (user, sqlIdentifier) -> {

            if(user.isNew()) {
                user.setId(UUID.randomUUID().toString());
            }

            return Mono.just(user);
        };
    }
}
