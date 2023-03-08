/**
 * 
 */
package com.kratonsolution.belian.partys.dm;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

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
