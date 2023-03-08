/**
 * 
 */
package com.kratonsolution.belian.ui.tools.datas;

import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.tools.svc.DataImportService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductDataImportWindow extends Window
{
	private Language lang = Springs.get(Language.class);

	private Caption caption = new Caption(lang.get("navbar.menu.tools.product"));

	public ProductDataImportWindow()
	{
		setClosable(true);
		setBorder(true);
		setWidth("300px");
		setHeight("500px");
		setPosition("center");
		
		init();
	}

	private void init()
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
				DataImportService service = Springs.get(DataImportService.class);
				service.insert(event.getMedia().getStreamData());
			}
		});
	}
}
