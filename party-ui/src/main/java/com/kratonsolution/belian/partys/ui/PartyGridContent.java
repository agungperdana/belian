package com.kratonsolution.belian.partys.ui;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;

import com.kratonsolution.belian.common.ui.GridContent;
import com.kratonsolution.belian.common.ui.event.UIEvent;
import com.kratonsolution.belian.common.ui.util.FlowHelper;
import com.kratonsolution.belian.common.ui.util.RowUtils;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.common.ui.util.UIHelper;
import com.kratonsolution.belian.party.api.application.PartyDeleteCommand;
import com.kratonsolution.belian.party.api.application.PartyService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class PartyGridContent extends GridContent
{
	private static final long serialVersionUID = -7191047588399258066L;

	private PartyService service = Springs.get(PartyService.class);

	public PartyGridContent()
	{
		super();
		initToolbar();
		initGrid();
	}

	protected void initToolbar()
	{
		appendChild(toolbar);

		toolbar.getRefresh().addEventListener(Events.ON_CLICK, e->FlowHelper.next(new PartyUIEvent(UIEvent.GRID)));
		toolbar.getNewData().addEventListener(Events.ON_CLICK, e->FlowHelper.next(new PartyUIEvent(UIEvent.ADD_FORM)));
		toolbar.getDelete().addEventListener(Events.ON_CLICK, ev->{
			
			Messagebox.show(Labels.getLabel("warning.remove"), "Warning",Messagebox.CANCEL|Messagebox.OK, Messagebox.QUESTION, e-> {

				if(e.getName().equals("onOK"))
				{
					for(Object object:grid.getRows().getChildren())
					{
						Row row = (Row)object;

						if(RowUtils.isChecked(row,0)) {

							PartyDeleteCommand command = new PartyDeleteCommand();
							command.setCode(RowUtils.string(row, 1));
							service.delete(command);
						}
					}

					FlowHelper.next(new PartyUIEvent(UIEvent.GRID));
				}
			});
		});

		toolbar.getSearch().addEventListener(Events.ON_CLICK, e->{});

	}

	protected void initGrid()
	{
		grid.setHeight("80%");
		grid.setEmptyMessage(Labels.getLabel("warning.grid.empty"));
		grid.setModel(PartyModel.build(1));
		grid.setRowRenderer(new PartyRowRenderer());
		grid.setPagingPosition("both");
		grid.setMold("paging");
		grid.setPageSize(UIHelper.getSetting().getMaxRow());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"25px"));
		grid.getColumns().appendChild(new Column(Labels.getLabel("party.label.code"),null,"200px"));
		grid.getColumns().appendChild(new Column(Labels.getLabel("party.label.name"),null,"150px"));
		grid.getColumns().appendChild(new Column(Labels.getLabel("party.label.taxcode"), null, "85px"));
		grid.getColumns().appendChild(new Column(Labels.getLabel("party.label.type"), null, "125px"));
		grid.appendChild(getFoot(grid.getColumns().getChildren().size()));
		grid.setSpan("2");

		appendChild(grid);
	}
}