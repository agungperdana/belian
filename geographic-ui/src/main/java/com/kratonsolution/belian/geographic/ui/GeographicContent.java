package com.kratonsolution.belian.geographic.ui;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Treecol;
import org.zkoss.zul.Treecols;

import com.kratonsolution.belian.common.ui.TreeContent;
import com.kratonsolution.belian.common.ui.event.ContentEvent;
import com.kratonsolution.belian.common.ui.event.GeographicUIContentEvent;
import com.kratonsolution.belian.common.ui.util.FlowHelper;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
public class GeographicContent extends TreeContent
{
	private static final long serialVersionUID = -7191047588399258066L;

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
				FlowHelper.next(GeographicUIContentEvent.toGrid());
			}
		});

		toolbar.getNewData().addEventListener(Events.ON_CLICK,new EventListener<Event>(){
			@Override
			public void onEvent(Event event) throws Exception
			{
				FlowHelper.next(GeographicUIContentEvent.newForm());
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
		tree.setModel(GeographicTreeModel.buid());
		tree.setItemRenderer(new GeographicTreeItemRenderer());
		
		appendChild(tree);
	}
}