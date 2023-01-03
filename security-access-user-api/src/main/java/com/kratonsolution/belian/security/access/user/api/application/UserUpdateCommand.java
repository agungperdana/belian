package com.kratonsolution.belian.security.access.user.api.application;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0.0
 */
@Data
public class UserUpdateCommand {

	@NonNull
    private String email;

    private String name;
    
    private Boolean enabled;

    private List<UserRoleCommand> roles = new ArrayList<>();
}
