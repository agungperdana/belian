package com.kratonsolution.belian.user.api;

import lombok.Data;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.1
 */
@Data
public class UserDeleteCommand {

    @NonNull
    private String email;
}
