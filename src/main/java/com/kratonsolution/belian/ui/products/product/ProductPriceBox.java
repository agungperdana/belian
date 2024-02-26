/**
 * 
 */
package com.kratonsolution.belian.ui.products.product;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Vector;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.A;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.api.dm.Observable;
import com.kratonsolution.belian.api.dm.Observer;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.products.dm.PriceComponent;
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.ProductFeature;
import com.kratonsolution.belian.products.dm.SaleType;
import com.kratonsolution.belian.products.svc.ProductService;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.Springs;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
public class ProductPriceBox extends Hbox implements Observer,Observable
{
	private IDValueRef product;
	
	private IDValueRef feature;
	
	private IDValueRef customer;
		
	private Date date = DateTimes.currentDate();
	
	private Decimalbox nominal = new Decimalbox(BigDecimal.ZERO);
	
	private A a = new A();
	
	private Language lang = Springs.get(Language.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private ProductService service = Springs.get(ProductService.class);
	
	private Vector<Observer> observers = new Vector<>();
	
	public ProductPriceBox(boolean fullspan)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("150px");
		
		a.setIconSclass("z-icon-search");
		
		appendChild(nominal);
		appendChild(a);
		
		nominal.setHflex("1");
		nominal.setStyle("text-align:right");
		
		a.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(product == null && feature == null)
				{
					Clients.showNotification(lang.get("inventory.product.grid.column.emptyproductorfeature"));
					return;
				}
					
				Display display = new Display();
				display.setTitle(lang.get("label.component.generic.pricelist"));
				display.setPage(getPage());
				display.doModal();
			}
		});
	}
	
	private class Display extends Window
	{
		public Display()
		{
			setBorder(false);
			setWidth("65%");
			setClosable(true);
		
			Grid grid = new Grid();
			grid.setWidth("100%");
			grid.setEmptyMessage(lang.get("message.grid.empty"));
			grid.appendChild(new Rows());
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"25px"));
			grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.start"),null,"125px"));
			grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.end"),null,"125px"));
			grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.price"),null,"150px"));
			grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.organization"),null,"150px"));
			grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.customer"),null,"200px"));
			grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.geographic"),null,"150px"));
			grid.getColumns().appendChild(new Column(lang.get("inventory.product.grid.column.saletype"),null,"150px"));
			grid.setSpan("4");
			
			Product out = service.findOne(product.getId());
			if(out != null)
			{
				for(PriceComponent component:out.getPrices())
				{
					if(component.getOrganization().getId().equals(utils.getOrganization().getId()) && 
					   customer != null && component.getCustomer().getId().equals(customer.getId()) &&
					   DateTimes.inRange(date, component.getStart(), component.getEnd()) && 
					   component.getSaleType().equals(SaleType.STANDARD_RETAIL_SALES))
					{
						A a = new A();
						a.setIconSclass("z-icon-plus-circle");
						a.addEventListener(Events.ON_CLICK, new EventListener<Event>()
						{
							@Override
							public void onEvent(Event event) throws Exception
							{
								nominal.setValue(component.getPrice());
								
								for(Observer observer:observers)
									observer.valueChange(component.toRef());

								detach();
							}
						});
						
						Row row = new Row();
						row.appendChild(a);
						row.appendChild(new Label(DateTimes.format(component.getStart())));
						row.appendChild(new Label(DateTimes.format(component.getEnd())));
						row.appendChild(new Label(Numbers.format(component.getPrice())));
						row.appendChild(new Label(component.getOrganization()!=null?component.getOrganization().getValue():""));
						row.appendChild(new Label(component.getCustomer()!=null?component.getCustomer().getValue():""));
						row.appendChild(new Label(component.getArea()!=null?component.getArea().getValue():""));
						row.appendChild(new Label(component.getSaleType()!=null?component.getSaleType().display(utils.getLanguage()):""));
						
						grid.getRows().appendChild(row);
					}
				}
			}
			
			appendChild(grid);
		}
	}
	
	@Override
	public void valueChange(IDValueRef value)
	{
		if(value != null)
		{
			if(value.getType().equals(Product.class.getSimpleName()))
				product = value;
			else if(value.getType().equals(ProductFeature.class.getSimpleName()))
				feature = value;
			
			nominal.setValue(BigDecimal.ZERO);
		}
	}

	@Override
	public void addObserver(Observer observer)
	{
		if(observer != null)
			observers.add(observer);
	}
}
