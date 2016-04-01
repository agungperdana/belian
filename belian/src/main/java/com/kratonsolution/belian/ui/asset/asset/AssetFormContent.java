/**
 * 
 */
package com.kratonsolution.belian.ui.asset.asset;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.asset.dm.Asset;
import com.kratonsolution.belian.asset.svc.AssetService;
import com.kratonsolution.belian.asset.svc.AssetTypeService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class AssetFormContent extends FormContent
{	
	private AssetService service = Springs.get(AssetService.class);
	
	private AssetTypeService typeService = Springs.get(AssetTypeService.class);
	
	private Textbox code = Components.stdTextBox(null,false);
	
	private Textbox name = Components.stdTextBox(null,false);
	
	private Datebox acquired = Components.currentDatebox();
	
	private Datebox lastServiced = Components.currentDatebox();
	
	private Datebox nextServiced = Components.currentDatebox();
	
	private Doublebox price = Components.doubleBox(0);
	
	private Checkbox active = new Checkbox("Active");
	
	private Checkbox disposed = new Checkbox("Disposed");
	
	private Listbox types = Components.newSelect(typeService.findAll(),false);
	
	private Textbox note = new Textbox();
	
	public AssetFormContent()
	{
		super();
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
				AssetWindow window = (AssetWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(code.getText()))
					throw new WrongValueException(code,"Code cannot be empty");
			
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Name cannot be empty");
				
				Asset uom = new Asset();
				uom.setCode(code.getText());
				uom.setName(name.getText());
				uom.setNote(note.getText());
				
				service.add(uom);
				
				AssetWindow window = (AssetWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
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
		
		note.setWidth("350px");
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Code"));
		row1.appendChild(code);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Name"));
		row2.appendChild(name);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Note"));
		row3.appendChild(note);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
	}
}
