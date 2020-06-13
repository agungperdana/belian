package com.kratonsolution.belian.security.api.application;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Getter
@Setter
public class ChangePasswordCommand {

    @NonNull
    private String name;
    
    @NonNull
    private String oldPassword;
    
    @NonNull
    private String newPassword;
}
