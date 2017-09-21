/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.common.dm.Referenceable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
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
