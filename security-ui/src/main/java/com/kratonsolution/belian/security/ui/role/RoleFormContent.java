package com.kratonsolution.belian.security.ui.role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Auxhead;
import org.zkoss.zul.Auxheader;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.ui.AbstractForm;
import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.common.ui.util.FlowHelper;
import com.kratonsolution.belian.common.ui.util.RowUtils;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.security.api.ModuleData;
import com.kratonsolution.belian.security.api.ModuleGroup;
import com.kratonsolution.belian.security.api.application.ModuleService;
import com.kratonsolution.belian.security.api.application.RoleCreateCommand;
import com.kratonsolution.belian.security.api.application.RoleModuleCommand;
import com.kratonsolution.belian.security.api.application.RoleService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class RoleFormContent extends AbstractForm
{	
	private static final long serialVersionUID = 1858194593980526506L;

	private RoleService service = Springs.get(RoleService.class);
	
	private ModuleService moduleService = Springs.get(ModuleService.class);
	
	private Textbox code = Components.mandatoryTextBox(false);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private Textbox note = Components.stdTextBox(null,false);
	
	private Checkbox status = new Checkbox(Labels.getLabel("label.active"));
	
	private Tabbox tabbox = new Tabbox();
	
	private Collection<Grid> modules = new ArrayList<>();
	
	public RoleFormContent()
	{
		super();
		
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		appendChild(tabbox);
		
		initToolbar();
		initForm();
		initModules();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK, e->FlowHelper.next(RoleUIEvent.toGrid()));
		
		toolbar.getSave().addEventListener(Events.ON_CLICK, e->{
			
			if(Strings.isNullOrEmpty(code.getText()))
				throw new WrongValueException(code, Labels.getLabel("message.field.empty"));
		
			if(Strings.isNullOrEmpty(name.getText()))
				throw new WrongValueException(name,Labels.getLabel("message.field.empty"));
		
			RoleCreateCommand command = new RoleCreateCommand();
			command.setCode(code.getText());
			command.setName(name.getText());
			command.setNote(note.getText());
			command.setEnabled(status.isChecked());
			
			modules.stream().forEach(grid -> {
				
				grid.getRows().getChildren().stream().forEach(obj ->{
					
					Row row = (Row)obj;
					
					RoleModuleCommand rmd = new RoleModuleCommand();
					rmd.setModuleCode(RowUtils.string(row, 0));
					rmd.setModuleName(RowUtils.string(row, 1));
					rmd.setAdd(RowUtils.isChecked(row, 2));
					rmd.setRead(RowUtils.isChecked(row, 3));
					rmd.setEdit(RowUtils.isChecked(row, 4));
					rmd.setDelete(RowUtils.isChecked(row, 5));
					rmd.setPrint(RowUtils.isChecked(row, 6));
					rmd.setModuleGroup(ModuleGroup.valueOf(RowUtils.string(row, 7)));
					
					command.getModules().add(rmd);
				});
			});
			
			service.create(command);
			FlowHelper.next(RoleUIEvent.toGrid());
		});
	}

	@Override
	public void initForm()
	{
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
		row4.appendChild(new Label(Labels.getLabel("label.status")));
		row4.appendChild(status);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
	}
	
	protected void initModules()
	{
		for(ModuleGroup group:ModuleGroup.values())
		{
			Grid grid = new Grid();
			grid.appendChild(new Rows());
			grid.appendChild(new Columns());
			grid.setHflex("1");
			grid.setSpan("0");
			
			Auxhead head = new Auxhead();
			Auxheader header = new Auxheader(Labels.getLabel("role.module.title"));
			header.setColspan(7);
			header.setRowspan(1);
			
			head.appendChild(header);
			
			Column canCreate = new Column(null,null,"85px");
			Column canRead = new Column(null,null,"85px");
			Column canUpdate = new Column(null,null,"85px");
			Column canDelete = new Column(null,null,"85px");
			Column canPrint = new Column(null,null,"85px");
			
			Vector<Checkbox> reads = new Vector<>();
			Vector<Checkbox> adds = new Vector<>();
			Vector<Checkbox> edits = new Vector<>();
			Vector<Checkbox> deletes = new Vector<>();
			Vector<Checkbox> prints = new Vector<>();
			
			Checkbox createChk = new Checkbox(Labels.getLabel("label.create"));
			createChk.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
			{
				@Override
				public void onEvent(CheckEvent event) throws Exception
				{
					adds.stream().forEach(box -> box.setChecked(event.isChecked()));
				}
			});
			
			Checkbox readChck = new Checkbox(Labels.getLabel("label.read"));
			readChck.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
			{
				@Override
				public void onEvent(CheckEvent event) throws Exception
				{
					reads.stream().forEach(box -> box.setChecked(event.isChecked()));
				}
			});
			
			Checkbox updateChk = new Checkbox(Labels.getLabel("label.update"));
			updateChk.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
			{
				@Override
				public void onEvent(CheckEvent event) throws Exception
				{
					edits.stream().forEach(box -> box.setChecked(event.isChecked()));
				}
			});
			
			Checkbox deleteChk = new Checkbox(Labels.getLabel("label.delete"));
			deleteChk.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
			{
				@Override
				public void onEvent(CheckEvent event) throws Exception
				{
					deletes.stream().forEach(box -> box.setChecked(event.isChecked()));
				}
			});
			
			Checkbox printChk = new Checkbox(Labels.getLabel("label.print"));
			printChk.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
			{
				@Override
				public void onEvent(CheckEvent event) throws Exception
				{
					prints.stream().forEach(box -> box.setChecked(event.isChecked()));
				}
			});
			
			canCreate.appendChild(createChk);
			canRead.appendChild(readChck);
			canUpdate.appendChild(updateChk);
			canDelete.appendChild(deleteChk);
			canPrint.appendChild(printChk);
			
			grid.getColumns().appendChild(new Column(Labels.getLabel("module.Caption"), null, "175px"));
			grid.getColumns().appendChild(new Column());
			grid.getColumns().appendChild(canCreate);
			grid.getColumns().appendChild(canRead);
			grid.getColumns().appendChild(canUpdate);
			grid.getColumns().appendChild(canDelete);
			grid.getColumns().appendChild(canPrint);
			grid.getColumns().appendChild(new Column());
			grid.getColumns().getLastChild().setVisible(false);
			
			for(ModuleData module:moduleService.getAllModules())
			{
				if(module.getGroup().equals(group))
				{
					Row row = new Row();
					row.appendChild(new Label(module.getCode()));
					row.appendChild(new Label(module.getName()));
					
					Checkbox add = Components.checkbox(module.getGroup().equals(ModuleGroup.SYSTEM));
					Checkbox read = Components.checkbox(module.getGroup().equals(ModuleGroup.SYSTEM));
					Checkbox edit = Components.checkbox(module.getGroup().equals(ModuleGroup.SYSTEM));
					Checkbox delete = Components.checkbox(module.getGroup().equals(ModuleGroup.SYSTEM));
					Checkbox print = Components.checkbox(module.getGroup().equals(ModuleGroup.SYSTEM));
					
					row.appendChild(add);
					row.appendChild(read);
					row.appendChild(edit);
					row.appendChild(delete);
					row.appendChild(print);
					row.appendChild(new Label(group.name()));
					
					adds.add(add);
					reads.add(read);
					edits.add(edit);
					deletes.add(delete);
					prints.add(print);
					
					grid.getRows().appendChild(row);
				}
			}
			
			grid.appendChild(head);
			grid.setSpan("0");
			
			Tabpanel panel = new Tabpanel();
			panel.appendChild(grid);
			
			tabbox.getTabs().appendChild(new Tab(group.name()));
			tabbox.getTabpanels().appendChild(panel);
			
			modules.add(grid);
		}
	}
}
