
package com.kratonsolution.belian.payments.dm;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Embeddable
public class InvoiceRef
{
	@Column(name="invoice_id")
	private String id;

	@Column(name="invoice_date")
	private Date date;
	
	@Column(name="invoice_number")
	private String number;
	
	@Transient
	private String type;
}
