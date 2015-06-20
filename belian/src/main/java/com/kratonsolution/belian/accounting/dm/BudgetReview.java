/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Person;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="budget_review")
public class BudgetReview implements Serializable
{
	public enum ReviewResult{ACCEPTED,REJECTED}
	
	@Id
	private String id;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="review_result")
	@Enumerated(EnumType.STRING)
	private ReviewResult result = ReviewResult.ACCEPTED;
	
	@ManyToOne
	@JoinColumn(name="fk_person_reviewer")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name="fk_budget")
	private Budget budget;
	
	@Version
	private Long version;
}
