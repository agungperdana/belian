/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kratonsolution.belian.hr.dm.PayHistory;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Entity
@Table(name="employment")
public class Employment implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@OneToMany(mappedBy="employment",cascade=CascadeType.ALL)
	private Set<PayHistory> payHistorys = new HashSet<PayHistory>();
}