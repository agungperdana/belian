
package com.kratonsolution.belian.partys.dm;

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
@Table(name="contact")
public class Contact implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="contact",nullable=false)
	private String contact;

	@Column(name="type",nullable=false)
	@Enumerated(EnumType.STRING)
	private ContactType type = ContactType.OFFICE_PHONE;
	
	@Column(name="status")
	@Convert(converter = YesNoConverter.class)
	private boolean active;

	@ManyToOne
	@JoinColumn(name="fk_party")
	private Party party;
	
	@Version
	private Long version;
	
	public Contact(){}
	
	public Contact(IDValueRef ref)
	{
		if(ref != null)
		{
			setId(ref.getId());
			setContact(ref.getValue());
		}
	}

	@Override
	public String getLabel()
	{
		return getContact()+" ("+type.display()+")";
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
