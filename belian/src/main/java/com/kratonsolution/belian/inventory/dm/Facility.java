/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

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
public class Facility implements Serializable
{
	public enum Type{WAREHOUSE,PLAN}
	
	@Id
	private String id;
	
	@Column(name="code",nullable=false,unique=true)
	private String code;
	
	@Column(name="name",nullable=false,unique=true)
	private String name;
	
	@Column(name="note")
	private String note;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private Type type = Type.WAREHOUSE;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="facility",cascade=CascadeType.REMOVE,orphanRemoval=true)
	private Set<Container> containers = new HashSet<Container>(); 
}
