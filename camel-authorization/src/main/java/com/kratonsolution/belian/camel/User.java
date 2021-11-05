package com.kratonsolution.belian.camel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.base.MoreObjects;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 1.0
 */
@Getter
@Setter
public class User implements Serializable {

	private static final long serialVersionUID = 3403743802200817381L;

	private String name;

	private String email;

	private boolean enabled;

	private boolean locked;

	private Set<Role> roles = new HashSet<>();

	private List<Organization> organizations = new ArrayList<>();

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
						  .add("name", name)
						  .add("roles", roles)
						  .add("organizations", organizations)
						  .toString();
	}
}
