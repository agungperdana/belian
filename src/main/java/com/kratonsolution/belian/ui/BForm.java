
package com.kratonsolution.belian.ui;

import org.zkoss.zul.A;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.global.svc.NumberGenerator;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class BForm extends Vlayout implements Removeable
{
	protected Language lang = Springs.get(Language.class);
	
	protected SessionUtils utils = Springs.get(SessionUtils.class);
	
	protected NumberGenerator numberGen = Springs.get(NumberGenerator.class);
	
	protected Breadcrumb breadcrumb = new Breadcrumb();
	
	protected Grid grid = new Grid();
	
	protected FormToolbar toolbar = new FormToolbar();
	
	public BForm()
	{
		setHflex("1");
		setVflex("1");
		setStyle("overflow:auto");
		
		grid.setWidth("100%");
		grid.appendChild(new Columns());
		grid.appendChild(new Rows());
		
//		appendChild(breadcrumb);
		appendChild(toolbar);
		appendChild(grid);
	}
	
	public void addRow(Row row)
	{
		if(row != null)
			grid.getRows().appendChild(row);
	}
	
	public void addColumn(Column column)
	{
		if(column != null)
			grid.getColumns().appendChild(column);
	}
	
	public void appendBreadcrumb(String label)
	{
		breadcrumb.appendChild(new Label(label));
	}
	
	public void appendBreadcrumbSeparator()
	{
		A a = new A();
		a.setIconSclass("z-icon-chevron-right");
		
		breadcrumb.appendChild(a);
	}
	
	public abstract void initToolbar();
	
	public abstract void initForm();
	
	public void onClose(){}
}
