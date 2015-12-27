/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Row;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.HasCreateForm;
import com.kratonsolution.belian.ui.HasEditForm;
import com.kratonsolution.belian.ui.HasGrid;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorDashboardWindow extends AbstractWindow implements HasGrid,HasCreateForm,HasEditForm
{
	private Language language = Springs.get(Language.class);
	
	private Caption caption = new Caption(language.get("navbar.menu.healtcare.doctordashboard"));
	
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
		insertGrid();
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

	@Override
	public void insertEditForm(Row row)
	{
		appendChild(new DoctorDashboardEditContent(row));
	}

	@Override
	public void removeEditForm()
	{
		for(Component component:getChildren())
		{
			if(component instanceof DoctorDashboardEditContent)
			{
				removeChild(component);
				break;
			}
		}
	}

	@Override
	public void insertCreateForm(){}

	@Override
	public void removeCreateForm(){}

	@Override
	public void insertGrid()
	{
		appendChild(new DoctorDashboardGridContent());
	}

	@Override
	public void removeGrid()
	{
		for(Component component:getChildren())
		{
			if(component instanceof DoctorDashboardGridContent)
			{
				removeChild(component);
				break;
			}
		}
	}	
}
