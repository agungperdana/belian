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
public class GeographicUpdateCommand implements Serializable {

	private static final long serialVersionUID = -4756901072213595348L;

	@NonNull
	private String code;

	private String name;

	private String note;

	private GeographicType type;
}
