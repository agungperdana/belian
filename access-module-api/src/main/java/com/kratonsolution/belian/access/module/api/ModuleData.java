package com.kratonsolution.belian.access.module.api;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

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
public class ModuleData implements Serializable {

	private static final long serialVersionUID = -1510690541332344917L;

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
