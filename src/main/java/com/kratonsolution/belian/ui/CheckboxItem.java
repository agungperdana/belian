/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CheckboxItem extends Listitem
{
	private String id;
	
	private String label;
	
	private Checkbox checkbox = new Checkbox();
	
	public CheckboxItem(String id,String label)
	{
		this.id = id;
		this.label = label;
		
		this.checkbox.setLabel(" "+label);
		Listcell list1 = new Listcell();
		list1.appendChild(checkbox);
		
		appendChild(list1);
	}
	
	public boolean isSelected()
	{
		return checkbox.isChecked();
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public void selected()
	{
		this.checkbox.setChecked(true);
	}
}
