/**
 * 
 */
package com.kratonsolution.belian.ui.general.party;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.partys.dm.PartySkillType;
import com.kratonsolution.belian.partys.svc.PartySkillTypeService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PartySkillTypeList extends Listbox
{
	private PartySkillTypeService service = Springs.get(PartySkillTypeService.class);
	
	private Map<String,PartySkillType> maps = new HashMap<String, PartySkillType>();
	
	public PartySkillTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public PartySkillTypeList(boolean fullspan,PartySkillType type)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		setSelectedItem(null);
		
		for(PartySkillType skill:service.findAll())
		{
			Listitem listitem = appendItem(skill.getName(), skill.getId());
			if(type != null && skill.equals(type))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(skill.getName()))
				maps.put(skill.getName(), skill);
		}
	}
	
	public PartySkillType getPartySkillType()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getLabel()))
			return maps.get(getSelectedItem().getLabel());
		
		return null;
	}
	
	public void setPartySkillType(PartySkillType skill)
	{
		if(skill != null)
		{
			getItems().clear();
			setSelectedItem(appendItem(skill.getName(), skill.getId()));
			
			if(!maps.containsKey(skill.getName()))
				maps.put(skill.getName(), skill);
		}
	}
}
