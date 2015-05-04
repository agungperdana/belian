/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kratonsolution.belian.general.dm.Organization;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="journal_entry")
public class JournalEntry implements Serializable
{
	@Id
	private String id;

	@Column(name="date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization owner;
	
	@ManyToOne
	@JoinColumn(name="fk_currency")
	private Currency currency;
}
