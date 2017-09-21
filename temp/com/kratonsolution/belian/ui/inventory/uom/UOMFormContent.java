/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.uom;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.general.dm.UOMFactor;
import com.kratonsolution.belian.general.dm.UOMType;
import com.kratonsolution.belian.general.dm.UnitOfMeasure;
import com.kratonsolution.belian.inventory.svc.UnitOfMeasureService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class UOMFormContent extends FormContent
{	
	private UnitOfMeasureService service = Springs.get(UnitOfMeasureService.class);
	
	private Textbox code = Components.mandatoryTextBox(false);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private Listbox types = Components.newSelect();
	
	private Textbox note = Components.stdTextBox(null,false);
	
	private Grid factors = new Grid();
	
	public UOMFormContent()
	{
		super();
		initToolbar();
		initForm();
		initFactors();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new UOMGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(code.getText()))
					throw new WrongValueException(code,lang.get("message.field.empty"));
			
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,lang.get("message.field.empty"));
				
				UnitOfMeasure uom = new UnitOfMeasure();
				uom.setCode(code.getText());
				uom.setName(name.getText());
				uom.setType(UOMType.valueOf(Components.string(types)));
				uom.setNote(note.getText());
				
				for(Component comp:factors.getRows().getChildren())
				{
					Row row = (Row)comp;
					
					UOMFactor factor = new UOMFactor();
					factor.setFrom(uom);
					factor.setTo(service.findOne(RowUtils.string(row, 1)));
					factor.setFactor(RowUtils.decimal(row, 2));
					
					uom.getFactors().add(factor);
				}
				
				service.add(uom);
				
				Flow.next(getParent(), new UOMGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		for(UOMType type:UOMType.values())
			types.setSelectedItem(types.appendItem(type.name(), type.name()));
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("generic.grid.column.code")));
		row1.appendChild(code);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("generic.grid.column.name")));
		row2.appendChild(name);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("generic.grid.column.type")));
		row3.appendChild(types);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("generic.grid.column.note")));
		row4.appendChild(note);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
	}
	
	private void initFactors()
	{
		NRCToolbar nrc = new NRCToolbar(factors);
		
		factors.setWidth("100%");
		factors.appendChild(new Rows());
		factors.appendChild(new Columns());
		factors.setEmptyMessage(lang.get("message.grid.empty"));
		factors.getColumns().appendChild(new Column(null,null,"25px"));
		factors.getColumns().appendChild(new Column(lang.get("uom.grid.to"),null,"200px"));
		factors.getColumns().appendChild(new Column(lang.get("uom.grid.factor"),null,"85px"));
		factors.setSpan("1");
		factors.getColumns().getLastChild().setVisible(false);
		
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.fullSpanSelect(service.findAll(),true));
				row.appendChild(Components.doubleOne());
				
				factors.getRows().appendChild(row);
			}
		});
		
		appendChild(nrc);
		appendChild(factors);
	}
}
