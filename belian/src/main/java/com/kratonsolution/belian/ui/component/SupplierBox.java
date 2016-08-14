/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.A;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Hbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.procurement.dm.Supplier;
import com.kratonsolution.belian.procurement.dm.SupplierRelationship;
import com.kratonsolution.belian.procurement.svc.SupplierRelationshipService;
import com.kratonsolution.belian.ui.util.Springs;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class SupplierBox extends Hbox implements SupplierRegistrationListener
{
	private Language lang = Springs.get(Language.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private SupplierRelationshipService service = Springs.get(SupplierRelationshipService.class);
	
	private Combobox identity = new Combobox();
	
	private A link = new A(lang.get("label.component.button.newsupplier"));
	
	private Map<String,Party> maps = new HashMap<>();
	
	public SupplierBox(boolean showCreateLink)
	{
		setWidth("400px");
		
		identity.setPlaceholder(lang.get("message.field.iden"));
		identity.setAutodrop(true);
		identity.setAutocomplete(false);
		identity.setWidth("290px");
		
		appendChild(identity);
		
		if(showCreateLink)
			appendChild(link);
		
		identity.addEventListener(Events.ON_CHANGING, new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent input) throws Exception
			{
				identity.getChildren().clear();
				for(SupplierRelationship relationship:service.findAll(input.getValue()))
				{
					identity.appendItem(relationship.getSupplier().getParty().getName());
					if(!maps.containsKey(relationship.getSupplier().getParty().getName()))
						maps.put(relationship.getSupplier().getParty().getName(), relationship.getSupplier().getParty());
				}
			}
		});
		
		link.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				SupplierRegistration registration = new SupplierRegistration();
				registration.addListener(SupplierBox.this);
				registration.setPage(getPage());
				registration.doModal();
			}
		});
	}
	
	public Party getSupplier()
	{
		if(!Strings.isNullOrEmpty(identity.getValue()))
			return maps.get(identity.getValue());
		
		return null;
	}

	@Override
	public void setSupplier(Supplier supplier)
	{
		if(supplier != null)
		{
			identity.appendItem(supplier.getParty().getName());
			identity.setSelectedIndex(0);
			if(!maps.containsKey(supplier.getParty().getName()))
				maps.put(supplier.getParty().getName(), supplier.getParty());
		}
	}
	
	public void setSupplier(Party supplier)
	{
		if(supplier != null)
		{
			identity.appendItem(supplier.getName());
			identity.setSelectedIndex(0);
			if(!maps.containsKey(supplier.getName()))
				maps.put(supplier.getName(), supplier);
		}
	}
}
