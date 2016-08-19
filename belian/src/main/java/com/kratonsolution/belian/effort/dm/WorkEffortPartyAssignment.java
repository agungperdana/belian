/**
 * 
 */
package com.kratonsolution.belian.effort.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.order.dm.RoleType;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WorkEffortPartyAssignment implements Serializable
{
private String id = UUID.randomUUID().toString();
	
	private Date start;
	
	private Date end;
	
	private String comment;
	
	private Party party;
	
	private WorkEffort workEffort;
	
	private RoleType type = RoleType.IMPLEMENTER;
	
	private Long value;
	
	public WorkEffortPartyAssignment(){}
}
