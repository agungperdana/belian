/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.Person;

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
@Table(name="approveable")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Approveable implements Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="number",unique=true,nullable=true)
	private String number;
	
	@Column(name="date")
	protected Date date;
	
	@Enumerated(EnumType.STRING)
	@Column(name="approver_status")
	protected ApproverStatus approverStatus = ApproverStatus.SUBMITTED;
	
	@Enumerated(EnumType.STRING)
	@Column(name="request_status")
	protected RequestStatus requestStatus = RequestStatus.INCOMPLETE;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	protected Organization organization;
	
	@ManyToOne
	@JoinColumn(name="requester")
	protected Person requester;
	
	@ManyToOne
	@JoinColumn(name="approver")
	protected Person approver;
	
	@Version
	protected Long version;
	
	public abstract String getType();
	
	public abstract Set<? extends ApproveAndReviewableItem> getItems();
	
}
