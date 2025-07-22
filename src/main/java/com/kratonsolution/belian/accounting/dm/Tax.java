
package com.kratonsolution.belian.accounting.dm;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.*;

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
@Table(name="tax")
public class Tax implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="code",nullable=false,unique=true)
	private String code;
	
	@Column(name="name",nullable=false,unique=true)
	private String name;
	
	@Column(name="note")
	private String note;
	
	@Column(name="amount",nullable=false)
	private BigDecimal amount = BigDecimal.ZERO;
	
	@Column(name="is_default")
	@Convert(converter = YesNoConverter.class)
	private boolean base;

	@Version
	private Long version;

	@Override
	public String getLabel()
	{
		return getName();
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
