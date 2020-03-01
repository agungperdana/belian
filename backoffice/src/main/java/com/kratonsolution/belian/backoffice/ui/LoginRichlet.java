package com.kratonsolution.belian.backoffice.ui;

import org.zkoss.zk.ui.GenericRichlet;
import org.zkoss.zk.ui.Page;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class LoginRichlet extends GenericRichlet {

	@Override
	public void service(Page page) throws Exception {
		
		Window window = new Window();
		window.setTitle("BelianERP 2.0");
		window.setHeight("450px");
		window.setWidth("400px");
		
		Textbox user = new Textbox();
		user.setWidth("100%");
		user.setParent(window);
		
		Textbox password = new Textbox();
		password.setType("password");
		password.setWidth("100%");
		password.setParent(window);
		
		Button submit = new Button("Login");
		submit.setWidth("100%");
		submit.setParent(window);
		
		window.setPage(page);
	}

}
