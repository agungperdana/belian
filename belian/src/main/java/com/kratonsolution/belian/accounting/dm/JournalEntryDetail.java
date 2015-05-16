/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.math.BigDecimal;

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
@Table(name="journal_entry_detail")
public class JournalEntryDetail
{
	public enum Type{DEBET,CREDIT}
	
	@Id
	private String id;
	
	@ManyToOne
	@JoinColumn(name="fk_gl_account")
	private GLAccount account;

	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private Type type = Type.DEBET;
	
	@Column(name="amount")
	private BigDecimal amount;
	
	@Column(name="note")
	private String note;

	@ManyToOne
	@JoinColumn(name="fk_journal_entry")
	private JournalEntry journal;
	
	@Version
	private Long version;
}
