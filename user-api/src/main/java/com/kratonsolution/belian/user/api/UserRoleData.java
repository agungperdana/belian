package com.kratonsolution.belian.user.api;

import lombok.Data;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.1
 */
@Data
public class UserRoleData {

    private String role;

    private String roleName;

    private boolean enabled;
}
