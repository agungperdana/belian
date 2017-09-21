/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
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
@Table(name="geographic")
public class Geographic implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="code",unique=true,nullable=false)
	private String code;
	
	@Column(name="name",unique=true,nullable=false)
	private String name;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private GeographicType type = GeographicType.CITY;
	
	@Column(name="note")
	private String note;
	
	@Version
	private Long version;
	
	public Geographic(){}
	
	public Geographic(IDValueRef ref)
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
