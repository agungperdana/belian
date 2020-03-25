package com.kratonsolution.belian.security.ui.role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.event.Event;
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
import com.kratonsolution.belian.common.ui.event.WindowContentChangeEvent;
import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.common.ui.util.FlowHelper;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.security.api.RoleData;
import com.kratonsolution.belian.security.api.application.ModuleService;
import com.kratonsolution.belian.security.api.application.RoleService;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class RoleEditContent extends AbstractForm
{	
	private static final long serialVersionUID = 4266050630661061597L;

	private RoleService service = Springs.get(RoleService.class);

	private ModuleService moduleService = Springs.get(ModuleService.class);
	
	private Textbox code = Components.mandatoryTextBox(false);

	private Textbox name = Components.mandatoryTextBox(false);

	private Textbox note = Components.stdTextBox(null,false);

	private Checkbox status = new Checkbox(Labels.getLabel("label.status"));
	
	private String roleCode;

	private Tabbox tabbox = new Tabbox();
	
	private Collection<Grid> modules = new ArrayList<>();

	public RoleEditContent(@NonNull String roleCode)
	{
		super();

		this.roleCode = roleCode;
		
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
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				FlowHelper.next(getParent(), WindowContentChangeEvent.GRID);
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

//				Role role = service.findOne(RowUtils.id(row));
//				if(role != null)
//				{
//					role.setCode(code.getText());
//					role.setName(name.getText());
//					role.setNote(note.getText());
//
//					for(Grid grid:modules)
//					{
//						Rows moduleRows = grid.getRows();
//						for(Object object:moduleRows.getChildren())
//						{
//							Row _row = (Row)object;
//
//							Iterator<AccessRole> iterator = role.getAccesses().iterator();
//							while (iterator.hasNext())
//							{
//								AccessRole accessRole = (AccessRole) iterator.next();
//								if(accessRole.getId().equals(RowUtils.string(_row, 7)))
//								{
//									accessRole.setCanCreate(RowUtils.isChecked(_row, 1));
//									accessRole.setCanRead(RowUtils.isChecked(_row, 2));
//									accessRole.setCanUpdate(RowUtils.isChecked(_row, 3));
//									accessRole.setCanDelete(RowUtils.isChecked(_row, 4));
//									accessRole.setCanPrint(RowUtils.isChecked(_row, 5));
//								}
//							}
//						}
//					}
//
//					service.edit(role);
//				}

				FlowHelper.next(getParent(), WindowContentChangeEvent.GRID);
			}
		});
	}

	@Override
	public void initForm()
	{
		Optional<RoleData> opt = service.getByCode(this.roleCode);
		if(!opt.isPresent()) {
			
			code.setConstraint("no empty");
			code.setWidth("250px");
			code.setText(opt.get().getCode());

			name.setConstraint("no empty");
			name.setWidth("250px");
			name.setText(opt.get().getName());

			note.setText(opt.get().getNote());
			note.setWidth("300px");
			
			status.setChecked(opt.get().isEnabled());
		}
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(Labels.getLabel("generic.grid.column.code")));
		row1.appendChild(code);
		
		Row row2 = new Row();
		row2.appendChild(new Label(Labels.getLabel("generic.grid.column.name")));
		row2.appendChild(name);
		
		Row row3 = new Row();
		row3.appendChild(new Label(Labels.getLabel("generic.grid.column.note")));
		row3.appendChild(note);

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
	}

	protected void initModules()
	{
		for(ModuleGroup group:ModuleGroup.values())
		{
			Grid grid = new Grid();
			grid.appendChild(new Columns());
			grid.appendChild(new Rows());
			grid.setSpan("0");
			grid.setHflex("1");
			
			Auxhead head = new Auxhead();
			Auxheader header = new Auxheader("Module Access");
			header.setColspan(8);
			header.setRowspan(1);

			head.appendChild(header);

			grid.getColumns().appendChild(new Column("Module",null,"175px"));
			grid.getColumns().appendChild(new Column(null,null,"85px"));
			grid.getColumns().appendChild(new Column(null,null,"85px"));
			grid.getColumns().appendChild(new Column(null,null,"85px"));
			grid.getColumns().appendChild(new Column(null,null,"85px"));
			grid.getColumns().appendChild(new Column(null,null,"85px"));
			grid.getColumns().appendChild(new Column());
			grid.getColumns().appendChild(new Column());
			grid.getColumns().getChildren().get(6).setVisible(false);
			grid.getColumns().getChildren().get(7).setVisible(false);

			Checkbox check1 = new Checkbox("Create");
			check1.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
			{
				@Override
				public void onEvent(CheckEvent event) throws Exception
				{
					Rows rows = grid.getRows();
					for(Object object:rows.getChildren())
					{
						Row _row = (Row)object;
						if(event.isChecked())
							RowUtils.checked(_row, 1);
						else
							RowUtils.unchecked(_row, 1);
					}
				}
			});

			Checkbox check2 = new Checkbox("Read");
			check2.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
			{
				@Override
				public void onEvent(CheckEvent event) throws Exception
				{
					Rows rows = grid.getRows();
					for(Object object:rows.getChildren())
					{
						Row _row = (Row)object;
						if(event.isChecked())
							RowUtils.checked(_row, 2);
						else
							RowUtils.unchecked(_row, 2);
					}
				}
			});

			Checkbox check3 = new Checkbox("Update");
			check3.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
			{
				@Override
				public void onEvent(CheckEvent event) throws Exception
				{
					Rows rows = grid.getRows();
					for(Object object:rows.getChildren())
					{
						Row _row = (Row)object;
						if(event.isChecked())
							RowUtils.checked(_row, 3);
						else
							RowUtils.unchecked(_row, 3);
					}
				}
			});

			Checkbox check4 = new Checkbox("Delete");
			check4.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
			{
				@Override
				public void onEvent(CheckEvent event) throws Exception
				{
					Rows rows = grid.getRows();
					for(Object object:rows.getChildren())
					{
						Row _row = (Row)object;
						if(event.isChecked())
							RowUtils.checked(_row, 4);
						else
							RowUtils.unchecked(_row, 4);
					}
				}
			});

			Checkbox check5 = new Checkbox("Print");
			check5.addEventListener(Events.ON_CHECK,new EventListener<CheckEvent>()
			{
				@Override
				public void onEvent(CheckEvent event) throws Exception
				{
					Rows rows = grid.getRows();
					for(Object object:rows.getChildren())
					{
						Row _row = (Row)object;
						if(event.isChecked())
							RowUtils.checked(_row, 5);
						else
							RowUtils.unchecked(_row, 5);
					}
				}
			});

			grid.getColumns().getChildren().get(1).appendChild(check1);
			grid.getColumns().getChildren().get(2).appendChild(check2);
			grid.getColumns().getChildren().get(3).appendChild(check3);
			grid.getColumns().getChildren().get(4).appendChild(check4);
			grid.getColumns().getChildren().get(5).appendChild(check5);

			List<Module> newModules = new ArrayList<Module>();

			Role role = service.findOne(RowUtils.string(this.row, 4));
			for(AccessRole accessRole:role.getAccesses())
			{
				if(accessRole.getModule() != null)
				{
					Module module = moduleService.findOne(accessRole.getModule().getId());
					if(module != null && module.getGroup().equals(group))
					{
						Checkbox create = new Checkbox();
						create.setChecked(accessRole.isCanCreate());

						Checkbox read = new Checkbox();
						read.setChecked(accessRole.isCanRead());

						Checkbox update = new Checkbox();
						update.setChecked(accessRole.isCanUpdate());

						Checkbox delete = new Checkbox();
						delete.setChecked(accessRole.isCanDelete());

						Checkbox print = new Checkbox();
						print.setChecked(accessRole.isCanPrint());

						Row row = new Row();
						row.appendChild(new Label(module.getName()));
						row.appendChild(create);
						row.appendChild(read);
						row.appendChild(update);
						row.appendChild(delete);
						row.appendChild(print);
						row.appendChild(new Label(module.getId()));
						row.appendChild(new Label(accessRole.getId()));

						grid.getRows().appendChild(row);
					}
				}
			}

			for(Module module:moduleService.findAll())
			{
				boolean exist = false;
				for(AccessRole accessRole:role.getAccesses())
				{
					if(accessRole.getModule() != null && accessRole.getModule().getId().equals(module.getId()))
						exist = true;
				}

				if(!exist)
					newModules.add(module);
			}

			if(!newModules.isEmpty())
			{
				for(Module module:newModules)
				{
					if(module.getGroup().equals(group))
					{
						Row row = new Row();
						row.appendChild(new Label(module.getName()));
						row.appendChild(new Checkbox());
						row.appendChild(new Checkbox());
						row.appendChild(new Checkbox());
						row.appendChild(new Checkbox());
						row.appendChild(new Checkbox());
						row.appendChild(new Label(module.getId()));

						grid.getRows().appendChild(row);
					}
				}
			}

			grid.appendChild(head);

			Tabpanel tabpanel = new Tabpanel();
			tabpanel.appendChild(grid);
			
			
			tabbox.getTabs().appendChild(new Tab(group.name().toString()));
			tabbox.getTabpanels().appendChild(tabpanel);
		
			modules.add(grid);
		}
	}
}
