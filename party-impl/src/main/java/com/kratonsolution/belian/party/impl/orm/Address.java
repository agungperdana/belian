
package com.kratonsolution.belian.party.impl.orm;

import com.kratonsolution.belian.common.persistence.IDValueRef;
import com.kratonsolution.belian.common.persistence.Referenceable;
import com.kratonsolution.belian.country.impl.orm.Country;
import com.kratonsolution.belian.geographic.impl.orm.Geographic;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
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
