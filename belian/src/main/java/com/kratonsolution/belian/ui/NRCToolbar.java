/**
 * 
 */
package com.kratonsolution.belian.ui;

import java.util.Iterator;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Row;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.ui.util.RowUtils;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class NRCToolbar extends Toolbar
{
	private Toolbarbutton newData = new Toolbarbutton("New","/icons/new.png");
	
	private Toolbarbutton remove = new Toolbarbutton("Remove","/icons/delete.png");
	
	private Toolbarbutton clear = new Toolbarbutton("Clear","/icons/refresh.png");
	
	private Grid parent;
	
	public NRCToolbar(Grid grid)
	{
		this.parent = grid;
		setHeight("40px");
		appendChild(newData);
		appendChild(remove);
		appendChild(clear);
		
		getRemove().addEventListener(Events.ON_CLICK,new RemoveListener());
		getClear().addEventListener(Events.ON_CLICK,new ClearListener());
	}
	
	public NRCToolbar()
	{
		this(null);
	}
	
	public Toolbarbutton getNew()
	{
		return newData;
	}
	
	public Toolbarbutton getRemove()
	{
		return remove;
	}
	
	public Toolbarbutton getClear()
	{
		return clear;
	}
	
	private class RemoveListener implements EventListener<Event>
	{
		@Override
		public void onEvent(Event event) throws Exception
		{
			if(parent != null)
			{
				Iterator<Component> iterator = parent.getRows().getChildren().iterator();
				while (iterator.hasNext())
				{
					Row row = (Row) iterator.next();
					if(RowUtils.isChecked(row, 0))
						iterator.remove();
				}
			}
		}
	}
	
	private class ClearListener implements EventListener<Event>
	{
		@Override
		public void onEvent(Event event) throws Exception
		{
			if(parent != null)
				parent.getRows().getChildren().clear();
		}
	}
	
	public void disabled()
	{
		newData.setDisabled(true);
		remove.setDisabled(true);
		clear.setDisabled(true);
	}
	
	public void enabled()
	{
		newData.setDisabled(false);
		remove.setDisabled(false);
		clear.setDisabled(false);
	}
}
