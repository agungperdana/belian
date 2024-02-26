/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zul.Menupopup;
import org.zkoss.zul.Menuseparator;

import com.kratonsolution.belian.ui.general.companystructure.CompanyStructureMenu;
import com.kratonsolution.belian.ui.general.country.CountryMenu;
import com.kratonsolution.belian.ui.general.geographic.GeographicMenu;
import com.kratonsolution.belian.ui.general.organization.OrganizationMenu;
import com.kratonsolution.belian.ui.general.person.PersonMenu;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class General extends AbstractMenu
{
	private CountryMenu country = new CountryMenu();
	
	private GeographicMenu geographic = new GeographicMenu();
	
	private OrganizationMenu organization = new OrganizationMenu();
	
	private PersonMenu person = new PersonMenu();
	
	private CompanyStructureMenu structure = new CompanyStructureMenu();
	
	public General()
	{
		setLabel(lang.get("navbar.menu.general"));
		setImage("/icons/general16.png");
		
		Menupopup popup = new Menupopup();
		
		if(!country.isDisabled())
		{
			popup.appendChild(country);
			popup.appendChild(new Menuseparator());
		}
		
		if(!geographic.isDisabled())
		{
			popup.appendChild(geographic);
			popup.appendChild(new Menuseparator());
		}

		if(!organization.isDisabled())
		{
			popup.appendChild(organization);
			popup.appendChild(new Menuseparator());
		}
		
		if(!person.isDisabled())
		{
			popup.appendChild(person);
			popup.appendChild(new Menuseparator());
		}

		if(!structure.isDisabled())
			popup.appendChild(structure);
		
		if(!popup.getChildren().isEmpty())
			appendChild(popup);
	}
}
