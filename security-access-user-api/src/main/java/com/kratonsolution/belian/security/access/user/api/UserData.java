package com.kratonsolution.belian.security.access.user.api;

import lombok.*;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserData {

	private String name;

	private String email;

	private String source;

	private Boolean enabled;
}
