/**
 * 
 */
package com.kratonsolution.belian.ui.general.party;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Setter
public class PartyWindow extends AbstractWindow
{
	private PartyBox box;
	
	public static PartyWindow newInstance(Page page,PartyBox box,boolean isPerson)
	{
		PartyWindow window = new PartyWindow(box,isPerson);
		window.setPage(page);
		window.doOverlapped();
		
		return window;
	}
	
	public PartyWindow(PartyBox box,boolean isPerson)
	{
		super();
		
		caption.setLabel(lang.get("navbar.menu.general.partyreg"));
		caption.setImage("/icons/party32.png");
		
		appendChild(new PartyFormContent(box,isPerson));
	}
}
