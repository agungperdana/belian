/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Organization;

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
public abstract class ProductReceiveable implements Serializable,Listable
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
