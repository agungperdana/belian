package com.kratonsolution.belian.accounting.dm;

import java.util.UUID;

import jakarta.persistence.*;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.common.dm.Referenceable;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.YesNoConverter;

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
	@Convert(converter = YesNoConverter.class)
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
