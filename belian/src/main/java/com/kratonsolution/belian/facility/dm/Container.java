/**
 * 
 */
package com.kratonsolution.belian.facility.dm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="Container")
public class Container implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="name")
	private String name;
	
	@Column(name="note")
	private String note;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private ContainerType type;

	@ManyToOne
	@JoinColumn(name="parent")
	private Container parent;
	
	@ManyToOne
	@JoinColumn(name="fk_facility")
	private Facility facility;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="parent")
	private Set<Container> childs = new HashSet<>();
}
