/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
@Cacheable
@Table(name="journal_entry_detail")
public class JournalEntryDetail implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="reference")
	private String reference;
	
	@Column(name="posting")
	private String posting;
	
	@ManyToOne
	@JoinColumn(name="fk_gl_account")
	@NotFound(action=NotFoundAction.IGNORE)
	private OGLAccount account;

	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private JournalEntryDetailType type = JournalEntryDetailType.DEBET;
	
	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ZERO;
	
	@Column(name="note")
	private String note;

	@ManyToOne
	@JoinColumn(name="fk_journal_entry")
	private JournalEntry journal;
	
	@Version
	private Long version;
	
	public JournalEntryDetail(){}
	
	public static JournalEntryDetail DEBET(OGLAccount account,BigDecimal amount,String note)
	{
		JournalEntryDetail detail = new JournalEntryDetail();
		detail.setAccount(account);
		detail.setAmount(amount);
		detail.setNote(note);
		detail.setType(JournalEntryDetailType.DEBET);
		
		return detail;
	}
	
	public static JournalEntryDetail CREDIT(OGLAccount account,BigDecimal amount,String note)
	{
		JournalEntryDetail detail = new JournalEntryDetail();
		detail.setAccount(account);
		detail.setAmount(amount);
		detail.setNote(note);
		detail.setType(JournalEntryDetailType.CREDIT);
		
		return detail;
	}
}
