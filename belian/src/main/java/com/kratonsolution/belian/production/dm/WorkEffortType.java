/**
 * 
 */
package com.kratonsolution.belian.production.dm;

import com.google.common.base.Strings;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum WorkEffortType
{
	Task,Proggram,Project,Activity;
	
	public String display(String lang)
	{
		if(!Strings.isNullOrEmpty(lang) && lang.equals("in_ID"))
		{
			switch (this)
			{
				case Task:
					return "Tindakan";
				case Proggram:
					return "Program";
				case Project:
					return "Proyek";
				case Activity:
					return "Aktivitas";
			}
		}
		
		return name();
	}
}
