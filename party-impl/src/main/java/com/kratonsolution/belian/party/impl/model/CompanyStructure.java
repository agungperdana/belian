package com.kratonsolution.belian.party.impl.model;

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
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.party.api.model.CompanyStructureType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Getter
@Setter
@Entity
@Table(name="company_structure")
public class CompanyStructure
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "note")
	private String note;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private CompanyStructureType type = CompanyStructureType.HOLDING;
	
	@ManyToOne
	@JoinColumn(name = "fk_parent")
	private CompanyStructure parent;
	
	@Version
	protected Long version;

	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<CompanyStructure> children = new HashSet<>();
	
	public CompanyStructure(){}
}
