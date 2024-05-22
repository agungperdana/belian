package com.kratonsolution.belian.general.dm;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.common.dm.Referenceable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
@Getter
@Setter
@Entity
@Table(name="country")
public class Country implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="code")
	private String code;
	
	@Column(name="name")
	private String name;
	
	@Version
	private Long version;
	
	public Country(){}

	@Override
	public String getLabel()
	{
		return getName();
	}

	@Override
	public String getValue()
	{
		// TODO Auto-generated method stub
		return getId();
	}
}
