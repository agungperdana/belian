/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.global.dm.EconomicResource;

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
@Table(name="gl_account")
public class GLAccount implements EconomicResource
{
	public enum Type{ASSETS,LIABILITIES,EQUITY,REVENUE,DRAWING,COGS,EXPENSE}
	
	@Id
	private String id;
	
	@Column(name="number",nullable=false,unique=true)
	private Long number;
	
	@Column(name="name",nullable=false,unique=true)
	private String name;
	
	@Column(name="note")
	private String note;

	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private Type type = Type.ASSETS;
	
	@ManyToOne
	@JoinColumn(name="fk_gl_account_parent")
	private GLAccount parent;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="parent",cascade=CascadeType.REMOVE,orphanRemoval=true)
	@OrderBy("number ASC")
	private Set<GLAccount> members = new HashSet<GLAccount>();
}
