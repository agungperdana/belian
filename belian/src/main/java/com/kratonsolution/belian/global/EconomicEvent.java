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
@Table(name="economic_event")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="economic_event")
public interface EconomicEvent
{
	@Id
	public String getId();
	
	public void setId(String id);
}
