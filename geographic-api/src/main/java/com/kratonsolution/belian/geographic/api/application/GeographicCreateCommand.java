package com.kratonsolution.belian.geographic.api.application;

import java.io.Serializable;

import com.kratonsolution.belian.geographic.api.GeographicType;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Getter
@Setter
public class GeographicCreateCommand implements Serializable {

	private static final long serialVersionUID = -3095350621012911795L;

	@NonNull
	private String code;

	@NonNull
	private String name;

	private String note;

	@NonNull
	private GeographicType type;

	private String parent;
}
