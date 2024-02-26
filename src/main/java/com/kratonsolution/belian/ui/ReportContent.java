/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.North;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class ReportContent extends Borderlayout implements Removeable
{
	protected Language lang = Springs.get(Language.class);
	
	protected SessionUtils utils = Springs.get(SessionUtils.class);
	
	protected ReportToolbar toolbar = new ReportToolbar();

	private North north = new North();
	
	private Center center = new Center();
	
	protected Iframe frame = new Iframe();
	
	public ReportContent()
	{
		setWidth("100%");
		setStyle("overflow: auto");
		
		toolbar.setWidth("100%");
		toolbar.removeChild(toolbar.getPrint());
		
		frame.setHflex("1");
		frame.setVflex("1");
		frame.setStyle("overflow: auto");
		
		north.setHeight(toolbar.getHeight());
		north.appendChild(toolbar);
		center.appendChild(frame);
		
		appendChild(north);
		appendChild(center);
	}

	protected abstract void initToolbar();
	
	protected abstract void initContent();
}
