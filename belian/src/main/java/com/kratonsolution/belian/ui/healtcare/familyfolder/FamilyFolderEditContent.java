/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.familyfolder;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.healtcare.dm.FamilyFolder;
import com.kratonsolution.belian.healtcare.dm.FamilyMember;
import com.kratonsolution.belian.healtcare.svc.FamilyFolderService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.PatientBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FamilyFolderEditContent extends FormContent
{	
	private FamilyFolderService service = Springs.get(FamilyFolderService.class);
	
	private Textbox name = new Textbox();
	
	private Textbox description = new Textbox();
	
	private Grid members = new Grid();
	
	private Row row;
	
	public FamilyFolderEditContent(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
		initMembers();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				FamilyFolderWindow window = (FamilyFolderWindow)getParent();
				window.removeEditForm();
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
				
				if(Strings.isNullOrEmpty(description.getText()))
					throw new WrongValueException(description,"Value cannot be empty");
			
				FamilyFolder folder = service.findOne(RowUtils.string(row, 4));
				folder.setName(name.getText());
				folder.setNote(description.getText());
				folder.getMembers().clear();

				for(Component com:members.getRows().getChildren())
				{
					Row _row = (Row)com;
					
					PatientBox box = (PatientBox)_row.getChildren().get(1);
					
					FamilyMember member = new FamilyMember();
					member.setFolder(folder);
					member.setPatient(box.getPatient());
					member.setType(FamilyMember.Type.valueOf(RowUtils.string(_row, 2)));
					
					folder.getMembers().add(member);
				}
				
				service.edit(folder);
				
				FamilyFolderWindow window = (FamilyFolderWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		FamilyFolder type = service.findOne(RowUtils.string(row, 3));
		if(type != null)
		{
			name.setConstraint("no empty");
			name.setWidth("300px");
			name.setText(type.getName());
			
			description.setWidth("300px");
			description.setText(type.getNote());
			
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"75px"));
			grid.getColumns().appendChild(new Column());
			
			Row row2 = new Row();
			row2.appendChild(new Label("Name"));
			row2.appendChild(name);
			
			Row row3 = new Row();
			row3.appendChild(new Label("Description"));
			row3.appendChild(description);
			
			rows.appendChild(row2);
			rows.appendChild(row3);
		}
	}
	
	private void initMembers()
	{
		NRCToolbar nrc = new NRCToolbar(members);
		
		members.appendChild(new Rows());
		members.appendChild(new Columns());
		members.setWidth("100%");
		members.getColumns().appendChild(new Column(null,null,"25px"));
		members.getColumns().appendChild(new Column("Patient",null,"150px"));
		members.getColumns().appendChild(new Column("Role",null,"150px"));
		members.setSpan("1");
		
		nrc.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Listbox roles = Components.fullSpanSelect();
				for(FamilyMember.Type type:FamilyMember.Type.values())
					roles.appendItem(type.name(),type.name());
				
				Components.setDefault(roles);
				
				Row row = new Row();
				row.appendChild(new Checkbox());
				row.appendChild(new PatientBox());
				row.appendChild(roles);
				
				members.getRows().appendChild(row);
			}
		});
		
		FamilyFolder folder = service.findOne(RowUtils.string(row, 3));
		if(folder != null)
		{
			for(FamilyMember member:folder.getMembers())
			{
				PatientBox box = new PatientBox();
				box.setPatient(member.getPatient());
				
				Listbox listbox = Components.fullSpanSelect();
				
				for(FamilyMember.Type type:FamilyMember.Type.values())
				{
					Listitem item = listbox.appendItem(type.name(),type.name());
					if(type.equals(member.getType()))
						listbox.setSelectedItem(item);
				}
				
				Row _row = new Row();
				_row.appendChild(new Checkbox());
				_row.appendChild(box);
				_row.appendChild(listbox);
				
				members.getRows().appendChild(_row);
			}
		}
		
		appendChild(nrc);
		appendChild(members);
	}
}