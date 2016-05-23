/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.event.KeyEvent;
import org.zkoss.zk.ui.event.SelectEvent;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductPrice;
import com.kratonsolution.belian.inventory.dm.ProductPriceRepository;
import com.kratonsolution.belian.inventory.dm.ProductPriceType;
import com.kratonsolution.belian.inventory.dm.ProductRepository;
import com.kratonsolution.belian.sales.dm.BillableItem;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductRow extends Row
{
	private ProductRepository repository = Springs.get(ProductRepository.class);

	private ProductRepository productRepository = Springs.get(ProductRepository.class);
	
	private ProductPriceRepository priceRepository = Springs.get(ProductPriceRepository.class);
	
	private Combobox products = new Combobox();

	private Listbox prices = Components.newSelect();

	private Listbox discounts = Components.newSelect();

	private Listbox uoms = Components.newSelect();
	
	private Listbox charges = Components.newSelect();
	
	private Doublebox quantity = Components.readOnlyDoubleOne();

	private Textbox note = new Textbox();
	
	private EventListener<Event> onSelectEvent;
	
	private Collection<ProductPriceSelectionListener> listeners = new ArrayList<ProductPriceSelectionListener>();

	public ProductRow(String geographic,String customer,String currency)
	{
		appendChild(new Checkbox());
		appendChild(products);
		appendChild(quantity);
		appendChild(uoms);
		appendChild(prices);
		appendChild(discounts);
		appendChild(charges);
		appendChild(note);
		
		initComponent();
		init(geographic,customer,currency);
	}
	
	public ProductRow(BillableItem item,EventListener<Event> onSelectEvent)
	{
		this.onSelectEvent = onSelectEvent;
		setId(item.getId());
		initComponent();
		
		appendChild(products);
		appendChild(quantity);
		appendChild(uoms);
		appendChild(prices);
		appendChild(discounts);
		appendChild(charges);
		appendChild(note);
		appendChild(new Label(item.getId()));
		
		setBillable(item);
	}

	private void initComponent()
	{
		products.setWidth("100%");
		quantity.setWidth("100%");
		uoms.setWidth("100%");
		prices.setWidth("100%");
		discounts.setWidth("100%");
		charges.setWidth("100%");
		note.setWidth("100%");
		
		if(onSelectEvent != null)
		{
			prices.addEventListener(Events.ON_SELECT,onSelectEvent);
			discounts.addEventListener(Events.ON_SELECT,onSelectEvent);
			charges.addEventListener(Events.ON_SELECT,onSelectEvent);
		}
	}
	
	public Product getProduct()
	{
		if(products.getSelectedItem() != null)
			return ((ProductComboItem)products.getSelectedItem()).getProduct();
		
		return null;
	}
	
	public void setBillable(BillableItem bill)
	{
		
		products.appendChild(new ProductComboItem(bill.getProduct()));
		products.setSelectedIndex(0);
		products.setReadonly(true);
	
		quantity.setValue(bill.getQuantity().doubleValue());
		quantity.setReadonly(true);
		
		uoms.appendItem(bill.getProduct().getUom().getName(), bill.getProduct().getUom().getId());
		uoms.setSelectedIndex(0);
		
		for(ProductPrice price:bill.getProduct().getPrices())
		{
			if(!price.getType().equals(ProductPriceType.DISCOUNT) && !price.getType().equals(ProductPriceType.CHARGE))
			{
				Listitem itm = prices.appendItem(price.getLabel()+"("+price.getType().name()+")", price.getValue());
				if(price.getType().equals(ProductPriceType.BASE))
					prices.setSelectedItem(itm);
			}
		}
		
		for(ProductPrice price:bill.getProduct().getPrices())
			if(price.getType().equals(ProductPriceType.DISCOUNT))
				discounts.appendItem(price.getLabel(), price.getValue());
		
		for(ProductPrice price:bill.getProduct().getPrices())
			if(price.getType().equals(ProductPriceType.CHARGE))
				charges.appendItem(price.getLabel(), price.getValue());
		
		note.setText(bill.getNote());
		
		if(prices.getChildren().isEmpty())
		{
			prices.appendItem("Free", "0");
			Components.setDefault(prices);
		}
		
		if(discounts.getChildren().isEmpty())
		{
			discounts.appendItem("No Discount", "0");
			Components.setDefault(discounts);
		}
		
		if(charges.getChildren().isEmpty())
		{
			charges.appendItem("No Charge", "0");
			Components.setDefault(charges);
		}
	}
	
	public void setProduct(Product product)
	{
		products.appendChild(new ProductComboItem(product));
		products.setSelectedIndex(0);
		
		uoms.appendItem(product.getUom().getName(), product.getUom().getId());
		uoms.setSelectedIndex(0);
		
		for(ProductPrice price:product.getPrices())
			prices.appendItem(price.getLabel(), price.getValue());
	}
	
	public void setQuantity(BigDecimal quantity)
	{
		this.quantity.setValue(quantity.doubleValue());
	}
	
	public void setPrice(BigDecimal price)
	{
		prices.appendItem(Numbers.format(price), price.toString());
		prices.setSelectedIndex(0);
	}
	
	public void setDiscount(BigDecimal discount)
	{
		discounts.appendItem(Numbers.format(discount), discount.toString());
		discounts.setSelectedIndex(0);
	}
	
	public void setCharge(BigDecimal charge)
	{
		charges.appendItem(Numbers.format(charge), charge.toString());
		charges.setSelectedIndex(0);
	}
	
	public void setNote(String text)
	{
		note.setText(text);
	}
	
	public BigDecimal getQuantity()
	{
		return BigDecimal.valueOf(quantity.getValue());
	}
	
	public BigDecimal getPrice()
	{
		if(prices.getSelectedItem() == null)
			return BigDecimal.ZERO;
		
		return BigDecimal.valueOf(Double.parseDouble(prices.getSelectedItem().getValue().toString()));
	}
	
	public BigDecimal getDiscount()
	{
		if(discounts.getSelectedItem() == null)
			return BigDecimal.ZERO;
		
		return BigDecimal.valueOf(Double.parseDouble(discounts.getSelectedItem().getValue().toString()));
	}
	
	public BigDecimal getCharge()
	{
		if(charges.getSelectedItem() == null)
			return BigDecimal.ZERO;
		
		return BigDecimal.valueOf(Double.parseDouble(charges.getSelectedItem().getValue().toString()));
	}
	
	public String getNote()
	{
		return note.getText();
	}

	private void init(String geographic,String customer,String currency)
	{
		ProductListener listener = new ProductListener(geographic,customer,currency);
		
		products.setWidth("100%");
		products.setConstraint("no empty");
		products.setAutocomplete(true);
		products.setAutodrop(true);
		products.addEventListener(Events.ON_CHANGING,listener );
		products.addEventListener(Events.ON_OK, listener);
		products.addEventListener(Events.ON_CANCEL, listener);
		products.addEventListener(Events.ON_SELECT, listener);

		prices.setWidth("100%");
		discounts.setWidth("100%");

		quantity.setWidth("100%");
		quantity.setConstraint("no empty");
		quantity.addEventListener(Events.ON_CHANGE, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				for(ProductPriceSelectionListener listener:listeners)
					listener.fireSelectedPrice(BigDecimal.valueOf(Double.parseDouble(quantity.getText())), Components.decimal(prices), Components.decimal(discounts), Components.decimal(charges));
			}
		});
		quantity.addEventListener(Events.ON_OK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				for(ProductPriceSelectionListener listener:listeners)
					listener.fireSelectedPrice(BigDecimal.valueOf(Double.parseDouble(quantity.getText())), Components.decimal(prices), Components.decimal(discounts), Components.decimal(charges));
			}
		});
		quantity.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				for(ProductPriceSelectionListener listener:listeners)
					listener.fireSelectedPrice(BigDecimal.valueOf(Double.parseDouble(quantity.getText())), Components.decimal(prices), Components.decimal(discounts), Components.decimal(charges));
			}
		});
		quantity.addEventListener(Events.ON_CANCEL, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				for(ProductPriceSelectionListener listener:listeners)
					listener.fireSelectedPrice(BigDecimal.valueOf(Double.parseDouble(quantity.getText())), Components.decimal(prices), Components.decimal(discounts), Components.decimal(charges));
			}
		});
		
		uoms.setWidth("100%");
		charges.setWidth("100%");
		
		note.setWidth("100%");
	}

	public void addProductPriceListener(ProductPriceSelectionListener listener)
	{
		if(listener != null)
			listeners.add(listener);
	}
	
	private class ProductListener implements EventListener<Event>
	{
		private String location;
		
		private String customer;
		
		private String currency;
		
		public ProductListener(String geographic,String customer,String currency)
		{
			this.location = geographic;
			this.customer = customer;
			this.currency = currency;
		}
		
		@Override
		public void onEvent(Event event) throws Exception
		{
			if(event instanceof InputEvent)
			{
				InputEvent input = (InputEvent)event;

				products.getChildren().clear();

				for(Product product:repository.findAll(new Date(System.currentTimeMillis()),input.getValue()))
					products.appendChild(new ProductComboItem(product));
			}
			else if(event instanceof SelectEvent)
			{
				if(products.getSelectedItem() != null)
				{
					ProductComboItem item = (ProductComboItem)products.getSelectedItem();
					initPrice(item.getProduct());
					initUom(item.getProduct());
				}
				else
					Clients.showNotification("Please select product first.");
				
			}
			else if(event instanceof KeyEvent)
			{
				KeyEvent key = (KeyEvent)event;
				if(key.getName().equals("onOK"))
				{
					Product product = productRepository.findOneByName(products.getValue());
					if(product != null)
					{
						initPrice(product);
						initUom(product);
					}
				}
			}
		}

		private void initUom(Product item)
		{
			uoms.appendItem(item.getUom().getName(), item.getUom().getId());
			uoms.setSelectedIndex(0);
		}

		private void initPrice(Product item)
		{
			prices.getChildren().clear();
			discounts.getChildren().clear();
			charges.getChildren().clear();
			
			/**
			 * populate price for selected product
			 */
			if(!Strings.isNullOrEmpty(location) && !Strings.isNullOrEmpty(customer))
			{
				for(ProductPrice price:priceRepository.findAll(new Date(System.currentTimeMillis()),location,customer,currency,item.getId(),ProductPriceType.BASE))
					prices.appendItem(price.getLabel(), price.getValue());

				for(ProductPrice price:priceRepository.findAll(new Date(System.currentTimeMillis()),location,customer,currency,item.getId(),ProductPriceType.DISCOUNT))
					discounts.appendItem(price.getLabel(), price.getValue());
				
				for(ProductPrice price:priceRepository.findAll(new Date(System.currentTimeMillis()),location,customer,currency,item.getId(),ProductPriceType.CHARGE))
					charges.appendItem(price.getLabel(), price.getValue());
			}
			
			if(!Strings.isNullOrEmpty(location))
			{
				for(ProductPrice price:priceRepository.findAllWithLocation(new Date(System.currentTimeMillis()),location,currency,item.getId(),ProductPriceType.BASE))
					prices.appendItem(price.getLabel(), price.getValue());
				
				for(ProductPrice price:priceRepository.findAllWithLocation(new Date(System.currentTimeMillis()),location,currency,item.getId(),ProductPriceType.DISCOUNT))
					discounts.appendItem(price.getLabel(), price.getValue());
				
				for(ProductPrice price:priceRepository.findAllWithLocation(new Date(System.currentTimeMillis()),location,currency,item.getId(),ProductPriceType.CHARGE))
					charges.appendItem(price.getLabel(), price.getValue());
			}
			
			if(!Strings.isNullOrEmpty(customer))
			{
				for(ProductPrice price:priceRepository.findAllWithCustomer(new Date(System.currentTimeMillis()),customer,currency,item.getId(),ProductPriceType.BASE))
					prices.appendItem(price.getLabel(), price.getValue());
				
				for(ProductPrice price:priceRepository.findAllWithCustomer(new Date(System.currentTimeMillis()),customer,currency,item.getId(),ProductPriceType.DISCOUNT))
					discounts.appendItem(price.getLabel(), price.getValue());
				
				for(ProductPrice price:priceRepository.findAllWithCustomer(new Date(System.currentTimeMillis()),customer,currency,item.getId(),ProductPriceType.CHARGE))
					charges.appendItem(price.getLabel(), price.getValue());
			}
			
			if(prices.getChildren().isEmpty())
			{
				for(ProductPrice price:priceRepository.findAll(new Date(System.currentTimeMillis()),currency,item.getId(),ProductPriceType.BASE))
					prices.appendItem(price.getLabel(), price.getValue());
			}
			
			if(discounts.getChildren().isEmpty())
			{
				for(ProductPrice price:priceRepository.findAll(new Date(System.currentTimeMillis()),currency,item.getId(),ProductPriceType.DISCOUNT))
					discounts.appendItem(price.getLabel(), price.getValue());
			}
			
			if(charges.getChildren().isEmpty())
			{
				for(ProductPrice price:priceRepository.findAll(new Date(System.currentTimeMillis()),currency,item.getId(),ProductPriceType.CHARGE))
					charges.appendItem(price.getLabel(), price.getValue());
			}
			
			if(prices.getChildren().isEmpty())
				prices.appendItem("0","0");

			discounts.appendItem("0","0");
			charges.appendItem("0","0");

			Components.setDefault(prices);
			Components.setDefault(discounts);
			Components.setDefault(charges);
			
			quantity.setReadonly(false);
			
			for(ProductPriceSelectionListener listener:listeners)
				listener.fireSelectedPrice(BigDecimal.valueOf(quantity.getValue()), Components.decimal(prices), Components.decimal(discounts), Components.decimal(charges));
		}
	}
}
