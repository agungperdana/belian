/**
 * 
 */
package com.kratonsolution.belian.ui.person;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.event.PagingEvent;

import com.kratonsolution.belian.general.view.PersonController;
import com.kratonsolution.belian.ui.GridContent;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class PersonGridContent extends GridContent
{
	private final PersonController controller = Springs.get(PersonController.class);
	
	public PersonGridContent()
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
				grid.setModel(new PersonModel(8));
			}
		});
		
		gridToolbar.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PersonWindow window = (PersonWindow)getParent();
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
												controller.delete(label.getValue());
											}
										}
									}
									
									PersonWindow window = (PersonWindow)getParent();
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
		final PersonModel model = new PersonModel(8);
		
		grid.setParent(this);
		grid.setHeight("80%");
		grid.setEmptyMessage("No person data exist.");
		grid.setModel(model);
		grid.setRowRenderer(new PersonRowRenderer());
		grid.setPagingPosition("both");
		grid.setMold("paging");
		grid.setPageSize(8);
		
		Columns columns = new Columns();
		
		Column select = new Column(null,null,"25px");
		Column name = new Column("Name");
		Column date = new Column("Birth Date");
		Column tax = new Column("Tax");
		Column id = new Column();
		id.setVisible(false);
		
		columns.appendChild(select);
		columns.appendChild(name);
		columns.appendChild(date);
		columns.appendChild(tax);
		columns.appendChild(id);
		
		grid.appendChild(columns);
		grid.addEventListener("onPaging",new EventListener<PagingEvent>()
		{
			@Override
			public void onEvent(PagingEvent event) throws Exception
			{
				model.next(event.getActivePage(), 8);
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
					PersonWindow window = (PersonWindow)getParent();
					window.removeGrid();
					window.insertEditForm(row);
				}
			});
		}
	}
}