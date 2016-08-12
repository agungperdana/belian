/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class InvoiceTerm implements Serializable
{
	private BigDecimal value;
	
	private InvoiceTermType type;
	
	private Invoice invoice;
}
