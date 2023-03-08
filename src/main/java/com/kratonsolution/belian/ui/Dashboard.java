/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Hbox;

import com.kratonsolution.belian.tools.view.KernelTask;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class Dashboard extends Hbox implements Removeable
{
	protected KernelTask task = Springs.get(KernelTask.class);
	
	protected Canvas canvas = new Canvas();
	
	public Dashboard()
	{
		setHflex("1");
		setVflex("1");
	}
}
