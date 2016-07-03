/**
 * 
 */
package com.kratonsolution.belian.ui.util;

import java.math.BigDecimal;
import java.util.Date;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Cell;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.HasEditForm;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class RowUtils
{
	public static Row shield(String value)
	{
		if(Strings.isNullOrEmpty(value))
			return null;
		
		Row row = new Row();
		row.appendChild(new Label(value));
		
		return row;
	}
	
	public static Row shield(Object value)
	{
		if(value instanceof String && Strings.isNullOrEmpty(value.toString()))
			return null;
		
		Row row = new Row();
		row.appendChild(new Label(value.toString()));
		
		return row;
	}
	
	public static String string(Row row,int index)
	{
		Object object = row.getChildren().get(index);
		if(object != null)
		{
			if(object instanceof Label)
				return ((Label)object).getValue();
			else if(object instanceof Listbox)
				return Components.string((Listbox)object);
			else if(object instanceof Textbox)
				return ((Textbox)object).getText();
		}
		
		return "";
	}
	
	public static String id(Row row)
	{
		Object object = row.getLastChild();
		if(object != null && object instanceof Label)
			return ((Label)object).getValue();
		
		return "";
	}
	
	public static BigDecimal decimal(Row row,int index)
	{
		Object object = row.getChildren().get(index);
		if(object != null)
		{
			if(object instanceof Label)
				return new BigDecimal(((Label)object).getValue());
			if(object instanceof Doublebox)
				return BigDecimal.valueOf(((Doublebox)object).doubleValue());
			if(object instanceof Listbox)
				return Components.decimal((Listbox)object);
		}
		
		return BigDecimal.ZERO;
	}
	
	public static int integer(Row row,int index)
	{
		Object object = row.getChildren().get(index);
		if(object != null && object instanceof Doublebox)
			return ((Doublebox)object).getValue().intValue();
		
		return 0;
	}
	
	public static Date date(Row row,int index)
	{
		Object object = row.getChildren().get(index);
		if(object != null && object instanceof Datebox)
			return ((Datebox)object).getValue();
		
		return null;
	}
	
	public static java.sql.Date sql(Row row,int index)
	{
		Date dt = date(row,index);
		if(dt != null)
			return DateTimes.sql(dt);
		
		return null;
	}
	
	public static boolean isChecked(Row row,int idex)
	{
		Component component = row.getChildren().get(idex);
		if(component != null && component instanceof Checkbox)
			return ((Checkbox)component).isChecked();
		else if(component instanceof Label)
		{
			Label label = (Label)component;
			if(label.getValue().equals("Active"))
				return true;
		}
		
		return false;
	}

	public static void checked(Row row,int idex)
	{
		Component component = row.getChildren().get(idex);
		if(component != null && component instanceof Checkbox)
		{
			((Checkbox)component).setChecked(true);
		}
	}
	
	public static void unchecked(Row row,int idex)
	{
		Component component = row.getChildren().get(idex);
		if(component != null && component instanceof Checkbox)
		{
			((Checkbox)component).setChecked(false);
		}
	}
	
	public static AbstractWindow window(Row row)
	{
		if(row.getParent() != null && row.getParent().getParent() != null && 
		   row.getParent().getParent().getParent() != null && row.getParent().getParent().getParent().getParent() != null)
		{
			if(row.getParent().getParent().getParent().getParent() instanceof HasEditForm)
				return (AbstractWindow)row.getParent().getParent().getParent().getParent();
		}
			
		return null;
	}

	public static Row row(String label,String value)
	{
		if(!Strings.isNullOrEmpty(label))
		{
			Row row = new Row();
			row.appendChild(new Label(label));
			row.appendChild(new Label(value));
			
			return row;
		}
		
		return new Row();
	}
	
	public static Row row(String label,Component component)
	{
		if(!Strings.isNullOrEmpty(label))
		{
			Row row = new Row();
			row.appendChild(new Label(label));
			row.appendChild(component);
			
			return row;
		}
		
		return new Row();
	}
	
	public static Row row(Component label,Component component)
	{
		Row row = new Row();
		row.appendChild(label);
		row.appendChild(component);
		
		return row;
	}
	
	public static Cell cell(String content,int colspan)
	{
		if(!Strings.isNullOrEmpty(content))
		{
			Cell cell = new Cell();
			cell.appendChild(new Label(content));
			cell.setColspan(colspan);
			cell.setStyle("font-weight:bolder;color:blue;");
			
			return cell;
		}
		
		return new Cell();
	}
}
