
package com.kratonsolution.belian.global.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.common.dm.Referenceable;
import com.kratonsolution.belian.partys.dm.Organization;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="product_receivable")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class ProductReceiveable implements Serializable,Referenceable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	protected Date date;
	
	@Column(name="number")
	protected String number;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	protected Organization organization;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	protected Status status = Status.NEW;

	@Version
	protected Long version;
	
	public abstract String getType();

	public abstract Set<? extends ProductReceiveableItem> getItems();
	
	@Override
	public String getLabel()
	{
		return getType()+"("+getNumber()+")";
	}
	
	@Override
	public String getValue()
	{
		return getId();
	}
}
