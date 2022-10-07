package com.kratonsolution.belian.security.access.role.api;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.0
 * @version 2.0.1
 */
@ToString
@Getter
@Setter
public class RoleData {

    @NonNull
    private String name;

    private boolean enabled;

    private String description;

    private List<RoleModuleData> modules;
}
