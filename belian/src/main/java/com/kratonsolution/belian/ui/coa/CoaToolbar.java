/**
 * 
 */
package com.kratonsolution.belian.ui.coa;

import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

/**
 * @author agungdodiperdana
 *
 */
public class CoaToolbar extends Toolbar
{
	private Toolbarbutton create = new Toolbarbutton("New GL Account", "/icons/coasmall.png");
	
	public CoaToolbar()
	{
		setHeight("35px");
		setWidth("100%");
		
		appendChild(create);
	}

	public Toolbarbutton getNewbutton()
	{
		return create;
	}
}
