package com.kratonsolution.belian.security.ui.user;

import org.zkoss.zul.ListModelList;

import com.kratonsolution.belian.access.api.UserData;
import com.kratonsolution.belian.access.api.application.UserService;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.common.ui.util.UIHelper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Slf4j
public class UserModel extends ListModelList<UserData>
{
	private static final long serialVersionUID = 1375335679104539758L;

	private int totalSize = 1;
	
	UserModel() {
		
		super(Springs.get(UserService.class).getAllUsers(0, UIHelper.getSetting().getMaxRow()), true);
		totalSize = Springs.get(UserService.class).count();
		log.info("USERS {} & Size {}", _list, totalSize);
	}

	@Override
	public int getSize() {

		return totalSize;
	}

	public void next(int pageIndex) {
	}
	
	public static UserModel build() {
		return new UserModel();
	}
}
