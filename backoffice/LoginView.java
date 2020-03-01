package com.kratonsolution.belian.backoffice.ui;

import java.util.Collections;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Tag("sa-login-view")
@Route(value = LoginView.ROUTE)
@PageTitle("Login")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

	private static final long serialVersionUID = 1L;

	public static final String ROUTE = "login";

	private LoginOverlay login = new LoginOverlay(); // 

	public LoginView(){
		
		login.setAction("login"); // 
		login.setOpened(true); // 
		login.setTitle("BelianERP 2.0");
		login.setDescription("Enter your login information");

		getElement().appendChild(login.getElement()); // 
	}

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		
		if(!event.getLocation()
				.getQueryParameters().getParameters()
				.getOrDefault("error", Collections.emptyList()).isEmpty()) {
			login.setError(true); // 
		}
	}
}
