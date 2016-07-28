/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.kratonsolution.belian.general.dm.Organization;

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
@Table(name="journal_setting")
public class AutoJournalSetting implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_organization",unique=true)
	@NotFound(action=NotFoundAction.IGNORE)
	private Organization organization;
	
	@Column(name="note")
	private String note;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_auto_journal_sales")
	private AutoJournalSales sales;
	
	@Version
	private Long version;
	
	public AutoJournalSetting(){}
}
