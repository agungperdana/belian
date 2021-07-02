package com.kratonsolution.belian.security.ui.user;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;

import com.kratonsolution.belian.access.api.application.UserDeleteCommand;
import com.kratonsolution.belian.access.api.application.UserService;
import com.kratonsolution.belian.common.ui.GridContent;
import com.kratonsolution.belian.common.ui.util.FlowHelper;
import com.kratonsolution.belian.common.ui.util.RowUtils;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.common.ui.util.UIHelper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Slf4j
public class UserGridContent extends GridContent
{
	private static final long serialVersionUID = 6355501178171697053L;

	private UserService service = Springs.get(UserService.class);

	public UserGridContent()
	{
		super();
		initToolbar();
		initGrid();
	}

	protected void initToolbar()
	{
		appendChild(toolbar);
		
		toolbar.getRefresh().addEventListener(Events.ON_CLICK, e->FlowHelper.next(UserUIEvent.toGrid()));
		toolbar.getNewData().addEventListener(Events.ON_CLICK, e->FlowHelper.next(UserUIEvent.newForm()));
		toolbar.getDelete().addEventListener(Events.ON_CLICK, e->{

			Messagebox.show(Labels.getLabel("message.removedata"),"Warning",
					Messagebox.CANCEL|Messagebox.OK, Messagebox.QUESTION,ev->{
						
						if(ev.getName().equals("onOK"))
						{
							grid.getRows().getChildren().forEach(rw -> {

								log.info("Selected row {}", RowUtils.isChecked((Row)rw));
								
								if(RowUtils.isChecked((Row)rw)) {
									
									UserDeleteCommand command = new UserDeleteCommand();
									command.setName(RowUtils.string((Row)rw, 1));

									service.delete(command);
									grid.setModel(UserModel.build());
								}
							});
						}
					});
		});

		toolbar.getSearch().addEventListener(Events.ON_CLICK,e->{});

	}

	protected void initGrid()
	{
		appendChild(grid);
		
		grid.setHeight("80%");
		grid.setEmptyMessage(Labels.getLabel("message.grid.empty"));
		grid.setModel(UserModel.build());
		grid.setRowRenderer(new UserRowRenderer());
		grid.setPagingPosition("both");
		grid.setMold("paging");
		grid.setPageSize(UIHelper.getSetting().getMaxRow());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"25px"));
		grid.getColumns().appendChild(new Column(Labels.getLabel("user.grid.name")));
		grid.getColumns().appendChild(new Column(Labels.getLabel("user.grid.email")));
		grid.getColumns().appendChild(new Column(Labels.getLabel("user.grid.status")));
		grid.appendChild(getFoot(grid.getColumns().getChildren().size()));
	}
}