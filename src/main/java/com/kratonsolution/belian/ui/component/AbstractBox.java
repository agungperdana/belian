/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.util.Vector;

import org.zkoss.zul.Hbox;

import com.kratonsolution.belian.api.dm.Observer;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class AbstractBox extends Hbox
{
	protected SessionUtils utils = Springs.get(SessionUtils.class);
	
	protected Language lang = Springs.get(Language.class);

	protected Vector<Observer> observers = new Vector<>();
}
