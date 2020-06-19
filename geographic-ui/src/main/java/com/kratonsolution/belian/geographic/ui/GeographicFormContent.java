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

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.ui.AbstractForm;
import com.kratonsolution.belian.common.ui.event.ContentEvent;
import com.kratonsolution.belian.common.ui.event.GeographicUIContentEvent;
import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.common.ui.util.FlowHelper;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.geographic.api.GeographicType;
import com.kratonsolution.belian.geographic.api.application.GeographicCreateCommand;
import com.kratonsolution.belian.geographic.api.application.GeographicService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class GeographicFormContent extends AbstractForm
{	
	private static final long serialVersionUID = -7870478694132790931L;

	private GeographicService service = Springs.get(GeographicService.class);
	
	private Textbox code = Components.mandatoryTextBox(false);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private Textbox note = Components.stdTextBox(null, false);
	
	private Listbox types = Components.newSelect();
	
	private Listbox parents = Components.newSelect();
	
	public GeographicFormContent()
	{
		super();
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
			
				GeographicCreateCommand command = new GeographicCreateCommand();
				command.setCode(code.getText());
				command.setName(name.getText());
				command.setNote(note.getText());
				command.setType(types.getSelectedItem().getValue());
				command.setParent(Optional.ofNullable(parents.getSelectedItem()!=null?parents.getSelectedItem().getValue():null));
				
				service.create(command);
				
				FlowHelper.next(GeographicUIContentEvent.toGrid());
			}
		});
	}

	@Override
	public void initForm()
	{
		service.getAllGeographics().forEach(parent -> {
			parents.appendChild(new Listitem(parent.getName(), parent.getCode()));
		});
		
		for(GeographicType type:GeographicType.values()) {
			types.appendChild(new Listitem(type.name(), type));
		}
		
		parents.setSelectedItem(null);
		types.setSelectedIndex(0);
		
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
