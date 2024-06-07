
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Foot;
import org.zkoss.zul.Footer;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.common.app.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.tools.view.KernelTask;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class GridContent extends Vlayout implements Removeable
{
	protected SessionUtils utils = Springs.get(SessionUtils.class);
	
	protected Language lang = Springs.get(Language.class);
	
	protected KernelTask task = Springs.get(KernelTask.class);
	
	protected GridToolbar toolbar = new GridToolbar();
	
	protected Textbox filter = Components.textBox(null);
	
	protected Grid grid = new Grid();
	
	public GridContent()
	{
		setSpacing("3px");
		setWidth("100%");
		setHeight("100%");
		setStyle("overflow:auto");
		
		filter.setHeight("30px");
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
