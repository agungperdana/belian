package com.kratonsolution.belian.common.ui.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Cell;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class RowUtils
{
	
	public static Row shield(@NonNull String value)
	{
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
			{
				if(Strings.isNullOrEmpty(((Label)object).getValue()))
					return BigDecimal.ZERO;

				String txt = ((Label)object).getValue().replace(",", "");
				
				return new BigDecimal(txt);
			}
			if(object instanceof Doublebox)
				return BigDecimal.valueOf(((Doublebox)object).doubleValue());
			if(object instanceof Listbox)
				return Components.decimal((Listbox)object);
			if(object instanceof Decimalbox)
				return ((Decimalbox)object).getValue();
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
	
	public static Timestamp timestam(Row row,int index)
	{
		Object object = row.getChildren().get(index);
		if(object != null && object instanceof Datebox && ((Datebox)object).getValue() != null)
		{
			Date date = ((Datebox)object).getValue();
			return new Timestamp(date.getTime());
		}
		
		return null;
	}
	
	public static java.sql.Date sql(Row row,int index)
	{
		Date dt = date(row,index);
		if(dt != null)
			return new java.sql.Date(dt.getTime());
		
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
	
	public static boolean isChecked(Row row)
	{
		Component com = row.getFirstChild();
		if(com != null && com instanceof Checkbox)
			return ((Checkbox)com).isChecked();
		
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
	
	public static Row row(String label,String value,String align)
	{
		if(!Strings.isNullOrEmpty(label))
		{
			Label lb = new Label(label);
			lb.setStyle("float:"+align+";font-weight:bolder");
			
			Label con = new Label(value);
			con.setStyle("float:"+align+";font-weight:bolder");
			
			Row row = new Row();
			row.appendChild(lb);
			row.appendChild(con);
			
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
