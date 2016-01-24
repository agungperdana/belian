/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.sales.dm.Billable;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="medication")
public class Medication extends Billable
{
	@OneToMany(mappedBy="medication",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<MedicationItem> items = new HashSet<MedicationItem>();

	@Override
	public String getBillingType()
	{
		return "Medication";
	}
}
