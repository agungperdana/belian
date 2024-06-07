
package com.kratonsolution.belian.invoice.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.common.orm.IDValueRef;

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
