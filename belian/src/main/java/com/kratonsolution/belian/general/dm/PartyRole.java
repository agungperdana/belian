/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="party_role")
public class PartyRole
{
	@Id
	private String id;
	
	@Column(name="date_from",nullable=false)
	private Date from;
	
	@Column(name="date_to")
	private Date to;
	
	@ManyToOne
	@JoinColumn(name="fk_party_role_type")
	private PartyRoleType type;
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	private Party party;
	
	@Version
	private Long version;
}
