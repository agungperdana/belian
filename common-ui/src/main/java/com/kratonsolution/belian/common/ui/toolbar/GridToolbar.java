package com.kratonsolution.belian.common.ui.toolbar;

import org.zkoss.image.AImage;
import org.zkoss.util.resource.Labels;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

import lombok.Getter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Getter
public class GridToolbar extends Toolbar
{
	private static final long serialVersionUID = -8553580636645989598L;

	private final Toolbarbutton refresh = new Toolbarbutton(Labels.getLabel("toolbar.refresh"));
	
	private final Toolbarbutton newData = new Toolbarbutton(Labels.getLabel("toolbar.new"));

	private final Toolbarbutton select = new Toolbarbutton(Labels.getLabel("toolbar.select"));
	
	private final Toolbarbutton deselect = new Toolbarbutton(Labels.getLabel("toolbar.deselect"));
	
	private final Toolbarbutton delete = new Toolbarbutton(Labels.getLabel("toolbar.delete"));
	
	private final Toolbarbutton search = new Toolbarbutton(Labels.getLabel("toolbar.search"));
	
	public GridToolbar()
	{
		setWidth("100%");
		setLeft("0px");
		setHeight("20%");
		
		try {
			
			newData.setImageContent(new AImage(getClass().getResource("/images/toolbar/new.png")));
			select.setImageContent(new AImage(getClass().getResource("/images/toolbar/selectall.png")));
			deselect.setImageContent(new AImage(getClass().getResource("/images/toolbar/deselect.png")));
			delete.setImageContent(new AImage(getClass().getResource("/images/toolbar/delete.png")));
			search.setImageContent(new AImage(getClass().getResource("/images/toolbar/search.png")));
			refresh.setImageContent(new AImage(getClass().getResource("/images/toolbar/refresh.png")));
		} catch (Exception e) {}
		
		appendChild(refresh);
		appendChild(newData);
		appendChild(select);
		appendChild(delete);
		appendChild(search);
	}
	
	public void disabled()
	{
		refresh.setDisabled(true);
		newData.setDisabled(true);
		select.setDisabled(true);
		deselect.setDisabled(true);
		search.setDisabled(true);
	}
	
	public void enabled()
	{
		refresh.setDisabled(false);
		newData.setDisabled(false);
		select.setDisabled(false);
		deselect.setDisabled(false);
		search.setDisabled(false);
	}
}
