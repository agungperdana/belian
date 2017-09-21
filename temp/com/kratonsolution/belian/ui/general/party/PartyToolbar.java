/**
 * 
 */
package com.kratonsolution.belian.ui.general.party;

import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
public class PartyToolbar extends Toolbar
{
	private Language lang = Springs.get(Language.class);
	
	private Toolbarbutton address = new Toolbarbutton(lang.get("organization.grid.column.newaddress"),"/icons/address.png");
	
	private Toolbarbutton contact = new Toolbarbutton(lang.get("organization.grid.column.newcontacts"),"/icons/contact.png");


	public PartyToolbar()
	{
		setHeight("35px");
		
		address.setHeight("30px");
		contact.setHeight("30px");
		
		appendChild(address);
		appendChild(contact);
	}
}
