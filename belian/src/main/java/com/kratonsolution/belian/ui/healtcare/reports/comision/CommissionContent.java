/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.reports.comision;

import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.North;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.ReportToolbar;
import com.kratonsolution.belian.ui.healtcare.doctor.DoctorBox;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CommissionContent extends Borderlayout
{
	private Language lang = Springs.get(Language.class);
	
	private North north = new North();
	
	private Center center = new Center();
	
	public CommissionContent()
	{
		setHflex("1");
		setVflex("1");
		
		appendChild(north);
		appendChild(center);
	
		init();
	}
	
	private void init()
	{
		ReportToolbar toolbar = new ReportToolbar();
		
		DoctorBox doctorBox = new DoctorBox(false);
		Datebox start = new Datebox();
		Datebox end = new Datebox();
		
		Grid grid = new Grid();
		grid.appendChild(new Rows());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		grid.setSpan("1");
		grid.getRows().appendChild(RowUtils.row(lang.get("healtcare.grid.column.doctor"), doctorBox));
		grid.getRows().appendChild(RowUtils.row(lang.get("generic.grid.column.start"), start));
		grid.getRows().appendChild(RowUtils.row(lang.get("generic.grid.column.end"), end));
		
		Vlayout layout = new Vlayout();
		layout.appendChild(toolbar);
		layout.appendChild(grid);

		north.setTitle("Filter Criteria");
		north.setCollapsible(true);
		north.setMaxsize(155);
		north.appendChild(layout);
		
		Iframe iframe = new Iframe();
		iframe.setWidth("100%");
		iframe.setHeight("100%");
		
		center.appendChild(iframe);
	}
}
