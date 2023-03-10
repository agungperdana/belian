
package com.kratonsolution.belian.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Row;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.persistence.IDValueRef;
import com.kratonsolution.belian.common.persistence.Observable;
import com.kratonsolution.belian.common.persistence.Observer;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class NRCToolbar extends Toolbar implements Observable
{
	private Language lang = Springs.get(Language.class);
	
	private Toolbarbutton newData = new Toolbarbutton(lang.get("label.component.button.new"),"/icons/new.png");
	
	private Toolbarbutton remove = new Toolbarbutton(lang.get("label.component.button.delete"),"/icons/delete.png");
	
	private Toolbarbutton clear = new Toolbarbutton(lang.get("label.component.button.clear"),"/icons/refresh.png");
	
	private Grid parent;
	
	private List<Observer> observers = new ArrayList<>();
	
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
			
				for(Observer observer:observers)
					observer.valueChange(IDValueRef.empty());
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

	@Override
	public void addObserver(Observer observer)
	{
		if(observer != null)
			observers.add(observer);
	}
}
