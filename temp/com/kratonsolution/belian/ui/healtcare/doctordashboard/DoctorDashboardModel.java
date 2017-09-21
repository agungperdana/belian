/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.svc.DoctorAppointmentService;
import com.kratonsolution.belian.ui.SearchCriteria;
import com.kratonsolution.belian.ui.Searchable;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorDashboardModel implements ListModel<DoctorAppointment>,Searchable
{
	private DoctorAppointmentService service = Springs.get(DoctorAppointmentService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class); 
	
	private List<DoctorAppointment> data = new ArrayList<DoctorAppointment>();
	
	public DoctorDashboardModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public DoctorAppointment getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return service.size(new Date(System.currentTimeMillis()),utils.getOrganization().getId(),utils.getUser().getPerson().getId());
	}

	@Override
	public void addListDataListener(ListDataListener l)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListDataListener(ListDataListener l)
	{
		// TODO Auto-generated method stub
		
	}

	public void next(int pageIndex,int itemSize)
	{
		data.clear();
		data.addAll(service.findAllTodayByDoctor(new Date(System.currentTimeMillis()),utils.getOrganization().getId(),utils.getUser().getPerson().getId()));
	}

	@Override
	public void search(String param)
	{
		data.clear();
		
		if(Strings.isNullOrEmpty(param))
			data.addAll(service.findAll(new Date(System.currentTimeMillis()),utils.getOrganization().getId(),utils.getUser().getPerson().getId(),param));
		else
			data.addAll(service.findAllTodayByDoctor(new Date(System.currentTimeMillis()),utils.getOrganization().getId(),utils.getUser().getPerson().getId()));
	}

	@Override
	public void search(SearchCriteria criteria)
	{
	}
}
