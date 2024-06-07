
package com.kratonsolution.belian.orders.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.core.party.impl.orm.Party;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="quote")
public class Quote implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="issue_date")
	private Date issueDate;
	
	@Column(name="valid_from")
	private Date validFrom;
	
	@Column(name="valid_to")
	private Date validTo;
	
	@Column(name="type")
	private QuoteType type = QuoteType.Product;
	
	@Column(name="description")	
	private String description;
	
	@ManyToOne
	@JoinColumn(name="fk_issuer")
	private Party issuer;
	
	@ManyToOne
	@JoinColumn(name="fk_receiver")
	private Party receiver;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="quote",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<QuoteItem> items = new HashSet<>();
	
	@OneToMany(mappedBy="quote",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<QuoteTerm> terms = new HashSet<>();
	
	@OneToMany(mappedBy="quote",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<QuoteRole> roles = new HashSet<>();
}
