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
public class AssetTypeFormContent extends FormContent implements Removeable
{	
private AssetTypeService service = Springs.get(AssetTypeService.class);
	
	private Textbox code = new Textbox();

	private Textbox name = new Textbox();

	private Listbox types = Components.newSelect();
	
	private AssetType parent;
	
	public AssetTypeFormContent(AssetType parent)
	{
		super();

		this.parent = parent;
		
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
				AssetType type = new AssetType();
				type.setCode(code.getText());
				type.setName(name.getText());
				
				if(parent != null)
					type.setParent(parent);
			
				service.add(type);
				
				Flow.next(getParent().getParent().getParent(), new AssetTypeContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		code.setConstraint("no empty");
		code.setWidth("200px");
		
		name.setConstraint("no empty");
		name.setWidth("300px");
		
		types.setMold("select");
		if(this.parent != null)
		{
			types.appendItem(this.parent.getName(), this.parent.getId());
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
