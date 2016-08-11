/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

import java.io.Serializable;
import java.sql.Timestamp;

import com.kratonsolution.belian.general.dm.Party;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class InvoiceRole implements Serializable
{
	private Timestamp date;
	
	private InvoiceRoleType type;
	
	private Party party;
	
	private Invoice invoice;
	
	public InvoiceRole(){}
}
