package com.kratonsolution.belian.auth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "access_module")
@NoArgsConstructor
@AllArgsConstructor
public class AccessModule {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "name")
    private String name;

    @Column(name = "enabled")
    private boolean enabled;

    @Version
    private Long version;
}
