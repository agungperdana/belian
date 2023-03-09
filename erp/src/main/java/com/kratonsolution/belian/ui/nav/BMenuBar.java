
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zul.Menubar;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BMenuBar extends Menubar
{
	private Belian belian = new Belian();
	
	private Security security = new Security();
	
	private General general = new General();
	
	private Inventory inventory = new Inventory();
	
	private Products products = new Products();
	
	private OrdersMenu orders = new OrdersMenu();
	
	private Accounting accounting = new Accounting();
	
	private Finance finance = new Finance();
	
	private HR hr = new HR();
	
	private Healthcares healtcares = new Healthcares();
	
	public BMenuBar()
	{
		setHflex("1");

		appendChild(belian);
		
		if(!security.getChildren().isEmpty())
			appendChild(security);
		
		if(!general.getChildren().isEmpty())
			appendChild(general);

		if(!products.getChildren().isEmpty())
			appendChild(products);
		
		if(!inventory.getChildren().isEmpty())
			appendChild(inventory);
		
		if(!orders.isDisabled())
			appendChild(orders);
		
		if(!finance.isDisabled())
			appendChild(finance);
		
		if(!accounting.getChildren().isEmpty())
			appendChild(accounting);
		
		if(!hr.getChildren().isEmpty())
			appendChild(hr);
		
		if(!healtcares.isDisabled())
			appendChild(healtcares);
	
		appendChild(new Tools());
	}
	
	public void clear()
	{
		getChildren().clear();
		appendChild(belian);
	}
}