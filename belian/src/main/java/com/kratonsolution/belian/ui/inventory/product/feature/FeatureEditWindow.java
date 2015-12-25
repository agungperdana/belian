/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.product.feature;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductFeature;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.FormToolbar;
import com.kratonsolution.belian.ui.inventory.product.ProductEditContent;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class FeatureEditWindow extends AbstractWindow
{
	private Vlayout layout = new Vlayout();
	
	private FormToolbar toolbar = new FormToolbar();
	
	private Grid content = new Grid();
	
	private ProductService service = Springs.get(ProductService.class);
	
	private Product product;
	
	private Textbox value = new Textbox();
	
	private Textbox note = new Textbox();
	
	private Listbox types = new Listbox();

	private String featureId;
	
	public FeatureEditWindow(Product product,String featureId)
	{
		super();

		this.product = product;
		this.featureId = featureId;
		
		setMode(Mode.POPUP);
		
		Caption caption = new Caption("Product Feature");
		caption.setImage("/icons/product.png");
		
		appendChild(caption);
		
		layout.setWidth("100%");

		layout.appendChild(toolbar);
		layout.appendChild(content);
		
		content.appendChild(new Rows());
		content.appendChild(new Columns());
		
		appendChild(layout);
		
		initToolbar();
		initContent();
	}
	
	protected void initToolbar()
	{
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				ProductFeature feature = service.findFeature(product, featureId);
				if(feature != null)
				{
					feature.setValue(value.getText());
					feature.setNote(note.getText());
					feature.setType(ProductFeature.Type.valueOf(types.getSelectedItem().getValue().toString()));
					
					service.editFeature(feature);
				}
				
				ProductEditContent parent = (ProductEditContent)getParent();
				parent.refresh();
				parent.setSelectedTab(1);
				
				onClose();
			}
		});
		
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				onClose();
			}
		});
	}
	
	protected void initContent()
	{
		for(ProductFeature feature:product.getFeatures())
		{
			if(feature.getId().equals(featureId))
			{
				value.setText(feature.getValue());
				value.setConstraint("no empty");
				value.setWidth("250px");
				
				note.setText(feature.getNote());
				note.setWidth("300px");
				
				for(ProductFeature.Type type:ProductFeature.Type.values())
				{
					Listitem listitem = new Listitem(type.name(),type.name());
					types.appendChild(listitem);
					if(type.equals(feature.getType()))
						types.setSelectedItem(listitem);
				}
				
				types.setMold("select");
				
				content.getColumns().appendChild(new Column(null,null,"100px"));
				content.getColumns().appendChild(new Column());
				
				Row row1 = new Row();
				row1.appendChild(new Label("Value"));
				row1.appendChild(value);
				
				Row row2 = new Row();
				row2.appendChild(new Label("Type"));
				row2.appendChild(types);
				
				Row row3 = new Row();
				row3.appendChild(new Label("Note"));
				row3.appendChild(note);
				
				content.setWidth("100%");
				content.getRows().appendChild(row1);
				content.getRows().appendChild(row2);
				content.getRows().appendChild(row3);
				
				break;
			}
		}
		
	}
	
	@Override
	public void onClose()
	{
		setVisible(false);
		setParent(null);
	}
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.HasStatus#insertStatus()
	 */
	@Override
	public void insertStatus()
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.HasStatus#removeStatus()
	 */
	@Override
	public void removeStatus()
	{
		// TODO Auto-generated method stub

	}

}
