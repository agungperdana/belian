/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.coa;

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
import com.kratonsolution.belian.accounting.dm.GLAccountType;
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
	
	private Textbox number = Components.mandatoryTextBox(false);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private Textbox note = Components.stdTextBox(null, false);
	
	private Listbox parents = Components.newSelect();
	
	private Listbox types = Components.newSelect();
	
	private GLAccount parent;
	
	private Grid grid = new Grid();
	
	private Vlayout layout = new Vlayout();
	
	public GLAFormContent(GLAccount parent)
	{
		super();
		setMode(Mode.POPUP);
		
		Caption caption = new Caption(lang.get("coa.grid.column.gl"));
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
						throw new WrongValueException(number,lang.get("message.field.empty"));
				
					if(Strings.isNullOrEmpty(name.getText()))
						throw new WrongValueException(name,lang.get("message.field.empty"));
				
					GLAccount coa = new GLAccount();
					coa.setNumber(number.getValue());
					coa.setName(name.getText());
					coa.setNote(note.getText());
					coa.setType(GLAccountType.valueOf(types.getSelectedItem().getValue().toString()));
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
		if(parent != null)
		{
			parents.appendChild(new Listitem(parent.getName(),parent.getId()));
			parents.setSelectedIndex(0);
		}
		
		for(GLAccountType type:GLAccountType.values())
		{
			Listitem listitem = new Listitem(type.name(),type.name());
			
			types.appendChild(listitem);
			if(parent != null && type.equals(parent.getType()))
				types.setSelectedItem(listitem);
		}

		grid.appendChild(new Rows());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("coa.grid.column.number")));
		row1.appendChild(number);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("coa.grid.column.name")));
		row2.appendChild(name);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("coa.grid.column.type")));
		row3.appendChild(types);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("coa.grid.column.parent")));
		row4.appendChild(parents);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("coa.grid.column.note")));
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
