package com.kratonsolution.belian.user.api;

import lombok.Data;
import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.1
 */
@Data
public class UserRoleUpdateCommand {

    @NonNull
    private String roleId;

    private boolean enabled = false;
}
