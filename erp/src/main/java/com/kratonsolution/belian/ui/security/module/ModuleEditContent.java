package com.kratonsolution.belian.ui.security.module;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.access.module.impl.orm.Module;
import com.kratonsolution.belian.access.module.impl.orm.ModuleGroup;
import com.kratonsolution.belian.access.module.impl.application.ModuleService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public class ModuleEditContent extends AbstractForm
{	
	private ModuleService service = Springs.get(ModuleService.class);
	
	private Textbox code = Components.mandatoryTextBox(false);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private Textbox note = Components.stdTextBox(null, false);
	
	private Listbox groups = Components.newSelect();
	
	private Row row;
	
	public ModuleEditContent(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new ModuleGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(code.getText()))
					throw new WrongValueException(code,lang.get("message.field.empty"));
			
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,lang.get("message.field.empty"));
			
				Module module = service.findById(RowUtils.id(row));
				if(module != null)
				{
					module.setCode(code.getText());
					module.setName(name.getText());
					module.setNote(note.getText());
					module.setGroup(ModuleGroup.valueOf(Components.string(groups)));
					
					service.edit(module);
				}
				
				Flow.next(getParent(), new ModuleGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		Module module = service.findById(RowUtils.id(row));
		if(module != null)
		{
			code.setText(module.getCode());
			name.setText(module.getName());
			note.setText(module.getNote());
			
			for(ModuleGroup group:ModuleGroup.values())
			{
				Listitem item = groups.appendItem(group.name(),group.name());
				if(group.equals(module.getGroup()))
					groups.setSelectedItem(item);
			}
			
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"100px"));
			grid.getColumns().appendChild(new Column());
			
			Row row1 = new Row();
			row1.appendChild(new Label(lang.get("module.grid.column.code")));
			row1.appendChild(code);
			
			Row row2 = new Row();
			row2.appendChild(new Label(lang.get("module.grid.column.name")));
			row2.appendChild(name);
			
			Row row3 = new Row();
			row3.appendChild(new Label(lang.get("module.grid.column.note")));
			row3.appendChild(note);
			
			Row row4 = new Row();
			row4.appendChild(new Label(lang.get("module.grid.column.group")));
			row4.appendChild(groups);
			
			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			rows.appendChild(row4);
		}
	}
}
