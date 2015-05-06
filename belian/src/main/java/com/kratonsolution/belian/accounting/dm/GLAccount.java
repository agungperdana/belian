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
@Table(name="gl_account")
public class GLAccount
{
	public enum Type{ASSETS,LIABILITIES,EQUITY,REVENUE,COGS,EXPENSE}
	
	@Id
	private String id;
	
	@Column(name="number",nullable=false,unique=true)
	private String number;
	
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
	private Set<GLAccount> members = new HashSet<GLAccount>();
}
