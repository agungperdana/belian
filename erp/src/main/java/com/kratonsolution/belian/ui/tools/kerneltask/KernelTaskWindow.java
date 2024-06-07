
package com.kratonsolution.belian.ui.tools.kerneltask;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.common.app.Language;
import com.kratonsolution.belian.tools.view.KernelTask;
import com.kratonsolution.belian.tools.view.Watchable;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class KernelTaskWindow extends Window
{
	private Language lang = Springs.get(Language.class);
	
	private KernelTask task = Springs.get(KernelTask.class);
	
	private Grid grid = new Grid();
	
	public KernelTaskWindow()
	{
		setClosable(true);
		setBorder(true);
		setWidth("300px");
		setHeight("500px");
		setPosition("center");
		
		init();
	}
	
	private void init()
	{
		Caption caption = new Caption();
		caption.setLabel(lang.get("navbar.menu.kernel"));
		caption.setImage("/icons/kernel32.png");
		
		grid.appendChild(new Columns());
		grid.appendChild(new Rows());
		grid.getColumns().appendChild(new Column(null,null, "25px"));
		grid.getColumns().appendChild(new Column(null,null, "35px"));
		grid.getColumns().appendChild(new Column(lang.get("module.grid.column.name"),null, "250px"));
		grid.setSpan("2");
		grid.setWidth("100%");
		
		populate(grid);
		
		Toolbar toolbar = new Toolbar();
		toolbar.appendChild(new Toolbarbutton("","/icons/refresh.png"));
		toolbar.appendChild(new Toolbarbutton("","/icons/delete.png"));
		
		toolbar.getChildren().get(0).addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				populate(grid);
			}
		});
		
		toolbar.getChildren().get(1).addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				for(Component com:grid.getRows().getChildren())
				{
					Row row = (Row)com;
					
					Checkbox checkbox = (Checkbox)row.getChildren().get(0);
					if(checkbox.isChecked())
						task.kill(checkbox.getAttribute("win_name").toString());
				}
				
				populate(grid);
			}
		});
		
		Vlayout vlayout = new Vlayout();
		vlayout.setHflex("1");
		vlayout.appendChild(toolbar);
		vlayout.appendChild(grid);
		
		appendChild(caption);
		appendChild(vlayout);
	}

	private void populate(Grid grid)
	{
		grid.getRows().getChildren().clear();
		
		for(Watchable watchable:task.list())
		{
			Image image = new Image(watchable.getIcon());
			image.setWidth("16px");
			image.setHeight("16px");
			
			Checkbox checkbox = new Checkbox();
			checkbox.setAttribute("win_name", watchable.getName());
			
			Row row = new Row();
			row.appendChild(checkbox);
			row.appendChild(image);
			row.appendChild(new Label(watchable.getName()));
			
			grid.getRows().appendChild(row);
		}
	}
	
	@Override
	public void onClose()
	{
		setVisible(false);
	}
	
	@Override
	public void doOverlapped()
	{
		super.doOverlapped();
		populate(grid);
	}
}
