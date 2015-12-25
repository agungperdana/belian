/**
 * 
 */
package com.kratonsolution.belian.ui.general.party;

import org.zkoss.zul.Tree;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treecol;
import org.zkoss.zul.Treecols;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Treerow;

import com.kratonsolution.belian.ui.Refreshable;

/**
 * @author agungdodiperdana
 *
 */
public class PartyInformation extends Tree implements Refreshable
{
	private Treecols treecols = new Treecols();
	
	private Treecol column1 = new Treecol();
	
	private Treecol column2 = new Treecol(null,null,"25px");
	
	private Treeitem addressRoot = new Treeitem();
	private Treeitem contactRoot = new Treeitem();
	
	private Treecell address = new Treecell("Address");
	private Treecell contact = new Treecell("Contacts");
	
	private Treerow addressContent = new Treerow();
	private Treerow contactContent = new Treerow();
	
	private Treechildren root = new Treechildren();
	private Treechildren addresses = new Treechildren();
	private Treechildren contacts = new Treechildren();

	
	public PartyInformation(String label)
	{
		column1.setLabel(label);
		
		treecols.appendChild(column1);
		treecols.appendChild(column2);
		
		address.setImage("/icons/address.png");
		contact.setImage("/icons/contact.png");
		
		addressContent.appendChild(address);
		contactContent.appendChild(contact);
		
		addressRoot.appendChild(addressContent);
		contactRoot.appendChild(contactContent);
		
		root.appendChild(addressRoot);
		root.appendChild(contactRoot);
		
		addressRoot.appendChild(addresses);
		contactRoot.appendChild(contacts);
		
		appendChild(treecols);
		appendChild(root);
	}

	public void addAddress(AddressInformation information)
	{
		this.addresses.appendChild(information);
	}
	
	public void addContact(ContactInformation information)
	{
		this.contacts.appendChild(information);
	}
	
	public void refresh()
	{
		((Refreshable)getParent()).refresh();
	}
}
