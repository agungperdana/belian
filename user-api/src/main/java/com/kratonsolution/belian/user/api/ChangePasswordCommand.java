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
public class ChangePasswordCommand {

    @NonNull
    private String email;

    @NonNull
    private String oldPassword;

    @NonNull
    private String newPassword;

    @NonNull
    private String reNewPassword;
}
