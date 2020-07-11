package com.kratonsolution.belian.security.ui.user;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.common.ui.UISetting;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.common.ui.util.UIHelper;
import com.kratonsolution.belian.security.api.UserData;
import com.kratonsolution.belian.security.api.application.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Slf4j
public class UserModel implements ListModel<UserData>
{
	private final UserService service = Springs.get(UserService.class);
	
	private final UISetting setting = UIHelper.getSetting();
	
	private List<UserData> data = new ArrayList<>();
	
	public UserModel() {
		
		next(0);
	}
	
	@Override
	public UserData getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		log.info("User Count {}", service.count());
		return service.count();
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

	public void next(int pageIndex)
	{
		List<UserData> list = service.getAllUsers(pageIndex, (setting.getMaxRow()*pageIndex)+setting.getMaxRow());
		
		log.info("Users {}", list);
		
		data.clear();
		data.addAll(list);
	}
}
