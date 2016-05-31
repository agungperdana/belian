/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.kratonsolution.belian.sales.dm.Billable;

import lombok.Getter;
import lombok.Setter;

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
	@Column(name="is_bpjs")
	private boolean bpjs;
	
	@Enumerated(EnumType.STRING)
	@Column(name="bpjs_payment_status")
	private BPJSPaymentStatus bpjsStatus = BPJSPaymentStatus.UNPAID;
	
	@Enumerated(EnumType.STRING)
	@Column(name="medication_status")
	private MedicationStatus status = MedicationStatus.Registered;
	
	@OneToMany(mappedBy="medication",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<MedicationItem> items = new HashSet<MedicationItem>();
	
	@Transient
	private String type = "Pharmacy";

	@Override
	public String getBillingType()
	{
		return type;
	}

	@Override
	public int getTableNumber()
	{
		return 0;
	}
}
