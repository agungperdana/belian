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
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.asset.dm.Asset;
import com.kratonsolution.belian.asset.svc.AssetService;
import com.kratonsolution.belian.asset.svc.AssetTypeService;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.Removeable;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class AssetEditContent extends FormContent implements Removeable
{	
	private AssetService service = Springs.get(AssetService.class);

	private AssetTypeService typeService = Springs.get(AssetTypeService.class);

	private Textbox code = Components.mandatoryTextBox(false);

	private Textbox name = Components.mandatoryTextBox(false);

	private Datebox acquired = Components.currentDatebox();

	private Datebox lastServiced = Components.datebox();

	private Datebox nextServiced = Components.datebox();

	private Doublebox price = Components.stdDoubleBox(0);

	private Checkbox active = new Checkbox(lang.get("asset.grid.column.active"));

	private Checkbox disposed = new Checkbox(lang.get("asset.grid.column.disposed"));

	private Listbox types = Components.newSelect(typeService.findAll(),false);

	private OrganizationList companys = new OrganizationList();

	private Textbox note = Components.stdTextBox(null, false);

	private Row row;

	public AssetEditContent(Row row)
	{
		super();
		this.row = row;
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
				Asset asset = service.findOne(RowUtils.id(row));
				if(asset != null)
				{
					if(Strings.isNullOrEmpty(code.getText()))
						throw new WrongValueException(code,lang.get("message.field.empty"));

					if(Strings.isNullOrEmpty(name.getText()))
						throw new WrongValueException(name,lang.get("message.field.empty"));

					if(companys.getOrganization() == null)
						throw new WrongValueException(companys,lang.get("message.field.empty"));

					asset.setCode(code.getText());
					asset.setName(name.getText());
					asset.setAcquired(DateTimes.sql(acquired.getValue()));
					asset.setActive(active.isChecked());
					asset.setDisposed(disposed.isChecked());
					asset.setLastServiced(DateTimes.sql(lastServiced.getValue()));
					asset.setNextServiced(DateTimes.sql(nextServiced.getValue()));
					asset.setNote(note.getText());
					asset.setOrganization(companys.getOrganization());
					asset.setPrice(BigDecimal.valueOf(price.doubleValue()));
					asset.setType(typeService.findOne(Components.string(types)));

					service.edit(asset);
				}

				Flow.next(getParent(),new AssetGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		Asset asset = service.findOne(RowUtils.id(row));
		if(asset != null)
		{
			code.setText(asset.getCode());
			name.setText(asset.getName());
			companys.setOrganization(asset.getOrganization());
			acquired.setValue(asset.getAcquired());
			lastServiced.setValue(asset.getLastServiced());
			nextServiced.setValue(asset.getNextServiced());
			price.setValue(asset.getPrice().doubleValue());
			active.setChecked(asset.isActive());
			disposed.setChecked(asset.isDisposed());
			note.setText(asset.getNote());

			for(Listitem listitem:types.getItems())
			{
				if(listitem.getValue().toString().equals(asset.getType().getId()))
				{
					types.setSelectedItem(listitem);
					break;
				}
			}

			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());

			Row row0 = new Row();
			row0.appendChild(new Label(lang.get("asset.grid.column.company")));
			row0.appendChild(companys);
			
			Row row1 = new Row();
			row1.appendChild(new Label(lang.get("asset.grid.column.code")));
			row1.appendChild(code);
			
			Row row2 = new Row();
			row2.appendChild(new Label(lang.get("asset.grid.column.name")));
			row2.appendChild(name);
			
			Row row3 = new Row();
			row3.appendChild(new Label(lang.get("asset.grid.column.acquired")));
			row3.appendChild(acquired);
			
			Row row4 = new Row();
			row4.appendChild(new Label(lang.get("asset.grid.column.lastservice")));
			row4.appendChild(lastServiced);
			
			Row row5 = new Row();
			row5.appendChild(new Label(lang.get("asset.grid.column.nextservice")));
			row5.appendChild(nextServiced);
			
			Row row6 = new Row();
			row6.appendChild(new Label(lang.get("asset.grid.column.status")));
			row6.appendChild(active);
			
			Row row7 = new Row();
			row7.appendChild(new Label(lang.get("asset.grid.column.disposed")));
			row7.appendChild(disposed);
			
			Row row8 = new Row();
			row8.appendChild(new Label(lang.get("asset.grid.column.price")));
			row8.appendChild(price);
			
			Row row9 = new Row();
			row9.appendChild(new Label(lang.get("asset.grid.column.type")));
			row9.appendChild(types);
			
			Row row10 = new Row();
			row10.appendChild(new Label(lang.get("asset.grid.column.note")));
			row10.appendChild(note);

			rows.appendChild(row0);
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
}
