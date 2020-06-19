package com.kratonsolution.belian.geographic.ui;

import java.util.Optional;

import org.zkoss.util.resource.Labels;
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

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.kratonsolution.belian.common.ui.AbstractForm;
import com.kratonsolution.belian.common.ui.event.ContentEvent;
import com.kratonsolution.belian.common.ui.event.GeographicUIContentEvent;
import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.common.ui.util.FlowHelper;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.geographic.api.GeographicData;
import com.kratonsolution.belian.geographic.api.GeographicType;
import com.kratonsolution.belian.geographic.api.application.GeographicService;
import com.kratonsolution.belian.geographic.api.application.GeographicUpdateCommand;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class GeographicUpdateContent extends AbstractForm
{	
	private static final long serialVersionUID = -7870478694132790931L;

	private GeographicService service = Springs.get(GeographicService.class);
	
	private Textbox code = Components.mandatoryTextBox(false);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private Textbox note = Components.stdTextBox(null, false);
	
	private Listbox types = Components.newSelect();
	
	private Listbox parents = Components.newSelect();
	
	private String _code;
	
	public GeographicUpdateContent(@NonNull String _code)
	{
		super();
		this._code = _code;
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
				FlowHelper.next(GeographicUIContentEvent.toGrid());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(code.getText()))
					throw new WrongValueException(code, Labels.getLabel("warning.empty"));
			
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name, Labels.getLabel("warning.empty"));
			
				GeographicUpdateCommand command = new GeographicUpdateCommand();
				command.setCode(code.getText());
				command.setName(Optional.ofNullable(name.getText()));
				command.setNote(Optional.ofNullable(note.getText()));
				command.setType(types.getSelectedItem().getValue());
				
				service.update(command);
				
				FlowHelper.next(GeographicUIContentEvent.toGrid());
			}
		});
	}

	@Override
	public void initForm()
	{
		Optional<GeographicData> opt = service.getByCode(this._code);
		Preconditions.checkState(opt.isPresent(), "Geographic with code {} not exist", this._code);
		
		service.getAllGeographics().forEach(parent -> {
			
			Listitem item = new Listitem(parent.getName(), parent.getCode());
			parents.appendChild(item);
			if(!Strings.isNullOrEmpty(opt.get().getParent()) && opt.get().getParent().equals(parent.getParent())) {
				parents.setSelectedItem(item);
			}
		});
		
		for(GeographicType type:GeographicType.values()) {
			
			Listitem item = new Listitem(type.name(), type);
			types.appendChild(item);
			if(opt.get().getType().equals(type)) {
				types.setSelectedItem(item);
			}
		}
			
		code.setText(opt.get().getCode());
		name.setText(opt.get().getName());
		note.setText(opt.get().getNote());
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(Labels.getLabel("geographic.label.code")));
		row1.appendChild(code);
		
		Row row2 = new Row();
		row2.appendChild(new Label(Labels.getLabel("geographic.label.name")));
		row2.appendChild(name);
		
		Row row3 = new Row();
		row3.appendChild(new Label(Labels.getLabel("geographic.label.type")));
		row3.appendChild(types);
		
		Row row4 = new Row();
		row4.appendChild(new Label(Labels.getLabel("geographic.label.parent")));
		row4.appendChild(parents);
		
		Row row5 = new Row();
		row5.appendChild(new Label(Labels.getLabel("geographic.label.note")));
		row5.appendChild(note);

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}
}
