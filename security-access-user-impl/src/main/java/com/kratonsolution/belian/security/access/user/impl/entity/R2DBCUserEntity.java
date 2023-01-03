package com.kratonsolution.belian.security.access.user.impl.entity;

import com.kratonsolution.belian.shared.kernel.Entity;
import io.r2dbc.postgresql.codec.Json;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.0
 */

@Data
@Builder
@Table("access_user")
@AllArgsConstructor
public class R2DBCUserEntity implements Entity
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

    private Json roles;

    @Version
    private Long version;
}
