/**
 * 
 */
package com.kratonsolution.belian.effort.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WorkEffortAssosiation implements Serializable
{
	private String id = UUID.randomUUID().toString();
	
	private Date start;
	
	private Date end;
	
	private WorkEffort fromEffort;
	
	private WorkEffort toEffort;
	
	private Long version;
}
