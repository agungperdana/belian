
package com.kratonsolution.belian.invoice.dm;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="sales_invoice")
public class SalesInvoice extends Invoice
{

}
