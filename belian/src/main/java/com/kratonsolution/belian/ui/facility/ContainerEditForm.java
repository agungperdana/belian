/**
 * 
 */
package com.kratonsolution.belian.ui.facility;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.inventory.dm.Container;
import com.kratonsolution.belian.inventory.svc.ContainerService;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class ContainerEditForm extends AbstractWindow
{
	private Vlayout layout = new Vlayout();
	
	private Textbox code = new Textbox();
	
	private Textbox name = new Textbox();
	
	private Textbox note = new Textbox();
	
	private Listbox types = new Listbox();
	
	private Listbox facilitys = new Listbox();
	
	private Listbox parents = new Listbox();
	
	private FacilityService facilityService = Springs.get(FacilityService.class);
	
	private ContainerService containerService = Springs.get(ContainerService.class);
	
	private Container edited;
	
	public ContainerEditForm(Container container)
	{
		super();
		setMode(Mode.POPUP);
		
		this.edited = container;
		
		Caption caption = new Caption("Container");
		caption.setImage("/icons/facility.png");
		
		appendChild(caption);
		appendChild(layout);
		
		initToolbar();
		initForm();
	}
	
	protected void initToolbar()
	{
		Toolbar toolbar = new Toolbar();
		
		Toolbarbutton back = new Toolbarbutton("Back","/icons/back.png");
		back.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				((Refreshable)getParent()).refresh();
				onClose();
			}
		});
		
		Toolbarbutton save = new Toolbarbutton("Save","/icons/save.png");
		save.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				edited.setCode(code.getText());
				edited.setName(name.getText());
				edited.setNote(note.getText());
				edited.setType(Container.Type.valueOf(types.getSelectedItem().getValue().toString()));
				
				containerService.edit(edited);
				
				((Refreshable)getParent()).refresh();
				onClose();
			}
		});
		
		toolbar.appendChild(back);
		toolbar.appendChild(save);
		
		layout.appendChild(toolbar);
	}
	
	protected void initForm()
	{
		Grid grid = new Grid();
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		grid.appendChild(new Rows());
		
		code.setConstraint("no empty");
		code.setWidth("200px");
		code.setText(edited.getCode());
		
		name.setConstraint("no empty");
		name.setWidth("250px");
		name.setText(edited.getName());
		
		note.setText(edited.getNote());
		note.setWidth("300px");
		
		types.setMold("select");
		facilitys.setMold("select");
		parents.setMold("select");
		
		for(Container.Type type:Container.Type.values())
		{	
			Listitem listitem = new Listitem(type.name(),type.name());
			types.appendChild(listitem);
			if(type.equals(edited.getType()))
				types.setSelectedItem(listitem);
		}
		
		types.setSelectedIndex(0);
		
		if(edited.getFacility() != null)
		{
			facilitys.appendChild(new Listitem(edited.getFacility().getName(),edited.getFacility().getId()));
			facilitys.setSelectedIndex(0);
		}
		
		if(edited.getParent() != null)
		{
			parents.appendChild(new Listitem(edited.getParent().getName(),edited.getParent().getId()));
			parents.setSelectedIndex(0);
		}
		
		Row row1 = new Row();
		row1.appendChild(new Label("Code"));
		row1.appendChild(code);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Name"));
		row2.appendChild(name);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Note"));
		row3.appendChild(note);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Type"));
		row4.appendChild(types);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Parent"));
		row5.appendChild(parents);
		
		Row row6 = new Row();
		row6.appendChild(new Label("Facility"));
		row6.appendChild(facilitys);
	
		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
		grid.getRows().appendChild(row4);
		grid.getRows().appendChild(row5);
		grid.getRows().appendChild(row6);
		
		layout.appendChild(grid);
	}
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.HasStatus#insertStatus()
	 */
	@Override
	public void insertStatus()
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.HasStatus#removeStatus()
	 */
	@Override
	public void removeStatus()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onClose()
	{
		setVisible(false);
		setParent(null);
	}
}
