/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.kratonsolution.belian.general.dm.Address;
import com.kratonsolution.belian.general.dm.Contact;
import com.kratonsolution.belian.general.dm.Party;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
public class Invoice implements Serializable
{
	private String id = UUID.randomUUID().toString();
	
	private Party sender;
	
	private Party receiver;
	
	private Address senderAddress;
	
	private Address receiverAddress;

	private Contact senderContact;
	
	private Contact receiverContact;

	private Set<InvoiceItem> items = new HashSet<>();
	
	private Set<InvoiceRole> roles = new HashSet<>();

	private Set<InvoiceStatus> statuses = new HashSet<>();
	
	private Set<InvoiceTerm> terms = new HashSet<>();
}
