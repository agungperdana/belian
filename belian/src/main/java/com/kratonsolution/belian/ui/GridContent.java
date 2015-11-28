/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Foot;
import org.zkoss.zul.Footer;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class GridContent extends Vlayout
{
	protected SessionUtils utils = Springs.get(SessionUtils.class);
	
	protected final GridToolbar gridToolbar = new GridToolbar();
	
	protected final Grid grid = new Grid();

	public GridContent()
	{
		setSpacing("3px");
		setWidth("100%");
		setHeight("100%");
		setStyle("overflow:auto");
	}
	
	protected abstract void initToolbar();
	
	protected abstract void initGrid();

	public void refresh(ListModel model)
	{
		grid.setModel(model);
		Rows rows = grid.getRows();
		for(Object object:rows.getChildren())
		{
			final Row row = (Row)object;
			row.addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					Component parent = getParent();
					if(parent != null)
					{
						if(parent instanceof HasGrid)
							((HasGrid)parent).removeGrid();
					
						if(parent instanceof HasEditForm)
							((HasEditForm)parent).insertEditForm(row);
					}
				}
			});
		}
	}
	
	protected Foot getFoot(int span)
	{
		Foot foot = new Foot();
		Footer footer = new Footer();
		footer.setSpan(span);
		footer.setHeight("30px");
		foot.appendChild(footer);
		
		return foot;
	}
}
