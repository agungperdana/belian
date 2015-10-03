/**
 * 
 */
package com.kratonsolution.belian.ui.util;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.global.dm.Listable;

/**
 * @author agungdodiperdana
 *
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
		listbox.appendChild(new Listitem(listable.getLabel(),listable.getValue()));
		listbox.setSelectedIndex(0);
		
		return listbox;
	}
	
	public static final Listbox newSelect(String label,String value)
	{
		Listbox listbox = new Listbox();
		listbox.setMold("select");
		listbox.appendChild(new Listitem(label,value));
		listbox.setSelectedIndex(0);
		
		return listbox;
	}
	
	public static final Listbox newSelect(Collection<? extends Listable> collections,boolean setDefault)
	{
		Listbox listbox = new Listbox();
		listbox.setMold("select");
		
		for(Listable object:collections)
			listbox.appendChild(new Listitem(object.getLabel(), object.getValue()));
		
		if(setDefault)
			setDefault(listbox);
		
		return listbox;
	}
	
	public static final Listbox fullSpanSelect(Collection<? extends Listable> collections,boolean setDefault)
	{
		Listbox listbox = new Listbox();
		listbox.setMold("select");
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
		listbox.setWidth("100%");
		listbox.appendChild(new Listitem(listable.getLabel(), listable.getValue()));
		listbox.setSelectedIndex(0);
		
		return listbox;
	}
	
	public static final Listbox fullSpanSelect()
	{
		Listbox listbox = new Listbox();
		listbox.setMold("select");
		listbox.setWidth("100%");
		
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
	
	public static final Textbox mandatoryTextBox(String text)
	{
		Textbox textbox = new Textbox(text);
		textbox.setWidth("100%");
		textbox.setConstraint("no empty");
		
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
}
