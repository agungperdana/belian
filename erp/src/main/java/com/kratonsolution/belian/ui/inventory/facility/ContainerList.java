
package com.kratonsolution.belian.ui.inventory.facility;

import java.util.Vector;

import org.zkoss.zul.Listitem;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.common.orm.Observer;
import com.kratonsolution.belian.facility.impl.orm.Container;
import com.kratonsolution.belian.facility.impl.orm.Facility;
import com.kratonsolution.belian.facility.impl.application.FacilityService;
import com.kratonsolution.belian.ui.component.AbstractList;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ContainerList extends AbstractList<Container> implements Observer
{
	private FacilityService service = Springs.get(FacilityService.class);
	
	public ContainerList(boolean fullspan)
	{
		setMold("select");

		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
	}

	@Override
	public Container getDomain()
	{
		return getSelectedItem()!=null?maps.get(getSelectedItem().getValue()):null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue()))
		{
			IDValueRef ref = new IDValueRef();
			ref.setId(getSelectedItem().getValue());
			ref.setValue(getSelectedItem().getLabel());
			ref.setType(Container.class.getSimpleName());
			
			return ref;
		}
		
		return null;
	}

	@Override
	public void setDomain(Container ref)
	{
		if(ref != null && !Strings.isNullOrEmpty(ref.getId()))
		{
			getItems().clear();
			
			if(!maps.containsKey(ref.getId()))
				maps.put(ref.getId(), ref);
			
			for(Container container:maps.values())
			{
				Listitem item = appendItem(container.getName(), container.getId());
				if(ref.getId().equals(container.getId()))
					setSelectedItem(item);
			}
		}
	}

	@Override
	public void setDomainAsRef(IDValueRef ref)
	{
		if(ref != null && !Strings.isNullOrEmpty(ref.getId()))
		{
			getItems().clear();
			
			if(!maps.containsKey(ref.getId()))
				maps.put(ref.getId(), new Container(ref));
			
			for(Container container:maps.values())
			{
				Listitem item = appendItem(container.getName(), container.getId());
				if(ref.getId().equals(container.getId()))
					setSelectedItem(item);
			}
		}
	}

	@Override
	public void valueChange(IDValueRef value)
	{
		if(value != null && !Strings.isNullOrEmpty(value.getId()))
		{
			Facility facility = service.findById(value.getId());
			if(facility != null)
			{
				getItems().clear();

				Vector<Container> containers = new Vector<>();
				for(Container container:facility.getContainers())
					extract(containers, container);
			
				for(Container container:containers)
				{
					appendItem(container.getLabel(), container.getId());
					
					if(!maps.containsKey(container.getId()))
						maps.put(container.getId(), container);
				}
			}
		}
	}
	
	private void extract(Vector<Container> containers,Container parent)
	{
		containers.add(parent);
		if(!parent.getChilds().isEmpty())
		{
			for(Container container:parent.getChilds())
				extract(containers, container);
		}
	}
}
