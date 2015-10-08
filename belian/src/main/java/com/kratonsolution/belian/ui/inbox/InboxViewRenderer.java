/**
 * 
 */
package com.kratonsolution.belian.ui.inbox;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.global.dm.ReviewResult;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface InboxViewRenderer<V extends ReviewResult>
{
	public void showInboxDetail(Page page,V v);
}
