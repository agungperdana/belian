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
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.dm.IndustrySegmentation;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class OrganizationFormContent extends FormContent
{	
	private OrganizationService service = Springs.get(OrganizationService.class);
		
	private Textbox code = Components.mandatoryTextBox(false);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private Datebox date = Components.currentDatebox();
	
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
				Flow.next(getParent(), new OrganizationGridContent());
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
				org.setIdentity(code.getText());
				org.setName(name.getText());
				org.setBirthDate(DateTimes.sql(date.getValue()));
				org.setTaxCode(tax.getText());
				org.setType(IndustrySegmentation.valueOf(types.getSelectedItem().getValue().toString()));
				
				service.add(org);
				
				Flow.next(getParent(), new OrganizationGridContent());
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
		
		Row row0 = new Row();
		row0.appendChild(new Label(lang.get("organization.grid.column.code")));
		row0.appendChild(code);
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("organization.grid.column.name")));
		row1.appendChild(name);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("organization.grid.column.birthdate")));
		row2.appendChild(date);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("organization.grid.column.tax")));
		row3.appendChild(tax);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("organization.grid.column.industry")));
		row4.appendChild(types);
		
		rows.appendChild(row0);
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
	}
}
