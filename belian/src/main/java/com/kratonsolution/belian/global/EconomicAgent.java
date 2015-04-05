/**
 * 
 */
package com.kratonsolution.belian.global;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author agungdodiperdana
 *
 */
@Entity
@Table(name="economic_agent")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="agent_type")
public interface EconomicAgent
{
	@Id
	public String getId();
	
	public void setId(String id);
	
	public String getName();
	
	public void setName(String name);
}
