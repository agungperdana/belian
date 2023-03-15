package com.kratonsolution.belian.module.api;

import java.time.Instant;

import com.kratonsolution.belian.common.core.Data;
import lombok.*;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ModuleData implements Data {
	@NonNull
	private String code;

	@NonNull
	private String name;

	private String note;
	@NonNull
	private ModuleGroup group;

	private boolean enabled;

	private String createdBy;

	private Instant createdDate;

	private String lastUpdatedBy;

	private Instant lastUpdatedDate;
}
