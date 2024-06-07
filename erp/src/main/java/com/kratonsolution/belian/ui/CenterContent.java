
package com.kratonsolution.belian.ui;

import java.util.Vector;

import org.zkoss.zul.Center;

import com.kratonsolution.belian.common.orm.Observable;
import com.kratonsolution.belian.common.orm.Observer;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class CenterContent extends Center implements Observable
{
	private Vector<Observer> observers = new Vector<>();
	
	@Override
	public void addObserver(Observer observer)
	{
		if(observer != null)
			observers.add(observer);
	}
}
