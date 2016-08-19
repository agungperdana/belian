/**
 * 
 */
package com.kratonsolution.belian.effort.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import com.kratonsolution.belian.inventory.dm.Facility;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WorkEffort implements Serializable
{
	private String id = UUID.randomUUID().toString();

	private String name;

	private String note;

	private Date scheduledStartDate;

	private Date scheduledCompleteDate;

	private Date actualStartDate;

	private Date actualCompleteDate;

	private BigDecimal moneyAllowed;

	private BigDecimal hourAllowed;

	private BigDecimal estimatedHour;

	private BigDecimal actualdHour;
	
	private String spesialTerm;
	
	private Facility performedAt;
	
	private WorkEffortType type = WorkEffortType.TASK;

	private WorkEffortPurposeType purposeType = WorkEffortPurposeType.PRODUCTION;

	private ProductionRunProperties productionRunProperties;
}
