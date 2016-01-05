/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SearchBox extends Hlayout
{
	private Language language = Springs.get(Language.class);
	
	private Label label = new Label(language.get("label.component.searchbox.search"));
	
	private Textbox text = new Textbox();
	
	public SearchBox(EventListener<InputEvent> event)
	{
		setWidth("100%");
		text.setWidth("500px");
		appendChild(label);
		appendChild(text);
		
		if(event != null)
			addEventListener(Events.ON_CHANGING, event);
	}
}
