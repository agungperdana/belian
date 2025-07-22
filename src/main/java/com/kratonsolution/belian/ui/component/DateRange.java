
package com.kratonsolution.belian.ui.component;

import java.sql.Date;

import org.zkoss.zul.Datebox;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DateRange extends Hbox
{
	private Language lang = Springs.get(Language.class);
	
	private Label startLabel = new Label(lang.get("generic.grid.column.start"));
	
	private Label endLabel = new Label(lang.get("generic.grid.column.end"));
	
	private Datebox start = new Datebox();
	
	private Datebox end = new Datebox();
	
	public DateRange()
	{
		setWidth("100%");
		appendChild(startLabel);
		appendChild(start);
		appendChild(endLabel);
		appendChild(end);
	}
	
	public Date getStart()
	{
		return DateTimes.sql(start.getValue());
	}
	
	public Date getEnd()
	{
		return DateTimes.sql(end.getValue());
	}
}
