/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.util.Set;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface HasStatus
{
	public Statuses getLastStatus();
	
	public void setLastStatus(Statuses status);
	
	public Set<? extends Statuses> getStatuses();
	
	public Set<? extends ApproveAndReviewableItem> getItems();
}
