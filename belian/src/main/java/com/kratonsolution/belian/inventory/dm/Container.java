/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="container")
public class Container
{
	public enum Type{ROOM,BIN,BAREL,FILEDRAWER,SHELF}
	
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
	private Type type = Type.SHELF;

	@ManyToOne
	@JoinColumn(name="fk_facility")
	private Facility facility;
	
	@ManyToOne
	@JoinColumn(name="fk_container_parent")
	private Container parent;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="parent",cascade=CascadeType.REMOVE,orphanRemoval=true)
	private Set<Container> members = new HashSet<Container>(); 
}
