/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="simple_invoice_clinic_item")
public class SimplePharmacyInvoiceItem implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="note")
	private String note;
	
	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ZERO;

	@ManyToOne
	@JoinColumn(name="fk_root")
	private SimplePharmacyInvoice invoice;
	
	@Version
	private Long version;
	
	public SimplePharmacyInvoiceItem(){}
}
