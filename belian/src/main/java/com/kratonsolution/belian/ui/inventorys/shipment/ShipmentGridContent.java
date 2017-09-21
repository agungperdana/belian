/**
 * 
 */
package com.kratonsolution.belian.ui.inventorys.shipment;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.event.PagingEvent;
import org.zkoss.zul.event.ZulEvents;

import com.kratonsolution.belian.shipment.svc.ShipmentService;
import com.kratonsolution.belian.ui.GridContent;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ShipmentGridContent extends GridContent
{
	private ShipmentService service = Springs.get(ShipmentService.class);

	public ShipmentGridContent()
	{
		super();
		initToolbar();
		initGrid();
	}

	protected void initToolbar()
	{
		appendChild(toolbar);
		
		toolbar.getRefresh().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new ShipmentGridContent());
			}
		});

		toolbar.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new ShipmentFormContent());
			}
		});

		toolbar.getSelect().addEventListener(Events.ON_CLICK,new EventListener<Event>()
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

					toolbar.removeChild(toolbar.getSelect());
					toolbar.insertBefore(toolbar.getDeselect(),toolbar.getDelete());
				}
			}
		});

		toolbar.getDeselect().addEventListener(Events.ON_CLICK,new EventListener<Event>()
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

					toolbar.removeChild(toolbar.getDeselect());
					toolbar.insertBefore(toolbar.getSelect(),toolbar.getDelete());
				}
			}
		});

		toolbar.getDelete().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Messagebox.show(lang.get("message.removedata"),"Warning",Messagebox.CANCEL|Messagebox.OK, Messagebox.QUESTION,new EventListener<Event>()
				{
					@Override
					public void onEvent(Event event) throws Exception
					{
						if(event.getName().equals("onOK"))
						{
							for(Object object:grid.getRows().getChildren())
							{
								Row row = (Row)object;
								if(RowUtils.isChecked(row))
									service.delete(RowUtils.id(row));
							}

							Flow.next(getParent(), new ShipmentGridContent());
						}
					}
				});
			}
		});

		toolbar.getSearch().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
			}
		});

	}

	protected void initGrid()
	{
		filter.setPlaceholder(lang.get("message.filter.placeholder"));

		appendChild(filter);
		appendChild(grid);

		filter.addEventListener(Events.ON_CHANGING, new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent input) throws Exception
			{
				grid.setModel(new ShipmentModel(utils.getRowPerPage(), input.getValue()));
			}
		});

		final ShipmentModel model = new ShipmentModel(utils.getRowPerPage(),filter.getText());

		grid.setHeight("80%");
		grid.setEmptyMessage(lang.get("message.grid.empty"));
		grid.setModel(model);
		grid.setRowRenderer(new ShipmentRowRenderer());
		grid.setPagingPosition("both");
		grid.setMold("paging");
		grid.setPageSize(utils.getRowPerPage());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"25px"));
		grid.getColumns().appendChild(new Column(lang.get("shipment.grid.column.number"),null,"125px"));
		grid.getColumns().appendChild(new Column(lang.get("shipment.grid.column.entrydate"),null,"100px"));
		grid.getColumns().appendChild(new Column(lang.get("shipment.grid.column.shipfromparty"),null,"250px"));
		grid.getColumns().appendChild(new Column(lang.get("shipment.grid.column.shiptoparty"),null,"250px"));
		grid.getColumns().appendChild(new Column(lang.get("shipment.grid.column.type"),null,"150px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().getLastChild().setVisible(false);
		grid.setSpan("4");
		grid.addEventListener(ZulEvents.ON_AFTER_RENDER, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Grid target = (Grid)event.getTarget();
				for(Component com:target.getRows().getChildren())
				{
					com.addEventListener(Events.ON_CLICK,new EventListener<Event>()
					{
						@Override
						public void onEvent(Event ev) throws Exception
						{
							Flow.next(getParent(), new ShipmentEditContent((Row)ev.getTarget()));
						}
					});
				}
			}
		});
		grid.addEventListener("onPaging",new EventListener<PagingEvent>()
		{
			@Override
			public void onEvent(PagingEvent event) throws Exception
			{
				model.next(event.getActivePage(), utils.getRowPerPage(),filter.getText());
				grid.setModel(model);
			}
		});
	}
}