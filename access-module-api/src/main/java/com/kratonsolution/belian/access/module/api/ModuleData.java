package com.kratonsolution.belian.access.module.api;

import lombok.*;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0
 */
@Data
@ToString
@NoArgsConstructor
public class ModuleData implements ModuleEntity {

	@NonNull
	private String id;

	@NonNull
	private String code;

	@NonNull
	private String name;

	@NonNull
	private String group;

	private String note;

	private boolean enabled = true;
}
