
package com.kratonsolution.belian.inventory.dm;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

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
@Table(name="facility")
public class Facility implements Referenceable
{
	@Id
	private String id = "0";
	
	@Column(name="name",unique=true,nullable=false)
	private String name;
	
	@Column(name="note")
	private String note;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private FacilityType type = FacilityType.WAREHOUSE;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="facility",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Container> containers = new HashSet<>();
	
	@OneToMany(mappedBy="facility",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<FacilityOrganization> organizations = new HashSet<>();
	
	public Facility(){}
	
	public Facility(IDValueRef ref)
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
