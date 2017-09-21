/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

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

import com.kratonsolution.belian.effort.dm.TimeEntry;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="time_entry_billing")
public class TimeEntryBilling implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_time_entry")
	private TimeEntry entry;
	
	@ManyToOne
	@JoinColumn(name="fk_invoice_item")
	private InvoiceItem invoiceItem;
	
	@Column(name="hour")
	private BigDecimal hour = BigDecimal.ZERO;
	
	@Version
	private Long version;

	public TimeEntryBilling(){}
}
