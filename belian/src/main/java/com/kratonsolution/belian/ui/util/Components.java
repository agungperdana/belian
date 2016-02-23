/**
 * 
 */
package com.kratonsolution.belian.ui.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Date;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.global.dm.Listable;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.ui.component.ProductBox;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Components
{
	public static final String string(Listbox listbox)
	{
		if(listbox != null && !listbox.getChildren().isEmpty() && listbox.getSelectedCount() > 0)
			return listbox.getSelectedItem().getValue().toString();
		
		return "";
	}
	
	public static final BigDecimal decimal(Component component)
	{
		if(component != null && (component instanceof Listbox) && !component.getChildren().isEmpty())
		{
			Listbox listbox = (Listbox)component;
			return new BigDecimal(listbox.getSelectedItem().getValue().toString());
		}
		else if(component != null && (component instanceof Doublebox))
		{
			Doublebox doublebox = (Doublebox)component;
			return BigDecimal.valueOf(doublebox.doubleValue());
		}
		
		return BigDecimal.ZERO;
	}
	
	public static final void setDefault(Listbox listbox)
	{
		if(!listbox.getChildren().isEmpty())
			listbox.setSelectedIndex(0);
	}
	
	public static final Listbox newSelect()
	{
		Listbox listbox = new Listbox();
		listbox.setMold("select");
		
		return listbox;
	}
	
	public static final Listbox newSelect(Listable listable)
	{
		Listbox listbox = new Listbox();
		listbox.setMold("select");
		listbox.setStyle("text-align:center;");
		listbox.appendChild(new Listitem(listable.getLabel(),listable.getValue()));
		listbox.setSelectedIndex(0);
		
		return listbox;
	}
	
	public static final Listbox newSelect(String label,String value)
	{
		Listbox listbox = new Listbox();
		listbox.setMold("select");
		listbox.setStyle("text-align:center;");
		listbox.appendChild(new Listitem(label,value));
		listbox.setSelectedIndex(0);
		
		return listbox;
	}
	
	public static final Listbox newSelect(Collection<? extends Listable> collections,boolean setDefault)
	{
		Listbox listbox = new Listbox();
		listbox.setMold("select");
		listbox.setStyle("text-align:center;");
		
		for(Listable object:collections)
			listbox.appendChild(new Listitem(object.getLabel(), object.getValue()));
		
		if(setDefault && listbox.getItemCount() > 0)
			setDefault(listbox);
		
		return listbox;
	}
	
	public static final Listbox fullSpanSelect(Collection<? extends Listable> collections,boolean setDefault)
	{
		Listbox listbox = new Listbox();
		listbox.setMold("select");
		listbox.setStyle("text-align:center;");
		listbox.setWidth("100%");
		
		for(Listable object:collections)
			listbox.appendChild(new Listitem(object.getLabel(), object.getValue()));
		
		if(setDefault)
			setDefault(listbox);
		
		return listbox;
	}
	
	public static final Listbox fullSpanSelect(Listable listable)
	{
		Listbox listbox = new Listbox();
		listbox.setMold("select");
		listbox.setStyle("text-align:center;");
		listbox.setWidth("100%");
	
		if(listable != null)
		{
			listbox.appendChild(new Listitem(listable.getLabel(), listable.getValue()));
			listbox.setSelectedIndex(0);
		}
		
		return listbox;
	}
	
	public static final Listbox fullSpanSelect()
	{
		Listbox listbox = new Listbox();
		listbox.setMold("select");
		listbox.setWidth("100%");
		
		return listbox;
	}
	
	public static final Listbox fullSpanSelect(BigDecimal decimal)
	{
		Listbox listbox = new Listbox();
		listbox.setMold("select");
		listbox.setWidth("100%");
		listbox.appendChild(newListitem(decimal));
		listbox.setSelectedIndex(0);
		
		return listbox;
	}
	
	public static final Textbox readOnlyTextBox()
	{
		Textbox textbox = new Textbox();
		textbox.setWidth("100%");
		textbox.setReadonly(true);
		return textbox;
	}
	
	public static final Textbox readOnlyTextBox(String text)
	{
		Textbox textbox = new Textbox(text);
		textbox.setWidth("100%");
		textbox.setReadonly(true);
		return textbox;
	}
	
	public static final Doublebox readOnlyDoubleBox()
	{
		Doublebox box = new Doublebox(0d);
		box.setWidth("100%");
		box.setReadonly(true);
		box.setStyle("text-align:right;");
		return box;
	}
	
	public static final Textbox readOnlyMoneyBox(BigDecimal decimal)
	{
		NumberFormat format = NumberFormat.getNumberInstance();
		format.setGroupingUsed(true);
		
		Textbox box = new Textbox();
		box.setWidth("100%");
		box.setReadonly(true);
		box.setText(format.format(decimal));
		box.setStyle("text-align:right;");
		return box;
	}
	
	public static final Label numberLabel(BigDecimal amout)
	{
		NumberFormat format = NumberFormat.getNumberInstance();
		format.setGroupingUsed(true);
		
		Label label = new Label();
		label.setWidth("100%");
		label.setValue(format.format(amout));
		label.setStyle("text-align:right;");
		
		return label;
	}
	
	public static final Doublebox doubleOne()
	{
		Doublebox box = new Doublebox(1);
		box.setWidth("100%");
		box.setStyle("text-align:right;");
		return box;
	}
	
	public static final Doublebox readOnlyDoubleOne()
	{
		Doublebox box = new Doublebox(1);
		box.setWidth("100%");
		box.setReadonly(true);
		box.setStyle("text-align:right;");
		return box;
	}
	
	public static final Doublebox readOnlyDoubleBox(double value)
	{
		Doublebox box = new Doublebox(0d);
		box.setWidth("100%");
		box.setReadonly(true);
		box.setStyle("text-align:right;");
		box.setValue(value);
		
		return box;
	}
	
	public static final Doublebox doubleBox()
	{
		Doublebox box = new Doublebox(0d);
		box.setWidth("100%");
		box.setStyle("text-align:right;");
		return box;
	}
	
	public static final Doublebox doubleBox(double value)
	{
		Doublebox box = new Doublebox(0d);
		box.setWidth("100%");
		box.setStyle("text-align:right;");
		box.setValue(value);
		
		return box;
	}
	
	public static final boolean isEmpty(Listbox listbox)
	{
		if(listbox == null)
			return true;
		
		if(listbox.getChildren().isEmpty())
			return true;
		
		if(listbox.getSelectedCount() == 0)
			return true;
		
		return false;
	}
	
	public static final Checkbox readOnlyCheckbox()
	{
		Checkbox checkbox = new Checkbox();
		checkbox.setDisabled(true);
		
		return checkbox;
	}
	
	public static final Checkbox checkbox(boolean isChecked)
	{
		Checkbox checkbox = new Checkbox();
		checkbox.setChecked(isChecked);
		
		return checkbox;
	}
	
	public static final Textbox mandatoryTextBox()
	{
		Textbox textbox = new Textbox();
		textbox.setWidth("100%");
		textbox.setConstraint("no empty");
		
		return textbox;
	}
	
	public static final Textbox moneyBox()
	{
		Textbox textbox = new Textbox();
		textbox.setWidth("100%");
		textbox.setReadonly(true);
		textbox.setStyle("text-align:right");
		
		return textbox;
	}
	
	public static final Textbox mandatoryTextBox(String text)
	{
		Textbox textbox = new Textbox(text);
		textbox.setWidth("100%");
		textbox.setConstraint("no empty");
		textbox.setText("0");
		
		return textbox;
	}
	
	public static final Textbox textBox(String text)
	{
		Textbox textbox = new Textbox(text);
		textbox.setWidth("100%");
		
		return textbox;
	}
	
	public static final Datebox mandatoryDatebox()
	{
		Datebox datebox = new Datebox(new Date());
		datebox.setWidth("100%");
		datebox.setConstraint("no empty");
		
		return datebox;
	}
	
	public static final Datebox mandatoryDatebox(Date date)
	{
		Datebox datebox = new Datebox(date);
		datebox.setWidth("100%");
		datebox.setConstraint("no empty");
		
		return datebox;
	}
	
	public static final Datebox currentDatebox()
	{
		Datebox datebox = new Datebox(new Date());
		datebox.setWidth("150px");
		datebox.setConstraint("no empty");
		
		return datebox;
	}
	
	public static final Datebox datebox()
	{
		Datebox datebox = new Datebox();
		datebox.setWidth("150px");
		
		return datebox;
	}
	
	public static final Datebox fullSpanDatebox(Date date)
	{
		Datebox datebox = new Datebox(date);
		datebox.setWidth("100%");
		
		return datebox;
	}
	
	public static final Datebox fullSpanReadOnlyDatebox(Date date)
	{
		Datebox datebox = new Datebox(date);
		datebox.setWidth("100%");
		datebox.setReadonly(true);
		datebox.setDisabled(true);

		if(date != null)
			datebox.setValue(date);
		
		return datebox;
	}
	
	public static Combobox autoComplete()
	{
		Combobox combobox = new Combobox();
		combobox.setAutodrop(true);
		combobox.setButtonVisible(false);
		combobox.setWidth("250px");
		
		return combobox;
	}
	
	public static Label label(BigDecimal decimal)
	{
		Label label = new Label();
		label.setWidth("100%");
		label.setStyle("text-align:right;");
		label.setValue(Numbers.format(decimal));
		
		return label;
	}

	public static final Listitem newListitem(BigDecimal decimal)
	{
		return new Listitem(Numbers.format(decimal), decimal);
	}
	
	public static final Listitem newListitem(Listable listable)
	{
		return new Listitem(listable.getLabel(),listable.getValue());
	}
	
	public static final Row row(int numberOfCell,String lastCellContent)
	{
		Row row = new Row();
		for(int idx=1;idx<numberOfCell;idx++)
			row.appendChild(new Label(""));
		
		row.appendChild(new Label(lastCellContent));
		
		return row;
	}
	
	public static final Product product(Row row,int index)
	{
		if(row.getChildren().get(index) != null && row.getChildren().get(index) instanceof ProductBox)
		{
			ProductBox box = (ProductBox)row.getChildren().get(index);
			return box.getProduct();
		}
		
		return null;
	}
}
