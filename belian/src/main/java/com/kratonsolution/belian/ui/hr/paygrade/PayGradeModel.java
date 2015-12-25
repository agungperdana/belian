/**
 * 
 */
package com.kratonsolution.belian.ui.hr.paygrade;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.hr.dm.PayGrade;
import com.kratonsolution.belian.hr.svc.PayGradeService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PayGradeModel implements ListModel<PayGrade>
{
	private final PayGradeService controller = Springs.get(PayGradeService.class);
	
	private List<PayGrade> data = new ArrayList<PayGrade>();
	
	public PayGradeModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public PayGrade getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return data.size();
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
		data.addAll(controller.findAll(0, (itemSize*pageIndex)+itemSize));
	}
}
