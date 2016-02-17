/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="code",nullable=false,unique=true)
	private String code;
	
	@Column(name="name",nullable=false,unique=true)
	private String name;
	
	@Column(name="note")
	private String note;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private FacilityType type = FacilityType.WAREHOUSE;
	
	@Version
	private Long version;

	@ManyToOne
	@JoinColumn(name="fk_facility_parent")
	private Facility parent;

	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("code ASC")
	private Set<Facility> childs = new HashSet<Facility>();
	
	public Facility(){}
}
