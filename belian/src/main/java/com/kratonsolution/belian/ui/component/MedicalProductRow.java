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
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.general.dm.IndustrySegmentation;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductPrice;
import com.kratonsolution.belian.inventory.dm.ProductPrice.Type;
import com.kratonsolution.belian.inventory.dm.ProductPriceRepository;
import com.kratonsolution.belian.inventory.dm.ProductRepository;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class MedicalProductRow extends Row
{
	private ProductRepository repository = Springs.get(ProductRepository.class);

	private ProductRepository productRepository = Springs.get(ProductRepository.class);
	
	private ProductPriceRepository priceRepository = Springs.get(ProductPriceRepository.class);
	
	private Combobox products = new Combobox();

	private Listbox prices = Components.newSelect();

	private Listbox discounts = Components.newSelect();

	private Listbox uoms = Components.newSelect();
	
	private Listbox charges = Components.newSelect();
	
	private Doublebox quantity = Components.doubleOne();

	private Textbox note = new Textbox();
	
	private Checkbox deleteable = new Checkbox();
	
	private Collection<ProductPriceSelectionListener> listeners = new ArrayList<ProductPriceSelectionListener>();

	public MedicalProductRow(String geographic,String customer,String currency,boolean bpjs)
	{
		appendChild(deleteable);
		appendChild(products);
		appendChild(quantity);
		appendChild(uoms);
		appendChild(note);
		
		init(geographic,customer,currency,bpjs);
	}
	
	public Product getProduct()
	{
		if(products.getSelectedItem() != null)
			return productRepository.findOne(products.getSelectedItem().getId());
		
		return null;
	}
	
	public void setProduct(Product product)
	{
		products.appendChild(new ProductComboItem(product));
		products.setSelectedIndex(0);
		
		uoms.appendItem(product.getUom().getName(), product.getUom().getId());
		uoms.setSelectedIndex(0);
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
		return BigDecimal.valueOf(Double.parseDouble(prices.getSelectedItem().getValue().toString()));
	}
	
	public BigDecimal getDiscount()
	{
		return BigDecimal.valueOf(Double.parseDouble(discounts.getSelectedItem().getValue().toString()));
	}
	
	public BigDecimal getCharge()
	{
		return BigDecimal.valueOf(Double.parseDouble(charges.getSelectedItem().getValue().toString()));
	}
	
	public String getNote()
	{
		return note.getText();
	}
	
	public void undeleteable()
	{
		this.deleteable.setDisabled(true);
	}

	private void init(String geographic,String customer,String currency,boolean bpjs)
	{
		ProductListener listener = new ProductListener(geographic,customer,currency,bpjs);
		
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
		
		private boolean bpjs;
		
		public ProductListener(String geographic,String customer,String currency,boolean bpjs)
		{
			this.location = geographic;
			this.customer = customer;
			this.currency = currency;
			this.bpjs = bpjs;
		}
		
		@Override
		public void onEvent(Event event) throws Exception
		{
			if(event instanceof InputEvent)
			{
				InputEvent input = (InputEvent)event;

				products.getChildren().clear();
				
				if(!Strings.isNullOrEmpty(input.getValue()))
				{
					for(Product product:repository.findAll(new Date(System.currentTimeMillis()),input.getValue(),IndustrySegmentation.MEDICAL))
					{
						Comboitem item = products.appendItem(product.getName());
						item.setId(product.getId());
					}
				}
				else
				{
					for(Product product:repository.findAll(new Date(System.currentTimeMillis()),IndustrySegmentation.MEDICAL))
					{
						Comboitem item = products.appendItem(product.getName());
						item.setId(product.getId());
					}
				}
			}
			else
			{
				if(products.getSelectedItem() != null)
				{
					for(Comboitem comboitem:products.getItems())
					{
						if(comboitem.getId().equals(products.getSelectedItem().getId()))
						{
							Product product = productRepository.findOne(comboitem.getId());
							if(product != null)
							{
								initPrice(product);
								initUom(product);
							}
						}
					}
				}
			}
//			else if(event instanceof SelectEvent)
//			{
//				if(products.getSelectedItem() != null)
//				{
//					ProductComboItem item = (ProductComboItem)products.getSelectedItem();
//					initPrice(item.getProduct());
//					initUom(item.getProduct());
//				}
//				else
//					Clients.showNotification("Please select product first.");
//				
//			}
//			else if(event instanceof KeyEvent)
//			{
//				KeyEvent key = (KeyEvent)event;
//				if(key.getName().equals("onOK"))
//				{
//					Product product = productRepository.findOneByName(products.getValue());
//					if(product != null)
//					{
//						initPrice(product);
//						initUom(product);
//					}
//				}
//				else if(key.getKeyCode() == KeyEvent.DOWN)
//				{
//					for(Product product:repository.findAll(new Date(System.currentTimeMillis()),IndustrySegmentation.MEDICAL))
//						products.appendChild(new ProductComboItem(product));
//				}
//			}
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
				for(ProductPrice price:priceRepository.findAll(new Date(System.currentTimeMillis()),location,customer,currency,item.getId(),Type.BASE))
					prices.appendItem(price.getLabel(), price.getValue());

				for(ProductPrice price:priceRepository.findAll(new Date(System.currentTimeMillis()),location,customer,currency,item.getId(),Type.DISCOUNT))
					discounts.appendItem(price.getLabel(), price.getValue());
				
				for(ProductPrice price:priceRepository.findAll(new Date(System.currentTimeMillis()),location,customer,currency,item.getId(),Type.CHARGE))
					charges.appendItem(price.getLabel(), price.getValue());
			}
			
			if(!Strings.isNullOrEmpty(location))
			{
				for(ProductPrice price:priceRepository.findAllWithLocation(new Date(System.currentTimeMillis()),location,currency,item.getId(),Type.BASE))
					prices.appendItem(price.getLabel(), price.getValue());
				
				for(ProductPrice price:priceRepository.findAllWithLocation(new Date(System.currentTimeMillis()),location,currency,item.getId(),Type.DISCOUNT))
					discounts.appendItem(price.getLabel(), price.getValue());
				
				for(ProductPrice price:priceRepository.findAllWithLocation(new Date(System.currentTimeMillis()),location,currency,item.getId(),Type.CHARGE))
					charges.appendItem(price.getLabel(), price.getValue());
			}
			
			if(!Strings.isNullOrEmpty(customer))
			{
				for(ProductPrice price:priceRepository.findAllWithCustomer(new Date(System.currentTimeMillis()),customer,currency,item.getId(),Type.BASE))
					prices.appendItem(price.getLabel(), price.getValue());
				
				for(ProductPrice price:priceRepository.findAllWithCustomer(new Date(System.currentTimeMillis()),customer,currency,item.getId(),Type.DISCOUNT))
					discounts.appendItem(price.getLabel(), price.getValue());
				
				for(ProductPrice price:priceRepository.findAllWithCustomer(new Date(System.currentTimeMillis()),customer,currency,item.getId(),Type.CHARGE))
					charges.appendItem(price.getLabel(), price.getValue());
			}
			
			if(prices.getChildren().isEmpty())
			{
				if(bpjs)
				{
					for(ProductPrice price:priceRepository.findAll(new Date(System.currentTimeMillis()),currency,item.getId(),Type.BPJS))
						prices.appendItem("BPJS ("+price.getLabel()+")", price.getValue());
				}
				
				for(ProductPrice price:priceRepository.findAll(new Date(System.currentTimeMillis()),currency,item.getId(),Type.BASE))
					prices.appendItem("Reguler ("+price.getLabel()+")", price.getValue());
			}
			
			if(discounts.getChildren().isEmpty())
			{
				for(ProductPrice price:priceRepository.findAll(new Date(System.currentTimeMillis()),currency,item.getId(),Type.DISCOUNT))
					discounts.appendItem(price.getLabel(), price.getValue());
			}
			
			if(charges.getChildren().isEmpty())
			{
				for(ProductPrice price:priceRepository.findAll(new Date(System.currentTimeMillis()),currency,item.getId(),Type.CHARGE))
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