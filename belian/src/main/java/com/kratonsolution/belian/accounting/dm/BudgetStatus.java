/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.io.Serializable;
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

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="budget_status")
public class BudgetStatus implements Serializable
{
	public enum StatusType{REVIEWED,SUBMITTED,APPROVED,REJECTED,NEEDMODIFICATION}
	
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Date date;
	
	@Column(name="description")
	private String description;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private StatusType type = StatusType.SUBMITTED;
	
	@ManyToOne
	@JoinColumn(name="fk_budget")
	private Budget budget;
	
	@Version
	private Long version;
}
