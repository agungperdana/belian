package com.kratonsolution.belian.security.ui.module;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.event.PagingEvent;
import org.zkoss.zul.event.ZulEvents;

import com.kratonsolution.belian.common.ui.GridContent;
import com.kratonsolution.belian.common.ui.util.FlowHelper;
import com.kratonsolution.belian.common.ui.util.RowUtils;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.common.ui.util.UIHelper;
import com.kratonsolution.belian.security.api.application.ModuleDeleteCommand;
import com.kratonsolution.belian.security.api.application.ModuleService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class ModuleGridContent extends GridContent
{
	private static final long serialVersionUID = -7191047588399258066L;

	private ModuleService service = Springs.get(ModuleService.class);

	public ModuleGridContent()
	{
		super();
		initToolbar();
		initGrid();
	}

	protected void initToolbar()
	{
		appendChild(toolbar);

		toolbar.getRefresh().addEventListener(Events.ON_CLICK, e->FlowHelper.next(ModuleUIEvent.toGrid()));
		toolbar.getNewData().addEventListener(Events.ON_CLICK, e->FlowHelper.next(ModuleUIEvent.newForm()));

		toolbar.getDelete().addEventListener(Events.ON_CLICK, e->{

			Messagebox.show(Labels.getLabel("warning.remove"),
					"Warning",Messagebox.CANCEL|Messagebox.OK, Messagebox.QUESTION, 
					new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					if(event.getName().equals("onOK"))
					{
						for(Object object:grid.getRows().getChildren())
						{
							Row row = (Row)object;

							if(RowUtils.isChecked(row,0)) {

								ModuleDeleteCommand command = new ModuleDeleteCommand();
								command.setCode(RowUtils.string(row, 1));
								service.delete(command);
							}
						}

						FlowHelper.next(ModuleUIEvent.toGrid());
					}
				}
			});
		});

		toolbar.getSearch().addEventListener(Events.ON_CLICK, e->{});
	}

	protected void initGrid()
	{
		final ModuleModel model = new ModuleModel();

		appendChild(grid);

		grid.setHeight("80%");
		grid.setEmptyMessage(Labels.getLabel("warning.grid.empty"));
		grid.setModel(model);
		grid.setRowRenderer(new ModuleRowRenderer());
		grid.setPagingPosition("both");
		grid.setMold("paging");
		grid.setPageSize(UIHelper.getSetting().getMaxRow());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"25px"));
		grid.getColumns().appendChild(new Column(Labels.getLabel("module.grid.code"),null,"200px"));
		grid.getColumns().appendChild(new Column(Labels.getLabel("user.grid.name"),null,"150px"));
		grid.getColumns().appendChild(new Column(Labels.getLabel("module.grid.group")));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().getLastChild().setVisible(false);
		grid.appendChild(getFoot(grid.getColumns().getChildren().size()));
		grid.setSpan("2");
		grid.addEventListener(ZulEvents.ON_PAGING,new EventListener<PagingEvent>()
		{
			@Override
			public void onEvent(PagingEvent event) throws Exception
			{
				model.next(event.getActivePage());
				grid.setModel(model);
			}
		});
	}
}