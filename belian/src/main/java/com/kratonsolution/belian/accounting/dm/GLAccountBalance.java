/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
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

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="gl_account_balance")
public class GLAccountBalance implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_accounting_period")
	@NotFound(action=NotFoundAction.IGNORE)
	private AccountingPeriod period;
	
	@ManyToOne
	@JoinColumn(name="fk_gl_account")
	@NotFound(action=NotFoundAction.IGNORE)
	private GLAccount account;
	
	@ManyToOne
	@JoinColumn(name="fk_currency")
	@NotFound(action=NotFoundAction.IGNORE)
	private Currency currency;
	
	@Column(name="debet_balance")
	private BigDecimal debet;
	
	@Column(name="credit_balance")
	private BigDecimal credit;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="account")
	@OrderBy("date ASC")
	private Set<JournalPosting> postings = new HashSet<JournalPosting>();
	
	@Version
	private Long version;
	
	public GLAccountBalance(){}
	
	public void post(JournalEntryDetail journal)
	{
		if(journal != null)
		{
			JournalPosting posting = new JournalPosting();
			posting.setAccount(this);
			posting.setAmount(journal.getAmount());
			posting.setDate(journal.getJournal().getDate());
			posting.setType(journal.getType());
			
			postings.add(posting);
			
			if(journal.getType().equals(JournalEntryDetail.Type.DEBET))
				debet = debet.add(journal.getAmount());
			else 
				credit = credit.add(journal.getAmount());
			
			journal.setPosting(posting);
		}
	}
	
	public void unpost(JournalEntryDetail journal)
	{
		if(journal != null && journal.getPosting() != null && journal.getPosting().getAccount().getId().equals(id))
		{
			if(journal.getType().equals(JournalEntryDetail.Type.DEBET))
				debet = debet.subtract(journal.getAmount());
			else 
				credit = credit.subtract(journal.getAmount());
			
			Iterator<JournalPosting> iterator = postings.iterator();
			while (iterator.hasNext())
			{
				JournalPosting posting = (JournalPosting) iterator.next();
				if(posting.getId().equals(journal.getPosting().getId()))
				{
					iterator.remove();
					break;
				}
			}
		}
	}
}
