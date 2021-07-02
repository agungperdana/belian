package com.kratonsolution.belian.security.ui.role;

import org.zkoss.zul.ListModelList;

import com.kratonsolution.belian.access.api.RoleData;
import com.kratonsolution.belian.access.api.application.RoleService;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.common.ui.util.UIHelper;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class RoleModel extends ListModelList<RoleData>
{
	private static final long serialVersionUID = 5135076577674305975L;

	public RoleModel() {
		super(Springs.get(RoleService.class).getAllRoles(0, UIHelper.getSetting().getMaxRow()), true);
	}
}
