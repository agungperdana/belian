
package com.kratonsolution.belian.ui.component;

import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SearchBox extends Grid
{
	private Language language = Springs.get(Language.class);
	
	private Label label = new Label(language.get("label.component.searchbox"));
	
	private Textbox text = new Textbox();
	
	public SearchBox(EventListener<InputEvent> event)
	{
		text.setWidth("100%");
		setWidth("100%");
		appendChild(new Rows());
		appendChild(new Columns());
		getColumns().appendChild(new Column(null,null,"60px"));
		getColumns().appendChild(new Column());
		setSpan("1");
		getRows().appendChild(RowUtils.row(label,text));	
		
		if(event != null)
			text.addEventListener(Events.ON_CHANGING, event);
	}
}
