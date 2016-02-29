/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.global.dm.EconomicAgent;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="party_role")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class PartyRole implements Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="date_from",nullable=false)
	protected Date start;
	
	@Column(name="date_to")
	protected Date end;
	
	@Version
	private Long version;
	
	public abstract <P extends EconomicAgent> P getFrom();
	
	public abstract <P extends EconomicAgent> P getTo();
	
	public PartyRole(){}
}
