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
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Organization;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="approve_and_reviewable")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class ApproveAndReviewable implements Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="number")
	protected String number;
	
	@Column(name="comment")
	protected String comment;

	@ManyToOne
	@JoinColumn(name="fk_organization_requested")
	protected Organization organization;
	
	@ManyToOne
	@JoinColumn(name="fk_last_status")
	protected Statuses lastStatus;
	
	@Version
	protected Long version;
	
	public abstract Date getDate();
	
	public abstract Set<? extends Review> getReviews();
	
	public abstract Set<? extends ApproveAndReviewableItem> getItems();

	public abstract Set<? extends Statuses> getStatuses();
	
	public abstract Set<? extends Roled> getRoles();
	
	public abstract String getName();
	
	public abstract Statuses createStatus();

	public abstract Review createReview();
	
	public boolean isDone()
	{
		return (lastStatus != null && (lastStatus.getType().equals(StatusType.Approved) || lastStatus.getType().equals(StatusType.Rejected)));
	}
}
