
package com.kratonsolution.belian.ui.component;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.zkoss.zul.A;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Hbox;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.api.dm.Observable;
import com.kratonsolution.belian.api.dm.Observer;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.tools.view.KernelTask;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class AbstractCombobox<T> extends Hbox implements Observable
{
	protected Language lang = Springs.get(Language.class);

	protected SessionUtils utils = Springs.get(SessionUtils.class);

	protected KernelTask kernel = Springs.get(KernelTask.class);
	
	protected Combobox input = new Combobox();

	protected A link = new A(lang.get("label.component.button.newparty"));

	protected Map<String,T> maps = new HashMap<>();
	
	protected Vector<ListSelectionListener<T>> listeners = new Vector<>();

	protected Vector<Observer> observers = new Vector<>();
	
	public AbstractCombobox(boolean showCreateLink,boolean fullspan)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("400px");

		input.setPlaceholder(lang.get("message.field.iden"));
		input.setAutodrop(true);
		input.setAutocomplete(false);

		if(fullspan)
			input.setHflex("1");
		else
			input.setWidth("290px");

		appendChild(input);

		if(showCreateLink)
			appendChild(link);
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
	
	public void setDisabled()
	{
		input.setDisabled(true);
	}
	
	public void setEnabled()
	{
		input.setDisabled(false);
	}
	
	public boolean isDisabled()
	{
		return input.isDisabled();
	}
	
	public void setReadonly()
	{
		input.setReadonly(true);
	}

	public abstract T getDomain();

	public abstract IDValueRef getDomainAsRef();

	public abstract void setDomain(T domain);

	public abstract void setDomainAsRef(IDValueRef ref);
}
