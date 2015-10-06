/**
 * 
 */
package com.kratonsolution.belian.ui.role.inbox;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Caption;

import com.kratonsolution.belian.ui.AbstractWindow;
import com.kratonsolution.belian.ui.HasGrid;

/**
 * @author agungdodiperdana
 *
 */
public class InboxWindow extends AbstractWindow implements HasGrid
{
	private final Caption caption = new Caption("Inbox");

	public InboxWindow()
	{
		super();
		init();
	}
	
	protected void init()
	{
		caption.setImage("/icons/inbox.png");
		appendChild(caption);
		insertGrid();
	}
	
	@Override
	public void onClose()
	{
		setVisible(false);
		removeStatus();
		setPage(null);
	}
	
	public void removeGrid()
	{
		for(Component component:getChildren())
		{
			if(component instanceof InboxGridContent)
			{
				removeChild(component);
				break;
			}
		}
	}

	public void insertGrid()
	{
		appendChild(new InboxGridContent());
	}

	@Override
	public void insertStatus()
	{
	}

	@Override
	public void removeStatus()
	{
	}
}
