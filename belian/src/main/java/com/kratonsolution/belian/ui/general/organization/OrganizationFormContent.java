/**
 * 
 */
package com.kratonsolution.belian.ui.general.organization;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.Dates;
import com.kratonsolution.belian.general.dm.IndustrySegmentation;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class OrganizationFormContent extends FormContent
{	
	private final OrganizationService service = Springs.get(OrganizationService.class);
		
	private Textbox name = new Textbox();
	
	private Datebox date = new Datebox();
	
	private Textbox tax = new Textbox();
	
	private Listbox types = new Listbox();
	
	public OrganizationFormContent()
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
				OrganizationWindow window = (OrganizationWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Name cannot be empty");
				
				if(date.getValue() == null)
					throw new WrongValueException(date,"Date cannot be empty");
			
				Organization org = new Organization();
				org.setName(name.getText());
				org.setBirthDate(Dates.sql(date.getValue()));
				org.setTaxCode(tax.getText());
				org.setType(IndustrySegmentation.valueOf(types.getSelectedItem().getValue().toString()));
				
				service.add(org);
				
				OrganizationWindow window = (OrganizationWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		name.setConstraint("no empty");
		name.setWidth("300px");
		
		date.setConstraint("no empty");
		date.setWidth("250px");
		
		tax.setWidth("300px");
		
		for(IndustrySegmentation type:IndustrySegmentation.values())
			types.appendChild(new Listitem(type.name(),type.name()));
		
		types.setSelectedIndex(0);
		types.setMold("select");
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Name"));
		row1.appendChild(name);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Birth Date"));
		row2.appendChild(date);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Tax Number"));
		row3.appendChild(tax);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Industry"));
		row4.appendChild(types);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
	}
}
