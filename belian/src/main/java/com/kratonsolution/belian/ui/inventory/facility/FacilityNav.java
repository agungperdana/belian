/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.facility;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.ui.Navigation;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class FacilityNav extends Navigation
{
	private Toolbarbutton organization = new Toolbarbutton(lang.get("facility.grid.column.org"),"/icons/organization32.png");
	
	private Toolbarbutton container = new Toolbarbutton(lang.get("facility.grid.column.containers"),"/icons/container32.png");
	
	public FacilityNav()
	{
		super();
		
		container.setOrient("vertical");
		container.setStyle("text-align:center;font-size:9px;");
		container.setWidth("55px");
		container.setHeight("55px");
		
		organization.setOrient("vertical");
		organization.setStyle("text-align:center;font-size:9px;");
		organization.setWidth("55px");
		organization.setHeight("55px");

		appendChild(organization);
		appendChild(container);

	}
	
	public void setAddMode(boolean addmode)
	{
		container.setDisabled(addmode);
		organization.setDisabled(addmode);
	}
}
