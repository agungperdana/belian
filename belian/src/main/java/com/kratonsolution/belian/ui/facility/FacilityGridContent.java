/**
 * 
 */
package com.kratonsolution.belian.ui.facility;

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

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.ui.GridContent;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FacilityGridContent extends GridContent
{
	private FacilityService service = Springs.get(FacilityService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	public FacilityGridContent()
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
				refresh(new FacilityModel(utils.getRowPerPage()));
			}
		});
		
		gridToolbar.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				FacilityWindow window = (FacilityWindow)getParent();
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
							
							refresh(new FacilityModel(utils.getRowPerPage()));
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
		final FacilityModel model = new FacilityModel(utils.getRowPerPage());
		
		grid.setHeight("80%");
		grid.setEmptyMessage("No facility data exist.");
		grid.setModel(model);
		grid.setRowRenderer(new FacilityRowRenderer());
		grid.setPagingPosition("both");
		grid.setMold("paging");
		grid.setPageSize(utils.getRowPerPage());
		
		appendChild(grid);
		
		Columns columns = new Columns();
		
		Column select = new Column(null,null,"25px");
		Column code = new Column("Code",null,"100px");
		Column name = new Column("Name",null,"150px");
		Column type = new Column("Type",null,"75px");
		Column note = new Column("Note");
		Column id = new Column();
		id.setVisible(false);
		
		columns.appendChild(select);
		columns.appendChild(code);
		columns.appendChild(name);
		columns.appendChild(type);
		columns.appendChild(note);
		columns.appendChild(id);
		
		grid.appendChild(columns);
		grid.addEventListener("onPaging",new EventListener<PagingEvent>()
		{
			@Override
			public void onEvent(PagingEvent event) throws Exception
			{
				model.next(event.getActivePage(), utils.getRowPerPage());
				grid.setModel(model);
				refresh(model);
			}
		});

		refresh(new FacilityModel(utils.getRowPerPage()));
	}
}