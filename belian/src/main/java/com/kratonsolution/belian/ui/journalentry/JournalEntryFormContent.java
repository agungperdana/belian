/**
 * 
 */
package com.kratonsolution.belian.ui.journalentry;

import java.util.Date;
import java.util.UUID;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Auxhead;
import org.zkoss.zul.Auxheader;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.JournalEntry;
import com.kratonsolution.belian.accounting.svc.JournalEntryService;
import com.kratonsolution.belian.security.dm.Module;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class JournalEntryFormContent extends FormContent
{	
	private JournalEntryService service = Springs.get(JournalEntryService.class);
	
	private Datebox date = new Datebox(new Date());
	
	private Listbox owners = Components.newSelect();
	
	private Listbox coas = Components.newSelect();
	
	public JournalEntryFormContent()
	{
		super();
		initToolbar();
		initForm();
		initModules();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				JournalEntryWindow window = (JournalEntryWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(code.getText()))
					throw new WrongValueException(code,"Code cannot be empty");
			
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Name cannot be empty");
			
				JournalEntry role = new JournalEntry();
				role.setId(UUID.randomUUID().toString());
				role.setCode(code.getText());
				role.setName(name.getText());
				role.setNote(note.getText());
				
				service.add(role);
				
				Rows moduleRows = accessModules.getRows();
				for(Object object:moduleRows.getChildren())
				{
					Row _row = (Row)object;
					
					Module module = moduleService.findOne(RowUtils.rowValue(_row, 6));
					if(module != null)
					{
						AccessJournalEntry accessJournalEntry = new AccessJournalEntry();
						accessJournalEntry.setId(UUID.randomUUID().toString());
						accessJournalEntry.setModule(module);
						accessJournalEntry.setJournalEntry(role);
						accessJournalEntry.setCanCreate(RowUtils.isChecked(_row, 1));
						accessJournalEntry.setCanRead(RowUtils.isChecked(_row, 2));
						accessJournalEntry.setCanUpdate(RowUtils.isChecked(_row, 3));
						accessJournalEntry.setCanDelete(RowUtils.isChecked(_row, 4));
						accessJournalEntry.setCanPrint(RowUtils.isChecked(_row, 5));
						
						role.getAccesses().add(accessJournalEntry);
					}
				}
				
				service.edit(role);
				
				JournalEntryWindow window = (JournalEntryWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		code.setConstraint("no empty");
		code.setWidth("250px");

		name.setConstraint("no empty");
		name.setWidth("250px");
		
		note.setWidth("300px");
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Code"));
		row1.appendChild(code);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Name"));
		row2.appendChild(name);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Note"));
		row3.appendChild(note);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
	}
	
	protected void initModules()
	{
		Auxhead head = new Auxhead();
		Auxheader header = new Auxheader("Module Access");
		header.setColspan(7);
		header.setRowspan(1);
		
		head.appendChild(header);
		
		Columns columns = new Columns();
		
		Column moduleName = new Column("Module");
		moduleName.setWidth("175px");
		
		Column canCreate = new Column();
		Column canRead = new Column();
		Column canUpdate = new Column();
		Column canDelete = new Column();
		Column canPrint = new Column();
		Column moduleId = new Column();
		moduleId.setVisible(false);
		
		Checkbox check1 = new Checkbox("Create");
		check1.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
		{
			@Override
			public void onEvent(CheckEvent event) throws Exception
			{
				Rows rows = accessModules.getRows();
				for(Object object:rows.getChildren())
				{
					Row _row = (Row)object;
					if(event.isChecked())
						RowUtils.checked(_row, 1);
					else
						RowUtils.unchecked(_row, 1);
				}
			}
		});
		
		Checkbox check2 = new Checkbox("Read");
		check2.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
		{
			@Override
			public void onEvent(CheckEvent event) throws Exception
			{
				Rows rows = accessModules.getRows();
				for(Object object:rows.getChildren())
				{
					Row _row = (Row)object;
					if(event.isChecked())
						RowUtils.checked(_row, 2);
					else
						RowUtils.unchecked(_row, 2);
				}
			}
		});
		
		Checkbox check3 = new Checkbox("Update");
		check3.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
		{
			@Override
			public void onEvent(CheckEvent event) throws Exception
			{
				Rows rows = accessModules.getRows();
				for(Object object:rows.getChildren())
				{
					Row _row = (Row)object;
					if(event.isChecked())
						RowUtils.checked(_row, 3);
					else
						RowUtils.unchecked(_row, 3);
				}
			}
		});
		
		Checkbox check4 = new Checkbox("Delete");
		check4.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
		{
			@Override
			public void onEvent(CheckEvent event) throws Exception
			{
				Rows rows = accessModules.getRows();
				for(Object object:rows.getChildren())
				{
					Row _row = (Row)object;
					if(event.isChecked())
						RowUtils.checked(_row, 4);
					else
						RowUtils.unchecked(_row, 4);
				}
			}
		});
		
		Checkbox check5 = new Checkbox("Print");
		check5.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
		{
			@Override
			public void onEvent(CheckEvent event) throws Exception
			{
				Rows rows = accessModules.getRows();
				for(Object object:rows.getChildren())
				{
					Row _row = (Row)object;
					if(event.isChecked())
						RowUtils.checked(_row, 5);
					else
						RowUtils.unchecked(_row, 5);
				}
			}
		});
		
		canCreate.appendChild(check1);
		canRead.appendChild(check2);
		canUpdate.appendChild(check3);
		canDelete.appendChild(check4);
		canPrint.appendChild(check5);
		
		columns.appendChild(moduleName);
		columns.appendChild(canCreate);
		columns.appendChild(canRead);
		columns.appendChild(canUpdate);
		columns.appendChild(canDelete);
		columns.appendChild(canPrint);
		columns.appendChild(moduleId);
	
		Rows moduleRows = new Rows();
		
		for(Module module:moduleService.findAll())
		{
			Row row = new Row();
			row.appendChild(new Label(module.getName()));
			row.appendChild(new Checkbox());
			row.appendChild(new Checkbox());
			row.appendChild(new Checkbox());
			row.appendChild(new Checkbox());
			row.appendChild(new Checkbox());
			row.appendChild(new Label(module.getId()));
			
			moduleRows.appendChild(row);
		}
		
		accessModules.appendChild(head);
		accessModules.appendChild(columns);
		accessModules.appendChild(moduleRows);
		
		appendChild(accessModules);
	}
}
