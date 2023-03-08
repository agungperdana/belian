/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="purchase_invoice")
public class PurchaseInvoice extends Invoice
{

}
