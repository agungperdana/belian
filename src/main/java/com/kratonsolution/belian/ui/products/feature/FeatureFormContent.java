
package com.kratonsolution.belian.ui.products.feature;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.products.dm.ProductFeature;
import com.kratonsolution.belian.products.svc.ProductFeatureService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FeatureFormContent extends AbstractForm
{	
	private ProductFeatureService service = Springs.get(ProductFeatureService.class);
	
	private Textbox desription = Components.mandatoryTextBox(false);
	
	private ProductFeatureTypeList types = new ProductFeatureTypeList(false);
	
	private Textbox note = Components.textarea(null, false, false);
	
	public FeatureFormContent()
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
				Flow.next(getParent(), new FeatureGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(desription.getText()))
					throw new WrongValueException(desription,lang.get("message.field.empty"));
			
				if(types.getProductFeatureType() == null)
					throw new WrongValueException(types,lang.get("message.field.empty"));
			
				ProductFeature feature = new ProductFeature();
				feature.setValue(desription.getText());
				feature.setType(types.getProductFeatureType());
				feature.setNote(note.getText());
				
				service.add(feature);
				
				Flow.next(getParent(), new FeatureGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("inventory.product.grid.column.description")));
		row1.appendChild(desription);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("inventory.product.grid.column.type")));
		row2.appendChild(types);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("inventory.product.grid.column.note")));
		row3.appendChild(note);
				
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
	}
}
