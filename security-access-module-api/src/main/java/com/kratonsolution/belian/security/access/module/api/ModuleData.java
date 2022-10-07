package com.kratonsolution.belian.security.access.module.api;

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
public class ModuleData {

	private String name;

	private String group;

	private String description;

	private Boolean enabled;
}
