package com.kratonsolution.belian.user.api;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.1
 */
@Data
public class UserData {

    private String userName;

    private String password;

    private boolean enabled;

    private UserSettingData setting;

    private boolean deleteable;

    private Set<UserRoleData> roles = new HashSet<>();
}
