/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="invoice")
public class Invoice implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Version
	private Long version;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="invoice")
	private Set<InvoiceItem> items = new HashSet<InvoiceItem>();
}
