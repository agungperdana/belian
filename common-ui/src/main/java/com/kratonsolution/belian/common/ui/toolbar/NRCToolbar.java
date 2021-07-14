package com.kratonsolution.belian.common.ui.toolbar;

import org.zkoss.image.AImage;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

import lombok.Getter;
import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Getter
public class NRCToolbar extends Toolbar
{
	private static final long serialVersionUID = -8756640053965159551L;

	private Toolbarbutton newData = new Toolbarbutton(Labels.getLabel("toolbar.new"));

	private Toolbarbutton remove = new Toolbarbutton(Labels.getLabel("toolbar.delete"));

	private Toolbarbutton clear = new Toolbarbutton(Labels.getLabel("toolbar.clear"));

	public NRCToolbar(@NonNull Grid parent)
	{
		setHeight("40px");
		appendChild(newData);
		appendChild(remove);
		appendChild(clear);

		try {

			newData.setImageContent(new AImage(getClass().getResource("/images/toolbar/new.png")));
			remove.setImageContent(new AImage(getClass().getResource("/images/toolbar/delete.png")));
			clear.setImageContent(new AImage(getClass().getResource("/images/toolbar/refresh.png")));
		} catch (Exception e) {}

		getClear().addEventListener(Events.ON_CLICK, e->parent.getRows().getChildren().clear());
	}

	public void disabled()
	{
		newData.setDisabled(true);
		remove.setDisabled(true);
		clear.setDisabled(true);
	}

	public void enabled()
	{
		newData.setDisabled(false);
		remove.setDisabled(false);
		clear.setDisabled(false);
	}
}
