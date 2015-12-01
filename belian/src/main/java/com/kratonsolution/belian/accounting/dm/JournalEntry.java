/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Organization;

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
@Table(name="journal_entry")
public class JournalEntry implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="date")
	private Date date;
	
	@Column(name="total_debet")
	private BigDecimal debet;
	
	@Column(name="total_credit")
	private BigDecimal credit;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization owner;
	
	@ManyToOne
	@JoinColumn(name="fk_organization_account")
	private OrganizationAccount coa;
	
	@ManyToOne
	@JoinColumn(name="fk_accounting_period")
	private AccountingPeriod period;
	
	@ManyToOne
	@JoinColumn(name="fk_currency")
	private Currency currency;
	
	@Column(name="note")
	private String note;
	
	@Column(name="is_posted")
	private boolean posted;
	
	@Column(name="is_auto")
	private boolean auto;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="journal",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("type DESC")
	private Set<JournalEntryDetail> journals = new HashSet<JournalEntryDetail>();
	
	public void addDetail(JournalEntryDetail detail)
	{
		detail.setJournal(this);
		journals.add(detail);
	}
}
