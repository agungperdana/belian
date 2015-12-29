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
	private Grid parent;
	
	public NRCToolbar(Grid grid)
	{
		this.parent = grid;
		setHeight("40px");
		appendChild(new Toolbarbutton("New","/icons/new.png"));
		appendChild(new Toolbarbutton("Remove","/icons/delete.png"));
		appendChild(new Toolbarbutton("Clear","/icons/refresh.png"));
		
		getRemove().addEventListener(Events.ON_CLICK,new RemoveListener());
		getClear().addEventListener(Events.ON_CLICK,new ClearListener());
	}
	
	public NRCToolbar()
	{
		this(null);
	}
	
	public Component getNew()
	{
		return getChildren().get(0);
	}
	
	public Component getRemove()
	{
		return getChildren().get(1);
	}
	
	public Component getClear()
	{
		return getChildren().get(2);
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
}
