/**
 * 
 */
package com.kratonsolution.belian.asset.dm;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="asset_type")
public class AssetType
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="code",unique=true)
	private String code;
	
	@Column(name="name",unique=true)
	private String name;
	
	@Version
	private Long version;

	@ManyToOne
	@JoinColumn(name="parent")
	private AssetType parent;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="parent",orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<AssetType> childs = new HashSet<>();
	
	public AssetType(){}
}
