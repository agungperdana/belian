/**
 * 
 */
package com.kratonsolution.belian.ui.general.party;

import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
public class PartyToolbar extends Toolbar
{
	private Toolbarbutton address = new Toolbarbutton("New Address","/icons/address.png");
	
	private Toolbarbutton contact = new Toolbarbutton("New Contact","/icons/contact.png");


	public PartyToolbar()
	{
		setHeight("35px");
		
		address.setHeight("30px");
		contact.setHeight("30px");
		
		appendChild(address);
		appendChild(contact);
	}
}
