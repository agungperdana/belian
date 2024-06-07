
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Caption;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.common.app.Language;
import com.kratonsolution.belian.tools.view.Dock;
import com.kratonsolution.belian.tools.view.KernelTask;
import com.kratonsolution.belian.tools.view.Watchable;
import com.kratonsolution.belian.ui.util.Springs;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
public abstract class AbstractWindow extends Window implements Watchable
{	
	protected Dock dock;
	
	protected KernelTask kernel = Springs.get(KernelTask.class);
	
	protected Language lang = Springs.get(Language.class);
	
	protected Caption caption = new Caption();
	
	public AbstractWindow()
	{
		appendChild(caption);
		
		setWidth("80%");
		setHeight("75%");
		setClosable(true);
		setMinimizable(true);
		setMaximizable(true);
		setSizable(true);
		setPosition("center");
		
		setSclass("frmaedisplay");
	}

	@Override
	public void open()
	{
		if(!isVisible())
			setVisible(true);
			
		setTopmost();
	}

	@Override
	public void kill()
	{
		detach();
	}

	@Override
	public String getName()
	{
		return caption.getLabel();
	}

	@Override
	public String getIcon()
	{
		return caption.getImage();
	}	
	
	@Override
	public void onClose()
	{
		kernel.kill(getName());
		detach();
	}
	
	@Override
	public boolean isAlive()
	{
		return getPage() != null;
	}
}
