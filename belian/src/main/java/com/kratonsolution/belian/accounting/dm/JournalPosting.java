/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
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

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Cacheable
@Table(name="journal_posting")
public class JournalPosting implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Date date;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private JournalEntryDetailType type = JournalEntryDetailType.DEBET;
	
	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ZERO;

	@ManyToOne
	@JoinColumn(name="fk_gl_account_balance")
	private OGLAccount account;
	
	@Version
	private Long version;
	
	public JournalPosting(){}
	
	public BigDecimal getDebet()
	{
		if(type.equals(JournalEntryDetailType.DEBET))
			return amount;
		
		return BigDecimal.ZERO;
	}
	
	public BigDecimal getCredit()
	{
		if(type.equals(JournalEntryDetailType.CREDIT))
			return amount;
		
		return BigDecimal.ZERO;
	}
}
