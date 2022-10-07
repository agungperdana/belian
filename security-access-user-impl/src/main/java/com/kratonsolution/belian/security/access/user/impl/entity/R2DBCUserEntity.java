package com.kratonsolution.belian.security.access.user.impl.entity;

import com.kratonsolution.belian.security.access.user.api.entity.UserEntity;
import lombok.*;
import org.reactivestreams.Publisher;
import org.springframework.data.annotation.*;
import org.springframework.data.mapping.callback.EntityCallback;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import org.springframework.data.r2dbc.mapping.event.BeforeSaveCallback;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.sql.SqlIdentifier;

import java.util.UUID;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.0
 */

@Data
@Builder
@Table("access_user")
public class R2DBCUserEntity implements UserEntity
{
    @Id
    private String id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String source;

    @Builder.Default()
    private Boolean enabled = Boolean.FALSE;

    @Version
    private Long version;

    public R2DBCUserEntity(String id, @NonNull  String name, @NonNull  String email, @NonNull String source, Boolean enabled, Long version) {

        this.id = id != null && !id.equals("")?id:UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.source = source;
        this.enabled = enabled;
        this.version = version;
    }
}
