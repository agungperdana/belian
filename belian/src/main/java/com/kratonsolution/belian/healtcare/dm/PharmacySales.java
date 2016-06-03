/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="pharmacy_sales")
public class PharmacySales extends MedicalSales
{
	@Column(name="is_reference")
	private boolean reference;
	
	@OneToMany(mappedBy="pharmacySales",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<PharmacySalesItem> items = new HashSet<>();
	
	public PharmacySales(){}

	@Override
	public String getBillingType()
	{
		return "Apotek";
	}
}