/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

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
@Table(name="accounting_period")
public class AccountingPeriod
{
	public enum Month{January,February,March,April,May,June,July,August,September,October,November,December}
	
	@Id
	private String id;
	
	@Column(name="number",nullable=false,unique=true)
	private String number;
	
	@Column(name="name",nullable=false,unique=true)
	private String name;
	
	@Column(name="date_from")
	private Date from;
	
	@Column(name="date_to")
	private Date to;
	
	@Column(name="month")
	@Enumerated(EnumType.STRING)
	private Month month = Month.January;
	
	@ManyToOne
	@JoinColumn(name="fk_accounting_period_parent")
	private AccountingPeriod parent;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="parent",cascade=CascadeType.REMOVE,orphanRemoval=true)
	@OrderBy("number ASC")
	private List<AccountingPeriod> members = new ArrayList<AccountingPeriod>();
}
