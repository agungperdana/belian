
package com.kratonsolution.belian.ui;

import org.zkoss.zk.ui.GenericRichlet;
import org.zkoss.zk.ui.Page;
import org.zkoss.zul.Style;
import org.zkoss.zul.Timer;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.tools.view.KernelTask;
import com.kratonsolution.belian.ui.nav.BMenuBar;
import com.kratonsolution.belian.ui.nav.Fisheyes;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Desktop extends GenericRichlet
{
	/* (non-Javadoc)
	 * @see org.zkoss.zk.ui.Richlet#service(org.zkoss.zk.ui.Page)
	 */
	@Override
	public void service(Page page) throws Exception
	{
		Timer timer = new Timer(3600000);
		timer.start();
		
		KernelTask task = Springs.get(KernelTask.class);
		
		if(task != null)
			task.clears();
		
		page.setTitle("BelianERP 1.0");
		
		Style style = new Style("/css/belian.css");
		style.setPage(page);
		
		Vlayout midle = new Vlayout();
		midle.setVflex("1");
		
		Vbox canvas = new Vbox();
		canvas.setSclass("frmaedisplay");
		canvas.setHflex("1");
		canvas.setVflex("1");
		canvas.setAlign("center");
		canvas.setPack("center");
		canvas.appendChild(new BMenuBar());
		canvas.appendChild(midle);
		canvas.appendChild((Fisheyes)Springs.get(KernelTask.class).setDocks(new Fisheyes()));
	
//		canvas.setPage(page);
		
		new UIDashboard().setPage(page);
	}
}