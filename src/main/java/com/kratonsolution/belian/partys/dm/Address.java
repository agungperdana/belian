
package com.kratonsolution.belian.partys.dm;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.common.dm.Referenceable;
import com.kratonsolution.belian.general.dm.Country;
import com.kratonsolution.belian.general.dm.Geographic;

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
@Table(name="address")
public class Address implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="address",nullable=false)
	private String address;
		
	@Column(name="postal",nullable=false)
	private String postal;
	
	@Column(name="status",nullable=false)
	private boolean active;
	
	@Column(name="type",nullable=false)
	@Enumerated(EnumType.STRING)
	private AddressType type = AddressType.OFFICE;

	@ManyToOne
	@JoinColumn(name="fk_country")
	private Country country;
	
	@ManyToOne
	@JoinColumn(name="fk_province")
	private Geographic province;
	
	@ManyToOne
	@JoinColumn(name="fk_city")
	private Geographic city;
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	private Party party;
	
	@Version
	private Long version;
	
	public Address(){}
	
	public Address(IDValueRef ref)
	{
		if(ref != null)
		{
			setId(ref.getId());
			setAddress(ref.getValue());
		}
	}

	@Override
	public String getLabel()
	{
		return getAddress()+","+getCity()!=null?getCity().getName():""+","+getProvince()!=null?getProvince().getName():""+","+getCountry() !=null?getCountry().getName():"";
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
