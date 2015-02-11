/**
 * 
 */
package com.kratonsolution.belian.ui.party;

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
	private Treeitem roleRoot = new Treeitem();
	private Treeitem relationRoot = new Treeitem();
	
	private Treecell address = new Treecell("Address");
	private Treecell contact = new Treecell("Contacts");
	private Treecell role = new Treecell("Role");
	private Treecell relation = new Treecell("Relationship");
	
	private Treerow addressContent = new Treerow();
	private Treerow contactContent = new Treerow();
	private Treerow roleContent = new Treerow();
	private Treerow relationContent = new Treerow();
	
	private Treechildren root = new Treechildren();
	private Treechildren addresses = new Treechildren();
	private Treechildren contacts = new Treechildren();
	private Treechildren roles = new Treechildren();
	private Treechildren relationships = new Treechildren();
	
	public PartyInformation(String label)
	{
		column1.setLabel(label);
		
		treecols.appendChild(column1);
		treecols.appendChild(column2);
		
		address.setImage("/icons/address.png");
		contact.setImage("/icons/contact.png");
		role.setImage("/icons/roletypesmall.png");
		relation.setImage("/icons/relationshiptype.png");
		
		addressContent.appendChild(address);
		contactContent.appendChild(contact);
		roleContent.appendChild(role);
		relationContent.appendChild(relation);
		
		addressRoot.appendChild(addressContent);
		contactRoot.appendChild(contactContent);
		roleRoot.appendChild(roleContent);
		relationRoot.appendChild(relationContent);
		
		root.appendChild(addressRoot);
		root.appendChild(contactRoot);
		root.appendChild(roleRoot);
		root.appendChild(relationRoot);
		
		addressRoot.appendChild(addresses);
		contactRoot.appendChild(contacts);
		roleRoot.appendChild(roles);
		relationRoot.appendChild(relationships);
		
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
	
	public void addRole(RoleInformation information)
	{
		this.roles.appendChild(information);
	}
	
	public void addRelationship(ContactInformation information)
	{
		this.relationships.appendChild(information);
	}
	
	public void refresh()
	{
		((Refreshable)getParent()).refresh();
	}
}
