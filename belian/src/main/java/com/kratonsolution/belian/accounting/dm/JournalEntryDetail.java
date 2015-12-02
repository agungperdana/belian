/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.math.BigDecimal;
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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="journal_entry_detail")
public class JournalEntryDetail
{
	public enum Type{DEBET,CREDIT}
	
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_gl_account")
	@NotFound(action=NotFoundAction.IGNORE)
	private GLAccount account;

	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private Type type = Type.DEBET;
	
	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ZERO;
	
	@Column(name="note")
	private String note;

	@ManyToOne
	@JoinColumn(name="fk_journal_entry")
	private JournalEntry journal;
	
	@ManyToOne
	@JoinColumn(name="fk_journal_posting")
	@NotFound(action=NotFoundAction.IGNORE)
	private JournalPosting posting;
	
	@Version
	private Long version;
	
	public static JournalEntryDetail DEBET(GLAccount account,BigDecimal amount,String note)
	{
		JournalEntryDetail detail = new JournalEntryDetail();
		detail.setAccount(account);
		detail.setAmount(amount);
		detail.setNote(note);
		detail.setType(Type.DEBET);
		
		return detail;
	}
	
	public static JournalEntryDetail CREDIT(GLAccount account,BigDecimal amount,String note)
	{
		JournalEntryDetail detail = new JournalEntryDetail();
		detail.setAccount(account);
		detail.setAmount(amount);
		detail.setNote(note);
		detail.setType(Type.CREDIT);
		
		return detail;
	}
}
