package com.kratonsolution.belian.auth.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleModule {

    private String name;

    private boolean add;

    private boolean read;

    private boolean edit;

    private boolean delete;

    private boolean print;
}
