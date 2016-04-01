/**
 * 
 */
package com.kratonsolution.belian.ui.assettype;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.asset.dm.AssetType;
import com.kratonsolution.belian.asset.svc.AssetTypeService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.Removeable;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class AssetTypeEditContent extends FormContent implements Removeable
{	
	private AssetTypeService service = Springs.get(AssetTypeService.class);
	
	private Textbox code = new Textbox();

	private Textbox name = new Textbox();

	private Listbox types = Components.newSelect();

	private AssetType asset;

	public AssetTypeEditContent(AssetType asset)
	{
		super();
		
		this.asset = asset;
		
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
				Flow.next(getParent(), null);
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				asset.setCode(code.getText());
				asset.setName(name.getText());
				
				service.edit(asset);
				
				Flow.next(getParent(), null);
			}
		});

		Toolbarbutton child = new Toolbarbutton("New Type","/icons/new-warehouse.png");
		toolbar.appendChild(child);
		child.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new AssetTypeFormContent(asset));
			}
		});
	}

	@Override
	public void initForm()
	{
		if(asset != null)
		{
			code.setConstraint("no empty");
			code.setText(asset.getCode());
			code.setWidth("250px");

			name.setConstraint("no empty");
			name.setWidth("300px");
			name.setText(asset.getName());

			types.setMold("select");
			if(asset.getParent() != null)
			{
				types.appendItem(asset.getParent().getName(), asset.getParent().getId());
				types.setSelectedIndex(0);
			}

			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"100px"));
			grid.getColumns().appendChild(new Column());

			Row row1 = new Row();
			row1.appendChild(new Label("Code"));
			row1.appendChild(code);

			Row row2 = new Row();
			row2.appendChild(new Label("Name"));
			row2.appendChild(name);

			Row row3 = new Row();
			row3.appendChild(new Label("Parent"));
			row3.appendChild(types);

			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
		}
	}
}
