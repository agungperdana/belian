package com.kratonsolution.belian.accounting.dm;

import java.util.UUID;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.common.persistence.IDValueRef;
import com.kratonsolution.belian.common.persistence.Referenceable;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Cacheable
@Table(name="currency")
public class Currency implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="code",nullable=false,unique=true)
	private String code;
	
	@Column(name="name",nullable=false,unique=true)
	private String name;
	
	@Column(name="is_default")
	private boolean base;
	@Version
	private Long version;
	
	public Currency(){}

	public Currency(IDValueRef ref)
	{
		if(ref != null)
		{
			setId(ref.getId());
			setName(ref.getValue());
		}
	}
	
	@Override
	public String getLabel()
	{
		return this.code;
	}

	@Override
	public String getValue()
	{
		return this.id;
	}
}
