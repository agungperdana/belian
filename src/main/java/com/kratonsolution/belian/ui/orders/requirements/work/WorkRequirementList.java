
package com.kratonsolution.belian.ui.orders.requirements.work;

import org.assertj.core.util.Strings;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.requirement.dm.WorkRequirement;
import com.kratonsolution.belian.requirement.svc.WorkRequirementService;
import com.kratonsolution.belian.ui.component.AbstractList;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WorkRequirementList extends AbstractList<WorkRequirement>
{
	private WorkRequirementService service = Springs.get(WorkRequirementService.class);
	
	public WorkRequirementList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public WorkRequirementList(boolean fullspan,WorkRequirement con)
	{
		super();
		
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setSelectedItem(null);
		
		for(WorkRequirement domain:service.findAllOpen())
		{
			Listitem listitem = appendItem(domain.getNumber(),domain.getId());
			if(con != null && con.getId().equals(domain.getId()))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(domain.getId()))
				maps.put(domain.getId(), domain);
		}
	}

	@Override
	public WorkRequirement getDomain()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}

	@Override
	public IDValueRef getDomainAsRef()
	{
		WorkRequirement type = getDomain();
		if( type != null)
		{
			IDValueRef ref = new IDValueRef();
			ref.setId(type.getId());
			ref.setValue(type.getNumber());
			
			return ref;
		}
		
		return null;
	}

	@Override
	public void setDomain(WorkRequirement domain)
	{
		if(domain != null)
		{
			if(!maps.containsKey(domain.getId()))
			{
				maps.put(domain.getId(), domain);
				setSelectedItem(appendItem(domain.getNumber(),domain.getId()));
			}
			else
			{
				for(Listitem item:getItems())
				{
					if(item.getValue().toString().equals(domain.getId()))
					{
						setSelectedItem(item);
						break;
					}
				}
			}
		}
	}

	@Override
	public void setDomainAsRef(IDValueRef ref)
	{
		if(ref != null && !Strings.isNullOrEmpty(ref.getId()))
		{
			if(!maps.containsKey(ref.getId()))
				maps.put(ref.getId(), new WorkRequirement(ref));
			
			getItems().clear();
			
			for(WorkRequirement work:maps.values())
			{
				Listitem listitem = appendItem(work.getNumber(),work.getId());
				if(work.getId().equals(ref.getId()))
					setSelectedItem(listitem);
			}
		}
	}
}
