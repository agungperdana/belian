package com.kratonsolution.belian.auth.model;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "access_role")
@TypeDefs({
    @TypeDef(name = "json", typeClass = JsonType.class)
})
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "name")
    private String name;

    @Column(name = "enabled")
    private boolean enabled;

    @Type(type = "jsonb")
    @Column(columnDefinition = "json", name = "modules")
    private Set<RoleModule> modules;

    @Version
    private Long version;
}
