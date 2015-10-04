/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.tools.dm.Inbox;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="review_result")
public abstract class ReviewResult extends Inbox
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
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	protected Type type = Type.WAITING;
	
	@Column(name="comment")
	protected String comment;
	
	@ManyToOne
	@JoinColumn(name="fk_reviewable")
	protected Reviewable reviewable;
}
