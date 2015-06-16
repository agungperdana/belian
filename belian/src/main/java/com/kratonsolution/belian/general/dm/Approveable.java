/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Table(name="approveable")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="approveable_type")
public abstract class Approveable
{
	public enum Type{BUDGET}
	
	public enum Status{APPROVED,REJECTED,CORRECTION,SUBMITTED}
	
	@Id
	protected String id;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	protected Type type = Type.BUDGET;

	@Column(name="status")
	@Enumerated(EnumType.STRING)
	protected Status status = Status.SUBMITTED;
	
	@Version
	protected Long version;
	
	public abstract <T extends PartyRelationship> T getApprover();
}
