/**
 * 
 */
package com.kratonsolution.belian.ui.positiontyperate;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.event.PagingEvent;

import com.kratonsolution.belian.hr.svc.PositionTypeRateService;
import com.kratonsolution.belian.ui.GridContent;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PositionTypeRateGridContent extends GridContent
{
	private final PositionTypeRateService service = Springs.get(PositionTypeRateService.class);
	
	public PositionTypeRateGridContent()
	{
		super();
		initToolbar();
		initGrid();
	}
	
	protected void initToolbar()
	{
		gridToolbar.setParent(this);
		gridToolbar.getRefresh().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				grid.getPagingChild().setActivePage(0);
				grid.setModel(new PositionTypeRateModel(8));
			}
		});
		
		gridToolbar.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PositionTypeRateWindow window = (PositionTypeRateWindow)getParent();
				window.removeGrid();
				window.insertCreateForm();
			}
		});
		
		gridToolbar.getSelect().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Rows rows = grid.getRows();
				for(Object object:rows.getChildren())
				{
					Row row = (Row)object;
					
					if(row.getFirstChild() instanceof Checkbox)
					{
						Checkbox checkbox = (Checkbox)row.getFirstChild();
						checkbox.setChecked(true);
					}
					
					gridToolbar.removeChild(gridToolbar.getSelect());
					gridToolbar.insertBefore(gridToolbar.getDeselect(),gridToolbar.getDelete());
				}
			}
		});
		
		gridToolbar.getDeselect().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Rows rows = grid.getRows();
				for(Object object:rows.getChildren())
				{
					Row row = (Row)object;
					if(row.getFirstChild() instanceof Checkbox)
					{
						Checkbox checkbox = (Checkbox)row.getFirstChild();
						checkbox.setChecked(false);						
					}
				
					gridToolbar.removeChild(gridToolbar.getDeselect());
					gridToolbar.insertBefore(gridToolbar.getSelect(),gridToolbar.getDelete());
				}
			}
		});
		
		gridToolbar.getDelete().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Messagebox.show("Are you sure want to remove the data(s) ?","Warning",Messagebox.CANCEL|Messagebox.OK, Messagebox.QUESTION,new EventListener<Event>()
				{
					@Override
					public void onEvent(Event event) throws Exception
					{
						if(event.getName().equals("onOK"))
						{
							for(Object object:grid.getRows().getChildren())
							{
								Row row = (Row)object;

								if(RowUtils.isChecked(row,0))
									service.delete(RowUtils.string(row, 4));
							}
							
							PositionTypeRateWindow window = (PositionTypeRateWindow)getParent();
							window.removeGrid();
							window.insertGrid();
						}
					}
				});
			}
		});
		
		gridToolbar.getSearch().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
			}
		});

	}
	
	protected void initGrid()
	{
		final PositionTypeRateModel model = new PositionTypeRateModel(8);
		
		grid.setParent(this);
		grid.setHeight("80%");
		grid.setEmptyMessage("No Position Type Rate data exist.");
		grid.setModel(model);
		grid.setRowRenderer(new PositionTypeRateRowRenderer());
		grid.setPagingPosition("both");
		grid.setMold("paging");
		grid.setPageSize(25);
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"25px"));
		grid.getColumns().appendChild(new Column("Start",null,"85px"));
		grid.getColumns().appendChild(new Column("End",null,"85px"));
		grid.getColumns().appendChild(new Column("Position",null,"135px"));
		grid.getColumns().appendChild(new Column("Rate Type",null,"135px"));
		grid.getColumns().appendChild(new Column("Period",null,"135px"));
		grid.getColumns().appendChild(new Column("Amount",null,"135px"));
		grid.getColumns().appendChild(new Column(null,null,"1px"));
		grid.getColumns().getChildren().get(7).setVisible(false);
		
		grid.addEventListener("onPaging",new EventListener<PagingEvent>()
		{
			@Override
			public void onEvent(PagingEvent event) throws Exception
			{
				model.next(event.getActivePage(), 25);
				grid.setModel(model);
			}
		});
		
		Rows rows = grid.getRows();
		for(Object object:rows.getChildren())
		{
			final Row row = (Row)object;
			row.addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					PositionTypeRateWindow window = (PositionTypeRateWindow)getParent();
					window.removeGrid();
					window.insertEditForm(row);
				}
			});
		}
	}
}