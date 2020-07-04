package com.kratonsolution.belian.geographic.ui;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Treecol;
import org.zkoss.zul.Treecols;

import com.kratonsolution.belian.common.ui.TreeContent;
import com.kratonsolution.belian.common.ui.util.FlowHelper;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.geographic.api.application.GeographicDeleteCommand;
import com.kratonsolution.belian.geographic.api.application.GeographicService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
public class GeographicContent extends TreeContent
{
	private static final long serialVersionUID = -7191047588399258066L;

	private GeographicTreeModel model = GeographicTreeModel.buid();
	
	public GeographicContent()
	{
		super();
		initToolbar();
		initTree();
	}

	protected void initToolbar()
	{
		appendChild(toolbar);

		toolbar.getRefresh().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				FlowHelper.next(GeographicUIEvent.toGrid());
			}
		});

		toolbar.getNewData().addEventListener(Events.ON_CLICK,new EventListener<Event>(){
			@Override
			public void onEvent(Event event) throws Exception
			{
				FlowHelper.next(GeographicUIEvent.newForm());
			}
		});

		toolbar.getSelect().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{

			}
		});

		toolbar.getDeselect().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
			}
		});

		toolbar.getDelete().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Messagebox.show(Labels.getLabel("warning.remove"),
						"Warning",Messagebox.CANCEL|Messagebox.OK, Messagebox.QUESTION, 
						new EventListener<Event>()
				{
					@Override
					public void onEvent(Event event) throws Exception
					{
						model.getSelection().forEach(node -> {
							
							GeographicDeleteCommand command = new GeographicDeleteCommand();
							command.setCode(node.getData().getCode());
							
							Springs.get(GeographicService.class).delete(command);
							FlowHelper.next(GeographicUIEvent.toGrid());
						});
					}
				});
			}
		});

		toolbar.getSearch().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
			}
		});

	}

	@Override
	protected void initTree() {

		Treecols cols = new Treecols();
		cols.appendChild(new Treecol(Labels.getLabel("geographic.label.code")));
		cols.appendChild(new Treecol(Labels.getLabel("geographic.label.name")));
		cols.appendChild(new Treecol(Labels.getLabel("geographic.label.type")));
		cols.appendChild(new Treecol(Labels.getLabel("geographic.label.note")));
		
		tree.appendChild(cols);
		tree.setModel(model);
		tree.setItemRenderer(new GeographicTreeItemRenderer());
		tree.setCheckmark(true);
		
		appendChild(tree);
	}
}