/**
 * 
 */
package com.kratonsolution.belian;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ItextTest
{
	@Test
	public void test()
	{
		try
		{
			ByteArrayOutputStream pdf = new ByteArrayOutputStream();
			
			Document document = new Document();
			PdfWriter.getInstance(document,pdf);
			document.open();
			document.add(new Paragraph("Dar Der Dor"));
			document.close();
			
			for(byte bt:pdf.toByteArray())
				System.out.print((char)bt);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
