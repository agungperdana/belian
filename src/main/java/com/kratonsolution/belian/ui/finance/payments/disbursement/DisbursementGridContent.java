/**
 * 
 */
package com.kratonsolution.belian.ui.finance.payments.disbursement;

import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.event.PagingEvent;
import org.zkoss.zul.event.ZulEvents;

import com.kratonsolution.belian.payments.svc.DisbursementService;
import com.kratonsolution.belian.ui.GridContent;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DisbursementGridContent extends GridContent
{
	private DisbursementService service = Springs.get(DisbursementService.class);
	
	public DisbursementGridContent()
	{
		super();
		initToolbar();
		initGrid();
	}
	
	protected void initToolbar()
	{
		toolbar.setParent(this);
		toolbar.getRefresh().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new DisbursementGridContent());
			}
		});
		
		toolbar.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new DisbursementFormContent());
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
							Vector<String> ids = new Vector<>();
							
							for(Object object:grid.getRows().getChildren())
							{
								Row row = (Row)object;
								if(RowUtils.isChecked(row))
									ids.add(RowUtils.id(row));
							}

							service.delete(ids);
							
							Flow.next(getParent(), new DisbursementGridContent());
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
		final DisbursementModel model = new DisbursementModel(utils.getRowPerPage());
		
		appendChild(grid);
		
		grid.setHeight("80%");
		grid.setEmptyMessage(lang.get("message.grid.empty"));
		grid.setModel(model);
		grid.setRowRenderer(new DisbursementRenderer());
		grid.setPagingPosition("both");
		grid.setMold("paging");
		grid.setPageSize(utils.getRowPerPage());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"25px"));
		grid.getColumns().appendChild(new Column(lang.get("payments.grid.column.number"),null,"115px"));
		grid.getColumns().appendChild(new Column(lang.get("payments.grid.column.date"),null,"100px"));
		grid.getColumns().appendChild(new Column(lang.get("payments.grid.column.payer"),null,"200px"));
		grid.getColumns().appendChild(new Column(lang.get("payments.grid.column.receiver"),null,"200px"));
		grid.getColumns().appendChild(new Column(lang.get("payments.grid.column.amount"),null,"80px"));
		grid.getColumns().appendChild(new Column(lang.get("payments.grid.column.method"),null,"90px"));
		grid.getColumns().appendChild(new Column(lang.get("payments.grid.column.reference"),null,"100px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().getLastChild().setVisible(false);
		grid.setSpan("3");
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
							Row row = (Row)ev.getTarget();
							Flow.next(getParent(), new DisbursementEditContent(row));
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
				model.next(event.getActivePage(), utils.getRowPerPage());
				grid.setModel(model);
			}
		});
	}
}