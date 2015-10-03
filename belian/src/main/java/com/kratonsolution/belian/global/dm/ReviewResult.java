/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.general.dm.Person;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="review_result")
public class ReviewResult
{
	public enum Type{
		WAITING("Waiting for Review"),
		ACCEPTED("Accepted"),
		REJECTED("Rejected"),
		NEEDMODIFICATION("Need Modification"),
		SUSPENDED("Suspended");
		
		String display;
		
		private Type(String display)
		{
			this.display = display;
		}
		
		public String display()
		{
			return this.display;
		}
	}
	
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="date")
	private Date date;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private Type type = Type.WAITING;
	
	@Column(name="comment")
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="fk_reviewable")
	private Reviewable reviewable;

	@ManyToOne
	@JoinColumn(name="fk_person_reviewer")
	private Person reviewer;

	@Version
	private Long version;
}
