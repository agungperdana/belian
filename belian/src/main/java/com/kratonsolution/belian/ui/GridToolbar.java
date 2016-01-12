/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GridToolbar extends Toolbar
{
	private Language language = Springs.get(Language.class);
	
	private final Toolbarbutton refresh = new Toolbarbutton(language.get("label.component.button.refresh"),"/icons/refresh.png");
	
	private final Toolbarbutton newData = new Toolbarbutton(language.get("label.component.button.new"),"/icons/new.png");

	private final Toolbarbutton select = new Toolbarbutton(language.get("label.component.button.selectall"),"/icons/selectall.png");
	
	private final Toolbarbutton deselect = new Toolbarbutton(language.get("label.component.button.deselectall"),"/icons/deselect.png");
	
	private final Toolbarbutton delete = new Toolbarbutton(language.get("label.component.button.delete"),"/icons/delete.png");
	
	private final Toolbarbutton search = new Toolbarbutton(language.get("label.component.button.refresh"),"/icons/search.png");
	
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
	
	public void disabled()
	{
		refresh.setDisabled(true);
		newData.setDisabled(true);
		select.setDisabled(true);
		deselect.setDisabled(true);
		search.setDisabled(true);
	}
	
	public void enabled()
	{
		refresh.setDisabled(false);
		newData.setDisabled(false);
		select.setDisabled(false);
		deselect.setDisabled(false);
		search.setDisabled(false);
	}
}
