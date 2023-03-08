/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="invoice_work_effort_billing")
public class WorkEffortBilling implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ONE;
	
	@Column(name="percent")
	private BigDecimal percent = BigDecimal.ONE;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="work_effort_id")),
		@AttributeOverride(name="value",column=@Column(name="work_effort_value"))
	})
	private IDValueRef effort;
	
	@ManyToOne
	@JoinColumn(name="fk_invoice_item")
	private InvoiceItem item;
	
	@Version
	private Long version;
	
	public WorkEffortBilling(){}
}
