/**
 * 
 */
package com.kratonsolution.belian.ui.party;

import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

/**
 * @author agungdodiperdana
 *
 */
public class PartyToolbar extends Toolbar
{
	private Toolbarbutton address = new Toolbarbutton("New Address","/icons/address.png");
	
	private Toolbarbutton contact = new Toolbarbutton("New Contact","/icons/contact.png");

	private Toolbarbutton role = new Toolbarbutton("New Role","/icons/roletypesmall.png");

	private Toolbarbutton relationship = new Toolbarbutton("New Relationship","/icons/relationshiptype.png");


	public PartyToolbar()
	{
		setHeight("35px");
		
		address.setHeight("30px");
		contact.setHeight("30px");
		role.setHeight("30px");
		relationship.setHeight("30px");
		
		appendChild(address);
		appendChild(contact);
		appendChild(role);
		appendChild(relationship);
	}


	public Toolbarbutton getAddress()
	{
		return address;
	}


	public Toolbarbutton getContact()
	{
		return contact;
	}


	public Toolbarbutton getRole()
	{
		return role;
	}


	public Toolbarbutton getRelationship()
	{
		return relationship;
	}
}
