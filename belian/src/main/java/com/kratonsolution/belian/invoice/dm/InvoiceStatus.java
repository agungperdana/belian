/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class InvoiceStatus implements Serializable
{
	private Date date;
	
	private InvoiceStatusType type;
	
	private Invoice invoice;
}
