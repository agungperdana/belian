/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listbox;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.api.dm.Observable;
import com.kratonsolution.belian.api.dm.Observer;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class AbstractList<T> extends Listbox implements Observable
{
	protected SessionUtils utils = Springs.get(SessionUtils.class);
	
	protected Language lang = Springs.get(Language.class);
	
	protected Map<String,T> maps = new HashMap<>();
	
	protected Set<ListSelectionListener<T>> listeners = new HashSet<ListSelectionListener<T>>();
	
	protected Vector<Observer> observers = new Vector<>();
	
	public abstract T getDomain();
	
	public abstract IDValueRef getDomainAsRef();
	
	public abstract void setDomain(T domain);
	
	public abstract void setDomainAsRef(IDValueRef ref);
	
	public AbstractList()
	{
		setMold("select");
		
		addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				for(Observer observer:observers)
					observer.valueChange(getDomainAsRef());
			}
		});
	}
	
	public void addListSelectionListener(ListSelectionListener<T> listener)
	{
		if(listener != null)
			listeners.add(listener);
	}
	
	@Override
	public void addObserver(Observer observer)
	{
		if(observer != null)
		{
			observers.add(observer);
			observer.valueChange(getDomainAsRef());
		}
	}
}
