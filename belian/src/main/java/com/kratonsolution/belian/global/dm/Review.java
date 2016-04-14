/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.io.Serializable;
import java.sql.Date;
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

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="review")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Review implements Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();

	@Column(name="date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	protected EconomicAgent party;
	
	@Column(name="result")
	protected String result;
	
	@Version
	protected Long version;
	
	public Review(){}
	
	public abstract ApproveAndReviewable getDocument();
}
