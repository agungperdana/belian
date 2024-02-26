/**
 * 
 */
package com.kratonsolution.belian.ui.products.product;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.ui.Navigation;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class ProductNav extends Navigation
{
	private Toolbarbutton code = new Toolbarbutton(lang.get("inventory.product.grid.column.codes"),"/icons/codes32.png");
	
	private Toolbarbutton category = new Toolbarbutton(lang.get("inventory.product.grid.column.categorys"),"/icons/categorys32.png");
	
	private Toolbarbutton component = new Toolbarbutton(lang.get("inventory.product.grid.column.components"),"/icons/component32.png");
	
	private Toolbarbutton feature = new Toolbarbutton(lang.get("inventory.product.grid.column.features"),"/icons/feature32.png");
	
	private Toolbarbutton supplier = new Toolbarbutton(lang.get("inventory.product.grid.column.suppliers"),"/icons/supplier32.png");
	
	private Toolbarbutton price = new Toolbarbutton(lang.get("inventory.product.grid.column.prices"),"/icons/price32.png");
	
	private Toolbarbutton cost = new Toolbarbutton(lang.get("inventory.product.grid.column.costs"),"/icons/cost32.png");
	
	public ProductNav()
	{
		super();
		
		code.setOrient("vertical");
		code.setStyle("text-align:center;font-size:9px;");
		code.setWidth("55px");
		code.setHeight("55px");
		
		category.setOrient("vertical");
		category.setStyle("text-align:center;font-size:9px;");
		category.setWidth("55px");
		category.setHeight("55px");
		
		component.setOrient("vertical");
		component.setStyle("text-align:center;font-size:9px;");
		component.setWidth("55px");
		component.setHeight("55px");
		
		feature.setOrient("vertical");
		feature.setStyle("text-align:center;font-size:9px;");
		feature.setWidth("55px");
		feature.setHeight("55px");
		
		supplier.setOrient("vertical");
		supplier.setStyle("text-align:center;font-size:9px;");
		supplier.setWidth("55px");
		supplier.setHeight("55px");
		
		price.setOrient("vertical");
		price.setStyle("text-align:center;font-size:9px;");
		price.setWidth("55px");
		price.setHeight("55px");
		
		cost.setOrient("vertical");
		cost.setStyle("text-align:center;font-size:9px;");
		cost.setWidth("55px");
		cost.setHeight("55px");
		
		appendChild(code);
		appendChild(category);
		appendChild(component);
		appendChild(feature);
		appendChild(supplier);
		appendChild(price);
		appendChild(cost);
	}
	
	public void setAddMode(boolean addmode)
	{
		code.setDisabled(addmode);
		category.setDisabled(addmode);
		component.setDisabled(addmode);
		feature.setDisabled(addmode);
		supplier.setDisabled(addmode);
		price.setDisabled(addmode);
		cost.setDisabled(addmode);
	}
}
