package com.kratonsolution.belian.user.api;

import lombok.Data;
import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.1
 */
@Data
public class UserRoleCreateCommand {

    @NonNull
    private String roleId;

    @NonNull
    private String roleName;

    private boolean enabled = false;
}
