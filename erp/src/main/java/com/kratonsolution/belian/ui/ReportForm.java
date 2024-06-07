
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.common.app.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class ReportForm extends Vlayout implements Removeable
{
	protected Language lang = Springs.get(Language.class);
	
	protected SessionUtils utils = Springs.get(SessionUtils.class);
	
	protected ReportToolbar toolbar = new ReportToolbar();

	protected Grid grid = new Grid();
	
	public ReportForm()
	{
		setWidth("100%");
		
		toolbar.setWidth("100%");

		grid.setWidth("100%");
		grid.appendChild(new Rows());
		grid.appendChild(new Columns());
		
		appendChild(toolbar);
		appendChild(grid);
	}

	protected abstract void initToolbar();

	protected abstract void initForm();
}
