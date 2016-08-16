/**
 * 
 */
package com.kratonsolution.belian.order.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Party;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Quote implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
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
}
