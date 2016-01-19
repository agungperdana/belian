/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.labsresgistration;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.healtcare.dm.DoctorType;
import com.kratonsolution.belian.healtcare.svc.DoctorTypeService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class LabsRegistrationEditContent extends FormContent
{	
	private DoctorTypeService service = Springs.get(DoctorTypeService.class);
	
	private Textbox code = new Textbox();
	
	private Textbox name = new Textbox();
	
	private Textbox description = new Textbox();
	
	private Row row;
	
	public LabsRegistrationEditContent(Row row)
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
				LabsRegistrationWindow window = (LabsRegistrationWindow)getParent();
				window.removeEditForm();
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
				
				if(Strings.isNullOrEmpty(description.getText()))
					throw new WrongValueException(description,"Value cannot be empty");
			
				DoctorType type = service.findOne(RowUtils.string(row, 4));
				type.setCode(code.getText());
				type.setName(name.getText());
				type.setDescription(description.getText());
				
				service.edit(type);
				
				LabsRegistrationWindow window = (LabsRegistrationWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		System.out.println("init form......");
		DoctorType type = service.findOne(RowUtils.string(row, 4));
		if(type != null)
		{
			System.out.println(type);
			
			code.setConstraint("no empty");
			code.setText(type.getCode());
			
			name.setConstraint("no empty");
			name.setWidth("300px");
			name.setText(type.getName());
			
			description.setWidth("300px");
			description.setText(type.getDescription());
			
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
			row3.appendChild(new Label("Description"));
			row3.appendChild(description);
			
			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			
			System.out.println("add maning");
		}
	}
}
