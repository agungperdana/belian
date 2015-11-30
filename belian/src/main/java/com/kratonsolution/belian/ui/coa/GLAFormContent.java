/**
 * 
 */
package com.kratonsolution.belian.ui.coa;

import org.zkoss.zk.ui.WrongValueException;
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
import org.zkoss.zul.Vlayout;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.GLAccount;
import com.kratonsolution.belian.accounting.svc.GLAccountService;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.FormToolbar;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GLAFormContent extends AbstractWindow
{	
	private final GLAccountService service = Springs.get(GLAccountService.class);
	
	private Textbox number = new Textbox();
	
	private Textbox name = new Textbox();
	
	private Textbox note = new Textbox();
	
	private Listbox parents = Components.newSelect();
	
	private Listbox types = Components.newSelect();
	
	private GLAccount parent;
	
	private Grid grid = new Grid();
	
	private Vlayout layout = new Vlayout();
	
	public GLAFormContent(GLAccount parent)
	{
		super();
		setMode(Mode.POPUP);
		
		Caption caption = new Caption("GL Account");
		caption.setImage("/icons/coa.png");
		
		appendChild(caption);
		
		layout.setWidth("100%");
		layout.setHeight("97%");
		layout.setStyle("overflow:auto");
		
		appendChild(layout);
		
		this.parent = parent;
		
		initToolbar();
		initForm();
	}

	public void initToolbar()
	{
		FormToolbar toolbar = new FormToolbar();
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				((Refreshable)getParent()).refresh();
				onClose();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				parent = service.findOne(parent.getId());
				if(parent != null)
				{
					if(Strings.isNullOrEmpty(number.getText()))
						throw new WrongValueException(number,"Number cannot be empty");
				
					if(Strings.isNullOrEmpty(name.getText()))
						throw new WrongValueException(name,"Name cannot be empty");
				
					GLAccount coa = new GLAccount();
					coa.setNumber(number.getValue());
					coa.setName(name.getText());
					coa.setNote(note.getText());
					coa.setType(GLAccount.Type.valueOf(types.getSelectedItem().getValue().toString()));
					coa.setParent(parent);
					
					service.add(coa);
					
					parent.getMembers().add(coa);
					
					service.edit(parent);
				}

				((Refreshable)getParent()).refresh();
				
				onClose();
			}
		});
		
		layout.appendChild(toolbar);
	}

	public void initForm()
	{
		grid.appendChild(new Rows());
		
		number.setConstraint("no empty");
		number.setWidth("200px");
		
		name.setConstraint("no empty");
		name.setWidth("300px");
		
		note.setWidth("400px");
		
		if(parent != null)
		{
			parents.appendChild(new Listitem(parent.getName(),parent.getId()));
			parents.setSelectedIndex(0);
		}
		
		for(GLAccount.Type type:GLAccount.Type.values())
		{
			Listitem listitem = new Listitem(type.name(),type.name());
			
			types.appendChild(listitem);
			if(parent != null && type.equals(parent.getType()))
			{
				types.setSelectedItem(listitem);
//				number.setValue(service.nextNumber(type));
			}
		}
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Number"));
		row1.appendChild(number);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Name"));
		row2.appendChild(name);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Type"));
		row3.appendChild(types);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Parent"));
		row4.appendChild(parents);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Description"));
		row5.appendChild(note);
		
		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
		grid.getRows().appendChild(row4);
		grid.getRows().appendChild(row5);
		
		layout.appendChild(grid);
	}
	
	@Override
	public void onClose()
	{
		setVisible(false);
		setParent(null);
	}

	@Override
	public void insertStatus()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeStatus()
	{
		// TODO Auto-generated method stub
		
	}
}
