package com.kratonsolution.belian.security.ui.module;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.access.api.ModuleData;
import com.kratonsolution.belian.access.api.application.ModuleService;
import com.kratonsolution.belian.access.api.application.ModuleUpdateCommand;
import com.kratonsolution.belian.common.ui.AbstractForm;
import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.common.ui.util.FlowHelper;
import com.kratonsolution.belian.common.ui.util.Springs;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class ModuleEditContent extends AbstractForm
{	
	private static final long serialVersionUID = -4267104303139844670L;

	private ModuleService service = Springs.get(ModuleService.class);

	private Textbox code = Components.readOnlyTextBox();

	private Textbox name = Components.mandatoryTextBox(false);

	private Textbox note = Components.stdTextBox(null, false);
	
	private Checkbox enabled = new Checkbox(Labels.getLabel("label.active"));

	private Listbox groups = ModuleGroupUIHelper.get();

	private String moduleCode;
	
	public ModuleEditContent(@NonNull String moduleCode)
	{
		super();
		this.moduleCode= moduleCode;
		initToolbar();
		initForm();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK, e->FlowHelper.next(ModuleUIEvent.toGrid()));
		toolbar.getSave().addEventListener(Events.ON_CLICK, e->{
			
			if(Strings.isNullOrEmpty(code.getText()))
				throw new WrongValueException(code, Labels.getLabel("warning.empty"));

			if(Strings.isNullOrEmpty(name.getText()))
				throw new WrongValueException(name,Labels.getLabel("warning.empty"));

			ModuleUpdateCommand command = new ModuleUpdateCommand();
			command.setCode(moduleCode);
			command.setName(name.getText());
			command.setEnabled(enabled.isChecked());
			command.setNote(note.getText());
			command.setGroup(ModuleGroupUIHelper.get(groups));
			
			service.update(command);
			
			FlowHelper.next(ModuleUIEvent.toGrid());
		});
	}

	@Override
	public void initForm()
	{
		ModuleData opt = service.getByCode(this.moduleCode);
		if(opt != null)
		{
			code.setText(opt.getCode());
			name.setText(opt.getName());
			note.setText(opt.getNote());
			enabled.setChecked(opt.isEnabled());
			
			ModuleGroupUIHelper.select(groups, opt.getGroup());
		}
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(Labels.getLabel("label.code")));
		row1.appendChild(code);

		Row row2 = new Row();
		row2.appendChild(new Label(Labels.getLabel("label.name")));
		row2.appendChild(name);

		Row row3 = new Row();
		row3.appendChild(new Label(Labels.getLabel("label.note")));
		row3.appendChild(note);

		Row row4 = new Row();
		row4.appendChild(new Label(Labels.getLabel("module.grid.group")));
		row4.appendChild(groups);
		
		Row row5 = new Row();
		row5.appendChild(new Label(Labels.getLabel("label.status")));
		row5.appendChild(enabled);

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}
}
