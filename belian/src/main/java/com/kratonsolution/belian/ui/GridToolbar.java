/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GridToolbar extends Toolbar
{
	private final Toolbarbutton refresh = new Toolbarbutton("Refresh","/icons/refresh.png");
	
	private final Toolbarbutton newData = new Toolbarbutton("New","/icons/new.png");

	private final Toolbarbutton select = new Toolbarbutton("Select All","/icons/selectall.png");
	
	private final Toolbarbutton deselect = new Toolbarbutton("Deselect All","/icons/deselect.png");
	
	private final Toolbarbutton delete = new Toolbarbutton("Remove","/icons/delete.png");
	
	private final Toolbarbutton search = new Toolbarbutton("Search","/icons/search.png");
	
	public GridToolbar()
	{
		setWidth("100%");
		setLeft("0px");
		setHeight("20%");
		
		appendChild(refresh);
		appendChild(newData);
		appendChild(select);
		appendChild(delete);
	}
	
	public Toolbarbutton getRefresh()
	{
		return this.refresh;
	}
	
	public Toolbarbutton getNew()
	{
		return this.newData;
	}
	
	public Toolbarbutton getSelect()
	{
		return this.select;
	}
	
	public Toolbarbutton getDeselect()
	{
		return this.deselect;
	}
	
	public Toolbarbutton getDelete()
	{
		return this.delete;
	}

	public Toolbarbutton getNewData()
	{
		return newData;
	}

	public Toolbarbutton getSearch()
	{
		return search;
	}
}
