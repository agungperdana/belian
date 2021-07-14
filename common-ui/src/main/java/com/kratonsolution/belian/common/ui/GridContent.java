package com.kratonsolution.belian.common.ui;

import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Foot;
import org.zkoss.zul.Footer;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.common.ui.toolbar.GridToolbar;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public abstract class GridContent extends Vlayout
{	
	private static final long serialVersionUID = 8061204597422773603L;

	protected GridToolbar toolbar = new GridToolbar();

	protected Textbox filter = new Textbox();

	protected Grid grid = new Grid();

	public GridContent()
	{
		setSpacing("3px");
		setWidth("100%");
		setHeight("100%");
		setStyle("overflow:auto");

		filter.setHeight("30px");

		toolbar.getSelect().addEventListener(Events.ON_CLICK, e->{

			Rows rows = grid.getRows();
			for(Object object:rows.getChildren())
			{
				Row row = (Row)object;

				if(row.getFirstChild() instanceof Checkbox)
				{
					Checkbox checkbox = (Checkbox)row.getFirstChild();
					checkbox.setChecked(true);
				}

				toolbar.removeChild(toolbar.getSelect());
				toolbar.insertBefore(toolbar.getDeselect(),toolbar.getDelete());
			}
		});

		toolbar.getDeselect().addEventListener(Events.ON_CLICK, e->{

			Rows rows = grid.getRows();
			for(Object object:rows.getChildren())
			{
				Row row = (Row)object;
				if(row.getFirstChild() instanceof Checkbox)
				{
					Checkbox checkbox = (Checkbox)row.getFirstChild();
					checkbox.setChecked(false);						
				}

				toolbar.removeChild(toolbar.getDeselect());
				toolbar.insertBefore(toolbar.getSelect(),toolbar.getDelete());
			}
		});
	}

	protected abstract void initToolbar();

	protected abstract void initGrid();

	protected Foot getFoot(int span)
	{
		Foot foot = new Foot();
		Footer footer = new Footer();
		footer.setSpan(span);
		footer.setHeight("30px");
		foot.appendChild(footer);

		return foot;
	}
}
