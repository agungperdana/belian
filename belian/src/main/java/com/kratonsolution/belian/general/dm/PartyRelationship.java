/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
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

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="party_relationship")
@Inheritance(strategy=InheritanceType.JOINED)
public class PartyRelationship implements Serializable
{
	public enum Type{COMPANYSTRUCTURE,CUSTOMER,SUPPLIER,EMPLOYMENT,DOCTORPARTNERSHIP}
	
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="date_from",nullable=false)
	protected Date from;
	
	@Column(name="date_to")
	protected Date to;
	
	@Enumerated(EnumType.STRING)
	@Column(name="relationhip_type")
	protected Type type = Type.COMPANYSTRUCTURE;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="fk_parent")
	@NotFound(action=NotFoundAction.IGNORE)
	protected PartyRole parent;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="fk_child")
	@NotFound(action=NotFoundAction.IGNORE)
	protected PartyRole child;
	
	@Version
	protected Long version;
	
	public PartyRelationship(){}
}
