
package com.kratonsolution.belian.ui.component;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;

import com.kratonsolution.belian.common.orm.IDValueRef;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Setter
@Getter
public class ToggleButton extends Button
{	
	private boolean selected;
	
	private IDValueRef model;
	
	public ToggleButton(IDValueRef model,String icon)
	{
		this(model.getValue(),icon);
		this.model = model;
	}
	
	public ToggleButton(String label,String icon)
	{
		setLabel(label);
		setImage(icon);
		
		addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				setSelected(!selected);
				
				if(selected)
					setImage("/icons/check.png");
				else
					setImage(icon);
			}
		});
	}
}
