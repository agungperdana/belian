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

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.global.dm.Listable;

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
@Table(name="organization_gl_account")
public class OGLAccount implements Serializable,Listable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="is_selected")
	private boolean selected;

	@ManyToOne
	@JoinColumn(name="fk_account")
	@NotFound(action=NotFoundAction.IGNORE)
	private GLAccount account;

	@ManyToOne
	@JoinColumn(name="fk_organization_account")
	@NotFound(action=NotFoundAction.IGNORE)
	private OrganizationAccount parent;

	@Version
	private Long version;

	@OneToMany(mappedBy="account",fetch=FetchType.EAGER)
	private Set<JournalPosting> postings = new HashSet<>();

	public OGLAccount(){}

	@Override
	public String getLabel()
	{
		return this.account.getName();
	}

	@Override
	public String getValue()
	{
		return this.id;
	}

	public BigDecimal getDebet(Date start,Date end)
	{
		BigDecimal debet = BigDecimal.ZERO;

		for(JournalPosting posting:postings)
		{
			if(posting.getType().equals(JournalEntryDetailType.DEBET) && DateTimes.inRange(posting.getDate(), start, end))
				debet = debet.add(posting.getAmount());
		}

		return debet;
	}

	public BigDecimal getCredit(Date start,Date end)
	{
		BigDecimal credit = BigDecimal.ZERO;

		for(JournalPosting posting:postings)
		{
			if(posting.getType().equals(JournalEntryDetailType.CREDIT) && DateTimes.inRange(posting.getDate(), start, end))
				credit = credit.add(posting.getAmount());
		}

		return credit;
	}
}
