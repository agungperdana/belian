package com.kratonsolution.belian.security.api.application;

import java.io.Serializable;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0.0
 */
@Getter
@Setter
public class ChangePasswordCommand implements Serializable {

    private static final long serialVersionUID = 6479635969120851520L;

	@NonNull
    private String name;
    
    @NonNull
    private String oldPassword;
    
    @NonNull
    private String newPassword;
}
