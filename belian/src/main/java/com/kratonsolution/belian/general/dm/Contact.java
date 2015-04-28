/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.global.dm.EconomicAgent;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="contact")
public class Contact
{
	public enum Type{CELLPHONE,HOMEPHONE,OFFICEPHONE,PAGER,EMAIL,POSTBOX}
	
	@Id
	private String id;
	
	@Column(name="contact",nullable=false)
	private String contact;

	@Column(name="type",nullable=false)
	@Enumerated(EnumType.STRING)
	private Type type = Type.OFFICEPHONE;
	
	@Column(name="active")
	private boolean active;

	@ManyToOne
	@JoinColumn(name="fk_party")
	private EconomicAgent party;
	
	@Version
	private Long version;
}
