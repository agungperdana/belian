package com.kratonsolution.belian.backoffice.ui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.material.Material;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Route("secure/home")
@Theme(value = Material.class, variant = Lumo.LIGHT)
public class Dashboard extends AppLayout {

	private static final long serialVersionUID = 1L;

	private MenuBar belian = new MenuBar();
	
	private HorizontalLayout dock = new HorizontalLayout();
	
	private VerticalLayout layout = new VerticalLayout();
	
	private VerticalLayout content = new VerticalLayout();
	
	public Dashboard() {
		
		addToNavbar(belian);
		
		initMenu();
	}
	
	private void initMenu() {

		belian.addThemeVariants(MenuBarVariant.LUMO_SMALL);
		
		MenuItem root = belian.addItem(new Icon(VaadinIcon.BOLD));
		
		SubMenu child = root.getSubMenu();
		child.addItem("About", e->{});
		child.addItem("Setting", e->{});
		child.addItem("Logout", e->UI.getCurrent().navigate("logout"));
	}
	
	private void initDock() {
		
		dock.setWidth("50%");
		dock.setHeight("75px");
		
	}
	
}
