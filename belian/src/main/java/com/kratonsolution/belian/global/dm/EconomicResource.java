/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Entity
@Table(name="economic_resource")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="resource_type")
public interface EconomicResource
{
	@Id
	public String getId();
	
	public void setId(String id);
}