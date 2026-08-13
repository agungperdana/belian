
package com.kratonsolution.belian.ui.setting;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;
import com.kratonsolution.belian.ui.security.user.ChangePassword;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class ChangePasseordMenu extends AbstractMenuItem
{
	public ChangePasseordMenu()
	{
		setLabel(lang.get("generic.grid.column.changepassword"));
		setImage("/icons/key16.png");
		
		addEventListener(Events.ON_CLICK, this);
	}

	@Override
	public void onEvent(Event arg0) throws Exception
	{
		SettingWindow window = SettingWindow.newInstance(getPage());
		kernel.register(window);
		Flow.next(window, new ChangePassword(RowUtils.shield(utils.getUser().getId()), true));
	}
}
