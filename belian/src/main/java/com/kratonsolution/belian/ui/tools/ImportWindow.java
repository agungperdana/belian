/**
 * 
 */
package com.kratonsolution.belian.ui.tools;

import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ImportWindow extends Window
{
	private Caption caption = new Caption("Import");
	
	public ImportWindow()
	{
		caption.setImage("/icons/imports.png");
		
		Hlayout hlayout = new Hlayout();
		hlayout.setWidth("100%");
		
		appendChild(caption);
		appendChild(hlayout);
		
		Fileupload fileupload = new Fileupload("File");

		hlayout.appendChild(new Label("Choose excel file to import"));
		hlayout.appendChild(fileupload);
		
		fileupload.addEventListener(Events.ON_UPLOAD,new EventListener<UploadEvent>()
		{
			@Override
			public void onEvent(UploadEvent event) throws Exception
			{
				System.out.println(event.getMedia().getName());
				System.out.println(event.getMedia().getContentType());
			}
		});
		
		
		
		setWidth("550px");
		setHeight("450px");
		setClosable(true);
	}
}
