/**
 * 
 */
package com.kratonsolution.belian.ui.geographic;

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
import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.general.svc.GeographicService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class GeographicFormContent extends FormContent
{	
	private final GeographicService controller = Springs.get(GeographicService.class);
	
	private Textbox code = new Textbox();
	
	private Textbox name = new Textbox();
	
	private Listbox type = new Listbox();
	
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
				GeographicWindow window = (GeographicWindow)getParent();
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
			
				Geographic geographic = new Geographic();
				geographic.setCode(code.getText());
				geographic.setName(name.getText());
				geographic.setType(Geographic.Type.valueOf(type.getSelectedItem().getValue().toString()));
				
				controller.add(geographic);
				
				GeographicWindow window = (GeographicWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		code.setConstraint("no empty");
		name.setConstraint("no empty");
		
		for(Geographic.Type geo :Geographic.Type.values())
		{
			Listitem listitem = new Listitem(geo.toString(),geo.toString());
			type.appendChild(listitem);
		}
		
		type.setMold("select");
		type.setSelectedIndex(0);
		
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
		row3.appendChild(new Label("Type"));
		row3.appendChild(type);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
	}
}
