/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class ReportToolbar extends Toolbar
{
	private Language lang = Springs.get(Language.class);
	
	private Toolbarbutton generate = new Toolbarbutton(lang.get("label.component.button.generate"),"/icons/generate-report.png");
	
	private Toolbarbutton pdf = new Toolbarbutton(lang.get("label.component.button.pdf"),"/icons/exportpdf.png");
	
	private Toolbarbutton excel = new Toolbarbutton(lang.get("label.component.button.excel"),"/icons/exportexcel.png");

	public ReportToolbar()
	{
		setWidth("100%");
		
		pdf.setDisabled(true);
		excel.setDisabled(true);
		
		appendChild(generate);
//		appendChild(pdf);
//		appendChild(excel);
	}
}
