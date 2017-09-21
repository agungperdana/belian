/**
 * 
 */
package com.kratonsolution.belian.products.dm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.common.dm.Referenceable;

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
@Table(name="unit_of_measure")
public class UnitOfMeasure implements Serializable,Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="name")
	private String name;

	@Column(name="note")
	private String note;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private UOMType type = UOMType.MASS;
	
	@Version
	private Long version;

	@OneToMany(mappedBy="from",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<UOMFactor> factors = new HashSet<>(); 
	
	public UnitOfMeasure(){}
	
	public UnitOfMeasure(IDValueRef ref)
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
		return getName();
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
