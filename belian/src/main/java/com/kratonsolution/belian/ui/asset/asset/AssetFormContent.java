/**
 * 
 */
package com.kratonsolution.belian.ui.asset.asset;

import java.math.BigDecimal;

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
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.Removeable;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Dates;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class AssetFormContent extends FormContent implements Removeable
{	
	private AssetService service = Springs.get(AssetService.class);
	
	private AssetTypeService typeService = Springs.get(AssetTypeService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Textbox code = Components.stdTextBox(null,false);
	
	private Textbox name = Components.stdTextBox(null,false);
	
	private Datebox acquired = Components.currentDatebox();
	
	private Datebox lastServiced = Components.datebox();
	
	private Datebox nextServiced = Components.datebox();
	
	private Doublebox price = Components.stdDoubleBox(0);
	
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
				Flow.next(getParent(),new AssetGridContent());
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
				
				Asset asset = new Asset();
				asset.setCode(code.getText());
				asset.setName(name.getText());
				asset.setAcquired(Dates.sql(acquired.getValue()));
				asset.setActive(active.isChecked());
				asset.setDisposed(disposed.isChecked());
				asset.setLastServiced(Dates.sql(lastServiced.getValue()));
				asset.setNextServiced(Dates.sql(nextServiced.getValue()));
				asset.setNote(note.getText());
				asset.setOrganization(utils.getOrganization());
				asset.setPrice(BigDecimal.valueOf(price.doubleValue()));
				asset.setType(typeService.findOne(Components.string(types)));
				
				service.add(asset);
				
				Flow.next(getParent(),new AssetGridContent());
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
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Code"));
		row1.appendChild(code);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Name"));
		row2.appendChild(name);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Acquired Date"));
		row3.appendChild(acquired);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Last service"));
		row4.appendChild(lastServiced);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Next Service"));
		row5.appendChild(nextServiced);
		
		Row row6 = new Row();
		row6.appendChild(new Label("Used Status"));
		row6.appendChild(active);
		
		Row row7 = new Row();
		row7.appendChild(new Label("Dispose Status"));
		row7.appendChild(disposed);
		
		Row row8 = new Row();
		row8.appendChild(new Label("Price"));
		row8.appendChild(price);
		
		Row row9 = new Row();
		row9.appendChild(new Label("Types"));
		row9.appendChild(types);
		
		Row row10 = new Row();
		row10.appendChild(new Label("Note"));
		row10.appendChild(note);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row7);
		rows.appendChild(row8);
		rows.appendChild(row9);
		rows.appendChild(row10);
	}
}
