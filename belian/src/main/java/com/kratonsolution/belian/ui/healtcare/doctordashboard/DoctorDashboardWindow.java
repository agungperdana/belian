/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import org.zkoss.zul.Caption;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Vbox;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorDashboardWindow extends AbstractWindow
{
	private Language language = Springs.get(Language.class);
	
	private Caption caption = new Caption(language.get("navbar.menu.healtcare.doctordashboard"));
	
	private Vbox layout = new Vbox();
	
	private Hbox content = new Hbox();
	
	private Hbox toolbar = new Hbox();
	
	public DoctorDashboardWindow()
	{
		super();
		setWidth("675px");
		init();
	}
	
	protected void init()
	{
		caption.setImage("/icons/doctordashboard.png");
		appendChild(caption);
		
		layout.setHeight("100%");
		layout.setWidth("100%");
		
		toolbar.setWidth("20%");
		toolbar.setHeight("100%");
		
		content.setWidth("80%");
		content.setHeight("100%");
		
		layout.appendChild(toolbar);
		layout.appendChild(content);
		
		appendChild(layout);
	}
	
	@Override
	public void onClose()
	{
		setVisible(false);
		removeStatus();
		setPage(null);
	}

	@Override
	public void insertStatus(){}

	@Override
	public void removeStatus(){}
}
