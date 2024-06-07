package com.kratonsolution.belian.ui.nav;

import org.zkoss.zul.Menu;
import org.zkoss.zul.Menupopup;

import com.kratonsolution.belian.common.app.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
public abstract class AbstractMenu extends Menu
{
	protected Language lang = Springs.get(Language.class);
	
	protected SessionUtils utils = Springs.get(SessionUtils.class);

	protected Menupopup popup = new Menupopup();
	
	public boolean isDisabled()
	{
		return popup.getChildren().isEmpty();
	}
}
