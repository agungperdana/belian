/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.inventoryitem;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.event.PagingEvent;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.svc.InventoryItemService;
import com.kratonsolution.belian.ui.GridContent;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class InventoryItemGridContent extends GridContent
{
	private InventoryItemService service = Springs.get(InventoryItemService.class);

	private SessionUtils utils = Springs.get(SessionUtils.class);

	public InventoryItemGridContent()
	{
		super();
		initToolbar();
		initGrid();
	}

	protected void initToolbar()
	{
		appendChild(gridToolbar);
		gridToolbar.getRefresh().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				grid.getPagingChild().setActivePage(0);
				refresh(new InventoryItemModel(utils.getRowPerPage()));
			}
		});

		gridToolbar.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				InventoryItemWindow window = (InventoryItemWindow)getParent();
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
				Messagebox.show("Are you sure want to remove the data(s) ?","Warning",
						Messagebox.CANCEL|Messagebox.OK, Messagebox.QUESTION,new EventListener<Event>()
				{
					@Override
					public void onEvent(Event event) throws Exception
					{
						if(event.getName().equals("onOK"))
						{
							for(Object object:grid.getRows().getChildren())
							{
								Row row = (Row)object;

								if(row.getFirstChild() instanceof Checkbox)
								{
									Checkbox check = (Checkbox)row.getFirstChild();
									if(check.isChecked())
									{
										Label label = (Label)row.getLastChild();
										service.delete(label.getValue());
									}
								}
							}

							refresh(new InventoryItemModel(utils.getRowPerPage()));
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
		filter.setPlaceholder("Type product code/name to filter");

		appendChild(filter);
		appendChild(grid);

		filter.addEventListener(Events.ON_CHANGING, new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent input) throws Exception
			{
				refresh(new InventoryItemModel(utils.getRowPerPage(),input.getValue()));
			}
		});

		final InventoryItemModel model = new InventoryItemModel(utils.getRowPerPage());

		grid.setHeight("80%");
		grid.setEmptyMessage(lang.get("message.grid.empty"));
		grid.setModel(model);
		grid.setRowRenderer(new InventoryItemRowRenderer());
		grid.setPagingPosition("both");
		grid.setMold("paging");
		grid.setPageSize(utils.getRowPerPage());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"25px"));
		grid.getColumns().appendChild(new Column(lang.get("inventoryitem.grid.column.product")));
		grid.getColumns().appendChild(new Column(lang.get("inventoryitem.grid.column.facility"),null,"145px"));
		grid.getColumns().appendChild(new Column(lang.get("inventoryitem.grid.column.serial"),null,"100px"));
		grid.getColumns().appendChild(new Column(lang.get("inventoryitem.grid.column.onhand"),null,"70px"));
		grid.getColumns().appendChild(new Column(lang.get("inventoryitem.grid.column.expired"),null,"85px"));
		grid.getColumns().appendChild(new Column(null,null,"1px"));
		grid.getColumns().getLastChild().setVisible(false);
		grid.setSpan("1");

		grid.addEventListener("onPaging",new EventListener<PagingEvent>()
		{
			@Override
			public void onEvent(PagingEvent event) throws Exception
			{
				model.next(event.getActivePage(), utils.getRowPerPage(),filter.getText());
				grid.setModel(model);
				refresh(model);
			}
		});

		refresh(new InventoryItemModel(utils.getRowPerPage()));
	}
}