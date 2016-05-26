/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class ReportToolbar extends Toolbar
{
	private Toolbarbutton generate = new Toolbarbutton("Generate","/icons/generate-report.png");
	
	private Toolbarbutton pdf = new Toolbarbutton("Export Pdf","/icons/exportpdf.png");
	
	private Toolbarbutton excel = new Toolbarbutton("Export Xls","/icons/exportexcel.png");

	public ReportToolbar()
	{
		pdf.setDisabled(true);
		excel.setDisabled(true);
		
		appendChild(generate);
//		appendChild(pdf);
//		appendChild(excel);
	}
}
